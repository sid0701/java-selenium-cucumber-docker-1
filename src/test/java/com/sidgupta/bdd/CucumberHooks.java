package com.sidgupta.bdd;

import com.sidgupta.utils.ScreenshotService;
import com.sidgupta.utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

public class CucumberHooks {

    private final TestContextSetup testContextSetup;

    public CucumberHooks(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @After
    public void quitBrowser() throws MalformedURLException {
        testContextSetup.baseTest.getDriver().quit();
    }

    @AfterStep
    public void attachScreenshot(Scenario scenario) throws MalformedURLException {

        if(scenario.isFailed()){
            scenario.attach(ScreenshotService.getScreenshotAsBytes(testContextSetup.baseTest.getDriver()), "image/png", scenario.getName());
        }

    }

}
