Feature:  Login

Scenario: Valid Login
	Given I navigate to HRMS application
	When I enter valid username
	And  I enter valid password
	And I click login button
	Then I validate that I am logged in 
	And I  quit the browser

Scenario: Invalid Password
Given I navigate to HRMS application
When I enter valid username
And  I enter invalid password
And I click login button
Then I validate that invalid credentials message is displayed.  
And I  quit the browser

	@homework
	Scenario Outline: Login New Employee
		When  new user enter "<username>" and "<password>"
		And   clicks login button
		Then  checks "<firstname>" welcmome message is displayed
		Examples:
		|firstname|username|password	 |
		|Leonardo	|Leonardo|leonardo123|
		|Sansolye |Sansolye|sansolye123|
	
	@homeworkWithDataTable
	Scenario: Login With DataTable
	When user login with credentilas and checks  welcome message
	
	@HW2
	Scenario: Login With DataTable
		When user enters username and password and click login button
		|username |password	     |firstname|
	 	|Tdanger  |tdanger@1234  |Teynir   |
	  |Bendeniz |bendeniz@1234 |Ben		   |
	
	