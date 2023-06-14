package com.opencart.pages;

import com.opencart.utilities.BrowserUtils;
import com.opencart.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='logo']//img")
    public WebElement opencartLogo;

    @FindBy(xpath = "//span[.='My Account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginLink;

    @FindBy(xpath = "//a[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//span[.='Shopping Cart']")
    public WebElement shoppingCartButton;

    @FindBy(xpath = "//span[.='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logOutButton;

    @FindBy(xpath = "//div/div[normalize-space()='Warning: No match for E-Mail Address and/or Password.']")
    public WebElement warningMessage;

    public WebElement elementForHomePage(String elementName){
        return Driver.getDriver().findElement(By.xpath("(//ul[@class='list-inline'])[2]//*[text()='"+elementName+"']"));
    }

    public static void logOut(){
        BasePage basePage = new BasePage();
        basePage.myAccountButton.click();
        basePage.logOutButton.click();
    }


    public void textField(String fieldName,String info){
        String TextFieldlocator="//input[@placeholder='" + fieldName +"']";
        Driver.getDriver().findElement(By.xpath(TextFieldlocator)).sendKeys(info);
        BrowserUtils.waitFor(2);
    }



}
