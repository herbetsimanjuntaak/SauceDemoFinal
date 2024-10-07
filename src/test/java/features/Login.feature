Feature: User Login

  Scenario: Successful login with valid credentials
    Given User on the SauceDemo login page
    And User input "standard_user" as username
    And User input "secret_sauce" as password
    When User click on the login button
    Then User should be redirected to the products page


  Scenario Outline: Unsuccessful login with locked user,invalid username and password
    Given User on the SauceDemo login page
    And User input <username> as username
    And User input <password> as password
    When User click on the login button
    Then User should see an error message <errorMessage>

    Examples:
      | username          | password       | errorMessage                                                                |
      | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out."                       |
      | "standard_user"   | "password"     | "Epic sadface: Username and password do not match any user in this service" |
      | "username"        | "secret_sauce" | "Epic sadface: Username and password do not match any user in this service" |



#  Scenario: Unsuccessful login with invalid password
#    Given I am on the SauceDemo login page
#    When I enter "standard_user" as username
#    And I enter "wrong_password" as password
#    And I click on the login button
#    Then I should see an error message "Username and password do not match any user in this service"
#
#  Scenario: Login page elements are visible
#    Given I am on the SauceDemo login page
#    Then I should see the username input field
#    And I should see the password input field
#    And I should see the login button
