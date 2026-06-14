# BlazeDemo Flight Booking Automation Framework

<div align="center">

Enterprise-grade Selenium Test Automation Framework built using **Java, Selenium WebDriver, TestNG, Maven, Jenkins, Docker, Extent Reports, and Log4j2**.

[![Java](https://img.shields.io/badge/Java-17+-orange)]()
[![Selenium](https://img.shields.io/badge/Selenium-4.x-green)]()
[![TestNG](https://img.shields.io/badge/TestNG-Framework-red)]()
[![Maven](https://img.shields.io/badge/Maven-Build-blue)]()
[![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-yellow)]()
[![Docker](https://img.shields.io/badge/Docker-Containerized-blue)]()

</div>

 - **Prepared By:** Mr. Baivab Sarkar
- **Mentor/ Trainer:** Mrs. Vaishali Sonanis

---

## Overview

The BlazeDemo Flight Booking Automation Framework is a scalable, maintainable, and enterprise-ready test automation solution developed as part of the Wipro Capstone Project.

The framework automates the complete flight booking workflow of the BlazeDemo web application while following industry-standard automation design principles such as:

- Page Object Model (POM)
- Data-Driven Testing
- Cross-Browser Testing
- CI/CD Integration
- Containerized Test Execution
- Automated Reporting & Logging

Application Under Test:

**URL:** https://blazedemo.com/

---

## Business Flow Covered

The framework validates the complete end-to-end booking journey:

1. Home Page Validation
2. Departure and Destination Selection
3. Flight Search
4. Flight Selection
5. Passenger Information Entry
6. Payment Information Submission
7. Booking Confirmation Validation
8. Negative Testing Scenarios
9. Login & Registration Validation

---

# Technology Stack

| Category | Technology |
|-----------|------------|
| Language | Java 17 |
| Automation Tool | Selenium WebDriver 4 |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Reporting | Extent Reports |
| Logging | Log4j2 |
| Test Data | Excel (Apache POI) |
| CI/CD | Jenkins |
| Containerization | Docker |
| Version Control | Git & GitHub |

---

# Framework Architecture

```text
BlazeDemo
│
├── src/test/java
│   ├── base
│   ├── listeners
│   ├── pages
│   ├── testcases
│   └── utilities
│
├── src/test/resources
│   ├── config
│   ├── testdata
│   └── log4j2.xml
│
├── reports
├── screenshots
├── Jenkinsfile
├── Dockerfile
├── pom.xml
├── testng.xml
└── testng-negative.xml
```

---

# Framework Features

## Page Object Model (POM)

All web elements and page actions are separated from test logic, ensuring:

- Better maintainability
- High reusability
- Easy scalability
- Reduced code duplication

---

## Data-Driven Testing

Test data is maintained externally using Excel files.

Supported validations:

- Multiple passenger records
- Different city combinations
- Multiple payment datasets

---

## Automated Reporting

Extent Reports provide:

- Execution summary
- Test status
- Screenshots
- Execution timestamps
- Failure details

Generated Report:

```text
reports/ExtentReport.html
```

---

## Logging

Log4j2 implementation captures:

- Browser launch events
- Test execution flow
- Validation checkpoints
- Failure information

Log File:

```text
log/automation.log
```

---

## Screenshot Capture

Automatic screenshots are captured:

- On failures
- During booking confirmation
- For reporting evidence

---

# Test Coverage

## Positive Scenarios

✔ Home Page Validation

✔ Flight Search Validation

✔ Flight Selection

✔ Purchase Form Submission

✔ Booking Confirmation Validation

---

## Negative Scenarios

✔ Blank Passenger Information

✔ Invalid Payment Data

✔ Invalid Credit Card Information

✔ Invalid Expiry Month

✔ Invalid Expiry Year

✔ Login Failure Validation

✔ Registration Failure Validation

---

# Defects Identified

The project successfully identified multiple application defects including:

| Defect ID | Description |
|------------|-------------|
| BLAZE-7 | Booking succeeds with blank fields |
| BLAZE-8 | Missing input validation |
| BLAZE-9 | Invalid month accepted |
| BLAZE-10 | Expired year accepted |
| BLAZE-11 | Mandatory fields not marked |
| BLAZE-12 | Credit card length validation missing |
| BLAZE-13 | Login/Registration returns HTTP 419 |

---

# Execution Results

## Positive Suite

| Metric | Result |
|---------|---------|
| Executed | 12 |
| Passed | 12 |
| Failed | 0 |
| Success Rate | 100% |

## Negative Suite

| Metric | Result |
|---------|---------|
| Executed | 3 |
| Passed | 3 |
| Failed | 0 |

---

# CI/CD Pipeline

Jenkins Pipeline Stages:

```text
Checkout
   ↓
Build
   ↓
Compile
   ↓
Test
   ↓
Docker Build
   ↓
Docker Run
   ↓
Post Actions
```

Benefits:

- Automated execution
- Continuous validation
- Faster feedback cycle
- Deployment-ready workflow

---

# Docker Execution

Framework is fully containerized using Docker.

Build Image

```bash
docker build -t blazedemo-framework .
```

Run Container

```bash
docker run --rm blazedemo-framework
```

---

# Running the Framework

## Clone Repository

```bash
git clone https://github.com/ThisIs-Developer/Wipro-Capstone-Project.git
```

## Install Dependencies

```bash
mvn clean install
```

## Execute Positive Suite

```bash
mvn test
```

## Execute Negative Suite

```bash
mvn test -DsuiteXmlFile=testng-negative.xml
```

---

# Browser Configuration

Update:

```properties
src/test/resources/config/config.properties
```

Example:

```properties
browser=chrome
url=https://blazedemo.com/
```

Supported Browsers:

- Chrome
- Firefox
- Edge

---

# Key Achievements

- Enterprise-level framework architecture
- 100% execution success rate
- End-to-End automation coverage
- Jenkins CI/CD integration
- Docker containerization
- Detailed reporting and logging
- Defect identification and tracking
- Scalable and maintainable design


---

# License

This project is developed for educational and demonstration purposes as part of the Wipro Capstone Project.
