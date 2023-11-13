package com.sgveteris.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sgveteris.automation.hooks.TestHooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductIncreaseSteps{

    private static final Logger logger = LoggerFactory.getLogger(ProductIncreaseSteps.class);

@When("increase the number of product in the basket")
    public void increaseProduct() {
        logger.info("The quantity of the product added to the cart is increased from 1 to 2.");
        TestHooks.driver.findElement(By.xpath("//*[@class='link account-basket']")).click();
        //TestHooks.driver.findElement(By.xpath("//button[contains(text(), 'Anladım')]")).click();
        TestHooks.driver.findElement(By.xpath("//button[@class='ty-numeric-counter-button']")).click();
    }

@Then("I see the product number is 2")
    public void checkIfIncrease() {
        logger.info("It is checked to see if the current number of products in the cart has increased to 2.");
        WebElement numberOfProductElement = TestHooks.driver.findElement(By.xpath("[@class='counter-content']"));
        int actualNumber = Integer.parseInt(numberOfProductElement.getText());
        int expectedNumber = 2;
        assertEquals(expectedNumber,actualNumber);
    }


}

