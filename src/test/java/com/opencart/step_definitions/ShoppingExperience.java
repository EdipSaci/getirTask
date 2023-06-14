package com.opencart.step_definitions;

import com.opencart.pages.*;
import com.opencart.utilities.BrowserUtils;
import com.opencart.utilities.ConfigurationReader;
import com.opencart.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.Select;

@Slf4j
public class ShoppingExperience {

    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @When("User navigate to web site")
    public void user_navigate_to_web_site() {

            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            log.info("Home page is launched");

    }

    @And("User click to {string} button")
    public void user_click_to_button(String myAccountButton) {
        loginPage.elementForHomePage(myAccountButton).click();
    }

    @And("User choose to {string} link")
    public void user_choose_to_login_button(String loginLink) {

        //While testing manually on Chrome browser relevant cookies are activated by chrome browser. While using selenium WebDriver to interact in browser during the automation we need to add this cookie in our source code.

        Cookie cookie = new Cookie("OCSESSID", "6e976adc91060d97d8b1fde3e0");
        Driver.getDriver().manage().addCookie(cookie);

        loginPage.elementForHomePage(loginLink).click();
    }

    @And("User write valid credentials on E-Mail Address area")
    public void user_write_valid_credantials_on_e_mail_address_area() {
        loginPage.emailAddressInputBox.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @And("User write valid credentials on Password area")
    public void user_write_valid_credantials_on_password_area() {
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.waitFor(2);
    }

    @And("User click to Login button")
    public void user_click_to_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User validate to see My Account text on page")
    public void user_validate_to_see_text_on_page() {
        Assert.assertTrue(accountPage.myAccountHeader.isDisplayed());
        BasePage.logOut();
    }

    @When("User write invalid credentials on E-Mail Address area")
    public void user_write_invalid_credentials_on_e_mail_address_area() {
        loginPage.emailAddressInputBox.sendKeys("asdasfafa");
    }

    @Then("User should see {string} alert message")
    public void user_should_see_alert_message(String warningMessage) {
        Assert.assertTrue(loginPage.warningMessage.getText().contains(warningMessage));
    }


    @When("user should able to login")
    public void user_should_able_to_login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.myAccountButton.click();
        Cookie cookie = new Cookie("OCSESSID", "6e976adc91060d97d8b1fde3e0");
        Driver.getDriver().manage().addCookie(cookie);
        loginPage.loginLink.click();
        loginPage.emailAddressInputBox.sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();
        BrowserUtils.waitFor(1);
        loginPage.opencartLogo.click();
        BrowserUtils.waitFor(1);
    }

    @When("User clicks on the iPhone link under the featured")
    public void user_clicks_on_the_i_phone_link_under_the_featured() {
        //BrowserUtils.executeJScommand("window.scrollBy(0,500)");
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(homePage.iPhoneImg);
        //homePage.iPhoneLink.click();
    }

    @When("User clicks to Add Cart button")
    public void user_clicks_to_add_cart_button() {
        productPage.addCartButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("User clicks the Shopping Cart button")
    public void user_clicks_the_shopping_cart_button() {
        //loginPage.shoppingCartButton.click();
        BrowserUtils.clickWithJS(loginPage.shoppingCartButton);
        BrowserUtils.waitFor(2);
    }

    @When("User clicks the Checkout button")
    public void user_clicks_the_checkout_button() {
        loginPage.checkoutButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("User fills the required places")
    public void user_fills_the_required_places() {

        if (checkoutPage.paymentAddressDropdown.isDisplayed()) {
            Select paymentDropdown = new Select(checkoutPage.paymentAddressDropdown);
            paymentDropdown.selectByIndex(1);
            Select shippingDropdown = new Select(checkoutPage.shippingAddressDropdown);
            shippingDropdown.selectByIndex(1);
            BrowserUtils.waitFor(3);

        }else {
            loginPage.textField("First Name", "John");
            loginPage.textField("Last Name", "Wick");
            loginPage.textField("Address 1", "address");
            loginPage.textField("City", "Turkey");
            loginPage.textField("Post Code", "123");
            Select country = new Select(checkoutPage.countryDropDown);
            country.selectByIndex(3);
            BrowserUtils.waitFor(2);
            Select regionState = new Select(checkoutPage.regionStateDropDown);
            regionState.selectByIndex(1);
            checkoutPage.continueButton.click();
            BrowserUtils.waitFor(2);
        }

        Select shippingMethod = new Select(checkoutPage.shippingMethodDropdown);
//        WebElement optGroup = checkoutPage.shippingMethodDropdown.findElement(By.xpath("//optgroup[@label='Flat Rate']"));
//
//        Select optGroupSelect = new Select(optGroup);

        shippingMethod.selectByVisibleText("Flat Shipping Rate - $5.00");
        BrowserUtils.waitFor(2);

        Select paymentMethod = new Select(checkoutPage.paymentMethodDropdown);
        paymentMethod.selectByIndex(1);
        BrowserUtils.waitFor(2);
    }

    @When("User clicks the Confirm Order button")
    public void user_clicks_the_confirm_order_button() {

        BrowserUtils.clickWithJS(checkoutPage.confirmOrderButton);
        BrowserUtils.waitFor(2);
    }

    @Then("User should see {string} message")
    public void user_should_see_message(String successMessage) {
        Assert.assertEquals(successMessage,checkoutPage.successPurchaseMessage.getText());
        BrowserUtils.waitFor(3);
        BasePage.logOut();
    }


}


//        registerPage.myAccountButton.click();
//        registerPage.registerButton.click();
//        registerPage.firstNameInputBox.sendKeys("yasar");
//        registerPage.lastNameInputBox.sendKeys("kemal");
//        registerPage.emailInputBox.sendKeys("yasar@gmail.com");
//        registerPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
//        registerPage.acceptSubscribeCheckBox.click();
//        registerPage.continueButton.click();