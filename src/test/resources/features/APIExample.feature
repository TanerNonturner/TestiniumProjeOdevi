#Author: Neotech Academy

Feature: Add a book and Get account

Background: 
	Given A token is generated
@API
Scenario: Adding a book and validating account
	When I add a book to the account
	And I get the account information
	Then I validate that book is in the account
	 