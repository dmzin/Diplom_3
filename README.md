# UI Test Automation — Stellar Burgers

[![Java 11](https://img.shields.io/badge/Java-11-ED8B00?logo=openjdk&logoColor=white)](https://adoptium.net/)
[![JUnit 4](https://img.shields.io/badge/JUnit-4.13.2-25A162?logo=junit5&logoColor=white)](https://junit.org/junit4/)
[![Selenium](https://img.shields.io/badge/Selenium-4.29.0-43B02A?logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![REST Assured](https://img.shields.io/badge/REST%20Assured-5.3.1-64BC4B?style=flat-square)](https://rest-assured.io/)
[![Allure](https://img.shields.io/badge/Allure-2.21.0-EB4D4D?style=flat-square)](https://docs.qameta.io/allure-report/)
[![WebDriverManager](https://img.shields.io/badge/WebDriverManager-5.7.0-0D6EFD?style=flat-square)](https://bonigarcia.dev/webdrivermanager/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.28-FF6F00?style=flat-square)](https://projectlombok.org/)
[![Maven](https://img.shields.io/badge/Maven-3-C71A36?style=flat-square&logo=apache-maven)](https://maven.apache.org)

Automated end-to-end UI test suite for **Stellar Burgers** — a web application for building and ordering custom burgers. The project validates key user journeys including registration, authentication, and constructor navigation while integrating backend API operations for reliable test data management.

Built with **Selenium WebDriver**, **JUnit 4**, **REST Assured**, and **Allure**, the project combines UI and API testing into a maintainable automation framework. The architecture follows the **Page Object Model**, with reusable page classes, API clients, data generators, and shared test infrastructure. Test users are created and removed through the backend API, making the UI scenarios independent, repeatable, and significantly faster than pure UI-based setup.

---

# Tech Stack

| Layer | Technology |
|---|---|
| **Language** | Java 11 |
| **Test Runner** | JUnit 4.13.2 |
| **UI Automation** | Selenium WebDriver 4.29.0 |
| **API Integration** | REST Assured 5.3.1 |
| **Driver Management** | WebDriverManager 5.7.0 |
| **Reporting** | Allure 2.21.0 |
| **Models** | Lombok |
| **Build Tool** | Apache Maven |

---

# Project Architecture

The project follows a layered architecture combining UI automation with backend API utilities.

```
src/
├── main/java/
│
├── client/
│   └── UserClient.java
│
├── generators/
│   └── UserGenerator.java
│
├── model/
│   └── User.java
│
├── pages/
│   ├── BasePage.java
│   ├── MainPage.java
│   ├── LoginPage.java
│   ├── RegisterPage.java
│   └── ForgotPasswordPage.java
│
├── Urls.java
└── Endpoints.java

└── test/java/
    ├── BaseTest.java
    ├── RegistrationTest.java
    ├── LoginTest.java
    └── ConstructorTest.java
```

### Key Design Decisions

- **Page Object Model** — every application page is represented by its own class exposing business-level actions instead of Selenium commands.
- **Shared BasePage** — common interaction methods (`click`, `type`, waits) eliminate duplicated Selenium code.
- **Shared BaseTest** — centralized browser initialization, Page Object creation and test cleanup.
- **API-assisted lifecycle** — users are created and deleted via REST API instead of UI to reduce execution time and improve stability.
- **Randomized test data** — unique users are generated automatically for every test run.
- **Cross-browser execution** — browser selection is controlled through JVM properties.

---

# Implemented Test Scenarios

### Registration

| Scenario | Expected Result |
|---|---|
| Successful registration | Redirect to login page |
| Password shorter than six characters | Validation error displayed |

### Authentication

| Scenario | Expected Result |
|---|---|
| Login from main page | Successful authentication |
| Login via Personal Account | Successful authentication |
| Login from registration page | Successful authentication |
| Login from password recovery page | Successful authentication |

### Constructor Navigation

| Scenario | Expected Result |
|---|---|
| Switch to Sauces | Sauces tab becomes active |
| Switch to Fillings | Fillings tab becomes active |
| Return to Buns | Buns tab becomes active |

---

# Features

- ✅ Page Object Model architecture
- ✅ Shared BasePage and BaseTest abstractions
- ✅ Explicit waits (`WebDriverWait`) without `Thread.sleep`
- ✅ API-driven creation and cleanup of test users
- ✅ Randomized test data generation
- ✅ Cross-browser execution (Chrome / Yandex Browser)
- ✅ Independent and repeatable test execution
- ✅ Allure reporting with step annotations
- ✅ Separation of UI automation and backend utilities

---

# Running the Project

```bash
# Run all tests (Chrome)
mvn clean test

# Run with Yandex Browser
mvn clean test -Dbrowser=yandex

# Generate Allure report
mvn allure:report

# Open Allure report
mvn allure:serve

# Run a single test class
mvn test -Dtest=LoginTest
```

Allure results are generated in:

```
target/allure-results/
```

---

# What This Project Demonstrates

- Selenium WebDriver UI automation
- End-to-end testing of web applications
- Page Object Model architecture
- Explicit wait synchronization strategies
- REST Assured integration for UI test setup
- Backend-assisted test data management
- Cross-browser execution
- Randomized test data generation
- Allure reporting
- Maven build automation

---

# Notes

- Test users are created through the backend API instead of the registration UI, significantly reducing execution time and avoiding unnecessary UI dependencies.
- User accounts are removed automatically during teardown, ensuring each test starts from a clean state.
- All browser synchronization relies on explicit waits (`ExpectedConditions`); no fixed delays (`Thread.sleep`) are used.
- Browser selection is configurable through JVM properties, allowing the same test suite to run against Chrome or Yandex Browser without code changes.
- Authentication tokens obtained through the API are used only for backend cleanup and are never handled through the UI layer.
