# Banking Application (Backend)

## Overview
The **Banking Application** is a backend project built using **Spring Boot** that provides fundamental banking operations. It includes features for account management, transactions, and error handling to ensure secure and smooth financial operations.

## Tech Stack
- **Spring Boot** - For building RESTful APIs.
- **Spring Data JPA** - For database interaction.
- **MySQL** - As the relational database.
- **Spring Security (Optional)** - For securing endpoints.
- **Lombok** - For reducing boilerplate code.

## Features
- **Account Management:**
  - Create a new bank account.
  - Close an existing account.
- **Transactions:**
  - Deposit money.
  - Withdraw money.
  - Transfer funds between accounts.
- **Transaction History:**
  - View a list of past transactions.
- **Exception Handling:**
  - Prevent transfers with zero balance.
  - Handle invalid account operations.

## Installation and Setup

### Prerequisites
- **Java 17+** (For running Spring Boot)
- **MySQL Server** (For database management)
- **Postman** (Optional, for API testing)

### Backend Setup (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/mayurk224/SpringBoot-Practice-Projects
   cd banking-app
   ```
2. Configure MySQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
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

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/api/accounts` | Create a new account |
| DELETE | `/api/accounts/{id}` | Close an account |
| POST | `/api/accounts/deposit` | Deposit money |
| POST | `/api/accounts/withdraw` | Withdraw money |
| POST | `/api/accounts/transfer` | Transfer funds between accounts |
| GET | `/api/transactions/{accountId}` | Get transaction history for an account |

## Future Enhancements
- Implement user authentication & authorization.
- Add interest calculations for savings accounts.
- Deploy the application to cloud services.

## License
This project is licensed under the MIT License.

## Author
**Mayur Dilip Kamble**

