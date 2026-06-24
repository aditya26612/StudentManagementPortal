# 🎓 Student Management Portal

A production-style Student Management Portal built using Spring Boot, JSP, JPA/Hibernate, and MySQL following layered architecture and enterprise development practices.

---

## 📌 Project Overview

The Student Management Portal is a web application that allows educational institutions to manage student records efficiently.

The system provides:

* Student Registration
* Student Login & Logout
* Profile Management
* Role-Based Access Control
* Admin Dashboard
* Student Search
* Student Pagination
* Student Details Management
* Secure Password Storage using BCrypt

---

## 🚀 Features

### Authentication Module

* Student Registration
* Student Login
* Student Logout
* BCrypt Password Encryption
* Session Management

### Student Module

* View Profile
* Update Profile
* Session-Based Access Control

### Admin Module

* Admin Dashboard
* View All Students
* Search Students
* View Student Details
* Delete Students
* Pagination Support

### Validation & Security

* DTO-Based Request Validation
* Global Exception Handling
* Unique Email Validation
* Password Encryption
* Role-Based Authorization

---

## 🏗️ Architecture

Client (JSP)
↓
Controller Layer
↓
Service Layer
↓
Repository Layer
↓
MySQL Database

---

## 📂 Project Structure

com.project.studentmanagementportal

├── advice

├── config

├── constants

├── controller

│ ├── AuthController

│ ├── StudentController

│ └── AdminController

├── dto

│ ├── request

│ └── response

├── entity

├── exception

├── mapper

├── repository

├── service

│ ├── AuthService

│ ├── StudentService

│ └── impl

├── util

└── StudentManagementPortalApplication

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* JSP
* JSTL

### Database

* MySQL

### Build Tool

* Maven

### Security

* BCryptPasswordEncoder
* Session-Based Authentication

---

## 🗄️ Database Design

### Student Table

| Column     | Type                |
| ---------- | ------------------- |
| id         | BIGINT              |
| name       | VARCHAR(100)        |
| email      | VARCHAR(100) UNIQUE |
| phone      | VARCHAR(15)         |
| course     | VARCHAR(100)        |
| password   | VARCHAR(255)        |
| status     | VARCHAR(50)         |
| role       | VARCHAR(50)         |
| created_at | TIMESTAMP           |
| updated_at | TIMESTAMP           |

---

## 👥 Roles

### STUDENT

* Login
* View Profile
* Update Profile

### ADMIN

* Dashboard Access
* View All Students
* Search Students
* View Student Details
* Delete Students

---

## 🔍 Search Functionality

Implemented using Spring Data JPA Derived Query Methods.

```java
List<Student> findByNameContainingIgnoreCase(String keyword);
```

Supports case-insensitive student search.

---

## 📄 Pagination

Implemented using:

```java
Page<Student> findAll(Pageable pageable);
```

Supports efficient loading of large student datasets.

---

## ⚙️ Validation

Implemented using Jakarta Validation.

Examples:

```java
@NotBlank
private String name;

@Email
private String email;

@Pattern(...)
private String phone;

@Size(min = 8)
private String password;
```

---

## 🚨 Exception Handling

Global Exception Handling implemented using:

```java
@ControllerAdvice
```

Custom Exceptions:

* StudentNotFoundException
* StudentAlreadyExistsException
* InvalidCredentialsException
* UnauthorizedException

---

## 🔐 Security Features

* BCrypt Password Encryption
* Session Management
* Role-Based Access Control
* Input Validation
* Global Exception Handling

---

## 📸 Application Screens

* Login Page
* Registration Page
* Student Profile Page
* Edit Profile Page
* Admin Dashboard
* Student Listing Page
* Student Details Page

(Add screenshots here)

---

## ▶️ Run Locally

### Clone Repository

```bash
git clone https://github.com/your-username/student-management-portal.git
```

### Configure Database

Update:

```properties
application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management_portal
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

Application:

```text
http://localhost:8080
```

---

## 📚 Concepts Demonstrated

* Java OOP
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate ORM
* DTO Pattern
* Mapper Pattern
* Exception Handling
* Session Management
* Authentication
* Authorization
* Validation
* Pagination
* Layered Architecture
* SOLID Principles

---

## 🔮 Future Enhancements

* Change Password
* Spring Security Integration
* Bootstrap UI
* Unit Testing (JUnit + Mockito)
* Dockerization
* REST API Version
* Email Notifications

---

## 👨‍💻 Author

Aditya Singh Senger

LinkedIn:
[www.linkedin.com/in/aditya-singh-senger-3a982b317](http://www.linkedin.com/in/aditya-singh-senger-3a982b317)

GitHub:
(Add your GitHub Profile Link)
