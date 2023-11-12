Feature: Login Function
  In order to avoid silly mistakes
  As a math idiot
  I want to be told the sum of two numbers

  Scenario: Unsuccessful login event
   
    When click to account button  
    And fill in the username as "test@example.com"
    And fill in the password as "password"
    When click on the login button 
    Then see the "E-posta adresiniz ve/veya şifreniz hatalı." message