package pageObject;


import org.openqa.selenium.WebElement;


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


