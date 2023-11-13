Feature: Search for category
I want to see if the resulting category matches the category I searched for

Scenario: Search laptop category

When write "laptop" in the search box
And click the search icon 
Then I should see the "Laptop" category is listed
  

