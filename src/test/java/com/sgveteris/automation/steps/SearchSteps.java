package com.sgveteris.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sgveteris.automation.hooks.TestHooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSteps {

    private static final Logger logger = LoggerFactory.getLogger(SearchSteps.class);

    @When("write {string} in the search box")
    public void search(String laptop) {
        logger.info("The word laptop is searched in the search bar.");
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
            logger.info("It was checked that the category of the word searched in the search bar was correct.");
        WebElement actualCategoryElement = TestHooks.driver.findElement(By.xpath("//*[@class='fltr-item-text chckd ctgry']"));
        String actualCategory = actualCategoryElement.getText();
        assertEquals(expectedCategory, actualCategory);
    }

}
