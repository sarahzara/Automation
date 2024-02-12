package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class PaymentPage {
    SHAFT.GUI.WebDriver driver;

    public PaymentPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By nameOnCardField = By.xpath("//input[@name='name_on_card']");
    private By card_numberField = By.xpath("//input[@name='card_number']");
    private By cVCField =
            By.name("cvc");
    private By mmExpirationField = By.xpath("//input[@placeholder='MM']");
    private By yyyyExpirationField = By.xpath("//input[@placeholder='YYYY']");
    private By submitButton = By.xpath("//button[@id='submit']");

    public static By successMessage() {
        //Absolute xpath
        return By.xpath("/html/body/section/div/div[3]/div/div[2]/form/div[4]/div/div");
        //return By.xpath("//button[@id='submit']");
    }

    public PaymentDonePage navigateToPaymentDonePage(String cardName, String cardNumber, String cvc, String monthExpiration, String yearExpiration) {
        driver.element().type(nameOnCardField, cardName);
        driver.element().type(card_numberField, cardNumber);
        driver.element().type(cVCField, cvc);
        driver.element().type(mmExpirationField, monthExpiration);
        driver.element().type(yyyyExpirationField, yearExpiration);
        driver.element().click(submitButton);
        ////////??????????? 15. Verify success message 'Your order has been placed successfully!'
        driver.browser().navigateBack();
        driver.browser().element().waitToBeInvisible(successMessage()).getText(successMessage());

        //"Value Should be 'Your order has been placed successfully!");
        driver.element().click(submitButton);
        //driver.element().clickUsingJavascript(submitButton);
        return new PaymentDonePage(driver);

    }


}
