package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    private By departureDropdown = By.name("fromPort");
    private By destinationDropdown = By.name("toPort");
    private By findFlightsButton = By.cssSelector("input[type='submit']");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isDepartureDropdownDisplayed() {
        WebElement element = driver.findElement(departureDropdown);
        wait.waitForVisibility(element);
        return element.isDisplayed();
    }

    public boolean isDestinationDropdownDisplayed() {
        WebElement element = driver.findElement(destinationDropdown);
        wait.waitForVisibility(element);
        return element.isDisplayed();
    }

    public boolean isFindFlightsButtonDisplayed() {
        WebElement element = driver.findElement(findFlightsButton);
        wait.waitForVisibility(element);
        return element.isDisplayed();
    }

    public void selectDepartureCity(String city) {
        Select select = new Select(driver.findElement(departureDropdown));
        select.selectByVisibleText(city);
    }

    public void selectDestinationCity(String city) {
        Select select = new Select(driver.findElement(destinationDropdown));
        select.selectByVisibleText(city);
    }

    public void clickFindFlights() {
        WebElement button = driver.findElement(findFlightsButton);
        wait.waitForClickable(button);
        button.click();
    }
}