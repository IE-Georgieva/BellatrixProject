package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactFormElements extends PageObject {
    public ContactFormElements(WebElement searchContext) {
        super(searchContext);
    }

    private WebElement firstName = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_1"));
    private WebElement lastName = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_1-last"));
    private WebElement email = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_2"));
    private WebElement bronzeAccessPass = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_3_1"));
    private WebElement silverAccessPass = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_3_2"));
    private WebElement goldAccessPass = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_3_3"));
    private WebElement firstSession = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_4_1"));
    private WebElement secondSession = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_4_2"));
    private WebElement thirdSession = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_4_3"));
    private WebElement fourthSession = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_4_4"));
    private WebElement fifthSession = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_4_5"));
    private WebElement yesStayingOvernightRadioButton = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_5_1"));
    private WebElement noStayingOvernightRadioButton = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_5_2"));
    private WebElement checkboxReceiveEmail = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_6_1"));
    private WebElement commentsOrQuestionsSection = SearchContext.findElement(By.cssSelector("#wpforms-3347-field_7"));
    private WebElement recaptchaCheckbox = SearchContext.findElement(By.cssSelector(".recaptcha-checkbox-border"));
    private WebElement submitButton = SearchContext.findElement(By.cssSelector("#wpforms-submit-3347"));
}
