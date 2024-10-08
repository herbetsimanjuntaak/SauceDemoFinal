package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.Utility.driver;
import static org.junit.Assert.assertEquals;

public class ProductPage {

    By addToCart = By.xpath("//*[text()='Add to cart']");

    public void clickProduct(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']")).click();
    }

    public void addProductToCart(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Menunggu elemen produk muncul
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + productName + "']")));

        // Menggunakan XPath untuk menemukan tombol "Add to Cart"
        WebElement productButton = driver.findElement(By.xpath("//div[text()='" + productName + "']//ancestor::div[@class='inventory_item_description']//following-sibling::div[@class='pricebar']//button"));

        // Mengklik tombol "Add to Cart"
        productButton.click();
    }

    public void clickButtonAddToCart() {
        WebElement addToCartButton = driver.findElement(addToCart);
        addToCartButton.click();

    }

    public void verifyCartItemIsMatch(String expectedCount) {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String actualCount = cartBadge.getText();
        assertEquals(actualCount, expectedCount);
    }

    public void removeProduct(String productName) {
        // Menunggu elemen produk muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + productName + "']")));

        // Menggunakan XPath untuk menemukan tombol "Remove"
//        WebElement removeButton = driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='cart_item']//button[contains(@id, 'remove')]"));
        WebElement removeButton = driver.findElement(By.xpath("//div[@class='cart_item']//div[contains(text(), 'Sauce Labs Bike Light')]//following-sibling::button[contains(@id, 'remove')]"));

        // Mengklik tombol "Remove"
        removeButton.click();
    }

    public void iSelectTheSortingOption(String sortingOption) throws InterruptedException {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(sortingOption);
        Thread.sleep(2000);
    }




}
