package com.slotegrator.ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='page']")
    protected WebElement mainContent;

    @FindBy(xpath = "//body")
    protected WebElement body;

    @FindBy(id = "nav-container")
    protected WebElement sideMenu;

    @FindBy(xpath = "//header")
    protected WebElement header;

    @FindBy(xpath = "//ul[@class='main-side-menu']/li/a/span")
    protected List<WebElement> sideMenuItemsList;

    protected WebElement getMenuItemByText(String text) throws Exception {
        try {
            return sideMenuItemsList.stream()
                    .filter(s -> s.getText().toLowerCase().equals(text.toLowerCase())).findFirst().get();
        } catch (NoSuchElementException e) {
            String allSideMenuItemsText = sideMenuItemsList.stream().map(Object::toString).collect(Collectors.joining("\n"));
            Assertions.fail(String.format("%s not found in side menu content list. \n Actual list: \n %s", text, allSideMenuItemsText));
        }
        throw new Exception("Unhandled Exception");
    }

    protected WebElement getMenuItemByItemByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected WebElement getChildMenuItemByText(String text) {
        return driver.findElement(By.xpath(String.format("//a[text()='%s']", text)));
    }

}
