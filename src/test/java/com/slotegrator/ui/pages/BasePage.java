package com.slotegrator.ui.pages;

import com.slotegrator.core.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected SoftAssertions softAssert;

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage() {
        this.softAssert = ContextProvider.getContext().getSoftAssert();
        this.driver = ContextProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openPage(String path) {
        driver.get(Config.UI_URL + path);
    }

    public void openBasePage() {
        driver.get(Config.UI_URL);
    }

}
