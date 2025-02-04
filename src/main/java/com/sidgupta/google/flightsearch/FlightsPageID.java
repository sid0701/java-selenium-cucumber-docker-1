package com.sidgupta.google.flightsearch;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class FlightsPageID extends FlightPageFactory {

    public FlightsPageID(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goTo(){
        driver.get("https://www.google.com/travel/flights/id?hl=id");
        if(confirmationPage.isAt())
            confirmationPage.acceptAndContinue();
    }

}
