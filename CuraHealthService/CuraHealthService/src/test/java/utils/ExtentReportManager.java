package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extent-report.html");
            reporter.config().setReportName("Selenium Automation Test Report");
            reporter.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Nelson");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
