# Employee Access and Payroll System

## Overview

This project is a menu-driven Employee Payroll System developed using Core Java. It allows creation of Fulltime and Contractual employees, secure salary management, controlled access to employee details, and payroll calculation.

The system enforces authorization rules based on employee roles and handles invalid operations using custom exceptions.

---

## OOP Concepts Used in This Project

### 1. Encapsulation

Encapsulation is implemented in the abstract `Employee` class.

The employee attributes:

* ID
* name
* role
* salary

are declared inside the class and are not accessible directly from outside.

Salary is modified only through the controlled method:

```
changeSalary(Role role, double Salary)
```

This method validates:

* Only HR can change salary
* Salary cannot be negative

Purpose in this code:
To protect salary from unauthorized modification.

---

### 2. Abstraction

Abstraction is implemented using:

Abstract class:

```
abstract class Employee
```

Interface:

```
interface Payrole
```

The interface defines:

```
double calculatepay();
```

The abstract Employee class implements this interface and provides base structure for all employee types.

Purpose in this code:
To define a common template for all employees while allowing different payroll behavior.

---

### 3. Inheritance

Inheritance is implemented using:

```
class FulltimeEmployee extends Employee
class ContractualEmployee extends Employee
```

Both classes reuse properties and methods of Employee class.

Purpose in this code:
To reuse employee data and behavior without rewriting code.

---

### 4. Runtime Polymorphism (Method Overriding)

Runtime polymorphism is implemented by overriding:

```
calculatepay()
```

in:

* FulltimeEmployee
* ContractualEmployee

Example from your code:

```
Employee emp = new FulltimeEmployee(...)
emp.calculatepay();
```

At runtime, the correct method executes based on object type.

Purpose in this code:
To allow different employee types to have different payroll behavior.

---

### 5. Interface Implementation

Interface used:

```
interface Payrole
```

Implemented by:

```
abstract class Employee implements Payrole
```

Purpose in this code:
To enforce payroll functionality for all employee types.

---

### 6. Exception Handling

This project uses both checked and unchecked exceptions.

Checked Exception:

```
class InvalidSalaryException extends Exception
```

Used in:

* Employee constructor
* changeSalary()

Purpose:
To prevent invalid salary values.

---

Unchecked Exception:

```
class UnauthorizedAccessException extends RuntimeException
```

Used in:

* seeDetails()
* changeSalary()

Purpose:
To prevent unauthorized access.

---

Handled in main using:

```
try
catch
```

Exception propagation is used because exceptions are thrown in Employee class and handled in main.

---

### 7. Enum Usage

Enum created:

```
enum Role
{
 HR,
 Others
}
```

Used for authorization checking.

Purpose in this code:
To restrict salary access based on role.

---

### 8. Menu Driven System

Main class:

```
Employee_Payroll_System
```

Provides options:

* Create employee
* View details
* Change salary
* Calculate pay

Uses:

```
Scanner
try-catch
```

Purpose:
To allow user interaction safely.

---

## Security Features Implemented

This system ensures:

* Salary cannot be negative
* Only HR can modify salary
* Unauthorized access is blocked
* Invalid input is handled safely
* Payroll calculated based on employee type

---

## Technologies Used

Java
Core Java
OOP
Custom Exception Handling

---

## Conclusion

This project demonstrates practical implementation of encapsulation, abstraction, inheritance, polymorphism, interface usage, enum, and exception handling to build a secure and controlled employee payroll system.

---

Author:
Sushobhit Chattaraj
