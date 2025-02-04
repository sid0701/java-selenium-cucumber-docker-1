package com.sidgupta.google.mainsearch.main;

import com.sidgupta.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestionComponent extends BasePage {

    @FindBy(xpath = "//ul[@role='listbox']/li")
    private List<WebElement> suggestions;

    public SearchSuggestionComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return wait.until((driver) -> !suggestions.isEmpty() );
    }

    public void selectSuggestion(int index){
        suggestions.get(index-1).click();
    }

}
