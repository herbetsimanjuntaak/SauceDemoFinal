package page;

import org.openqa.selenium.By;

import static helper.Utility.*;

public class LoginPage {

    By inputUsername = By.id("user-name");
    By inputPassword = By.id("password");
    By loginButton = By.id("login-button");

    By getNotifyError(String message){
        return By.xpath("//h3[contains(text(),'"+message+"')] ");
    }

    public void sauceDemoLogin(){
        driver.get("https://www.saucedemo.com/");
        explicitWaitClickable(inputUsername);
    }

    public void setInputUsername(String username){
        explicitWaitPresence(inputUsername);
        driver.findElement(inputUsername).sendKeys(username);
    }
    public void setInputPassword(String password){
        explicitWaitPresence(inputPassword);
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickButtonLogin(){
        explicitWaitClickable(loginButton);
        driver.findElement(loginButton).click();

    }

    public void lockedUser(String errorMessage){
        driver.findElement(getNotifyError(errorMessage)).isDisplayed();
    }

}
