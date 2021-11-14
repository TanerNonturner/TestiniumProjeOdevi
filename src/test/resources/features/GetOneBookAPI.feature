#Author: Neotech Academy
@GetOneBook
Feature: Get One Book API
	Description: This feature test get one book API
	
Background:
		Given I create get one book request
		And I provide the ISBN number "9781449325862" as a query param

Scenario: Gettig one book and validating in response
	When I make a get call to get one book endpoint
	Then I validate the status code of get one book response is 200
	And I validate the response body is "9781449325862"
	And I validate the book title is "Git Pocket Guide"