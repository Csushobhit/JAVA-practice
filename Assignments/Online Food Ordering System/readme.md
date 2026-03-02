# Online Food Ordering System

## Overview

The Online Food Ordering System is a Core Java application that allows creation of Veg and Non-Veg food items, displaying menu, ordering items, and generating the final bill with discount calculation. The system uses Object-Oriented Programming concepts such as abstraction, encapsulation, inheritance, and polymorphism to model real-world food ordering behavior.

---

## OOP Concepts Used in This Project

### 1. Encapsulation

Encapsulation is implemented in the `FoodItem` class.

The attributes:

* Id
* name
* price

are declared as private:

```
private String Id;
private String name;
private double price;
```

They are accessed using public getter methods:

```
getId()
getName()
getPrice()
```

Direct modification from outside the class is not allowed.

Purpose in this code:
To protect food item data and ensure controlled access.

---

### 2. Abstraction

Abstraction is implemented using the abstract class:

```
public abstract class FoodItem
```

This class defines the abstract method:

```
abstract public double calculateDiscount();
```

This forces subclasses to provide their own discount logic.

Purpose in this code:
To provide a common template and enforce discount implementation.

---

### 3. Inheritance

Inheritance is implemented using subclasses:

```
public class VegFoodItem extends FoodItem
public class NonVegFoodItem extends FoodItem
```

Both inherit:

* id
* name
* price
* getter methods

from FoodItem class.

Purpose in this code:
To reuse common food item properties.

---

### 4. Runtime Polymorphism (Method Overriding)

Runtime polymorphism is implemented by overriding:

```
calculateDiscount()
```

in:

* VegFoodItem
* NonVegFoodItem

Example from your code:

```
FoodItem item = menu.get(i);
double discount = item.calculateDiscount();
```

At runtime, correct discount method is called depending on object type.

Purpose in this code:
To apply different discount for Veg and Non-Veg items.

---

### 5. Polymorphism using Parent Reference and Same List

Polymorphism is implemented using:

```
ArrayList<FoodItem> menu = new ArrayList<>();
```

This list stores:

```
VegFoodItem object
NonVegFoodItem object
```

Example from your code:

```
menu.add(new VegFoodItem(...));
menu.add(new NonVegFoodItem(...));
```

Both stored in same list using parent reference.

Purpose in this code:
To manage different item types in a single collection.

---

### 6. Encapsulation in Order Class

Encapsulation is also implemented in:

```
class Order
```

The list:

```
private ArrayList<FoodItem> items;
```

is private.

Access provided using:

```
addItems()
getItems()
calculateTotalBill()
```

Purpose in this code:
To securely manage ordered items.

---

### 7. Method Implementation using calculateTotalBill()

Method:

```
public double calculateTotalBill()
```

This method:

* accesses FoodItem objects
* calls calculateDiscount()
* calculates final bill

Purpose in this code:
To generate total payable amount.

---

### 8. Menu Driven System

Main class provides options:

* Create Veg Item
* Create Non Veg Item
* Show Menu
* Order Item
* Exit

Uses:

```
Scanner
ArrayList
try-catch
```

Handles invalid input using:

```
InputMismatchException
```

Purpose:
To allow user interaction safely.

---

## Functional Features Implemented

This system allows:

* Creating food items
* Storing Veg and Non-Veg items
* Displaying menu
* Ordering items
* Calculating discount
* Generating final bill

---

## Technologies Used

Java
Core Java
OOP
ArrayList
Exception Handling

---

## Conclusion

This project demonstrates practical implementation of encapsulation, abstraction, inheritance, and runtime polymorphism to build a simple and structured food ordering system. It shows how different food items can have different discount logic while being managed in a unified system.

---

Author:
Sushobhit Chattaraj
