# Secure Banking Transaction Engine

## Overview

The Secure Banking Transaction Engine is a Core Java application designed to simulate real-world banking operations such as deposit and withdrawal while ensuring data security, validation, and system stability. The system is implemented using fundamental Object-Oriented Programming concepts and custom exception handling to ensure safe and controlled transaction processing.

---

## Implementation of OOP Concepts

### 1. Encapsulation

Encapsulation is implemented by declaring all account attributes such as account number, account holder name, and balance as private.

The balance is not directly accessible from outside the class. It can only be accessed using controlled public methods such as:

* getBalance()
* deposit()
* withdraw()

This ensures that the balance cannot be modified without proper validation and prevents unauthorized access.

Purpose:
To protect sensitive data and maintain data integrity.

---

### 2. Abstraction

Abstraction is implemented using an abstract class named BankAccount.

The abstract class provides a common template for all account types and defines common methods such as:

* deposit()
* withdraw()
* getBalance()

The internal implementation details are hidden, and only essential functionality is exposed.

Purpose:
To provide a common structure and hide implementation complexity.

---

### 3. Inheritance

Inheritance is implemented by creating subclasses:

* SavingsAccount
* CurrentAccount

Both classes extend the BankAccount class.

They inherit common properties and methods from the parent class and also provide their own specific behavior.

Purpose:
To reuse code and establish a relationship between general and specialized classes.

---

### 4. Runtime Polymorphism (Method Overriding)

Runtime polymorphism is implemented by overriding the withdraw() method in SavingsAccount and CurrentAccount classes.

Each account type applies its own transaction rules.

The method is called using the parent class reference, and the correct method is selected at runtime based on the object.

Purpose:
To allow different behavior for different account types using the same method name.

---

### 5. Compile Time Polymorphism (Method Overloading)

Method overloading is implemented by creating multiple versions of deposit() and withdraw() methods with different parameters.

Examples:

deposit(double amount)
deposit(double amount, String mode)

withdraw(double amount)
withdraw(double amount, String remarks)

Purpose:
To provide multiple ways to perform the same operation depending on input.

---

### 6. Exception Handling

Custom exceptions are created to handle invalid and unsafe transactions.

Checked Exception:

InvalidAmountException
This exception is used when the transaction amount is invalid such as negative or zero.

Unchecked Exception:

InsufficientBalanceException
This exception is used when the withdrawal amount exceeds the available balance.

The system uses:

* try block to execute risky operations
* catch block to handle exceptions
* finally block to ensure system stability

Purpose:
To prevent system crash and ensure secure transaction handling.

---

## Security and Validation Features

The system ensures the following:

* Balance cannot be negative
* Withdrawal beyond balance is prevented
* Invalid transaction amounts are rejected
* Direct access to balance is restricted
* Errors are handled safely

---

## Technologies Used

Java
Core Java OOP
Custom Exception Handling

---

## Conclusion

This project demonstrates the practical implementation of Object-Oriented Programming concepts in a real-world banking scenario. It ensures secure data handling, proper validation, and reliable system behavior using abstraction, encapsulation, inheritance, polymorphism, and exception handling.

---

Author:
Sushobhit Chattaraj

