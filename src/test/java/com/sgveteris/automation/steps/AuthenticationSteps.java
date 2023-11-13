package com.sgveteris.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sgveteris.automation.hooks.TestHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AuthenticationSteps {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSteps.class);

    @When("click to account button")
    public void clickToAccountButton() {
        logger.info("The login button was clicked on the main page.");
        TestHooks.driver.findElement(By.xpath("//*[@class='link account-user']")).click();
    }

    @And("fill in the username as {string}")
    public void fillUserName(String userName) {
        logger.info("The required input was entered in the username section.");
        TestHooks.driver.findElement(By.id("login-email")).sendKeys(userName);
    }

    @And("fill in the password as {string}")
    public void fillPassword(String password) {
        logger.info("The required input was entered in the password section.");
        TestHooks.driver.findElement(By.id("login-password-input")).sendKeys(password);
    }

    @When("click on the login button")
    public void loginButton() throws InterruptedException {
        logger.info("Login button clicked.");
        TestHooks.driver
                .findElement(By.cssSelector("#login-register > div.lr-container > div.q-layout.login > form > button"))
                .click();
                Thread.sleep(2000);
    }

    @Then("see the {string} message")
    public void errorMessage(String expectedMessage) {
        logger.info("Login process was checked with invalid credentials");
        WebElement actualMessageElement = TestHooks.driver.findElement(By.xpath("//*[@class='message']"));
        String actualMessage = actualMessageElement.getText();
        assertEquals(expectedMessage, actualMessage);
    }
}