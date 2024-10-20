# Orange HRM Web UI Automation

## Project Overview
This project automates the user interface of the Orange HRM demo site using Java Selenium. The automation framework is built on the Page Object Model (POM) design pattern, ensuring maintainability and scalability. TestNG is utilized for organizing and executing tests, with plans to implement Extent Reports for enhanced reporting.

## Features
- **Cross-Browser Support**: Runs on Chrome, Firefox, Edge, and Safari.
- **Test Organization**: Uses TestNG for structured test execution.
- **Design Pattern**: Implements the Page Object Model for better code organization.

## Prerequisites
Before running the project, ensure you have the following installed:
- Java Development Kit (JDK) 8 or higher
- Maven
- WebDriver for the browsers you intend to test (ChromeDriver, GeckoDriver, etc.)
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/yourusername/orange-hrm-automation.git
cd orange-hrm-automation
```


### Setup and Execution Steps

#### Set Up the Project
* **Import the Project**: Open your IDE and import the cloned project as a Maven project.
* **Add WebDriver Dependencies**: Ensure that the necessary WebDriver binaries are available in your system PATH or specify their locations in the project.


# OrangeHRM Web UI Automation

## Overview
This project is a **Web UI Automation Framework** for [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com/) using **Java**, **Selenium**, and the **Page Object Model (POM)** design pattern. It automates various UI functionalities of the OrangeHRM demo site, enabling regression testing for the web application across multiple browsers including **Chrome**, **Firefox**, **Edge**, and **Safari**. 

The framework is built with **TestNG** for test execution and organization, and it is designed to be extendable for further test cases and features. Future versions will include advanced reporting using **Extent Reports**.

## Key Features
- Cross-browser support for **Chrome**, **Firefox**, **Edge**, and **Safari**.
- **Page Object Model (POM)** design pattern for cleaner and maintainable code.
- Integrated with **TestNG** for parallel execution, suite management, and test organization.
- Easy configuration for different environments and browsers.
- Scalable and extendable architecture for adding more test cases and functionality.
- **Extent Reports** (To Be Implemented) for comprehensive test execution reports.

## Prerequisites
Before you can run the automation script, ensure that the following are installed and set up on your local machine:

- **Java JDK** (version 8 or higher)
- **Maven** (for dependency management)
- **Selenium WebDriver** 
- **TestNG** (for test execution)
- **Git** (for version control)
- **Browsers**: Chrome, Firefox, Edge, or Safari (with corresponding WebDriver installed)
- IDE (e.g., **IntelliJ IDEA** or **Eclipse**)

## Project Setup & Execution

### 1. Clone the Repository
First, clone the project from the GitHub repository to your local machine using the following command:
```bash
git clone https://github.com/yourusername/orangehrm-automation.git
```

### 2. Import the Project into Your IDE
1. Open your preferred IDE (e.g., IntelliJ IDEA or Eclipse).
2. Select **File > Open** and navigate to the folder where you cloned the repository.
3. Choose the project folder and click **Open**.
4. Ensure that the IDE detects the project as a **Maven Project**. If not, right-click on the `pom.xml` file and choose **Add as Maven Project**.

### 3. Install Dependencies
Maven will automatically download all required dependencies, such as **Selenium**, **TestNG**, and browser drivers. If this does not happen automatically, run:
```bash
mvn clean install
```

### 4. Configure WebDriver Paths
For each browser you wish to test (Chrome, Firefox, Edge, Safari), ensure that you have the respective WebDriver installed:
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
- [GeckoDriver](https://github.com/mozilla/geckodriver/releases) (for Firefox)
- [EdgeDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
- Safari WebDriver (pre-installed with macOS)

Ensure the drivers are either added to your system's PATH or update the path in the framework's configuration file.

### 5. Running the Tests
You can run the tests using **TestNG** from your IDE or through the command line. 

#### Option 1: Run from IDE
- Open the `testng.xml` file.
- Right-click and choose **Run 'testng.xml'**.

#### Option 2: Run from Command Line
- Navigate to the project directory and run:
```bash
mvn test
```

### 6. Configuring Browser for Test Execution
To run the tests on a specific browser, you can update the **`testng.xml`** file or pass the browser parameter through the command line.

Example (for Chrome):
```bash
mvn test -Dbrowser=chrome
```

Other available options are `firefox`, `edge`, and `safari`.

### 7. Future Enhancement: Extent Report Integration
The next iteration of this project will include **Extent Reports** for detailed test execution reports, including screenshots for failures and logs for passed, failed, and skipped tests. Keep an eye on future updates!

### 8. Test Results
Once tests are executed, the results can be viewed directly in the console or in the generated **TestNG reports** in the `test-output` folder. Once Extent Reports are integrated, more detailed and visually appealing reports will be available.

## Project Structure
Here’s a quick overview of the project structure:

```
src
 ├── main
 │    └── java
 │         └── pageobjects
 │         └── utils
 ├── test
      └── java
           └── testcases
           └── resources
           └── testng.xml
pom.xml
README.md
```

- **`pageobjects`**: Contains Page Object classes for each page of the OrangeHRM demo site.
- **`testcases`**: Test classes that define the actual test scenarios.
- **`utils`**: Utility classes for configurations, browser setup, and reusable methods.
- **`testng.xml`**: Configuration file for TestNG that defines test suites, test cases, and parameters.

## Future Enhancements
- Integration of **Extent Reports** for enhanced reporting.
- Adding more test cases to cover additional modules of the OrangeHRM application.
- Support for parallel execution across multiple browsers.

## Contributing
Contributions to this project are welcome! Please feel free to fork the repository and submit pull requests. 

