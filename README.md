# Shackle Tech Assignment - Hotel Search
This app gives user filter to search hotel and shows list of hotels

## Design Pattern:
Clean Architecture + MVVM (Model View View Model)

## Application Flow:
One activity based app with following 2 screens:

1. Main Search Screen:

| One Recent Search | Multiple Recent Search |
| :----: | :----: |
![Search_1_recent_search](https://github.com/Shackle-Group/android-test-assignment/assets/47480605/4b1d707f-6e0f-4719-baa8-20a71a011e96) | ![Search_Multiple_recent_searches](https://github.com/Shackle-Group/android-test-assignment/assets/47480605/767ce49a-aa21-41b4-8c69-20107e1c540b)
2. Hotel List Screen

| Hotel List Screen | - |
| :----: | :----: |
![Hotel_List_Screenshot](https://github.com/Shackle-Group/android-test-assignment/assets/47480605/b9da2b4d-419c-493c-aeaf-621c25278faa) | -



## Libraries:
- Jetpack Compose
- Jetpack Navigation between composable screens
- Jetpack Lifecycle and View model
- Flow and StateFLows
- Hilt for DI
- Room for local caching of recent searches
- Retrofit with Gson for web services
- Coil for hotel image
- Mockk for tests
- Robolectric for tests

## Building
Open the project in Android studio. Press run or debug to run on a connected device or an emulator.

## Testing
The project uses local unit tests that run on your computer. On Mac machine with a connected device or an emulator, to run both of them and generate a coverage report, you can run:
```gradlew fullCoverageReport```