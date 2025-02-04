package com.sidgupta.bdd.google.MainSearch;

import com.sidgupta.google.mainsearch.main.GoogleMainPage;
import com.sidgupta.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GoogleMainPageSteps {

    private GoogleMainPage googleMainPage;

    public GoogleMainPageSteps(TestContextSetup testContextSetup){
        googleMainPage = testContextSetup.pageObjectManager.getGoogleMainPage();
    }

    @Given("user is on Google Home Page")
    public void openGoogleHomePage(){
        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.isAt());
    }

    @When("^user searches for (.+) on Google Search Box$")
    public void searchKeyword(String keyword){
        googleMainPage.getSearchWidgetComponent().searchKeyword(keyword);
    }

    @When("^user selects (.+) suggestion$")
    public void selectsSuggestion(int index){
        Assert.assertTrue(googleMainPage.getSearchSuggestionComponent().isAt());
        googleMainPage.getSearchSuggestionComponent().selectSuggestion(index);
    }

}
