package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class Cart extends CommonPage {
    private WebElement proceedToCheckout = webDriver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward"));

    public Cart(WebDriver driver) {
        super(driver);
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckout.click();
    }

    public void verifyThatElementIsAddedSuccessfully() {
        Assert.assertTrue(proceedToCheckout.isDisplayed(), "Product is not added to cart");
    }

}
