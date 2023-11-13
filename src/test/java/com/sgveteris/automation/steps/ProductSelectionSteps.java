package com.sgveteris.automation.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sgveteris.automation.hooks.TestHooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSelectionSteps {

    private static final Logger logger = LoggerFactory.getLogger(ProductSelectionSteps.class);

    @When("I select a random product")
    public void addRandomProduct() throws InterruptedException {
        logger.info("A random product is selected among the products listed in the search result.");
        TestHooks.driver.findElement(By.id("container")).click();
        List<WebElement> elements = TestHooks.driver.findElements(By.xpath("//*[@class='prdct-desc-cntnr-name hasRatings']"));
        Random random = new Random();
        WebElement randomElement = elements.get(random.nextInt(elements.size()));
        randomElement.click();
    }

    @And("I add the product to the cart")
    public void switchTabAndClickByCss() throws InterruptedException {
        logger.info("The selected random product added to the cart.");
        ArrayList<String> tabs2 = new ArrayList<String>(TestHooks.driver.getWindowHandles());
        TestHooks.driver.switchTo().window(tabs2.get(1));
        TestHooks.driver.findElement(By.xpath("//*[@class='product-button-container']")).click();
        Thread.sleep(2000);
    }

    @Then("I click to the cart button and I see the product price is still the same")
    public void switchTabAndClickBy() {
        logger.info("The price of the product added to the cart checked.");
        ArrayList<String> tabs2 = new ArrayList<String>(TestHooks.driver.getWindowHandles());
        TestHooks.driver.switchTo().window(tabs2.get(1));
        WebElement productPriceElement = TestHooks.driver.findElement(By.xpath("//*[@class='prc-dsc']"));
        String priceBefore = productPriceElement.getText();
        TestHooks.driver.findElement(By.xpath("//*[@class='link account-basket']")).click();
        TestHooks.driver.findElement(By.xpath("//button[contains(text(), 'Anladım')]")).click();
        WebElement actualPriceElement = TestHooks.driver.findElement(By.xpath("//*[@class='pb-basket-item-price']"));
        String actualPrice = actualPriceElement.getText();
        assertEquals(priceBefore, actualPrice);
    }
}
