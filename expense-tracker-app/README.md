# Personal Expense Tracker (Backend)

## Overview
The **Personal Expense Tracker** is a backend project built using **Spring Boot** that helps users manage their financial transactions efficiently. It provides APIs for tracking income and expenses, categorizing transactions, and generating reports.

## Tech Stack
- **Spring Boot** - For building RESTful APIs.
- **Spring Data JPA** - For database interaction.
- **MySQL** - As the relational database.
- **Lombok** - For reducing boilerplate code.

## Features
- **User Management:**
  - Register and authenticate users.
- **Expense & Income Management:**
  - Add income and expense transactions.
  - Update and delete transactions.
  - Categorize transactions.
- **Reports & Insights:**
  - View total income, expenses, and savings.
  - Get transaction history for a specific period.
- **Exception Handling:**
  - Prevent invalid transactions.
  - Handle incorrect input values.

## Installation and Setup

### Prerequisites
- **Java 17+** (For running Spring Boot)
- **MySQL Server** (For database management)
- **Postman** (Optional, for API testing)

### Backend Setup (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/mayurk224/SpringBoot-Practice-Projects
   cd expense-tracker-backend
   ```
2. Configure MySQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
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

## Future Enhancements
- Implement authentication & authorization.
- Add recurring transactions feature.
- Deploy the application to cloud services.

## License
This project is licensed under the MIT License.

## Author
**Mayur Dilip Kamble**

