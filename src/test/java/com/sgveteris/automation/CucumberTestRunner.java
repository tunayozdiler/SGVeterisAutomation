package com.sgveteris.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.sgveteris.automation.steps",
        "com.sgveteris.automation.hooks" })
public class CucumberTestRunner {

}
