# Lombok Plugin Tutorial

## Overview
This repository provides a tutorial on how to use **Lombok**, a Java library that helps reduce boilerplate code in Java applications. Lombok provides annotations to automatically generate getters, setters, constructors, and other utility methods, improving code readability and maintainability.

## Tech Stack
- **Java** - Programming language
- **Lombok** - Code-reduction library for Java
- **Spring Boot (Optional)** - If used in a Spring project
- **Maven/Gradle** - Dependency management

## Features Covered
- **Installation and Setup**
- **Using Lombok Annotations:**
  - `@Getter` and `@Setter`
  - `@ToString`
  - `@EqualsAndHashCode`
  - `@NoArgsConstructor` and `@AllArgsConstructor`
  - `@RequiredArgsConstructor`
  - `@Data`
  - `@Builder`
  - `@Slf4j` (for logging)
- **Integrating Lombok with IDEs (IntelliJ, Eclipse, VS Code)**

## Installation and Setup

### Prerequisites
- **Java 8+**
- **Maven/Gradle**
- **IDE with Lombok support (IntelliJ, Eclipse, VS Code)**

### Adding Lombok Dependency
#### Using Maven:
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
```
#### Using Gradle:
```gradle
dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.30'
    annotationProcessor 'org.projectlombok:lombok:1.18.30'
}
```

### Enabling Lombok in IDE
- **IntelliJ IDEA:** Install Lombok Plugin and enable annotation processing.
- **Eclipse:** Install Lombok via Marketplace.
- **VS Code:** Add Lombok support via extension.

## Running the Examples
1. Clone the repository:
   ```sh
   git clone https://github.com/mayurk224/SpringBoot-Practice-Projects
   cd lombok-tutorial
   ```
2. Build and run the project:
   ```sh
   mvn clean install
   mvn spring-boot:run  # If using Spring Boot
   ```

## Future Enhancements
- Add more advanced Lombok use cases.
- Provide real-world project examples.

## License
This project is licensed under the MIT License.

## Author
**Mayur Dilip Kamble**
