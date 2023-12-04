## MVVM in Android Development

This CodeLab demonstrates the MVVM architecture pattern in Android.

### Code Demo

In this demo, we will refactor the provided code in the `main` branch to follow MVVM and discuss its benefits.

#### Steps:

-[] Implement a new class called `ProductsViewModel` that extends `ViewModel`.
-[] Set up LiveData for the products result and an error message in `ProductsViewModel`.
-[] Implement a function in `ProductsViewModel` called `retrieveProducts` to display the list of products at the start of the app.
-[] Implement the `updateProduct` function in the `ProductsViewModel`. This function allows users to add a product to their favorites or remove it from their favorites.
-[] Remove any unnecessary code from the MainActivity.

**Note:**
When writing the MODEL code for business and data logic, use only the functions exposed by `DataManager`. Do not modify or write the code yourself.

### Tasks

The tasks are ordered from easy to hard, enabling you to better grasp how MVVM patterns enhance code testability and maintainability. It is strongly advised to solve them sequentially.

#### Task 1

Try to refactor the code in the `main` branch to follow MVVM on your own.

*Reflections:*
- Familiarize yourself with the steps and components of Google Architecture.
#### Task 2

Implement a simple search feature to search the product list by name.

*Reflections:*
-  Notice the complexity to add new features and determine if the code is more scalable with MVVM.
#### Task 3

Write unit tests for your ViewModel implementation.

*Reflections:*
- Notice the complexity involved in testing the presentation code and observe the coupling in MVVM architecture.
- Familiarize yourself with how to write unit tests for ViewModels.
#### Task 4

Refactor the implementation of the Activity to use a Fragment instead.

*Reflections:*
- Determine if it is easier or harder to refactor to a new UI component.
- Observe the complexity of decoupling between `ViewModel` and the implemented `Fragment` or `Activity`.
- Consider the amount of code that has been modified.