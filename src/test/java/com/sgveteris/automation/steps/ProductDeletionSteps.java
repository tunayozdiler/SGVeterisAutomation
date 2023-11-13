package com.sgveteris.automation.steps;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sgveteris.automation.hooks.TestHooks;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductDeletionSteps {
    
    private static final Logger logger = LoggerFactory.getLogger(ProductDeletionSteps.class);

    @When("delete all the products from the basket") 
    public void deleteProducts() {
        logger.info("The product added to the cart is removed from the cart.");
        TestHooks.driver.findElement(By.xpath("//*[@class='i-trash']")).click();

    }

    @Then("check that the total price is {string}")
    public void cartEmpty(String expectedPrice) {
        logger.info("After the basket is emptied, the price on cart detail is checked to verify that the basket is empty.");
        WebElement actualPriceElement = TestHooks.driver.findElement(By.xpath("//*[@class='pb-summary-total-price ']"));
        String actualPrice = actualPriceElement.getText();
        assertEquals(expectedPrice, actualPrice);
        
        
    }
    
}