# Student Management System (JDBC Console Application)

## Overview

The Student Management System is a console-based Java application that performs database operations using JDBC and MySQL. It allows users to add, update, delete, and view student records stored in a relational database.

The system uses PreparedStatement for all database operations to ensure security, efficiency, and proper handling of SQL queries.

---

## JDBC Concepts Used in This Project

### 1. JDBC Driver Loading

The MySQL JDBC driver is loaded using:

```
Class.forName("com.mysql.cj.jdbc.Driver");
```

Purpose in this code:
To register the MySQL driver so Java can communicate with the database.

---

### 2. Establishing Database Connection

Connection is created using:

```
Connection con = DriverManager.getConnection(url, username, password);
```

Purpose in this code:
To establish connection between Java application and MySQL database.

This connection is used for executing SQL queries.

---

### 3. Use of PreparedStatement

PreparedStatement is used for all database operations:

Example from your code:

Insert:

```
ps = con.prepareStatement("INSERT INTO Student VALUES (?, ?, ?)");
```

Update:

```
ps = con.prepareStatement("UPDATE Student SET marks=? WHERE id=?");
```

Delete:

```
ps = con.prepareStatement("DELETE FROM Student WHERE id=?");
```

Select:

```
ps = con.prepareStatement("SELECT * FROM Student");
```

Purpose in this code:

* Prevent SQL Injection
* Improve performance
* Safely pass user input into queries

This satisfies requirement of not using Statement.

---

### 4. Executing Update Queries

For INSERT, UPDATE, DELETE:

```
ps.executeUpdate();
```

Purpose in this code:
To execute queries that modify database records.

Return value is used to check success.

Example:

```
int j = ps.executeUpdate();
```

---

### 5. Executing Select Queries

For SELECT operations:

```
ResultSet rs = ps.executeQuery();
```

Purpose in this code:
To retrieve data from database.

Data is accessed using:

```
rs.getInt("id")
rs.getString("name")
rs.getDouble("marks")
```

---

### 6. ResultSet Handling

ResultSet is used to read student records:

Example from your code:

```
while(rs.next())
{
 System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("marks"));
}
```

Purpose in this code:
To display database records.

---

## Menu Driven System

The system provides the following options:

1. Add Student
2. Update Student
3. Delete Student
4. View All Students
5. View Student by ID
6. Exit

Implemented using:

```
do-while loop
switch-case
Scanner
```

Purpose:
To allow user to perform database operations interactively.

---

## Exception Handling

Exception handling is implemented using:

Try block:

```
try
{
 database operation
}
```

Catch block:

```
catch(SQLException e)
{
 System.out.println("Database Error" + e);
}
```

Purpose in this code:

* Prevent program crash
* Handle database errors safely

Global exception handling:

```
catch(Exception e)
{
 e.printStackTrace();
}
```

---

## Database Table Structure

Table used:

```
Student
```

Fields:

```
id INT PRIMARY KEY
name VARCHAR(50)
marks DOUBLE
```

---

## Functional Features Implemented

This system allows:

* Insert new student record
* Update student marks
* Delete student record
* View all students
* View student by ID

All operations use PreparedStatement.

---

## Technologies Used

Java
JDBC
MySQL
PreparedStatement
ResultSet

---

## Conclusion

This project demonstrates practical implementation of JDBC using PreparedStatement to perform secure and efficient database operations. It shows how Java applications interact with relational databases while ensuring proper exception handling and user interaction.

---

Author:
Sushobhit Chattaraj
