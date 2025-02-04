package com.sidgupta.google.mainsearch.results;

import com.sidgupta.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBarComponent extends BasePage {

    @FindBy(css = "div.sBbkle")
    private WebElement navigationBar;

    @FindBy(xpath = "//div[text()='Videos']")
    private WebElement videosTab;

    @FindBy(xpath = "//div[text()='News']")
    private WebElement newsTab;

    @FindBy(xpath = "//div[text()='Tools']")
    private WebElement toolsTab;

    public NavigationBarComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(navigationBar));
        return navigationBar.isDisplayed();
    }

    public void goToVideos() {
        videosTab.click();
        toolsTab.click();
    }

    public void goToNews() {
        newsTab.click();
        toolsTab.click();
    }

}
