package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtils;

public class FlightsPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By flightTable = By.cssSelector("table[class='table']");
    private By flightRows = By.xpath("/html/body/div[2]/table/tbody/tr");
    private By chooseFlightButtons = By.cssSelector("input[value='Choose This Flight']");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public boolean isFlightTableDisplayed() {

        WebElement table = driver.findElement(flightTable);
        wait.waitForVisibility(table);
        return table.isDisplayed();
    }

    public int getFlightCount() {
        List<WebElement> rows = driver.findElements(flightRows);
//        System.out.println("Total Flight Count: "+rows.size());
        return rows.size();
    }

    public boolean hasFlights() {
        return getFlightCount() > 0;
    }

    public void chooseFirstFlight() {
        List<WebElement> buttons = driver.findElements(chooseFlightButtons);
        if (buttons.isEmpty()) {
            throw new RuntimeException("No Flight Found");
        }
        wait.waitForClickable(buttons.get(0));
        buttons.get(0).click();
    }
}