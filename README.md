# OpenCart SQA Automation Project

## 📌 Project Overview

This project is an automated testing framework developed for the OpenCart e-commerce application.

The framework uses Selenium WebDriver with Java, TestNG, Maven, and the Page Object Model (POM) design pattern.

The purpose of this project is to automate critical e-commerce functionalities and demonstrate practical Software Quality Assurance and Test Automation skills.

---

## 🛠️ Technologies & Tools

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports
- IntelliJ IDEA
- Git & GitHub
- Chrome WebDriver

---

## 🧪 Automated Modules

The following modules have been automated:

- Login
- Search
- Registration
- Product Details
- Shopping Cart
- Wishlist
- My Account
- Checkout
- Logout

---

## 📋 Test Coverage

The automation suite covers scenarios such as:

- Valid and invalid login
- Login with blank credentials
- Product search
- Product details verification
- Product image and price verification
- Add product to cart
- Update cart quantity
- Remove product from cart
- Add product to wishlist
- Registration with valid and invalid data
- Mandatory field validation
- Password mismatch validation
- My Account access
- Checkout flow
- Logout functionality

---

## 🏗️ Framework Structure

```text
OpenCart-SQA-Automation
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.opencart
│   │           ├── base
│   │           ├── pages
│   │           └── utilities
│   │
│   └── test
│       └── java
│           └── com.opencart
│               └── tests
│
├── testng.xml
├── pom.xml
├── .gitignore
└── README.md
