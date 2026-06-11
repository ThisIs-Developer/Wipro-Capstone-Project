package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utilities.Log;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED : "+ result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED : "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED : "+ result.getName());
        try {
        	BaseTest testClass = (BaseTest) result.getInstance();
            String screenshotPath = ScreenshotUtil.captureScreenshot(testClass.driver,result.getName());
            Log.error("Test Failed : "+ result.getName());
            Log.error("Failure Screenshot Saved : "+ screenshotPath);
        } catch (Exception e) {
            Log.error("Unable to capture screenshot : "+ e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED : "+ result.getName());
    }
}