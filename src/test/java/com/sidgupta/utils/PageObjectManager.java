package com.sidgupta.utils;

import com.sidgupta.google.flightsearch.FlightsPageEN;
import com.sidgupta.google.flightsearch.FlightsPageID;
import com.sidgupta.google.mainsearch.main.GoogleMainPage;
import com.sidgupta.google.mainsearch.results.GoogleResultsPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public GoogleMainPage getGoogleMainPage(){
        return new GoogleMainPage(driver);
    }

    public GoogleResultsPage getGoogleResultsPage(){
        return new GoogleResultsPage(driver);
    }

    public FlightsPageEN getFlightsPageEN(){
        return new FlightsPageEN(driver);
    }

    public FlightsPageID getFlightsPageID(){
        return new FlightsPageID(driver);
    }

}
