package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private ExtentManager() {}

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter( "reports/ExtentReport.html");
            sparkReporter.config().setDocumentTitle("Flight Booking Automation Report");
            sparkReporter.config().setReportName( "Automation Execution Results");
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}