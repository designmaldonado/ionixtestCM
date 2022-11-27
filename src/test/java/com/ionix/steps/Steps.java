package com.ionix.steps;
import com.ionix.configuration.SpringConfiguration;
import com.ionix.pageobjects.Register;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.Map;

@ContextConfiguration(classes = {SpringConfiguration.class})
public class Steps {

    private static final Logger logger = LoggerFactory.getLogger(Steps.class);


    @Lazy
    @Autowired
    private AppiumDriver ionixDriver;

    @Autowired
    @Lazy
    private Register register;


    @After
    @Attachment(value = "Test end", type = "image/png")
    public byte[] close() {
        byte[] screenshot = ((TakesScreenshot) ionixDriver)
                .getScreenshotAs(OutputType.BYTES);
        if (ionixDriver != null)
            ionixDriver.closeApp();
        return screenshot;
    }

    @Given("^Launch App$")
    public void LounchApp() throws IOException {

        ionixDriver.launchApp();

    }

    @When("^Register new user$")
    public void Registernewuser(DataTable data) throws InterruptedException, IOException {
        Map<String, String> datos = data.asMap(String.class, String.class);
        register.fillForm(datos);

    }

    @Then("^Button Submit$")
    public void ButtonSubmit() {

        register.ButtonClick();

    }

    @Then("^Evaluated Text Complete$")
    public void Evaluated_Text_Complete() {

        register.EvaluatedTextComplete();

    }








}
