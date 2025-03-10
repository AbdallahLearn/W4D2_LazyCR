# Food Menu App

## Overview
This is a food menu application built using Jetpack Compose for Android. The app displays a list of food categories and a vertical list of menu items. It includes a "Popular" badge for selected items and demonstrates how to create custom layouts with Jetpack Compose.

## Task Requirements

### 1. Data Classes
- **FoodCategory**: Represents a food category with an ID, name, description, and an image URL.
- **MenuItem**: Represents a menu item with an ID, name, price, description, category, image URL, and a flag for whether the item is popular.

### 2. Horizontal Category List
- A `LazyRow` is used to display a horizontal list of food categories.
- Each category has its name and a small icon.

### 3. Vertical Menu Items List
- A `LazyColumn` is used to display a vertical list of menu items.
- Each item includes the food name, price, a small description, an image, and a "Popular" badge for items marked as popular.

### 4. Two Different Layouts for Menu Items
- The app demonstrates two distinct layouts for displaying menu items in the same list.

## Features

- **Horizontal Category List**: Displays a list of food categories at the top of the screen.
- **Vertical Menu Items List**: Displays a list of food items with relevant information.
- **Popular Badge**: Items that are marked as popular will show a "Popular" badge.
- **Responsive Layout**: The app adapts to different screen sizes using Jetpack Compose.



## How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/food-menu-app.git
