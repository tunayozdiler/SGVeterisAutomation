Feature: Login Function
I want to see if I get an error message when I login with invalid credentials

Scenario: Unsuccessful login event
   
When click to account button  
And fill in the username as "test@example.com"
And fill in the password as "password"
When click on the login button 
Then see the "E-posta adresiniz ve/veya şifreniz hatalı." message