package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountCreatedPage {
    SHAFT.GUI.WebDriver driver ;

    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By continueButton = By.xpath("//a[normalize-space()='Continue']");

    public static By assert_AccountCreated(){
        return By.xpath("//b[normalize-space()='Account Created!']");
    }

    public HomePage navigateToHomePage(){
        driver.element().click(continueButton);
        return new HomePage(driver);

    }


}
