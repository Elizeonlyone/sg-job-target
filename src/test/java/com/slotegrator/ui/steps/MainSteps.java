package com.slotegrator.ui.steps;

import com.slotegrator.ui.data.SideMenu;
import com.slotegrator.ui.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

public class MainSteps extends MainPage {

    @When("Open menu item - {string} and section {string}")
    public void openMenuItem(String itemName, String childItemName) throws Exception {
        if (body.getAttribute("class").contains("nav-min")){
            new Actions(driver).moveToElement(getMenuItemByItemByXpath(SideMenu.fromString(itemName).getXpath()))
                    .build().perform();
        } else {
            getMenuItemByText(itemName).click();
        }
        getChildMenuItemByText(childItemName).click();
    }

    @Then("Verification Main page has been loaded")
    public void verificationPageHasLoaded() {
        softAssert.assertThat(mainContent.isDisplayed()).isTrue();
        softAssert.assertThat(sideMenu.isDisplayed()).isTrue();
        softAssert.assertThat(header.isDisplayed()).isTrue();
        softAssert.assertThat(getDriver().getTitle().equals("Dashboard - Casino")).isTrue();

        softAssert.assertAll();
    }
}
