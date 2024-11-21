<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png" alt="Kotlin Logo" width="50"/>
</p>

# Reorderable Cards

A Jetpack Compose project showcasing an interactive reorderable cards implementation with state persistence using **DataStore**. The app allows users to drag and drop items in a list to rearrange them, and their order is preserved even after closing and reopening the app.

---

## Features
1. **Draggable Items**:
    - Drag and drop functionality to reorder cards.
    - Smooth animations during reordering.

2. **State Persistence**:
    - Uses Jetpack's **DataStore** to persist the reordered cards.
    - Restores the card's state even after app restarts.

3. **Dynamic Lists**:
    - Supports multiple cards with draggable and non-draggable sections.
    - Customizable card configurations.

---

## Technologies Used
1. **Kotlin**

2. **Jetpack Compose**


3. **DataStore**



---

## Project Description
This project demonstrates a **reorderable card implementation** in Jetpack Compose. Users can reorder cards in the first list section via a drag-and-drop mechanism. Changes are automatically saved to DataStore, ensuring the cards order is restored upon reopening the app.

The project also showcases a clean architecture and modular design, focusing on:
- **Reusable components** for the drag-and-drop logic.
- **Efficient state management** with `LaunchedEffect` and `remember`.
- Separation of concerns between the UI and data layer.

---

## How It Works
1. **Drag and Drop**:
    - A custom `DragDropState` manages the drag gestures and calculates the item's new position.
    - `LazyColumn` is used to display the cards with items wrapped in draggable modifiers.

2. **State Persistence**:
    - The order of the cards is saved to **DataStore** every time the list changes.
    - On app launch, the saved state is restored, ensuring continuity.

3. **Fallback Mechanism**:
    - If no saved data exists, the list defaults to a predefined set of items.

---
