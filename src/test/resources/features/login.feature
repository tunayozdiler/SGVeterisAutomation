Feature: Login Function
  In order to avoid silly mistakes
  As a math idiot
  I want to be told the sum of two numbers

  Scenario: Unsuccessful login event
    When open "https://www.trendyol.com/butik/liste/1/kadin"
    When click to account button "#account-navigation-container > div > div.account-nav-item.user-login-container > div.link.account-user"
    And fill in the username as "test@example.com"
    And fill in the password as "password"
    When click on the login button "#login-register > div.lr-container > div.q-layout.login > form > button"
    
