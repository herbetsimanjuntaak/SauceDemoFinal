Feature: Product Interaction in SauceDemo Inventory
  As a user of SauceDemo
  I want to interact with products in the inventory
  So that I can add them to my cart and view details


  Scenario Outline: Viewing product details
    Given User successfully logged in to the SauceDemo application
    When User click on the <productName> product
    Then User should see the product details page
    Examples:
      | productName                         |
      | "Sauce Labs Backpack"               |
      | "Sauce Labs Bike Light"             |
      | "Sauce Labs Bolt T-Shirt"           |
      | "Sauce Labs Fleece Jacket"          |
      | "Sauce Labs Onesie"                 |
      | "Test.allTheThings() T-Shirt (Red)" |


  Scenario Outline: Adding a product to the cart
    Given User successfully logged in to the SauceDemo application
    When User add the <productName> to my cart
    Then the cart badge should show <expectedCount>
    Examples:
      | productName                         | expectedCount |
      | "Sauce Labs Backpack"               | "1"           |
      | "Sauce Labs Bike Light"             | "1"           |
      | "Sauce Labs Bolt T-Shirt"           | "1"           |
      | "Sauce Labs Fleece Jacket"          | "1"           |
      | "Sauce Labs Onesie"                 | "1"           |
      | "Test.allTheThings() T-Shirt (Red)" | "1"           |

  Scenario: Adding more than product to the cart
    Given User successfully logged in to the SauceDemo application
    When User add the "Sauce Labs Backpack" to my cart
    When User add the "Sauce Labs Bike Light" to my cart
    Then the cart badge should show "2"

  Scenario Outline: adding product when view product details
    Given User successfully logged in to the SauceDemo application
    And User click on the <productName> product
    And User should see the product details page
    When User click button add to cart
    Then the cart badge should show <expectedCount>
    Examples:
      | productName             | expectedCount |
      | "Sauce Labs Backpack"   | "1"           |
      | "Sauce Labs Bike Light" | "1"           |

  Scenario: Remove product
    Given User successfully logged in to the SauceDemo application
    And User add the "Sauce Labs Backpack" to my cart
    And User add the "Sauce Labs Bike Light" to my cart
    And the cart badge should show "2"
    When User remove product added "Sauce Labs Bike Light"
    And the cart badge should show "1"