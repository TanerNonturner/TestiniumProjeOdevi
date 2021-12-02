#Author: Taner Dönmez
@testiniumTrello
Feature: Trello 

  @trello
  Scenario: Trello functionality
    Given create one board request
    And in that board creat two card 
    When one of the card is updated
    Then delete the cards
    And delete the board
    