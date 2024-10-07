package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.LoginPage;

public class LoginStep {

    LoginPage loginPage;
    HomePage homePage;

    public LoginStep() {
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
    }

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
    }
}
