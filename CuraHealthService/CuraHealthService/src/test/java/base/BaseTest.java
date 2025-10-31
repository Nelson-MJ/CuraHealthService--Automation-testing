package base;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class BaseTest {
     public WebDriver driver;
     public WebDriverWait wait;
     public LoginPage login;
    protected static ExtentReports extent;
    protected static ExtentTest test;


    @BeforeSuite
    public void setupExtent() {
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void tearDownExtent() {
        extent.flush();
    }


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // ✅ Set the correct Chromium binary path
        options.setBinary("C:\\Users\\josep\\Downloads\\Chromium\\chrome-win64\\chrome-win64\\chrome.exe");

        // ✅ Crucial flags to prevent crashes and popup warnings
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-features=SafetyTipUI,LookalikeUrlNavigationSuggestionsUI,PasswordManagerOnboarding");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--password-store=basic");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        // ✅ Make sure profile directory exists (create manually)
        options.addArguments("--user-data-dir=C:/temp/chromium_profile");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Open login page
        login = new LoginPage(driver, wait);
        login.openUrl();
        login.loginCredentials();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            LoginPage logout = new LoginPage(driver, wait);
            logout.logout();
            driver.quit();
        }
    }
}
