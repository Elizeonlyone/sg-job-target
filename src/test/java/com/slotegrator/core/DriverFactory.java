package com.slotegrator.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static final String DEFAULT_TIMEOUT = "30";

    // Default value for version of local driver.
    private static String LOCAL_DRIVER_VERSION = "99.0";


    public static WebDriver createDriver(String browser, String timeout) {
        if (timeout.isEmpty()) timeout = DEFAULT_TIMEOUT;

        WebDriver driver;
        if (browser.toLowerCase().equals("firefox")) {
            synchronized (DriverFactory.class) {
                WebDriverManager.firefoxdriver().version(LOCAL_DRIVER_VERSION).setup();
            }
            driver = new FirefoxDriver();
        } else {
            synchronized (DriverFactory.class) {
                WebDriverManager.chromedriver().version(LOCAL_DRIVER_VERSION).setup();
            }
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(timeout)));
        return driver;
    }

}
