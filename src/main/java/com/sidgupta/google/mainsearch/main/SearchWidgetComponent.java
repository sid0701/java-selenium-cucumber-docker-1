package com.sidgupta.google.mainsearch.main;

import com.google.common.util.concurrent.Uninterruptibles;
import com.sidgupta.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class SearchWidgetComponent extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidgetComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        return searchBox.isDisplayed();
    }

    public void searchKeyword(String keyword) {
        var keywordInChar = keyword.toCharArray();
        for (var c : keywordInChar) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            searchBox.sendKeys(c + "");
        }
    }
}
