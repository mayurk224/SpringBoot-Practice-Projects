# Employee Management System

## Overview

The **Employee Management System** is a full-stack web application built to manage employee records efficiently. This project allows users to perform **CRUD (Create, Read, Update, Delete)** operations on employee data.

## Tech Stack

### Backend:

- **Spring Boot** (Java) - For building REST APIs.
- **Spring Data JPA** - For database interaction.
- **MySQL** - As the relational database.
- **Spring Security (Optional)** - For authentication and authorization (if implemented).

### Frontend:

- **React.js** (using Vite) - For building the user interface.
- **JavaScript** - Core scripting language.
- **Axios** - For making API requests.
- **Bootstrap** (Optional) - For UI styling.

## Features

- Add new employees.
- View all employees.
- Update employee details.
- Delete employees.
- Responsive UI for easy management.

## Installation and Setup

### Prerequisites

- **Java 17+** (For running Spring Boot)
- **Node.js 18+** (For running the React frontend)
- **MySQL Server** (For database management)
- **Postman** (Optional, for testing APIs)

### Backend Setup (Spring Boot)

1. Clone the repository:
   ```sh
   https://github.com/mayurk224/SpringBoot-Practice-Projects
   cd SpringBoot-Practice-Projects
   ```
2. Configure MySQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the backend:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
   The backend will run on `http://localhost:8080`.

### Frontend Setup (React + Vite)

1. Navigate to the frontend folder:
   ```sh
   cd frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the development server:
   ```sh
   npm run dev
   ```
   The frontend will run on `http://localhost:3000`.

## API Endpoints

| Method | Endpoint              | Description          |
| ------ | --------------------- | -------------------- |
| GET    | `/api/employees`      | Fetch all employees  |
| GET    | `/api/employees/{id}` | Fetch employee by ID |
| POST   | `/api/employees`      | Add a new employee   |
| PUT    | `/api/employees/{id}` | Update an employee   |
| DELETE | `/api/employees/{id}` | Delete an employee   |

## Future Enhancements

- Implement authentication & authorization.
- Add pagination and search functionality.
- Deploy the application to cloud services.

## License

This project is licensed under the MIT License.

## Author

**Mayur Dilip Kamble**

