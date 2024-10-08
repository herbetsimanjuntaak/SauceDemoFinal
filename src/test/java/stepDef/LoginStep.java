package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.LoginPage;

public class LoginStep {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Given("User on the SauceDemo login page")
    public void userOnTheSauceDemoLoginPage() {
        loginPage.sauceDemoLogin();
    }

    @And("User input {string} as username")
    public void userInputAsUsername(String username) {
        loginPage.setInputUsername(username);
    }

    @And("User input {string} as password")
    public void userInputAsPassword(String password) {
        loginPage.setInputPassword(password);
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickButtonLogin();
    }

    @Then("User should be redirected to the products page")
    public void userShouldBeRedirectedToTheProductsPage() {
        homePage.verifyOnHome();
    }

    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMessage) {
        loginPage.validateError(errorMessage);
    }

    @Given("User successfully logged in to the SauceDemo application")
    public void userSuccessfullyLoggedInToTheSauceDemoApplication() {
        loginPage.sauceDemoLogin();
        loginPage.setInputUsername("standard_user");
        loginPage.setInputPassword("secret_sauce");
        loginPage.clickButtonLogin();
        homePage.verifyOnHome();
    }

    @When("User click on the menu burger button")
    public void userClickOnTheMenuBurgerButton() {
        loginPage.clickButtonBurger();
    }

    @And("User click the logout button")
    public void userClickTheLogoutButton() {
        loginPage.clickButtonLogout();
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToTheLoginPage() {
        loginPage.sauceDemoLogin();
    }
}
