package com.sidgupta.google.mainsearch.main;

import com.sidgupta.BasePage;
import com.sidgupta.google.mainsearch.ConfirmationPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class GoogleMainPage extends BasePage {

    public SearchWidgetComponent searchWidgetComponent;
    public SearchSuggestionComponent searchSuggestionComponent;
    private ConfirmationPage confirmationPage;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
        searchWidgetComponent = new SearchWidgetComponent(driver);
        searchSuggestionComponent = new SearchSuggestionComponent(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    @Override
    public boolean isAt() {
        return searchWidgetComponent.isAt();
    }

    public void goTo() {
        driver.get("https://www.google.com");
        if (confirmationPage.isAt()){
            confirmationPage.acceptAndContinue();
        }
    }
}
