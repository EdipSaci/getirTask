package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "input-email")
    public WebElement emailAddressInputBox;

    @FindBy(id = "input-password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;



}
