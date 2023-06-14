package com.opencart.pages;

import com.opencart.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "button-payment-address")
    public WebElement continueButton;

    @FindBy(id = "input-payment-zone")
    public WebElement regionStateDropDown;

    @FindBy(id = "input-payment-country")
    public WebElement countryDropDown;

    @FindBy(xpath = "//div[@id='payment-existing']/select")
    public WebElement paymentAddressDropdown;

    @FindBy(xpath = "//div[@id='shipping-existing']/select")
    public WebElement shippingAddressDropdown;

    @FindBy(xpath = "//button[.='Confirm Order']")
    public WebElement confirmOrderButton;

    @FindBy(xpath = "//select[@id='input-shipping-method']")
    public WebElement shippingMethodDropdown;

    @FindBy(id = "input-payment-method")
    public WebElement paymentMethodDropdown;

    @FindBy(xpath = "//h1")
    public WebElement successPurchaseMessage;


}
