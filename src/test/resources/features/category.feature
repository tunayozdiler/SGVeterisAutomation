Feature: Search for category

Scenario: Search laptop category
  //Given I am on the login page "https://www.trendyol.com/giris?cb=%2F"
  When write "laptop" in the search box
  And click the search icon "#sfx-discovery-search-suggestions > div > div.N4M8bfaJ > i"
  Then I should see the laptop category is listed "#sticky-aggregations > div > div.fltrs-wrppr.hide-fltrs.ctgry > div.fltrs.ctgry > div > div > div > div > a > div""
  

