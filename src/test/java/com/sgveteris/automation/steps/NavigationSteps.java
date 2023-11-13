package com.sgveteris.automation.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;

import com.sgveteris.automation.hooks.TestHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NavigationSteps {
    
    private static final Logger logger = LoggerFactory.getLogger(NavigationSteps.class);

    @Given("I navigate to {string}")
    public void givenUrl(String url) {
        logger.info("Trendyol main page opened.");
        TestHooks.driver.navigate().to(url);
        TestHooks.driver.findElement(By.xpath("//*[@class='modal-close']")).click();
       
    }

    @Then("I should see the {string} is opened")
    public void checkUrl(String expectedUrl) {
        logger.info("Main page url checked");
        String currentUrl = TestHooks.driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
        logger.info("I see the main page opened when I go to the given url");
    }
}
