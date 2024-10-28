package page;

import org.openqa.selenium.By;

import static helper.Utility.*;

public class LoginPage {

    By inputUsername = By.id("user-name");
    By inputPassword = By.id("password");
    By loginButton = By.id("login-button");
    By burgerButton = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");

    By getNotifyError(String message) {
        return By.xpath("//h3[contains(text(),'" + message + "')] ");
    }

    public void sauceDemoLogin() {
        driver.get("https://www.saucedemo.com/");
        explicitWaitClickable(inputUsername);
    }

    public void setInputUsername(String username) {
        explicitWaitPresence(inputUsername);
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void setInputPassword(String password) {
        explicitWaitPresence(inputPassword);
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickButtonLogin() {
        explicitWaitClickable(loginButton);
        driver.findElement(loginButton).click();
    }

    public void validateError(String errorMessage) {
        driver.findElement(getNotifyError(errorMessage)).isDisplayed();
    }

    public void clickButtonBurger() {
        explicitWaitClickable(burgerButton);
        driver.findElement(burgerButton).click();
    }

    public void clickButtonLogout() {
        explicitWaitClickable(logoutButton);
        driver.findElement(logoutButton).click();
    }

}
