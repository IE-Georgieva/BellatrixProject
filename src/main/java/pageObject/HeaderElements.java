package pageObject;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HeaderElements extends PageObject {
    public HeaderElements(WebElement searchContext) {
        super(searchContext);
    }

    public String getMenuTitle() {
        return SearchContext.getText();
    }

    public void clickOnMenu() {
        SearchContext.click();
    }
}


