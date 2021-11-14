
@sprint17
Feature: Add Employee Feature

	Background: 
		Given user is logged in with valid credentials
		And   user navigates Add Employee Page
	@dataDriven
	Scenario: Add Employee with first name and last name
		When  user enters "Teynir" and last name "Sirnames"
		And   user clicks save button
		Then  employee "Tenir Sirnames" is added successfully
		
	@second	
	Scenario: Add Employee without Employe ID
		When  user enters firts name and last name
		And   user deletes Employee ID
		And   user clicks save button
		Then employee is added successfully
		
	@third	
	Scenario: Add Employee and create login credentials
		When  user enters firts name and last name
		And   user clicks on Create Login Details
		And   user provides credential information
		And   user clicks save button
		Then  employee is added successfully
		
	#To perform Data Driven Testing, we use	Scenario Outline (two or more data) and Examples
	@fourth
	Scenario Outline: Adding Multiple Employee
		When user enters "<FirstName>" , "<MiddleName>" and "<LastName>"	
		And user clicks save button
		Then user checks  new employee  credentials "<FirstName>", "<MiddleName>" and "<LastName>"
		
	
	Examples:
		|FirstName|MiddleName |LastName |  
		|Abrts		|Markls			|Abmarde  |	 
		|Sense		|Kanse			|Senka		|
		|Karkos		|Dank			  |Kardank	|
		
	#To perform DDT(Data Driven Testing) with Cucumber DataTable
	@dataTable	
	Scenario: Multiple Employee 
		When user enters employee details and clicks on save button then employee is added
		|firstname|middlename|lastname|
		|ahbr     |Anter		 |bdhris	|
		|Tnr    	|Esd		   |Sonu		|
		
@excelDataTable	
	Scenario: Add Multiple Employee from Excel
		When user enters employee  from "Employee" excel sheet than employee is added
		
		
		
		
		
		
