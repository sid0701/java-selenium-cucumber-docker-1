package com.sidgupta.google.flightsearch;

import com.sidgupta.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public abstract class FlightPageFactory extends BasePage {

    protected NavigationComponent navigationComponent;
    protected ConfirmationPage confirmationPage;

    public FlightPageFactory(WebDriver driver) {
        super(driver);
        navigationComponent = new NavigationComponent(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    @Override
    public boolean isAt() {
        return navigationComponent.isAt();
    }

    public abstract void goTo();
}
