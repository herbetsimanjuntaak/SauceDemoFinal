package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.Utility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    By products = By.xpath("(//*[text () = 'Products'])");
    By title = By.xpath("//div[@class='app_logo']");


    public void verifyOnHome() {
        explicitWaitPresence(products);
        driver.findElement(products).isDisplayed();
        WebElement productElement = driver.findElement(title);

        assertEquals("Swag Labs", productElement.getText());
    }
}
