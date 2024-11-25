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
      | ""                | "secret_sauce" | "Epic sadface: Username and password do not match any user in this service" |

  Scenario: Successful logout after login
    Given User successfully logged in to the SauceDemo application
    When User click on the menu burger button
    And User click the logout button
    Then User should be redirected to the login page