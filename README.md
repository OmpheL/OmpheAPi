# 🚀 Omphe Ndosi API Automation Project

## 📌 Project Overview
This project is an API automation framework built using **RestAssured, TestNG, and Maven**.  
It automates the full user lifecycle:

- Create a new user
- Approving the user (Admin)
- Assigning admin role
- Logging in as the new user
- Verifying admin privileges
- Deleting the user

---

## 🏗️ Framework Structure

```

RestAssuredFirstGroup2026/
├── pom.xml
├── README.md
├── reports/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/
│   │           └── PayloadStore.java
│   └── test/
│       └── java/
│           ├── common/
│           │   ├── BaseTest.java
│           │   └── BaseURIs.java
│           ├── payloadBuilder/
│           │   └── PayloadBuilder.java
│           ├── requestBuilder/
│           │   └── ApiRequestBuilder.java
│           ├── tests/
│           │   └── UserRegistrationTest.java
│           └── utils/
│               ├── ExtentManager.java
│               ├── Requests.java
│               └── TestListener.java

````

---

## ⚙️ Technologies Used

- Java
- RestAssured
- TestNG
- Maven
- Extent Reports

---

## 🔑 Test Scenario Covered

### ✅ User Lifecycle Automation
1. Register a new user
2. Login as Admin
3. Approve user
4. Assign Admin role
5. Login as new user
6. Verify user role = Admin
7. Delete user

---

## ▶️ How to Run Tests

### 🔹 Run all tests
```bash
mvn test
````

### 🔹 Run specific test

```bash
mvn -Dtest=UserRegistrationTest test
```

---

## 📊 Test Reports

After execution, open:

```
reports/ExtentReport.html
```

👉 This contains:

* Test steps
* Pass/Fail status
* Logs

---

## 🔐 Test Data

> ⚠️ Note: Test data used in this project is for testing purposes only and does not represent real user data.

---

## 👤 Admin Credentials (For Testing)

```
Email: testdummy@email.co.za
Password: testdummy@email.co.za
```

---

## 💡 Key Features

* Clean framework structure
* Reusable request builder
* Dynamic test data generation
* Token-based authentication handling
* Extent reporting integration

---

## 🚀 Future Improvements

* Add CI/CD integration (Jenkins/GitHub Actions)
* Add parallel test execution
* Add data-driven testing
* Add API schema validation

---

## 👩🏽‍💻 Author

**Omphemetse Lekaba**
QA Automation Engineer

---

````

---
