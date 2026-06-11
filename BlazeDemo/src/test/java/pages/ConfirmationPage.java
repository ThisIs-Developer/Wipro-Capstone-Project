package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtils;

public class ConfirmationPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By successMessage = By.tagName("h1");
    private By purchaseId = By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]");
    private By status = By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]");
    private By amount = By.xpath("/html/body/div[2]/div/table/tbody/tr[3]/td[2]");
    private By cardNumber = By.xpath("/html/body/div[2]/div/table/tbody/tr[4]/td[2]");
    private By date = By.xpath("/html/body/div[2]/div/table/tbody/tr[7]/td[2]");
    
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public String getSuccessMessage() {
        WebElement element = driver.findElement(successMessage);
        wait.waitForVisibility(element);
        return element.getText();
    }

    public String getPurchaseId() {
        return driver.findElement(purchaseId).getText();
    }

    public String getStatus() {
        return driver.findElement(status).getText();
    }

    public String getAmount() {
        return driver.findElement(amount).getText();
    }

    public String getCardNumber() {
        return driver.findElement(cardNumber).getText();
    }

    public String getDate() {
        return driver.findElement(date).getText();
    }
}