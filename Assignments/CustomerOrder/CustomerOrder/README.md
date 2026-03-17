# Customer-Order Management System (Hibernate JPA)

## Project Overview

This project demonstrates the implementation of **Hibernate ORM using Jakarta Persistence (JPA)** in a Java application.

It models a **One-to-One relationship between Customer and Order** and performs database operations using the **DAO (Data Access Object) pattern**.

The application interacts with a **MySQL database** and supports CRUD operations along with a **JPQL query**.

---

## Technologies Used

* Java
* Hibernate ORM
* Jakarta Persistence (JPA)
* MySQL
* Maven
* Eclipse IDE

---

## Project Architecture

The project follows a **layered architecture**.

```id="r27p4n"
Controller (App.java)
        │
        ▼
DAO Layer
(CustomerDAO, OrderDAO)
        │
        ▼
DAO Implementation
(CustomerDAOImpl, OrderDAOImpl)
        │
        ▼
Persistence Layer
(JPA / Hibernate)
        │
        ▼
MySQL Database
```

---

## Project Structure

```id="xjz3b7"
CustomerOrder
│
├── src/main/java
│   ├── com.app.CustomerOrder
│   │   └── App.java
│   │
│   ├── dao
│   │   ├── CustomerDAO.java
│   │   └── OrderDAO.java
│   │
│   ├── dao.impl
│   │   ├── CustomerDAOImpl.java
│   │   └── OrderDAOImpl.java
│   │
│   ├── entity
│   │   ├── Customer.java
│   │   └── Order.java
│   │
│   └── util
│       └── JPAUtil.java
│
└── src/main/resources
    └── META-INF
        └── persistence.xml
```

---

## Entity Relationship Diagram

```id="hlr3iq"
+-----------+          +-----------+
| Customer  | 1 ---- 1 |   Order   |
+-----------+          +-----------+
| id        |          | id        |
| name      |          | orderNo   |
| email     |          | product   |
| gender    |          | quantity  |
| phone     |          | price     |
| regDate   |          | orderDate |
+-----------+          +-----------+
```

* One **Customer** can have **one Order**
* One **Order** belongs to **one Customer**

---

## Hibernate Annotations Used

```id="j9yihc"
@Entity
@Table
@Id
@GeneratedValue
@OneToOne
@JoinColumn
mappedBy
```

These annotations define the **ORM mapping between Java objects and database tables**.

---

## Database Tables

### customers

| Column           | Description          |
| ---------------- | -------------------- |
| id               | Primary Key          |
| customerName     | Name of the customer |
| email            | Customer email       |
| gender           | Gender               |
| phone            | Phone number         |
| registrationDate | Registration date    |

---

### orders

| Column      | Description                      |
| ----------- | -------------------------------- |
| id          | Primary Key                      |
| orderNumber | Unique order number              |
| productName | Product name                     |
| quantity    | Quantity                         |
| price       | Product price                    |
| orderDate   | Order date                       |
| customer_id | Foreign key referencing Customer |

---

## Features Implemented

### Customer Operations

* Insert Customer with Order
* Update Customer
* Delete Customer by ID
* Fetch Customer by ID
* Fetch All Customers

### Order Operations

* Update Order details
* Fetch Order by ID

---

## JPQL Query

Fetch a customer using email.

```id="zty2h4"
SELECT c FROM Customer c WHERE c.email = :email
```

JPQL works on **entity classes instead of database tables**.

---

## How to Run the Project

1. Clone the repository
2. Open the project in **Eclipse**
3. Configure database credentials inside `persistence.xml`
4. Create the database

```id="7fuz0x"
CREATE DATABASE customerdb;
```

5. Run the main class

```id="v1pxq0"
App.java
```

Hibernate will automatically create the required tables.

---

## Author

**Sushobhit Chattaraj**
Institute of Engineering and Management
Department of Computer Science and Engineering (AI)
