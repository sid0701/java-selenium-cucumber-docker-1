package com.sidgupta.bdd.google.MainSearch;

import com.sidgupta.google.mainsearch.results.GoogleResultsPage;
import com.sidgupta.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GoogleResultsPageSteps {

    private GoogleResultsPage googleResultsPage;

    public GoogleResultsPageSteps(TestContextSetup testContextSetup) {
        googleResultsPage = testContextSetup.pageObjectManager.getGoogleResultsPage();
    }

    @When("^user clicks on (.+) Tab on Results Page$")
    public void clickOnTab(String tabName) {
        Assert.assertTrue(googleResultsPage.isAt());

        switch (tabName) {
            case "News":
                googleResultsPage.getNavigationBarComponent().goToNews();
                break;

            case "Videos":
                googleResultsPage.getNavigationBarComponent().goToVideos();
                break;
        }
    }

    @Then("^user verifies that results are greater than (.+)$")
    public void verifyResults(int count) {
        int actual_count = googleResultsPage.getResultStatsComponent().getResults();
        Assert.assertTrue(actual_count > count);
    }


}
