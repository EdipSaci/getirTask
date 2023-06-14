package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    public WebElement myAccountHeader;

}
