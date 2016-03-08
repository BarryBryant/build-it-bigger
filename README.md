# Gradle for Android and Java Final Project

Used Gradle to build a joke-telling app that has both a free and paid version. This included factoring functionality into libraries as well as using build flavors to modularize the construction of each variant of the app. A Google Cloud Endpoints development server was configured to supply the jokes.

![](http://i.imgur.com/wySJxC0.gif)

### Required Components

- [x] Project contains a Java library for supplying jokes
- [x] Project contains an Android library with an activity that displays jokes passed to it as intent extras.
- [x] Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
- [x] Project contains connected tests to verify that the async task is indeed loading jokes.
- [x] Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

### Required Behavior

- [x] App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.

### Optional Components

- [x] The free app variant displays interstitial ads between the main activity and the joke-displaying activity.
- [x] The app displays a loading indicator while the joke is being fetched from the server.
- [x] The root build.gradle file contains a task that will start up the GCE development server, run all Android tests, then shutdown the development server.
