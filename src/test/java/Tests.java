import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.*;

public class Tests extends BaseTest {

    @Test
    public void successfullyAddToCartElement() throws InterruptedException {
        homepage.getProductByName("Falcon 9").clickOnButton();
        Thread.sleep(2000);
        homepage.getHeader().getMenuByName("Cart").clickOnMenu();
        cart = new Cart(driver);
        cart.verifyThatElementIsAddedSuccessfully();
    }

    @Test
    public void successfullyClickOnReadMoreButton() throws InterruptedException {
        homepage.getProductByName("Proton-M").clickOnButton();
        readMorePage = new ReadMorePage(driver);
        readMorePage.verifyThatButtonIsClickedSuccessfully("Proton-M", "Read more button is not working correctly!");
    }

    @Test
    public void successfullyOrder() throws InterruptedException {
        homepage.getProductByName("Falcon 9").clickOnButton();
        Thread.sleep(2000);
        homepage.getHeader().getMenuByName("Cart").clickOnMenu();
        cart = new Cart(driver);
        cart.clickOnProceedToCheckoutButton();
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.fillCheckoutPage("TestFirstName", "TestLastName", "Mladost 1", "Sofia", "1000", "02365154210", "testEmail@abv.bg");
        checkOutPage.clickOnPlaceOrderButton();
        orderReceivedPage = new OrderReceivedPage(driver);
        orderReceivedPage.verifyThatOrderIsReceivedSuccessfully("Thank you. Your order has been received.", "Order is not received!");
    }
}
