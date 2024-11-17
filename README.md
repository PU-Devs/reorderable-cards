<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png" alt="Kotlin Logo" width="50"/>
   <img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjC97Z8BResg5dlPqczsRCFhP6zewWX0X0e7fVPG-G7PuUZwwZVsi9OPoqJYkgqT2h0FI95SsmWzVEgpt8b8HAqFiIxZ98TFtY4lE0b8UrtVJ2HrJebRwl6C9DslsQDl9KnBIrdHS6LtkY/s1600/jetpack+compose+icon_RGB.png" alt="Jetpack Compose Logo" width="50"/>
</p>

# Reorderable List App

A Jetpack Compose project showcasing an interactive reorderable list implementation with state persistence using **DataStore**. The app allows users to drag and drop items in a list to rearrange them, and their order is preserved even after closing and reopening the app.

---

## 📜 Features
1. **Draggable Items**:
    - Drag and drop functionality to reorder list items.
    - Smooth animations during reordering.

2. **State Persistence**:
    - Uses Jetpack's **DataStore** to persist the reordered list.
    - Restores the list's state even after app restarts.

3. **Dynamic Lists**:
    - Supports multiple lists with draggable and non-draggable sections.
    - Customizable list configurations.

4. **Modern UI Design**:
    - Built entirely with **Jetpack Compose** for declarative UI development.
    - Material 3 design components for a polished look and feel.

---

## 🛠️ Technologies Used
1. **Kotlin**:
    - Primary programming language for Android app development.

2. **Jetpack Compose**:
    - Declarative UI framework for building modern Android UIs.
    - Simplifies building complex lists and layouts.

3. **DataStore**:
    - Jetpack's modern, scalable data storage solution.
    - Utilized for lightweight, efficient state persistence.

4. **Coroutines**:
    - For asynchronous state management and DataStore integration.

5. **Material Design 3**:
    - Ensures a cohesive and user-friendly design experience.

---

## 📖 Project Description
This project demonstrates a **reorderable list implementation** in Jetpack Compose. Users can reorder items in the first list section via a drag-and-drop mechanism. Changes are automatically saved to DataStore, ensuring the list order is restored upon reopening the app.

The project also showcases a clean architecture and modular design, focusing on:
- **Reusable components** for the drag-and-drop logic.
- **Efficient state management** with `LaunchedEffect` and `remember`.
- Separation of concerns between the UI and data layer.

---

## 🔧 How It Works
1. **Drag and Drop**:
    - A custom `DragDropState` manages the drag gestures and calculates the item's new position.
    - `LazyColumn` is used to display the list with items wrapped in draggable modifiers.

2. **State Persistence**:
    - The order of the list is saved to **DataStore** every time the list changes.
    - On app launch, the saved state is restored, ensuring continuity.

3. **Fallback Mechanism**:
    - If no saved data exists, the list defaults to a predefined set of items.

---