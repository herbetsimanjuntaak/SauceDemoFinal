package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.Utility.driver;

public class CartPage {


    public void viewProductInCart(String productName){
        WebElement cartItem = driver.findElement(By.xpath("//div[text()='" + productName + "']"));
        Assert.assertTrue(cartItem.isDisplayed());
    }

    public void removesFromTheCart(String productRemove){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'" + productRemove + "')]/ancestor::div[@class='cart_item']//button[text()='Remove']")));
        removeButton.click();
    }
}
