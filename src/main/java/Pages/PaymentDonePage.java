package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class PaymentDonePage {
    SHAFT.GUI.WebDriver driver ;

    public PaymentDonePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By continueButton = By.xpath("//a[normalize-space()='Continue']");

    public static By assert_successMessage() {
        return By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']");
    }

    public HomePage navigateToHomePage_afterPayment() {
        driver.element().click(continueButton);
        return new HomePage(driver);
    }
}
