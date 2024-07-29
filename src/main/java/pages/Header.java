package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.HeaderElements;
import pageObject.PageObject;


import java.util.ArrayList;
import java.util.List;

public class Header extends PageObject {

    private List<WebElement> allMenus = SearchContext.findElements(By.cssSelector("ul.nav-menu li"));

    public Header(WebElement SearchContext) {
        super(SearchContext);
    }

    public List<HeaderElements> getAllMenus() {
        List<HeaderElements> resultMenu = new ArrayList<>();

        for (WebElement menuElement : allMenus) {
            HeaderElements tempMenu = new HeaderElements(menuElement);
            resultMenu.add(tempMenu);
        }
        return resultMenu;
    }

    public HeaderElements getMenuByName(String menuName) {
        HeaderElements resultMenu = null;
        List<HeaderElements> allMenus = getAllMenus();

        for (HeaderElements menu : allMenus) {

            if (menu.getMenuTitle().equals(menuName)) {
                resultMenu = menu;
                break;
            }
        }

        return resultMenu;
    }


}
