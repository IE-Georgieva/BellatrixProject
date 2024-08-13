package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.InStockProduct;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonPage {
    private List<WebElement> productsElements = webDriver.findElements(By.cssSelector(".product.type-product"));
    private List<InStockProduct> productElements;
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public List<InStockProduct> getAllProducts(){
        if (productElements == null){
            setAllProducts();
        }
        return productElements;
    }

    public void setAllProducts(){
        List<InStockProduct> resultProducts = new ArrayList<>();
        for (WebElement productElement : productsElements) {
            InStockProduct tempProduct = new InStockProduct(productElement);
            resultProducts.add(tempProduct);
        }
        productElements = resultProducts;
    }

    public InStockProduct getProductByName(String productName) {
        InStockProduct resultProduct = null;
        List<InStockProduct> allProducts = getAllProducts();
        for (InStockProduct product : allProducts) {
            if (product.getTitle().equals(productName)) {
                resultProduct = product;
                break;
            }
        }
        return resultProduct;
    }
}
