# Smart Resource Monitoring System

## Overview

The Smart Resource Monitoring System is a menu-driven Core Java application that monitors system resources such as CPU, Memory, and Disk usage. The system checks resource health, detects overload conditions, and handles failures safely using custom exceptions.

It uses Object-Oriented Programming concepts to ensure secure data handling, abstraction of resources, and dynamic health monitoring based on resource type.

---

## OOP Concepts Used in This Project

### 1. Encapsulation

Encapsulation is implemented in the abstract `Resource` class.

The attribute:

```
private double usage;
```

is declared private and cannot be accessed directly from outside the class.

It is accessed and modified only using controlled methods:

```
public double getUsage()
public void setUsage(double usage)
```

The setter method validates that usage is between 0 and 100.

Purpose in this code:
To protect resource usage data and prevent invalid values.

---

### 2. Abstraction

Abstraction is implemented using:

```
abstract class Resource
```

This class provides a common template for all resources and defines:

Abstract method:

```
public abstract void checkHealth() throws ResourceOverloadException;
```

Concrete method:

```
public void displayUsage()
```

Purpose in this code:
To define common structure while allowing each resource to implement its own health logic.

---

### 3. Inheritance

Inheritance is implemented using:

```
class CPUResource extends Resource
class MemoryResource extends Resource
class DiskResource extends Resource
```

These classes inherit common properties and methods from the Resource class.

Purpose in this code:
To reuse common monitoring functionality.

---

### 4. Runtime Polymorphism (Method Overriding)

Runtime polymorphism is implemented by overriding:

```
checkHealth()
```

in:

* CPUResource
* MemoryResource
* DiskResource

Example from your code:

```
Resource resource = new CPUResource();
resource.checkHealth();
```

At runtime, the correct method executes based on object type.

Purpose in this code:
To allow different health conditions for different resources.

---

### 5. Exception Handling

This project uses both checked and unchecked exceptions.

Checked Exception:

```
class ResourceOverloadException extends Exception
```

Used when resource usage exceeds warning level.

Example:

```
throw new ResourceOverloadException("CPU overload detected");
```

Purpose:
To indicate overload condition that must be handled.

---

Unchecked Exception:

```
class CriticalFailureException extends RuntimeException
```

Used when resource usage exceeds critical level.

Example:

```
throw new CriticalFailureException("CPU critical failure");
```

Purpose:
To indicate serious system failure.

---

Handled in main using:

```
try
catch
finally
```

Exception propagation is used because exceptions are thrown in resource classes and handled in main.

Purpose:
To prevent system crash and maintain stability.

---

### 6. Method Implementation through Separate Monitor Class

Class used:

```
class Monitor
```

Method:

```
public static void monitor(Resource resource)
```

This method accepts parent class reference and calls:

```
resource.displayUsage()
resource.checkHealth()
```

Purpose in this code:
To achieve polymorphic monitoring of all resources.

---

### 7. Menu Driven System

Main class provides options:

* Monitor CPU
* Monitor Memory
* Monitor Disk
* Exit

Uses:

```
Scanner
try-catch
```

Handles invalid input using:

```
InputMismatchException
IllegalArgumentException
```

Purpose:
To allow safe user interaction.

---

## System Safety Features

This system ensures:

* Resource usage cannot be invalid
* Overload conditions are detected
* Critical failures are handled
* Invalid input is handled safely
* System does not crash

---

## Technologies Used

Java
Core Java
OOP
Custom Exception Handling

---

## Conclusion

This project demonstrates practical implementation of encapsulation, abstraction, inheritance, runtime polymorphism, and exception handling to build a secure and stable system resource monitoring application.

---

Author:
Sushobhit Chattaraj
