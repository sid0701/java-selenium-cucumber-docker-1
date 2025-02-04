package com.sidgupta.google.mainsearch;

import com.sidgupta.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends BasePage {

    @FindBy(css = "h1.I90TVb")
    private WebElement confirmationHeader;

    @FindBy(xpath = "//button[@id='L2AGLb']")
    private WebElement acceptButton;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        wait.until(ExpectedConditions.visibilityOf(confirmationHeader));
        return confirmationHeader.isDisplayed();
    }

    public void acceptAndContinue(){
        actions.moveToElement(acceptButton).build().perform();
        acceptButton.click();
    }
}
