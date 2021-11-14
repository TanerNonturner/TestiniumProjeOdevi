#Author Neotech Academy
@OneBook
Feature: Get One Book API
	Description: This feature tests Get One Book API

Background:
	Given I create a request
	And   I provide the ISBN "9781491904244" as a query parameter for the request	
	
Scenario: Getting one book and validation the response
	When  I make a Get call to the get one book endpoint
	Then  I validate  that status code for get one book  is 200
	And   I validate the ISBN at response body is the same with "9781491904244"
	And   I validate book title is "You Don't Know JS"

	