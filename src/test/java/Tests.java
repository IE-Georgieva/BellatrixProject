import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObject.HeaderElements;
import pageObject.InStockProduct;
import pages.*;

import java.time.Duration;
import java.util.List;

public class Tests extends BaseTest {

    @Test
    public void successfullyAddToCartElement() throws InterruptedException {
        InStockProduct firstElement = homepage.getProductByName("Falcon 9");
        firstElement.clickOnButton();
        Thread.sleep(2000);
        HeaderElements thirdElement = homepage.getHeader().getMenuByName("Cart");
        thirdElement.clickOnMenu();
        cart = new Cart(driver);
        cart.verifyThatElementIsAddedSuccessfully();

    }

    @Test
    public void successfullyClickOnReadMoreButton() throws InterruptedException {
        InStockProduct thirdElement = homepage.getProductByName("Proton-M");
        thirdElement.clickOnButton();
        readMore = new ReadMore(driver);
        readMore.verifyThatButtonIsClickedSuccessfully("Proton-M", "Read more button is not working correctly!");

    }

    @Test
    public void successfullyOrder() throws InterruptedException {
        InStockProduct firstElement = homepage.getProductByName("Falcon 9");
        firstElement.clickOnButton();
        Thread.sleep(2000);
        HeaderElements thirdElement = homepage.getHeader().getMenuByName("Cart");
        thirdElement.clickOnMenu();
        cart = new Cart(driver);
        cart.clickOnProceedToCheckoutButton();
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.fillCheckoutPage("TestFirstName", "TestLastName", "Mladost 1, 5451 A", "Sofia", "1000", "02365154210", "testEmail@abv.bg");
        checkOutPage.clickOnPlaceOrderButton();
        Thread.sleep(10000);
        orderReceived = new OrderReceived(driver);
        orderReceived.verifyThatOrderIsReceivedSuccessfully("Thank you. Your order has been received.", "Order is not received!");
    }
    
}
