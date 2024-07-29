package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class OrderReceived extends CommonPage {

    private WebElement orderReceivedText = webDriver.findElement(By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received"));

    public OrderReceived(WebDriver driver) {
        super(driver);
    }

    public void verifyThatOrderIsReceivedSuccessfully(String expectedText, String messageOnFailure) {
        performWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(orderReceivedText));
        String actualText = orderReceivedText.getText();
        Assert.assertTrue(actualText.contains(expectedText), messageOnFailure);
    }

}
