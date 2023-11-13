Feature: Delete products from the cart
I want to see if I can delete the products in the cart

Scenario: Delete product and check if the cart is empty

When delete all the products from the basket 
Then check that the total price is "0 TL"

