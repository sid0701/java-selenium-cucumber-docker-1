package com.sidgupta.bdd.googlesteps.flightsearchsteps;

import com.sidgupta.google.flightsearch.FlightPageFactory;
import com.sidgupta.utils.TestContextSetup;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class GoogleFlightSearchSteps {

    private TestContextSetup testContextSetup;
    private FlightPageFactory flightPage;

    public GoogleFlightSearchSteps(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("^user is on Google Flight Search (.+) Language Page$")
    public void openFlightSearchPage(String language){

        switch(language){
            case "English" : flightPage = testContextSetup.pageObjectManager.getFlightsPageEN();
                break;
            case "Indonesia" : flightPage = testContextSetup.pageObjectManager.getFlightsPageID();
                break;
        }
        flightPage.goTo();
        Assert.assertTrue(flightPage.isAt());

    }

    @Then("user verifies the actual navigation tab labels are same as {labels}")
    public void verifyTabLabel(List<String> expectedLabels){
        Assert.assertEquals(flightPage.getNavigationComponent().getNamesOfTabs(), expectedLabels);
    }

    @ParameterType(".*")
    public List<String> labels(String s){
        return Arrays.asList(s.split("\\s*;\\s*"));
    }

}
