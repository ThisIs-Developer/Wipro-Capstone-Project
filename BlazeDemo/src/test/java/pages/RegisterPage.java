package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By name = By.id("name");
    private By company = By.id("company");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirm");
    private By registerButton = By.xpath("//button[contains(normalize-space(),'Register')]");

    public void registerUser(String userName, String companyName, String emailId, String pwd, String confirmPwd) {
        driver.findElement(name).sendKeys(userName);
        driver.findElement(company).sendKeys(companyName);
        driver.findElement(email).sendKeys(emailId);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
        driver.findElement(registerButton).click();
    }

    public boolean is419ErrorDisplayed() {
        return driver.getPageSource().contains("419") || driver.getPageSource().contains("Page Expired");
    }
}