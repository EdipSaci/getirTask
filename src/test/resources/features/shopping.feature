@OPC01
Feature: User Shopping Experience
  User Story: As a User I want to be able to browse and purchase products
  So that I can have a seamless shopping experience

  Acceptance Criterias:
  1. User should be able to login to website
  2. User should not login website without invalid credentials
  3. User should be able to purchase iPhone

# I did not start with register part. Because a user can register just first time.
#o I continued with login part. I created 2 scenario. First one is positive testing.
  @OPC01-01
  Scenario: User should be able to login to website
    When User navigate to web site
    And  User click to "My Account" button
    And User choose to "Login" link
    And User write valid credentials on E-Mail Address area
    And User write valid credentials on Password area
    And User click to Login button
    Then User validate to see My Account text on page

# Second one is negative testing. It can be multiple.
  @OPC01-02
  Scenario: User should not login website without invalid credentials
    When User navigate to web site
    And  User click to "My Account" button
    And User choose to "Login" link
    And User write invalid credentials on E-Mail Address area
    And User write valid credentials on Password area
    And User click to Login button
    Then User should see "Warning: No match for E-Mail Address and/or Password." alert message


# I chose this specific scenario because I could purchase the iPhone. So it can be automation testing
  @OPC01-03
  Scenario: User should be able to purchase iPhone
    When user should able to login
    And User clicks on the iPhone link under the featured
    And User clicks to Add Cart button
    And User clicks the Shopping Cart button
    And User clicks the Checkout button
    And User fills the required places
    And User clicks the Confirm Order button
    Then User should see "Your order has been placed!" message

