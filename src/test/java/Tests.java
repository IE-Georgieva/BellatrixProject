import org.testng.annotations.Test;
import pages.Cart;
import pages.CheckOutPage;
import pages.OrderReceivedPage;
import pages.ReadMorePage;

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
        checkOutPage.fillCheckoutPage("TestFirstName", "TestLastName", "Mladost 1, 5451 A", "Sofia", "1000", "02365154210", "testEmail@abv.bg");
        checkOutPage.clickOnPlaceOrderButton();
        Thread.sleep(10000);
        orderReceivedPage = new OrderReceivedPage(driver);
        orderReceivedPage.verifyThatOrderIsReceivedSuccessfully("Thank you. Your order has been received.", "Order is not received.");
    }

    @Test
    public void successfullyDeletedItem() throws InterruptedException {
        homepage.getProductByName("Falcon 9").clickOnButton();
        Thread.sleep(2000);
        homepage.getHeader().getMenuByName("Cart").clickOnMenu();
        cart = new Cart(driver);
        cart.clickOnDeleteButton();
        Thread.sleep(2000);
        cart.successfullyDeletedItem();
    }

    @Test
    public void successfullySortElements() throws InterruptedException {
        homepage.selectDropdownOptions(5);
        homepage.successfullySortedElements();
    }

    @Test
    public void ClickOnViewCartButton() throws InterruptedException {
        homepage.getProductByName("Falcon 9").clickOnButton();
        Thread.sleep(2000);
        homepage.getProductByName("Falcon 9").clickOnViewCartButton();
        Thread.sleep(2000);
        cart = new Cart(driver);
        cart.verifyThatElementIsAddedSuccessfully();
    }
}


