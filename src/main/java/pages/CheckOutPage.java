package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.PageObject;

import java.time.Duration;

public class CheckOutPage extends CommonPage {


    public CheckOutPage(WebDriver driver) {
        super(driver);

    }

    private WebElement loginButton = webDriver.findElement(By.cssSelector(".showlogin"));
    private WebElement couponButton = webDriver.findElement(By.cssSelector(".showcoupon"));
    private WebElement firstName = webDriver.findElement(By.cssSelector("#billing_first_name"));
    private WebElement lastName = webDriver.findElement(By.cssSelector("#billing_last_name"));
    private WebElement companyName = webDriver.findElement(By.cssSelector("#billing_company"));
    private WebElement country = webDriver.findElement(By.cssSelector("#select2-billing_country-container"));
    private WebElement streetAddress = webDriver.findElement(By.cssSelector("#billing_address_1"));
    private WebElement apartment = webDriver.findElement(By.cssSelector("#billing_address_2"));
    private WebElement city = webDriver.findElement(By.cssSelector("#billing_city"));
    private WebElement state = webDriver.findElement(By.cssSelector("#select2-billing_state-container"));
    private WebElement postcode = webDriver.findElement(By.cssSelector("#billing_postcode"));
    private WebElement phone = webDriver.findElement(By.cssSelector("#billing_phone"));
    private WebElement email = webDriver.findElement(By.cssSelector("#billing_email"));
    private WebElement createAnAccount = webDriver.findElement(By.cssSelector("#createaccount"));
    private WebElement orderNotes = webDriver.findElement(By.cssSelector("#order_comments"));
    private WebElement checkboxes = webDriver.findElement(By.cssSelector(".input-radio"));
    private WebElement placeOrderButton = webDriver.findElement(By.cssSelector("#place_order"));
    private WebElement orderReceivedText = webDriver.findElement(By.cssSelector(".entry-title"));

    public void fillCheckoutPage(String first, String last, String address, String town, String zip, String phoneNumber, String emailAddress) {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        streetAddress.sendKeys(address);
        city.sendKeys(town);
        postcode.sendKeys(zip);
        phone.sendKeys(phoneNumber);
        email.sendKeys(emailAddress);

    }

    public void clickOnPlaceOrderButton() {
        loadingIndicator();
        Actions actions = new Actions(webDriver);
        var element = webDriver.findElement(By.cssSelector("div.form-row"));
        actions.moveToElement(element).moveByOffset(0, -25).click().perform();
    }

    public void loadingIndicator() {
        performWait();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.blockOverlay")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockOverlay")));
    }

}
