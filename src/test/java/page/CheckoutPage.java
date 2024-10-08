package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static helper.Utility.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutPage {


    public void clickCheckoutButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
    }

    public void fillInformation(String firstName, String lastName, String postalCode){
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);

    }

    public void clickButtonContinue(){
        driver.findElement(By.id("continue")).click();
    }

    public void pageSummary(){
        WebElement summary = driver.findElement(By.className("summary_info"));
        assertTrue(summary.isDisplayed());
    }

    public void totalPriceTax() {
        double totalItemPrice = 0.0;

        // Ambil semua elemen item di keranjang
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));
        for (WebElement priceElement : itemPrices) {
            String priceText = priceElement.getText();
            double itemPrice = Double.parseDouble(priceText.replaceAll("[$,]", "")); // Menghilangkan simbol $ dan koma
            totalItemPrice += itemPrice; // Jumlahkan harga item
        }

        // Ambil jumlah pajak dari elemen di halaman
        WebElement taxElement = driver.findElement(By.className("summary_tax_label"));
        System.out.println(taxElement.getText());

        double taxAmount = Double.parseDouble(taxElement.getText().replaceAll("[Tax: $,]", "").trim()); // Menghilangkan simbol $ dan koma

        // Hitung total harga yang diharapkan
        double expectedTotalPrice = totalItemPrice + taxAmount;

        // Ambil total harga dari elemen di halaman
        WebElement totalPriceElement = driver.findElement(By.className("summary_total_label"));
        String totalPriceText = totalPriceElement.getText();
        double totalPrice = Double.parseDouble(totalPriceText.replaceAll("[Total: $]", "")); // Menghilangkan simbol $ dan koma

        System.out.println(expectedTotalPrice);
        // Verifikasi bahwa total harga yang ditampilkan sesuai dengan yang dihitung
        assertEquals(expectedTotalPrice, totalPrice, 0.01); // Gunakan toleransi untuk perbandingan
    }


    public void userFinishesTheCheckout() {
        driver.findElement(By.id("finish")).click();
    }


    public void userShouldSeeOrderConfirmation(String confirmationMessage) {
        WebElement confirmationText = driver.findElement(By.className("complete-header"));
        assertEquals(confirmationMessage, confirmationText.getText());
    }


}
