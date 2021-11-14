
Feature: Searching Google
  
	@googleSearch
  Scenario: Searching by typing
    Given I navigated to google.
    And I type a search item in search box.
    When I clicked on SearchButton.
    Then I see my resolut of search.
    And  I see number of the search.
		
  