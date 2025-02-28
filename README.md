# 🏥 Pregnancy Vitals Tracker 📊

A Jetpack Compose Android app that helps users log and track pregnancy vitals such as blood pressure, heart rate, weight, and baby kicks with live updates using Room Database. The app also sends periodic reminder notifications using WorkManager.

---

### 📌 Features :

- 📌 Add & View Vitals - Log blood pressure, heart rate, weight, and baby kicks.

- 🔄 Live Data Updates - Uses StateFlow & LiveData for real-time UI updates.

- ➕ Delete Vitals - Swipe to delete or use the delete button on the card.

- 🎨 Reminders Every 5 Hours - Uses WorkManager to notify users to log vitals.

- 🏗 Jetpack Compose UI - Modern declarative UI with Material 3.

- 🛠 Dark & Light Theme Support - Adaptive UI.

---

### 🏗 Tech Stack :

- Language: Kotlin

- Framework: Jetpack Compose

- Room Database

- Material 3

- Architecture: MVVM

- StateFlow / LiveData

- WorkManager

---

### Dependencies Used :

- Add the following dependencies to your build.gradle file:
    ```
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation (libs.material3)
    implementation (libs.androidx.work.runtime.ktx)
    implementation (libs.androidx.core.ktx.v1120)
    implementation (libs.accompanist.swiperefresh)
    ```
---

### Project Structure :

```yaml
📦 PregnancyVitalsTracker
 ┣ 📂 data                 # Data layer (Room Database entities & DAOs)
 ┃ ┣ 📜 VitalsDao.kt       # Data Access Object (DAO) for Room
 ┃ ┣ 📜 VitalsEntity.kt    # Entity class for storing vitals
 ┣ 📂 db                   # Database & repository
 ┃ ┣ 📜 VitalsDatabase.kt  # Room Database instance
 ┃ ┣ 📜 VitalsRepo.kt      # Repository for data handling
 ┣ 📂 notification         # WorkManager for periodic reminders
 ┃ ┣ 📜 VitalsReminderWorker.kt  # Background worker for notifications
 ┣ 📂 ui                   # UI Components (Jetpack Compose)
 ┃ ┣ 📂 theme              # Theming files (colors, typography)
 ┃ ┣ 📜 AddVitalsDialog.kt # Dialog to add vitals
 ┃ ┣ 📜 MainActivity.kt    # Entry point of the app
 ┃ ┣ 📜 MainScreen.kt      # Main screen layout
 ┃ ┣ 📜 VitalsCard.kt      # UI component for displaying vitals
 ┣ 📂 vm                   # ViewModel & Factory
 ┃ ┣ 📜 VitalsViewModel.kt        # ViewModel for vitals management
 ┃ ┣ 📜 VitalsViewModelFactory.kt # Factory for ViewModel instantiation
 ┣ 📜 AndroidManifest.xml  # App permissions & declarations
 ┣ 📂 res                  # Resources (drawables, layouts, etc.)

```

---

### 🔔 Setting Up WorkManager for Notifications : 

- This app uses WorkManager to send notifications every 5 hours, if you are not receiving notifications:

1. Ensure Battery Optimization is disabled for the app in Settings.
2. Grant POST_NOTIFICATIONS permission in Android 13+.


---

### How to Use :
1. Clone the repository
```git clone <repository-url>```

2. Open the project in Android Studio.

3. Add the required dependencies to your build.gradle file if not already included.

4. Run the app on an emulator or a physical device.

5. Use the app to manage your contacts by adding, editing, and deleting them.

---

### Screenshots & App Demo Video:

(Will upload these soon.)

---

### License

This project is open-source and available under the MIT License.
