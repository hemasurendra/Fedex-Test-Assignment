# Fedex Test Assignment

This is a POC of test automation for the FedEx UI Automation. This is a maven project that implements a serenity BDD framework which is wrapped on top of selenium with extra capabilities. Serenity reporting is clear and informative for debugging if required.


## Table of Contents
* [Functionality](#functionality)
* [Behaviour Driven Development](#behavior-driven-development)
* [Test Framework](#test-framework)
* [How to Run the tests](#how-to-run-the-tests)

# Functionality
The following flows has been automated:
  1. Register into Fedex application
  2. Login into application
  3. Calculate Shipping rate
  4. Tracking of shipment 
  
# Behavior Driven Development
BDD is a software development approach that allows the tester/business analyst to create test cases in simple text language. The test cases here in the automation framework are added in BDD format.

### Why BDD format?
    1) BDD allows the decoupling of system behaviour
    2) Using BDD format helps stakeholders to understand the test cases very easily
        
# Test Framework
* Serenity core (which includes selenium) for interaction with UI and implementation of Page Object Model
* assertJ assertions has been used for all the test validations.
* Serenity BDD has a great test reporting which can be used as a living documentation.

### Why Serenity BDD?
		1) Easy Maintainability and Reusability
		2) Run time session variable creation
		3) Readability of tests
		4) Living documentation of test results
		5) Opensource tool with huge support Online
        
# How to Run the tests

	# Pre-requisite:
	* JDK 8
	* Maven is installed in the machine and configured properly


## 1) Using Maven

	Open a command window and run:

		WindowsOS:	mvn clean verify

		MacOs : mvn clean verify 

	To Run Specific Tags of a test (Specific group of tests):

	  	mvn clean verify -Dcucumber.options="--tags @TAGNAME"
	 
	To Run without headless mode:
    
    	  	mvn clean verify -Dheadless.mode=false  	

## 2) Using IDE
	Open the cloned project in IDE. Enable Auto-Import for Maven-dependency
	Run Testrunner files in the path (\src\test\java\runner\RunAllTest.java)


## 3) Test Result
Serenity BDD has one of the best reporting and the test reports are generated every time we execute the tests.
When the project is cloned into Local, test results reporting, along with screenshots, can be seen if we open **_`index.html`_** from `(target\site\serenity\index.html)`.

Sample reports look like this ![Serenity Reports](FinalResult.png?raw=true "Serenity Reports")
