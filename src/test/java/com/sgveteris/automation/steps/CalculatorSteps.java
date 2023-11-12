package com.sgveteris.automation.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sgveteris.automation.hooks.TestHooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {
    JavascriptExecutor js = (JavascriptExecutor) TestHooks.driver;

    @Given("I navigate to {string}")
    public void givenUrl(String url) {
        TestHooks.driver.navigate().to(url);
    }

    @Then("I should see the {string} is opened")
    public void mainPage(String page) {
        assertEquals(TestHooks.driver.findElement(By.cssSelector("#browsing-gw-homepage")), page);
    }

    @When("click to account button")
    public void clickToAccountButton() {
        TestHooks.driver.findElement(By.xpath("//*[@class='link account-user']")).click();
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

    @When("click on the login button")
    public void loginButton() {
        TestHooks.driver
                .findElement(By.cssSelector("#login-register > div.lr-container > div.q-layout.login > form > button"))
                .click();
    }

    @Then("see the {string} message")
    public void errorMessage(String expectedMessage) {
        WebElement actualMessageElement = TestHooks.driver.findElement(By.xpath("//*[@class='message']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
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

    @And("click the search icon")
    public void clickSearchIcon() {
        TestHooks.driver.findElement(By.cssSelector("#sfx-discovery-search-suggestions > div > div.N4M8bfaJ > i"))
                .click();
    }

    @Then("I should see the {string} category is listed")
    public void categoryLaptop(String expectedCategory) {
        WebElement actualCategoryElement = TestHooks.driver.findElement(By.xpath("//*[@class='fltr-item-text chckd ctgry']"));
        String actualCategory = actualCategoryElement.getText();
        Assert.assertEquals(expectedCategory, actualCategory);
    
    }

    @When("I select a random product")
    public void addRandomProduct() throws InterruptedException {
        TestHooks.driver.findElement(By.xpath("//*[@class='header-top']")).click();
        //js.executeScript("window.scrollBy(0, 1000)");
        List<WebElement> elements = TestHooks.driver.findElements(By.xpath("//*[@class='prdct-desc-cntnr-name hasRatings']"));
        Random random = new Random();
        WebElement randomElement = elements.get(random.nextInt(elements.size()));
        TestHooks.driver.findElement(By.xpath("//*[@class='header-top']")).click();
        randomElement.click();
        
    }

    @And("I add the product to the cart")
    public void switchTabAndClickByCss() throws InterruptedException {
        ArrayList<String> tabs2 = new ArrayList<String>(TestHooks.driver.getWindowHandles());
        TestHooks.driver.switchTo().window(tabs2.get(1));
        TestHooks.driver.findElement(By.xpath("//*[@class='product-button-container']")).click();
        Thread.sleep(2000);
    }

    @Then("I click to the cart button and I see the product price is still the same")
    public void switchTabAndClickBy() {
        ArrayList<String> tabs2 = new ArrayList<String>(TestHooks.driver.getWindowHandles());
        TestHooks.driver.switchTo().window(tabs2.get(1));
        WebElement expectedPriceElement = TestHooks.driver.findElement(By.xpath("//*[@class='prc-dsc']"));
        String expectedPrice = expectedPriceElement.getText();
        TestHooks.driver.findElement(By.xpath("//*[@class='link account-basket']")).click();
        TestHooks.driver.findElement(By.xpath("//button[contains(text(), 'Anladım')]")).click();
        //TestHooks.driver.findElement(By.xpath("//button[@class='ty-numeric-counter-button']")).click();
        WebElement actualPriceElement = TestHooks.driver.findElement(By.xpath("//*[@class='pb-basket-item-price']"));
        String actualPrice = actualPriceElement.getText();
        Assert.assertEquals(expectedPrice, actualPrice);
    }


    /*
     * @When("I click the cart button")
     * public void clickToCart(){
     * TestHooks.driver.findElement(By.xpath("I click the cart button")).click();
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
