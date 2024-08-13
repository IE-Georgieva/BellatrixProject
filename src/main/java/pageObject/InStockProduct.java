package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InStockProduct extends PageObject {
    private WebElement titleElement = SearchContext.findElement(By.cssSelector("h2.woocommerce-loop-product__title"));
    private WebElement buttonElement = SearchContext.findElement(By.cssSelector(".product_type_simple"));

    public InStockProduct(WebElement searchContext) {
        super(searchContext);
    }

    public String getTitle() {
        return titleElement.getText();

    }

    public void clickOnButton() {
        buttonElement.click();
    }
}
