# Shackle Tech Assignment - Hotel Search
This app gives user few filters to search hotel and shows list of hotels

## Design Pattern:
Clean Architecture MVVM (Model View View Model)

![Search_1_recent_search](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*g6bqauGqu1u9Q1kZoNBvDQ.png)
Above image used from [this](https://medium.com/@ami0275/mvvm-clean-architecture-pattern-in-android-with-use-cases-eff7edc2ef76) article

## Application Flow:
One activity based app with following 2 screens:

### Main Search Screen:

| One Recent Search | Multiple Recent Search |
| :----: | :----: |
![Search_1_recent_search](https://github.com/Shackle-Group/android-test-assignment/assets/47480605/4b1d707f-6e0f-4719-baa8-20a71a011e96) | ![Search_Multiple_recent_searches](https://github.com/Shackle-Group/android-test-assignment/assets/47480605/767ce49a-aa21-41b4-8c69-20107e1c540b)

### Hotel List Screen
| Hotel List Screen | Hotel Error Screen |
| :----: | :----: |
![Hotel_List_Screenshot](https://github.com/Shackle-Group/android-test-assignment/assets/47480605/b9da2b4d-419c-493c-aeaf-621c25278faa) | ![Hotel_list_Error](https://github.com/tjabid/android-test-assignment/assets/47480605/a8986e82-e421-468c-bc17-549afeb27b2b)

## Testing
The project contains local unit tests that run on local machine and generate a coverage report using from terminal ```gradlew fullCoverageReport```
The project contains instrument tests that run on a device or emulator. Build type need to be selected: `instrumentalTests`

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
