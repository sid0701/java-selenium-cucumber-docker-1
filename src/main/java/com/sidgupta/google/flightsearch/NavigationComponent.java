package com.sidgupta.google.flightsearch;

import com.sidgupta.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class NavigationComponent extends BasePage {

    @FindBy(xpath = "//nav/div/div/button/span")
    private List<WebElement> tabLabels;

    public NavigationComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return wait.until((driver) -> !tabLabels.isEmpty());
    }

    public List<String> getNamesOfTabs(){
        return tabLabels.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
