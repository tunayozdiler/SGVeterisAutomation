Feature: Search for category

Scenario: Search laptop category
  When write "laptop" in the search box
  And click the search icon 
  Then I should see the "Laptop" category is listed 
  

