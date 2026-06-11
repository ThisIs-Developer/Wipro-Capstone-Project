package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.LoginPage;
import pages.PurchasePage;
import pages.RegisterPage;
import utilities.ConfigReader;

public class NegativeTestingTest extends BaseTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private PurchasePage purchasePage;
    private ConfirmationPage confirmationPage;

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][] {
            {"Baivab Sarkar", "Wipro", "baivab@test.com", "Test@123", "Test@123"}
        };
    }

    @DataProvider(name = "purchaseNegativeData")
    public Object[][] purchaseNegativeData() {
        return new Object[][] {
            {"", "123456", "@#$%^&*", "98765", "ABCDEF", "Visa", "1","99", "1900", "@@@###"}
        };
    }

    @Test(priority = 1, dataProvider = "userData")
    public void verifyRegistrationNegative(String name, String company, String email, String password, String confirmPassword){
    	driver.get(ConfigReader.getProperty("url")+"register");
        registerPage = new RegisterPage(driver);
        
        registerPage.registerUser(name, company, email, password, confirmPassword);
        Assert.assertTrue(registerPage.is419ErrorDisplayed(),"Known Defect: Registration request results in HTTP 419 Page Expired error.");
    }

    @Test(priority = 2, dataProvider = "userData")
    public void verifyLoginNegative(String name, String company, String email, String password, String confirmPassword){
        driver.get(ConfigReader.getProperty("url") + "login");
        loginPage = new LoginPage(driver);

        loginPage.login(email,password);
        Assert.assertTrue(loginPage.is419ErrorDisplayed(),"Known Defect: Login request results in HTTP 419 Page Expired error.");
    }

    @Test(priority = 3, dataProvider = "purchaseNegativeData")
    public void verifyPurchaseNegative(String name, String address, String city, 
    		String state, String zipCode, String cardType, String cardNumber, String month, String year, String nameOnCard){

        driver.get(ConfigReader.getProperty("url") + "purchase.php");
        purchasePage = new PurchasePage(driver);

        purchasePage.enterName(name);
        purchasePage.enterAddress(address);
        purchasePage.enterCity(city);
        purchasePage.enterState(state);
        purchasePage.enterZipCode(zipCode);
        purchasePage.selectCardType(cardType);
        purchasePage.enterCardNumber(cardNumber);
        purchasePage.enterMonth(month);
        purchasePage.enterYear(year);
        purchasePage.enterNameOnCard(nameOnCard);
        purchasePage.clickPurchaseFlight();

        confirmationPage = new ConfirmationPage(driver);

        Assert.assertEquals(
                confirmationPage.getSuccessMessage(),
                "Thank you for your purchase today!",
                "Critical Defect: System generated a booking confirmation despite invalid passenger and payment information.");

        Assert.assertFalse(
                confirmationPage.getPurchaseId().isEmpty(),
                "Critical Defect: Booking ID was generated for invalid booking data.");

        Assert.assertEquals(
                confirmationPage.getStatus(),
                "PendingCapture",
                "Critical Defect: Invalid booking received a valid transaction status.");

        Assert.assertFalse(
                confirmationPage.getAmount().isEmpty(),
                "Critical Defect: Amount was generated despite invalid input data.");

        Assert.assertFalse(
                confirmationPage.getCardNumber().isEmpty(),
                "Critical Defect: Invalid payment information was accepted.");

        Assert.assertFalse(
                confirmationPage.getDate().isEmpty(),
                "Critical Defect: Confirmation record was created for invalid booking data.");
    }
}