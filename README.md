

Android Application


Project Name
Nerede Yesem


Developer Name
Erdem ÇALIŞIR



Delivery date 18.05.2019





Platforms and Tools


Platform and IDE

	Android Studio 3.4
	JRE: 1.8.0_152-release-1343-b16-5323222 amd64
	JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
	Linux 4.18.0-17-generici

Programming Language

	Java
	Xml
	
	















1. Analysis
	
	People have trouble deciding where to eat. We wanted to help them in this choice. The main purpose of this project is to improve the user restaurant search habits.
	We thought about getting it by sorting the surrounding restaurants. We limit the number of restaurants to 5 because we use free Zomato API.
	After entering the user's fingerprint, user will see the nearest restaurants. Of course as long as the location is found by application.



2. Requirements

	1. List at list 5 restaurants.
	2.To get user location, use mobile phone location.
	3.The application should contain at least two pages, the "BACK" key must be implemented as "HistoryBack".
	4.The application should be entered via Fingerprint 
	5.The application should know its state when the user pushes it at the background.
	 






3. Design

	3.1 FingerPrint
	
	BiometricPrompt used to get fingerprints. if reading is successful, the activity proceeded

	3.2 Location

	The second activity is location finding. FusedLocationProviderClient used to get current location. Also the necessary permissions get for the location services.

	3.3 List Restaurant

	Restaurant list edited with location information. Retrofit used here to design restaurant list. Also we used <ListView/>

	3.4 Detail Restaurant

	The details of the restaurants were determined with the previously created examples. Also we used position from listRestaurantActivity for each restaurant location.






4. User Catalog

	This program will help you in finding a restaurant. Forget your old habits and enjoy your meals in the restaurants we found for you.
	Let's start.

	4.1 Welcome screen

		Welcome screen is as below picture. Click the button below to enter the application. 

	
	4.2 FingerPrint screen
		
		Then the fingerprint screen will appear to switch to the application.






















		
		You will meet with the screen in the way of an unsuccessful fingerprint attempt




	4.3 Location screen
		
		You need to wait on this screen while locating. The application is currently looking for your location






			When the program finds your location, it will display a short-time screen and switch to the list screen

		































	4.3 Restaurant List screen

		Transmits this information to the other screen when the location is found. Then, the nearest restaurant to you is listed below. You can choose the restaurant you want to know the details.




	
	4.4 Restaurant Detail screen

		In this screen you will see the restaurant with the necessary information. You can scroll downwards due to the feature of the screen







5. Limitations

	The phone must be a fingerprint reader
	Must be a registered fingerprint
	The phone must be connected to the internet
	All permissions must have been granted. (eg. location internet )
	The phone location app must be running
	

	

