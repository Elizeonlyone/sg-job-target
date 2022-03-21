package com.slotegrator.ui.steps;

import com.slotegrator.core.Config;
import com.slotegrator.ui.pages.AuthPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AuthSteps extends AuthPage {

    @Given("Open auth page")
    public void openAuthPage() {
        openPage("/admin/login");
        verificationPageHasLoaded();
    }

    @Given("Open page and auth with default user")
    public void openPageAndAuth() {
        openAuthPage();
        authWithDefaultUser();
        new MainSteps().verificationPageHasLoaded();
    }

    @When("Auth with default user")
    public void authWithDefaultUser() {
        loginTextField.sendKeys(Config.UI_USERNAME);
        passwordTextField.sendKeys(Config.UI_PASSWORD);
        signInBtn.click();
    }

    @Then("Verification Auth page has been loaded")
    public void verificationPageHasLoaded() {
        softAssert.assertThat(loginTextField.isDisplayed()).isTrue();
        softAssert.assertThat(passwordTextField.isDisplayed()).isTrue();
        softAssert.assertThat(signInBtn.isDisplayed()).isTrue();
        softAssert.assertThat(getDriver().getTitle().equals("Dashboard - Casino")).isTrue();

        softAssert.assertAll();
    }


}
