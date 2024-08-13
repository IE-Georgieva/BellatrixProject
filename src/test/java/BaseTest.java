import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homepage;
    protected Cart cart;
    protected CheckOutPage checkOutPage;
    protected OrderReceivedPage orderReceivedPage;
    protected ReadMorePage readMorePage;
    public static final String SCREENSHOTS_DIR = ("src\\test\\resources\\screenshots\\");
    private static BaseTest instance = null;

    protected BaseTest(){}

    @BeforeSuite
    protected final void setupTestSuite() throws IOException {
        cleanDirectory(SCREENSHOTS_DIR);
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    protected void tearDownTest(ITestResult testResult) {
        takeScreenshot(testResult);
        quitDriver();
    }

    @BeforeTest
    public WebDriver openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.bellatrix.solutions/");
        homepage = new HomePage(driver);
        return driver;

    }

    public static BaseTest getInstance() {
        if (instance == null) {
            instance = new BaseTest();
        }
        return instance;
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

    private void cleanDirectory(String directoryPath) throws IOException {

        File directory = new File(directoryPath);
        Assert.assertTrue(directory.isDirectory(), "Invalid directory!");

        try {
            FileUtils.cleanDirectory(directory);
            System.out.printf("All files are deleted in Directory: %s%n", directoryPath);
        } catch (IOException exception) {
            System.out.printf("Unable to delete the files in Directory: %s%n", directoryPath);
        }
    }

    private void takeScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {

            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                String testName = testResult.getName();
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR.concat(testName).concat(".jpeg")));
            } catch (IOException e) {
                System.out.println("Unable to create a screenshot file: " + e.getMessage());
            }
        }
    }
}
