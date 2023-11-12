package com.sgveteris.automation.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sgveteris.automation.hooks.TestHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {

    @Given("I navigate to {string}")
    public void givenUrl(String url) {
        TestHooks.driver.navigate().to(url);
    }

    @Then("I should see the {string} is opened")
    public void mainPage(String page) {
        assertEquals(TestHooks.driver.findElement(By.cssSelector("#browsing-gw-homepage")), page);
    }

    @When("open {string}")
    public void open(String url) {
        TestHooks.driver.navigate().to(url);
    }

    @When("click to account button {string}")
    public void clickToAccountButton(String selector) {
        TestHooks.driver.findElement(By.cssSelector(selector)).click();
    }

    @When("click to mail input {string}")
    public void clickToMailInput(String selector) {
        TestHooks.driver.findElement(By.xpath(selector)).click();
    }

    @And("fill in the username as {string}")
    public void fillUserName(String userName) {
        TestHooks.driver.findElement(By.id("login-email")).sendKeys(userName);
    }

    @And("fill in the password as {string}")
    public void fillPassword(String password) {
        TestHooks.driver.findElement(By.id("login-password-input")).sendKeys(password);
        TestHooks.driver.findElement(By.xpath("//*[@class='i-eye-close']")).click();
    }

    @When("click on the login button {string}")
    public void loginButton(String login) {
        TestHooks.driver
                .findElement(By.cssSelector("#login-register > div.lr-container > div.q-layout.login > form > button"))
                .click();
    }

    @Then("see the {string} message")
    public void errorMessage(String message) {
        assertEquals(TestHooks.driver.findElement(By.cssSelector("#error-box-wrapper > span.message")).getText(),
                (message));
    }

    /*
     * @Given ("I am on the login page {string}")
     * public void loginPage(String url){
     * TestHooks.driver.navigate().to(url);
     * }
     */

    @When("write {string} in the search box")
    public void search(String laptop) {
        TestHooks.driver.findElement(By.cssSelector("#sfx-discovery-search-suggestions > div > div > input"))
                .sendKeys(laptop);
    }

    @And("click the search icon {string}")
    public void clickIcon(String icon) {
        TestHooks.driver.findElement(By.cssSelector("#sfx-discovery-search-suggestions > div > div.N4M8bfaJ > i"))
                .click();
    }

    @Then("I should see the laptop category is listed {string}")
    public void categoryLaptop(String category) {
        assertEquals(TestHooks.driver.findElement(By.cssSelector(
                "#sticky-aggregations > div > div.fltrs-wrppr.hide-fltrs.ctgry > div.fltrs.ctgry > div > div > div > div > a > div")),
                category);
    }

    @Given("the selected laptop {string}")
    public void randomLaptop(String randomChoice) {
        TestHooks.driver.findElement(By.cssSelector(
                "#search-app > div > div.srch-rslt-cntnt > div.srch-prdcts-cntnr.srch-prdcts-cntnr-V2 > div:nth-child(5) > div:nth-child(1) > div > div:nth-child(2) > div.p-card-chldrn-cntnr.card-border > a > div.product-down > div:nth-child(1) > div > h3 > span.prdct-desc-cntnr-name.hasRatings"))
                .click();
    }

     @And ("I see the new tab open")
    public void switchTabAndClickByCss() {
        ArrayList<String> tabs2 = new ArrayList<String>(TestHooks.driver.getWindowHandles());
        TestHooks.driver.switchTo().window(tabs2.get(1));
        TestHooks.driver.findElement(By.cssSelector("#product-detail-app > div > div.flex-container > div > div:nth-child(2) > div:nth-child(2) > div > div.product-detail-wrapper > div.product-button-container > button > div.add-to-basket-button-text")).click();
    }

   /* @When("I click to the add to cart button {string}")
    public void addToCart(String addCart) {
        TestHooks.driver.findElement(By.cssSelector(
                "#product-detail-app > div > div.flex-container > div > div:nth-child(2) > div:nth-child(2) > div > div.product-detail-wrapper > div.product-button-container > button > div.add-to-basket-button-text"))
                .click();
    } */
   

    /*
     * @Then("I should see the page title as {string}")
     * public void pageTitle(String title) {
     * assertEquals(TestHooks.driver.findElement(By.xpath("/html/head/title/text()")
     * ).getText(), title);
     * }
     */

    @When("click by css {string}")
    public void clickByCss(String selector) {
        TestHooks.driver.findElement(By.cssSelector(selector)).click();
    }

    @When("click by xpath {string}")
    public void clickByXpath(String selector) {
        TestHooks.driver.findElement(By.cssSelector(selector)).click();
    }

}
