Feature: Checkout process on Sauce Demo website

  Scenario: Successful checkout
    Given User successfully logged in to the SauceDemo application
    When User adds the "Sauce Labs Backpack" to the cart
    And User adds the "Sauce Labs Onesie" to the cart
    And User navigates to the cart
    And User clicks on the Checkout button
    And User fills out the checkout information with first name "John", last name "Doe", and postal code "12345"
    And User continues to the next step
    Then User should see a summary of their order
    And User should see the total price including tax
    When User finishes the checkout
    Then User should see the order confirmation page with the message "Thank you for your order!"

  Scenario Outline: Checkout with missing first name
    Given User successfully logged in to the SauceDemo application
    When User adds the <productName> to the cart
    And User navigates to the cart
    And User clicks on the Checkout button
    And User fills out the checkout information with first name <firstName>, last name <lastName>, and postal code <postalCode>
    And User tries to continue to the next step
    Then User should see an error message <errorMessage>
    Examples:
      | productName           | firstName | lastName | postalCode | errorMessage                     |
      | "Sauce Labs Backpack" | ""        | "Doe"    | "12345"    | "Error: First Name is required"  |
      | "Sauce Labs Backpack" | "John"    | ""       | ""         | "Error: Last Name is required"   |
      | "Sauce Labs Backpack" | ""        | ""       | ""         | "Error: First Name is required"  |
      | "Sauce Labs Backpack" | "John"    | "Doe"    | ""         | "Error: Postal Code is required" |
