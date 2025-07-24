# Notation App

A simple Android application for note-taking, built using the MVVM (Model-View-ViewModel) architecture. This project demonstrates best practices for separation of concerns, UI reactivity, and persistent storage using SharedPreferences.

## Features

- Add, view, and manage notes
- Each note consists of a title and description
- Notes are displayed in a clean, scrollable list
- Data persists across app sessions using SharedPreferences
- MVVM architecture for maintainable and scalable code

## Screenshots

<img width="414" height="739" alt="Screenshot 2025-07-24 231256" src="https://github.com/user-attachments/assets/b7a8c956-893c-43b4-92ad-05216d0a212d" />


## Architecture

This project uses the MVVM architecture:

- **Model**: Handles data operations, including storage and retrieval of notes via SharedPreferences.
- **View**: Displays the UI components, including the list of notes and the add button.
- **ViewModel**: Acts as a bridge between the Model and View, exposing observable data for the UI and handling user actions.

## UI Overview

The main screen displays:
- A header titled "Notation"
- A scrollable list of note cards, each showing a title and description
- A floating action button (`+`) to add a new note

## Getting Started

1. Clone the repository:
   ```sh
   git clone https://github.com/inkand-paper/sharedpref-practice.git
   ```
2. Open the project in Android Studio.
3. Build and run on your Android device or emulator.

## Requirements

- Android Studio Electric Eel or newer
- Android API 21+

## How It Works

- Notes are stored locally using SharedPreferences.
- The ViewModel provides a LiveData list of notes to the UI.
- The UI listens for changes and updates automatically.
- New notes can be added using the floating action button.

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](LICENSE)
