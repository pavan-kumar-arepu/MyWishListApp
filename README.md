# WishListApp

WishListApp is a Kotlin-based Android application designed for users to create, manage, and organize their wish lists. The app utilizes modern technologies and follows best practices in mobile app development.

## Features

- **Add and Edit Wishes:** Users can seamlessly add new wishes, along with titles and descriptions. Existing wishes can also be edited to keep information up-to-date.

- **View Wishes:** The app provides a user-friendly interface that displays a list of all wishes on the home screen. This feature allows users to quickly review and manage their wishes.

## Tech Stack

### Language

- Kotlin

### UI Framework

- Jetpack Compose A modern UI toolkit for building native Android UIs.

### Architecture

- MVVM (Model-View-ViewModel): A design pattern that separates the UI presentation logic from the business logic, providing a scalable and maintainable structure.

### Database

- Room Database: A persistence library that provides an abstraction layer over SQLite to enable robust database access while following best practices.

### Navigation

- Jetpack Navigation Component: A library for navigating between different screens in a user's flow, providing a consistent and predictable user experience.

### Dependency Injection

- Hilt: A dependency injection library for Android that simplifies the setup of Dagger components.

### ViewModel

- Android ViewModel: A class designed to store and manage UI-related data, helping to survive configuration changes and managing the UI-related logic.

## Database Structure

The app's persistent storage is managed using a Room Database, consisting of the following components:

### Wish Entity

- `id`: Auto-generated primary key for each wish.

- `title`: The title of the wish.

- `description`: A detailed description of the wish.

### WishDao

- Provides Data Access Object methods for adding, updating, deleting, and retrieving wishes.

## Repository

The app's data is managed through the WishRepository, which interacts with the WishDao to perform CRUD (Create, Read, Update, Delete) operations.

## How to Build and Run

1. Clone the repository: `git clone https://github.com/pavan-kumar-arepu/MyWishListApp/tree/Master`

2. Open the project in Android Studio.

3. Build and run the application on an Android emulator or device.

## Screenshots

<div style="display: flex; justify-content: space-between;">

  <img src="https://github.com/pavan-kumar-arepu/MyWishListApp/assets/13812858/4c0857c7-bff1-4e0e-b22a-903431ceba40" alt="Wish List App first Look" width="300"/>
  <!-- It's all about a wish list, we can see all my wishlist of apps here -->

  <img src="https://github.com/pavan-kumar-arepu/MyWishListApp/assets/13812858/0fb820a4-c174-4b48-a27d-5ba97039860f" alt="Here we can add our wish here" width="300"/>
  <!-- Here we can add our wishes -->

   <img src="https://github.com/pavan-kumar-arepu/MyWishListApp/assets/13812858/8c40a6c9-fa2a-4d9d-8bd3-575d18eb41f4" alt="Here we can update wish here" width="300"/>
  <!-- Here we can update wish -->

</div>


Feel free to customize the content further according to your needs! If you have any specific details or additions you'd like to include, let me know!
