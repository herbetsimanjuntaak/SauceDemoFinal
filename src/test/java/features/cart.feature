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
      | productName               | productName2                        | expectedCount |
      | "Sauce Labs Backpack"     | "Sauce Labs Bike Light"             | "2"           |
      | "Sauce Labs Bolt T-Shirt" | "Sauce Labs Fleece Jacket"          | "2"           |
      | "Sauce Labs Onesie"       | "Test.allTheThings() T-Shirt (Red)" | "2"           |

  Scenario Outline: Remove an item from the cart
    Given User has <productName> and <productName2> in the cart
    When User removes <productRemove> from the cart
    Then User should see only <productName> in the cart
    And the cart badge should show <expectedCount> items
    Examples:
      | productName                | productName2                        | productRemove                       | expectedCount |
      | "Sauce Labs Backpack"      | "Sauce Labs Bike Light"             | "Sauce Labs Bike Light"             | "1"           |
      | "Sauce Labs Fleece Jacket" | "Sauce Labs Onesie"                 | "Sauce Labs Onesie"                 | "1"           |
      | "Sauce Labs Onesie"        | "Test.allTheThings() T-Shirt (Red)" | "Test.allTheThings() T-Shirt (Red)" | "1"           |

