package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{


    @FindBy(id = "input-firstname")
    public WebElement firstNameInputBox;

    @FindBy(id = "input-lastname")
    public WebElement lastNameInputBox;

    @FindBy(id = "input-email")
    public WebElement emailInputBox;

    @FindBy(id = "input-password")
    public WebElement passwordInputBox;

    @FindBy(id = "input-newsletter-no")
    public WebElement rejectSubscribeCheckBox;

    @FindBy(id = "input-newsletter-yes")
    public WebElement acceptSubscribeCheckBox;

    @FindBy(name = "//input[@name='agree']")
    public WebElement readPrivacyPolicyAgreeCheckBox;

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement continueButton;



}
