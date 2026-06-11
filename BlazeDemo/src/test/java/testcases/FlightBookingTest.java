package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utilities.ExcelUtils;
import utilities.ExtentManager;
import utilities.Log;
import utilities.ScreenshotUtil;

public class FlightBookingTest extends BaseTest {

    private final ExtentReports extent = ExtentManager.getInstance();
    private ExtentTest test;

    private HomePage homePage;
    private FlightsPage flightsPage;
    private PurchasePage purchasePage;
    private ConfirmationPage confirmationPage;

    private String departureCity;
    private String destinationCity;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    private String cardType;
    private String cardNumber;
    private String month;
    private String year;
    private String nameOnCard;

    @DataProvider(name = "bookingData")
    public static Object[][] bookingData() {
        return ExcelUtils.getExcelData("src/test/resources/testdata/FlightBookingData.xlsx","BookingData");
    }

    @Factory(dataProvider = "bookingData")
    public FlightBookingTest(String departureCity, String destinationCity, String name, String address, String city, String state, 
    		String zipCode, String cardType, String cardNumber, String month, String year, String nameOnCard) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.nameOnCard = nameOnCard;
    }

    @Test(priority=1, groups={"smoke", "regression"})
    public void verifyHomePage() {
        test = extent.createTest(departureCity+"->"+destinationCity);
        Log.info("Home Page Verification Started");

        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageTitle(), "BlazeDemo");
        Assert.assertEquals(homePage.getPageUrl(), "https://blazedemo.com/");
        Assert.assertTrue(homePage.isDepartureDropdownDisplayed());
        Assert.assertTrue(homePage.isDestinationDropdownDisplayed());
        Assert.assertTrue(homePage.isFindFlightsButtonDisplayed());
        homePage.selectDepartureCity(departureCity);
        homePage.selectDestinationCity(destinationCity);
        homePage.clickFindFlights();
        
        test.pass("Home Page Verified Successfully");
        Log.info("Home Page Verification Completed");
    }

    @Test(priority = 2,groups = {"regression"},dependsOnMethods = "verifyHomePage")
    public void verifyFlightSearch() {
        test = extent.createTest("Verify Flight Search");
        Log.info("Flight Search Verification Started");

        flightsPage = new FlightsPage(driver);
        Assert.assertTrue(flightsPage.isFlightTableDisplayed());
        Assert.assertTrue(flightsPage.hasFlights());
        flightsPage.chooseFirstFlight();

        test.pass("Flight Search Verified");
        Log.info("Flight Search Verification Completed");
    }

    @Test(priority = 3, groups = { "regression" }, dependsOnMethods = "verifyFlightSearch")
    public void verifyPurchasePage() {
        test = extent.createTest("Verify Purchase Page");
        Log.info("Purchase Page Verification Started");

        purchasePage = new PurchasePage(driver);
        Assert.assertTrue(purchasePage.isPriceDisplayed());
        Assert.assertTrue(purchasePage.isTotalCostDisplayed());
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

        test.pass("Passenger And Payment Details Submitted");
        Log.info("Purchase Page Verification Completed");
    }

    @Test(priority = 4,groups = {"regression"},dependsOnMethods = "verifyPurchasePage")
    public void verifyBookingConfirmation() throws Exception {
        test = extent.createTest("Verify Booking Confirmation");
        Log.info("Confirmation Verification Started");

        confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(confirmationPage.getSuccessMessage(),"Thank you for your purchase today!");
        Assert.assertFalse(confirmationPage.getPurchaseId().isEmpty());
        Assert.assertEquals(confirmationPage.getStatus(),"PendingCapture");
        Assert.assertFalse(confirmationPage.getAmount().isEmpty());
        Assert.assertFalse(confirmationPage.getCardNumber().isEmpty());
        Assert.assertFalse(confirmationPage.getDate().isEmpty());

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver,"BookingSuccess");

        test.addScreenCaptureFromPath(screenshotPath);
        Log.info("Screenshot Captured");
        test.pass("Booking Confirmation Verified");
        Log.info("Booking Confirmation Completed");
        extent.flush();
    }
}