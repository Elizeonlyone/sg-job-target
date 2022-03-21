package com.slotegrator.ui.steps;

import com.slotegrator.core.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class Hooks {

    @Before
    public void beforeScenario() {
        contextCreation();
        driverCreation();
    }

    @After
    public void afterScenario(Scenario scenario) {
        makeScreenshot(scenario);
        ContextProvider.quitDriver();
    }

    private void contextCreation() {
        Context context;
        if (ContextProvider.getContext() == null) {
            context = new Context();
            ContextProvider.setContext(context);
        } else {
            context = ContextProvider.getContext();
        }
        SoftAssertions softAssert = new SoftAssertions();
        context.setSoftAssert(softAssert);
        ContextProvider.getContext().setSessionData(initTestClassSessionDataTemplate());
    }

    private void driverCreation() {
        createDriver("chrome", "30");
    }

    private void createDriver(String browser, String timeout) {
        browser = System.getProperty("browser", browser);
        timeout = System.getProperty("timeout", timeout);

        ContextProvider.setDriver(
                DriverFactory.createDriver(browser, timeout));
    }

    private SessionData initTestClassSessionDataTemplate() {
        SessionData sessionData = new SessionData();
        sessionData.setBaseUrl(Config.UI_URL);
        sessionData.setUsername(Config.UI_USERNAME);
        sessionData.setPassword(Config.UI_PASSWORD);
        return sessionData;
    }

    public void makeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) ContextProvider.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png", scenario.getName());
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
    }

}
