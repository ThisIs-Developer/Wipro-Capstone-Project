package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.id("email");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[contains(normalize-space(),'Login')]");

    public void enterEmail(String emailId) {
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String emailId, String pwd) {
        enterEmail(emailId);
        enterPassword(pwd);
        clickLogin();
    }

    public boolean is419ErrorDisplayed() {

        return driver.getPageSource().contains("419") || driver.getPageSource().contains("Page Expired");
    }
}