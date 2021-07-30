# cab-nest

Description: A simple Android Cab Application that uses Parse from AWS. You can either be a rider or a driver. As a Rider you can request rides which are shown to drivers. Drivers can view the riders locations and select which rider they would like to pick up. Once selected, navigation is started on their device.

Tech Stack: java, Android, Parse from AWS
 
Code:
It includes 5 activites-

MainActivity.Java - The First page of the app. User decide if they want to be a rider or a driver. From here they are redirected to their respective activities.

RiderActivity.Java - This activity is for Rider. Once the app has determined you are a rider you are redirected to this page. This is a Google Maps Activity that shows the user their location. Here user can request and cancel an ride.

DriverActivity.Java - This is the Activity for Driver. This activity allows drivers to see a listview showing the rides over a particular distance. Drivers can click on the listview to see an individual ride which will take them to the Rider Activity.

ViewRequestActivity.Java - This is the activity where the drivers can see their location and their riders location on a map. If the locations are acceptable to the driver they can accept the ride which will open google maps and navigate them to their rider.

StarterApplication.Java - Sets up Parse server with our app ID and our server.
