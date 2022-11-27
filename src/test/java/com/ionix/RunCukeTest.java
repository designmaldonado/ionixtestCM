package com.ionix;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",
        glue = {"com.ionix.steps"},
        tags = {"@CP_Add3"}

)

public class RunCukeTest extends AbstractTestNGCucumberTests {

}
