package com.sgveteris.automation.steps;

import org.openqa.selenium.By;

import com.sgveteris.automation.hooks.TestHooks;

import io.cucumber.java.en.When;

public class CalculatorSteps {


    @When("open {string}")
    public void open(String url) {
        TestHooks.driver.navigate().to(url);
    }

    @When("click to catorgory {string}")
    public void clickToCategory(String selector) {
        TestHooks.driver.findElement(By.cssSelector(selector)).click();
    }

}
