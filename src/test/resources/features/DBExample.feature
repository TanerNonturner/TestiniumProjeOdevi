#Author: Neotech Academy

Feature: Database Testing
@DB
	Scenario: Getting top three customers with highest credit limit
	Given: I am connected to the database
	When: I get top three customers by credit limit
	Then: I print their names and credit limit
	And:  I close the database connection
