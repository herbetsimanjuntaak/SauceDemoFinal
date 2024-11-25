package stepDef;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.ProductPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helper.Utility.driver;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;



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


    @When("User select the {string} sorting option")
    public void userSelectTheSortingOption(String sortingOption) throws InterruptedException {
        productPage.iSelectTheSortingOption(sortingOption);
    }

    @Then("the products should be displayed in {string} order")
    public void theProductsShouldBeDisplayedInOrder(String orderDescription) {
        if (orderDescription.contains("A to Z")) {
            validateProductNamesOrder(orderDescription);
        } else if (orderDescription.contains("ascending") || orderDescription.contains("descending")) {
            validateProductPricesOrder(orderDescription);
        }
    }

    private void validateProductNamesOrder(String orderDescription) {
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement product : productElements) {
            actualProductNames.add(product.getText());
            System.out.println(product.getText());
        }

        List<String> sortedProductNames = new ArrayList<>(actualProductNames);
        if (orderDescription.contains("reverse")) {
            sortedProductNames.sort(reverseOrder()); // Sort Z to A
        } else {
            sort(sortedProductNames); // Sort A to Z
        }

        assertEquals(actualProductNames, sortedProductNames);
    }

    private void validateProductPricesOrder(String orderDescription) {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : priceElements) {
            actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        if (orderDescription.contains("descending")) {
            sortedPrices.sort(reverseOrder()); // Sort high to low
        } else {
            sort(sortedPrices); // Sort low to high
        }

        assertEquals(actualPrices, sortedPrices);
    }
}
