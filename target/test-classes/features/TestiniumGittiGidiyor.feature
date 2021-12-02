#Author: Taner Dönmez 

@testinium
Feature: www.gittigidiyor.com
  
  @gittigidiyor
  Scenario: www.gittigidiyor.com functionality
    Given I navigate to www.gittigidiyor.com
    When add search button "bilgisayar" and click search button
    And navigate the second result page
    Then validate opened if second result page
    And according the result page choose any one product
    And chosen product info and price is written in txt file.
    And chosen product is added to cart 
    Then compare  product price at  result page and price at cart
    And quality of the prodcut one increased
    Then validate quality of product one increased and equals to two
    And the product is deleted at cart
    Then validate cart is empty

  