Feature: Cart functionality on Sauce Demo website

  Scenario Outline: Add items to the cart and verify the cart
    Given User successfully logged in to the SauceDemo application
    When User adds the <productName> to the cart
    And User adds the <productName2> to the cart
    And User navigates to the cart
    Then User should see <productName> in the cart
    And User should see <productName2> in the cart
    And the cart badge should show <expectedCount> items
    Examples:
      | productName           | productName2            | expectedCount |
      | "Sauce Labs Backpack" | "Sauce Labs Bike Light" | "2"           |

  Scenario Outline: Remove an item from the cart
    Given User has <productName> and <productName2> in the cart
    When User removes <productRemove> from the cart
    Then User should see only <productName> in the cart
    And the cart badge should show <expectedCount> items
    Examples:
      | productName           | productName2            | productRemove           | expectedCount |
      | "Sauce Labs Backpack" | "Sauce Labs Bike Light" | "Sauce Labs Bike Light" | "1"           |

#  Scenario: Checkout the cart
#    Given User has "Sauce Labs Backpack" in the cart
#    When User clicks on the "Checkout" button
#    And User fills out the checkout information with first name "John", last name "Doe", and postal code "12345"
#    And User continues to the next step
#    Then User should see a summary of their order
#    And User should see the total price including tax
#    When User finishes the checkout
#    Then User should see the order confirmation page with the message "THANK YOU FOR YOUR ORDER"
