# E-Commerce Test Automation Framework

This is a Test Automation Framework project for an E-Commerce website, developed using Selenium WebDriver and Cucumber BDD in Java. The framework adheres to the Page Factory design pattern, effectively representing test automation best practices. The framework focuses on testing various functionalities, specifically the Checkout, Login, Product Detail Page, and the Product Page.

## Features

The project contains the following feature files:

- Checkout.feature
- Login.feature
- ProductDetailPage.feature
- ProductPage.feature

These features describe the behaviors that will be tested in plain language, making it easy for non-technical stakeholders to understand what is being tested.

## Page Objects

The java/pages directory contains the Page Factory classes:

- BasePage.java
- CheckoutPage.java
- LoginPage.java
- ProductsPage.java

Each page class encapsulates the WebDriver interactions with the elements of that page, and provides methods that allow the tests to interact with those elements in a way that makes sense in the context of the app's functionality.

## Step Definitions

The step definitions for the feature files are contained in:

- CheckoutSteps
- LoginSteps
- ProductSteps

Each step definition file includes the code that implements the behavior described in each step of the feature file.

## Test Runner

The CucumberTestsRunner class in the root of the project is used to execute the tests. The class contains setup and teardown methods for launching and closing the browser, and is annotated to point Cucumber to the feature files and step definitions.

## Project Dependencies

Dependencies for the project are managed with Maven. The key dependencies include:

- Java v18
- Cucumber v7.8.1 (for BDD)
- Cucumber-Junit v7.11.1
- Selenium v4.8.1 (for automated testing)
- Selenium Chrome Driver v4.8.1

## Setup and Running the project

### Prerequisites

1. **Java JDK**: Make sure you have Java 18 installed on your system. If not, you can download it from [here](https://www.oracle.com/java/technologies/javase-jdk18-downloads.html). After installation, set the JAVA_HOME environment variable to the path of the directory containing bin/java.

2. **IDE**: An IDE that supports Java and Maven - IntelliJ IDEA is recommended.

3. **Chromedriver** Download Chromedriber and set the path on `BasePage.launchBrowser() - System.setProperty()`
## Test Runner

The `CucumberTestsRunner` class in the root of the project is used to execute the tests. The class contains setup and teardown methods for launching and closing the browser, and is annotated to point Cucumber to the feature files and step definitions.
You need to configure `CucumberTestsRunner` as your runner on your IDE
1. Open the project in InteliJ IDEA
2. Navigate to the Run -> Edit Configurations... menu option.
3. In the Run/Debug Configurations window, click on the + button at the top left to add a new configuration.
4. In the drop-down list, select TestNG.
5. In the right panel, you need to specify your configuration settings:
Name: This can be anything. This is just to identify your Run configuration.
Class: Click on the ... button next to the Class field. 
This will open a new dialog where you can select your test runner class from your project.
You should navigate to and select your CucumberTestsRunner class and click OK.
6. Click OK to close the Run/Debug Configurations dialog. Your new configuration is now saved and can be run or debugged from the main menu or the toolbar at the top.
7. Run the tests by clicking on the green arrow (Run) in the top right of the IDE. In the drop-down menu, you should see your newly created Run configuration. Click on it to run your tests.


### CucumberTestsRunner.java
```java
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static pages.BasePage.closeBrowser;
import static pages.BasePage.launchBrowser;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = ""
)
```
Assigning Tags: Tags are assigned by using the @ symbol followed by any text you'd like to use as a tag. For example, you might tag all of your smoke tests with @smoke. You add this tag to a scenario or feature by including it on a line by itself before the Scenario or Feature keyword:

```
@smoke
Scenario: A smoke test scenario
```
Using Tags to Run Scenarios: When you run your tests, you can specify which tags to include or exclude. This is done in the CucumberOptions annotation in your test runner class. For example, to run only scenarios with the @smoke tag:

```@CucumberOptions(
tags = "@smoke"
)```
