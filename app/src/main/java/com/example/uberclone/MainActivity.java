package com.example.uberclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    public void redirectActivity(){
        if(ParseUser.getCurrentUser().get("riderOrDriver").equals("Rider")){
            Intent intent = new Intent(getApplicationContext(),RiderActivity.class);
            startActivity(intent);

        }else{
            Intent intent = new Intent(getApplicationContext(),ViewRequestActivity.class);
            startActivity(intent);
        }

    }
    public void riderDriver(View view){

        Switch userTypeSwitch = (Switch) findViewById(R.id.userTypeSwtich);
        Log.i("Value",String.valueOf(userTypeSwitch.isChecked()));
        String userType = "Rider";
        if(userTypeSwitch.isChecked()){
            userType ="Driver";
        }
        ParseUser.getCurrentUser().put("riderOrDriver",userType);
        ParseUser.getCurrentUser().saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null)
                {
                    redirectActivity();
                }
                else
                {
                    Log.i("Info","No Information Saved");
                }
            }
        });

       // Log.i("Info","Redirecting as "+userType);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        if(ParseUser.getCurrentUser()==null){
            ParseAnonymousUtils.logIn(new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(e==null){
                        Log.i("Info","Anonymous login successful");
                    }else{
                        Log.i("Info","Anonymous login Failed");
                    }
                }
            });
        }else{
            if(ParseUser.getCurrentUser().get("riderOrDriver") !=null){
              //  Log.i("Info","Redirecting as "+ParseUser.getCurrentUser().get("riderOrDriver"));
                redirectActivity();
            }
        }
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }


}