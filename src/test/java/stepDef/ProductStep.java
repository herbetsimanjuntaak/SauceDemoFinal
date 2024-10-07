package stepDef;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.ProductPage;

import static helper.Utility.driver;


public class ProductStep {


    ProductPage productPage;

    public ProductStep() {
        this.productPage = new ProductPage();
    }

    @When("User click on the {string} product")
    public void userClickOnTheProduct(String productName) {
        productPage.clickProduct(productName);
    }

    @Then("User should see the product details page")
    public void userShouldSeeTheProductDetailsPage() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        assert currentUrl.contains("inventory-item.html");
        WebElement buttonBack = driver.findElement(By.id("back-to-products"));
        buttonBack.isDisplayed();
    }

    @When("User add the {string} to my cart")
    public void userAddTheToMyCart(String productName) {
        productPage.addProductToCart(productName);
    }

    @Then("the cart badge should show {string}")
    public void theCartBadgeShouldShow(String expectedCount) {
        productPage.verifyCartItemIsMatch(expectedCount);
    }

    @When("User click button add to cart")
    public void userClickButtonAddToCart() {
        productPage.clickButtonAddToCart();
    }

    @When("User remove product added {string}")
    public void userRemoveProductAdded(String productName) {
        productPage.removeProduct(productName);
    }
}
