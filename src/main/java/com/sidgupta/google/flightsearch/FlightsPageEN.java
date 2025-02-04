package com.sidgupta.google.flightsearch;

import org.openqa.selenium.WebDriver;

public class FlightsPageEN extends FlightPageFactory {

    public FlightsPageEN(WebDriver driver) {
        super(driver);

    }

    @Override
    public void goTo(){
        driver.get("https://www.google.com/travel/flights/id?hl=en");
        if(confirmationPage.isAt())
            confirmationPage.acceptAndContinue();
    }

}
