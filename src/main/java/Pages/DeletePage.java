package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DeletePage {
    SHAFT.GUI.WebDriver driver ;

    public DeletePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By continueButton = By.xpath("//a[normalize-space()='Continue']");

    public static By assert_AccountDeleted(){
        return By.xpath("//b[normalize-space()='Account Deleted!']");
    }

    public HomePage navigateTohomePage(){
        driver.element().click(continueButton);
        return new HomePage(driver);

    }
}
