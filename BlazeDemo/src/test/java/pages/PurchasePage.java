package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtils;

public class PurchasePage {

    private WebDriver driver;
    private WaitUtils wait;

    private By priceText = By.xpath("/html/body/div[2]/p[3]");
    private By totalCost = By.xpath("/html/body/div[2]/p[4]");
    private By purchaseFlightButton = By.cssSelector("input[value='Purchase Flight']");
    private By nameField = By.id("inputName");
    private By addressField = By.id("address");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By zipCodeField = By.id("zipCode");
    private By cardTypeDropdown = By.id("cardType");
    private By cardNumberField = By.id("creditCardNumber");
    private By monthField = By.id("creditCardMonth");
    private By yearField =  By.id("creditCardYear");
    private By nameOnCardField = By.id("nameOnCard");

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public boolean isPriceDisplayed() {
        WebElement price = driver.findElement(priceText);
        wait.waitForVisibility(price);
        return price.isDisplayed();
    }

    public boolean isTotalCostDisplayed() {
        WebElement cost = driver.findElement(totalCost);
        wait.waitForVisibility(cost);
        return cost.isDisplayed();
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void selectCardType(String cardType) {
        Select select = new Select(driver.findElement(cardTypeDropdown));
        select.selectByVisibleText(cardType);
    }

    public void enterCardNumber(String cardNumber) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
    }

    public void enterMonth(String month) {
        driver.findElement(monthField).clear();
        driver.findElement(monthField).sendKeys(month);
    }

    public void enterYear(String year) {
        driver.findElement(yearField).clear();
        driver.findElement(yearField).sendKeys(year);
    }

    public void enterNameOnCard(String nameOnCard) {
        driver.findElement(nameOnCardField).sendKeys(nameOnCard);
    }

    public void clickPurchaseFlight() {
        WebElement button = driver.findElement(purchaseFlightButton);
        wait.waitForClickable(button);
        button.click();
    }
}