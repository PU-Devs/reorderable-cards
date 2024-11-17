<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png" alt="Kotlin Logo" width="50"/>
</p>

# Reorderable List App

A Jetpack Compose project showcasing an interactive reorderable list implementation with state persistence using **DataStore**. The app allows users to drag and drop items in a list to rearrange them, and their order is preserved even after closing and reopening the app.

---

## Features
1. **Draggable Items**:
    - Drag and drop functionality to reorder list items.
    - Smooth animations during reordering.

2. **State Persistence**:
    - Uses Jetpack's **DataStore** to persist the reordered list.
    - Restores the list's state even after app restarts.

3. **Dynamic Lists**:
    - Supports multiple lists with draggable and non-draggable sections.
    - Customizable list configurations.

---

## Technologies Used
1. **Kotlin**:

2. **Jetpack Compose**:


3. **DataStore**:



---

## Project Description
This project demonstrates a **reorderable list implementation** in Jetpack Compose. Users can reorder items in the first list section via a drag-and-drop mechanism. Changes are automatically saved to DataStore, ensuring the list order is restored upon reopening the app.

The project also showcases a clean architecture and modular design, focusing on:
- **Reusable components** for the drag-and-drop logic.
- **Efficient state management** with `LaunchedEffect` and `remember`.
- Separation of concerns between the UI and data layer.

---

## How It Works
1. **Drag and Drop**:
    - A custom `DragDropState` manages the drag gestures and calculates the item's new position.
    - `LazyColumn` is used to display the list with items wrapped in draggable modifiers.

2. **State Persistence**:
    - The order of the list is saved to **DataStore** every time the list changes.
    - On app launch, the saved state is restored, ensuring continuity.

3. **Fallback Mechanism**:
    - If no saved data exists, the list defaults to a predefined set of items.

---
