package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.InStockProduct;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;


public class HomePage extends CommonPage {
    private WebElement sortDropdown = webDriver.findElement(By.name("orderby"));
    private List<WebElement> productsElements = webDriver.findElements(By.cssSelector(".product.type-product"));
    private List<InStockProduct> productElement;
    private List<WebElement> priceElements = webDriver.findElements(By.cssSelector("span.price:not(:has(>del)), span.price ins"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List<InStockProduct> getAllProducts() {
        if (productElement == null) {
            setAllProducts();
        }
        return productElement;
    }

    public void setAllProducts() {
        List<InStockProduct> resultProducts = new ArrayList<>();
        for (WebElement productElement : productsElements) {
            InStockProduct tempProduct = new InStockProduct(productElement);
            resultProducts.add(tempProduct);
        }
        productElement = resultProducts;
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

    public void selectDropdownOptions(int index) {
        Select sortBy = new Select(sortDropdown);
        assertFalse(sortBy.isMultiple());
        List<WebElement> allMakeOptions = sortBy.getOptions();
        assertEquals(allMakeOptions.size(), 6);
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : allMakeOptions) {
            actualOptions.add(option.getText());
        }
        sortBy.selectByIndex(index);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void successfullySortedElements() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        List<WebElement> priceElements = webDriver.findElements(By.cssSelector("span.price:not(:has(>del)), span.price ins"));
        List<Double> prices = priceElements.stream()
                .map(e -> {
                    String priceText = e.getText().replace("€", "").trim();
                    Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
                    Matcher matcher = pattern.matcher(priceText);
                    if (matcher.find()) {
                        return Double.parseDouble(matcher.group());
                    } else {
                        throw new NumberFormatException("Invalid price format: " + priceText);
                    }
                })
                .collect(Collectors.toList());
        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(prices.get(i) >= prices.get(i + 1), "Prices are not sorted correctly.");
        }
        Double highestPrice = prices.get(0);
        System.out.println("Highest price: " + highestPrice);
    }
}

