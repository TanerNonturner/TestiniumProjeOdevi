 @HM4
Feature: Add Employee With Personel Details

	Background: 
		Given user is logged in with valid credentials
		And   user navigates Add Employee Page


 
  Scenario Outline: Add and Modify Employee Details
    When user enters  employee with "<FirstName>" and "<LastName>"
		And user clicks save button
		And click on Personel Details Edit button
		And I am able to modify Employe Personel Details "<DriverLicense>" , "<ExpirationDate>" , "<SSN>", "<Gender>" and "<Nationality>"
		Then click Personel Details Save button
		
		Examples:
			| FirstName | LastName | DriverLicense | ExpirationDate | SSN        | Gender | Nationality |
			| Abrahamm  | Lincolon | DN123456788   | 2024-02-14     | 123-45-123 | Male   | American    |
			| Dicaprios | Alandilon| DV902378312   | 2023-01-10     | 345-12-987 | Male   | Argentinean |
		
 