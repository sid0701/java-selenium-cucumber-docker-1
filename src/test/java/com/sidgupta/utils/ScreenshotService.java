package com.sidgupta.utils;

import com.google.common.primitives.Bytes;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotService {

    public static byte[] getScreenshotAsBytes(WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);

    }

}
