package com.sidgupta;

import com.sidgupta.utils.Config;
import com.sidgupta.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Slf4j
public class BaseTest {

    private WebDriver driver;

    public BaseTest() {
        Config.setDefaultProperties();
    }

    public WebDriver getDriver() throws MalformedURLException {
        return Boolean.parseBoolean(Config.getProperties(Constants.SELENIUM_GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
    }

    private WebDriver getRemoteDriver() throws MalformedURLException {
        if (driver == null) {
            Capabilities capabilities = new ChromeOptions();

            if (Config.getProperties(Constants.BROWSER).equalsIgnoreCase("firefox"))
                capabilities = new FirefoxOptions();

            String urlFormat = Config.getProperties(Constants.SELENIUM_GRID_URL_FORMAT);
            String host = Config.getProperties(Constants.SELENIUM_GRID_HUB_HOST);

            String url = String.format(urlFormat, host);

            log.info("URL : {}", url);
            driver = new RemoteWebDriver(new URL(url), capabilities);
        }
        return driver;
    }

    private WebDriver getLocalDriver() {
        if (driver == null) {
            if(Config.getProperties(Constants.BROWSER).equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().browserVersion(Config.getProperties(Constants.CHROME_BROWSER_VERSION)).setup();
                driver = new ChromeDriver();
            } else {
                WebDriverManager.firefoxdriver().browserVersion(Config.getProperties(Constants.FIREFOX_BROWSER_VERSION)).setup();
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperties(Constants.IMPLICIT_WAIT_DURATION))));
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();

        }
        return driver;
    }

}
