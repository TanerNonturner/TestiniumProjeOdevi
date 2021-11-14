@generateToken
Feature: Generate Token API

	Background: 
		Given I create a generate token request
		And I provide the header and body
	
	Scenario: Generating token
		When  I make a POST call to generate token endpoint
		Then  I validate the status code is 200
		And   I validate the body contains "authorized successfully"
		And   I validate the "result" is "User authorized successfully."