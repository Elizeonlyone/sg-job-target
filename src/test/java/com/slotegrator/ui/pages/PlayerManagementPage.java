package com.slotegrator.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlayerManagementPage extends BasePage {

    @FindBy(id = "payment-system-transaction-grid")
    protected WebElement mainContent;

    @FindBy(xpath = "//tbody/tr")
    protected List<WebElement> allPlayersRows;

    protected WebElement getColumnElement(int index) {
        return driver
                .findElement(By.id(String.format("payment-system-transaction-grid_c%s", index)))
                .findElement(By.xpath("./a"));
    }
}
