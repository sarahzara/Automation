package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    SHAFT.GUI.WebDriver driver;

    public CheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By placeButton = By.xpath("//a[normalize-space()='Place Order']");

    private By registerLoginField = By.xpath("//u[normalize-space()='Register / Login']");

    //11. Verify Address Details and Review Your Order
    private By productNameINCheckoutpage = By.xpath("/html/body/section/div/div[5]/table/tbody/tr[1]/td[2]/h4/a");
    private By priceINCartCheckoutpage = By.xpath("/html/body/section/div/div[5]/table/tbody/tr[1]/td[3]/p");

    public void getData() {
        String A = driver.element().getText(productNameINCheckoutpage);
        String B = driver.element().getText(priceINCartCheckoutpage);
        System.out.println(A);
        System.out.println(B);
//         List<String> expectedData = new ArrayList<String>();
//         List<String> actualData = new ArrayList<String>();

    }
    public void getname_checkout(String productName) {
        WebElement webElementName = driver.getDriver().findElement(By.xpath("//a[normalize-space()='" + productName + "']"));
        webElementName.getText();
        System.out.println(webElementName.getText());
        Assert.assertEquals(productName, "Blue Top", "Blue Top");
    }

    public PaymentPage navigateToPaymentPage() {
        driver.element().click(placeButton);
        return new PaymentPage(driver);
    }

    public SignupPage navigateToSignupPage_loginAfterCheckout() {
        driver.element().click(registerLoginField);
        return new SignupPage(driver);
    }






}
