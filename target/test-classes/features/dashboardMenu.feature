Feature: Dashboard
@dashboard
Scenario: Dashboard Menu for Admin User
		Given user is logged in with valid credentials
		Then I want to see these items in the menu
		| Admin      |
		| PIM        |
		| Leave		   |
		| Time       |
		| Recruitment|
		| My Info    |
		| Performance|
		| Dashboard  |
		| Directory  |
		| Maintenance|
		| Buzz       |