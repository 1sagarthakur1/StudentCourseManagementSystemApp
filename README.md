# 🎓 Student Course Management System

A Spring Boot web application to manage students and the courses they are enrolled in. Built with a clean layered architecture using Spring Boot, Spring Data JPA, and JPQL.

---

## 📌 Features

- ✅ Add new students and courses
- ✅ Enroll a student into a course
- ✅ View all students along with their enrolled courses
- ✅ Search students by course name using JPQL
- ✅ Delete students or courses
- ✅ Custom exception handling with `@ControllerAdvice`

---

## 🧱 Architecture

- **Controller Layer**: Exposes RESTful API endpoints.
- **Service Layer**: Contains core business logic.
- **Repository Layer**: Interacts with the database using Spring Data JPA and JPQL.

---

## ⚙️ Tech Stack

| Technology       | Description                     |
|------------------|---------------------------------|
| Java 17+         | Programming language            |
| Spring Boot      | Application framework           |
| Spring Data JPA  | ORM layer                       |
| MySQL       | Database (configurable)         |
| Maven            | Build tool                      |
| Swagger          | API documentation (optional)    |
| Postman          | API testing                     |

---

## 🔗 API Endpoints

| Method | Endpoint                      | Description                        |
|--------|-------------------------------|------------------------------------|
| POST   | `/student`                   | Add a new student                  |
| POST   | `/course`                    | Add a new course                   |
| POST   | `/student/{studentId}/enroll/{courseId}` | Enroll a student in a course       |
| GET    | `/students`                   | Get all students                   |
| GET    | `/students/course/{name}` | Get students by course name        |
| GET    | `/courses`              | Geta all course |
| DELETE | `/student/{id}`              | Delete student by ID               |
| DELETE | `/course/{id}`               | Delete course by ID                |

---

## 📄 JPQL Queries

- 🔍 Find all students enrolled in a specific course
- 🔍 List all courses with  students

---

## 🚨 Exception Handling

Handled using `@RestControllerAdvice`. Example response:

```json
{
  "timestamp": "2025-06-13T12:45:30.123",
  "status": 404,
  "error": "Not Found",
  "message": "Student not found"
}


