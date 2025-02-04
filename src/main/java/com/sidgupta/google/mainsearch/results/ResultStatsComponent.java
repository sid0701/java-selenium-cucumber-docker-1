package com.sidgupta.google.mainsearch.results;

import com.sidgupta.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultStatsComponent extends BasePage {

    @FindBy(id = "result-stats")
    private WebElement results;

    public ResultStatsComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(results));
        return results.isDisplayed();
    }

    public int getResults(){
        return Integer.parseInt(results.getText().split(" ")[1]);
    }
}
