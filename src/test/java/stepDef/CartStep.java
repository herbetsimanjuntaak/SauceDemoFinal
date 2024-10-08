package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;

import page.CartPage;
import page.HomePage;
import page.LoginPage;
import page.ProductPage;

import static helper.Utility.driver;

public class CartStep {

    CartPage cartPage = new CartPage();
    ProductPage productPage = new ProductPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @When("User adds the {string} to the cart")
    public void userAddsTheToTheCart(String productName) {
        productPage.addProductToCart(productName);
    }

    @And("User navigates to the cart")
    public void userNavigatesToTheCart() {
        driver.findElement(By.className("shopping_cart_link")).click();

    }

    @Then("User should see {string} in the cart")
    public void userShouldSeeInTheCart(String productName) {
        cartPage.viewProductInCart(productName);
    }

    @And("the cart badge should show {string} items")
    public void theCartBadgeShouldShowItems(String expectedCount) {
        productPage.verifyCartItemIsMatch(expectedCount);
    }

    @Given("User has {string} and {string} in the cart")
    public void userHasAndInTheCart(String productName, String productName2) {
        loginPage.sauceDemoLogin();
        loginPage.setInputUsername("standard_user");
        loginPage.setInputPassword("secret_sauce");
        loginPage.clickButtonLogin();
        homePage.verifyOnHome();
        productPage.addProductToCart(productName);
        productPage.addProductToCart(productName2);
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("User removes {string} from the cart")
    public void userRemovesFromTheCart(String productRemove) {
        cartPage.removesFromTheCart(productRemove);
    }

    @Then("User should see only {string} in the cart")
    public void userShouldSeeOnlyInTheCart(String productName) {
        cartPage.viewProductInCart(productName);
    }
}
