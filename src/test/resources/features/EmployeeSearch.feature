@employeeSearch
Feature: Search Employee
	@smoke 
	Scenario: Search for Employee by ID
		Given user is logged in with valid credentials
		And   user navigates to employee list page
		When  user enter valid employee ID
		And   clicks on search button
		Then  employee information is displayed
@regression		
Scenario: Search for Employee by Name
		Given user is logged in with valid credentials
		And   user navigates to employee list page
		When  user enter valid employee first and last name
		And   clicks on search button
		Then  employee information is displayed
		