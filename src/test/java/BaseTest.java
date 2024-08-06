import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homepage;
    protected Cart cart;
    protected CheckOutPage checkOutPage;
    protected OrderReceivedPage orderReceivedPage;
    protected ReadMorePage readMorePage;

    @BeforeTest
    public void setDriver() {
        driver = new ChromeDriver();
        System.out.println("Driver is initialized");
        driver.manage().window().maximize();
        driver.get("https://demos.bellatrix.solutions/");
        homepage = new HomePage(driver);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
