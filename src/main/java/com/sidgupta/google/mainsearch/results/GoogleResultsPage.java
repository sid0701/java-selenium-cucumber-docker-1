package com.sidgupta.google.mainsearch.results;

import com.sidgupta.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class GoogleResultsPage extends BasePage {

    public NavigationBarComponent navigationBarComponent;
    public ResultStatsComponent resultStatsComponent;

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
        navigationBarComponent = new NavigationBarComponent(driver);
        resultStatsComponent = new ResultStatsComponent(driver);
    }

    @Override
    public boolean isAt() {
        return navigationBarComponent.isAt();
    }

}
