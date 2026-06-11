package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        try {
            wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        } catch (Exception e) {
            throw new RuntimeException("Unable to initialize WaitUtils", e);
        }
    }

    public void waitForVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw new RuntimeException("Element not visible", e);
        }
    }

    public void waitForClickable(WebElement element) {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new RuntimeException("Element not clickable", e);
        }
    }

    public void waitForTitle(String title) {

        try {
        	wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            throw new RuntimeException("Title not found : " + title, e);
        }
    }

    public void waitForUrl(String url) {

        try {
        	wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            throw new RuntimeException("URL not found : " + url, e);
        }
    }
}