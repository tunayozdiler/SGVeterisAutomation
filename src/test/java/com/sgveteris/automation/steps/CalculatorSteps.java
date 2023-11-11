package com.sgveteris.automation.steps;

import org.openqa.selenium.By;

import com.sgveteris.automation.hooks.TestHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CalculatorSteps {


    @When("open {string}")
    public void open(String url) {
        TestHooks.driver.navigate().to(url);
    }

    @When("click to account button {string}")
    public void clickToAccountButton(String selector) {
        TestHooks.driver.findElement(By.cssSelector(selector)).click();
    }

    @When ("click to mail input {string}")
    public void clickToMailInput(String selector) {
        TestHooks.driver.findElement(By.xpath(selector)).click();
    }

    @And ("fill in the username as {string}")
    public void fillUserName(String userName) {
        TestHooks.driver.findElement(By.id("login-email")).sendKeys(userName);
    }

    @And ("fill in the password as {string}")
    public void fillPassword(String password) {
        TestHooks.driver.findElement(By.id("login-password-input")).sendKeys(password);
        TestHooks.driver.findElement(By.xpath("//*[@class='i-eye-close']")).click();
    }

    @When ("click on the login button {string}")
    public void loginButton(String login) {
        TestHooks.driver.findElement(By.cssSelector("#login-register > div.lr-container > div.q-layout.login > form > button")).click();
    }

    @When("click by css {string}")
    public void clickByCss(String selector) {
        TestHooks.driver.findElement(By.cssSelector(selector)).click();
    }

    @When ("click by xpath {string}")
    public void clickByXpath(String selector) {
        TestHooks.driver.findElement(By.cssSelector(selector)).click();
    }



}
