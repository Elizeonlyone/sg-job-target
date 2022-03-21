package com.slotegrator.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends BasePage {

    @FindBy(id = "UserLogin_username")
    protected WebElement loginTextField;

    @FindBy(id = "UserLogin_password")
    protected WebElement passwordTextField;

    @FindBy(xpath = "//input[@value='Sign in']")
    protected WebElement signInBtn;

}
