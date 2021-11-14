

Feature: Database Testing

  @DB1
  Scenario: Getting top three customers with highest credit limit
    Given I am connected to the database
    When  I get top three customers by credit limit
    Then  print their names and credit limit
  	And I close conncetion

      |
