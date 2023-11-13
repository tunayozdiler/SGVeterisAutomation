package com.sgveteris.automation.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class TestHooks {

    public static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(TestHooks.class);

    @BeforeAll
    public static void beforeAll() {
        logger.info("Test starts...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    logger.info("Test ends.");
    }
}
