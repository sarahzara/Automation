package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    static SHAFT.GUI.WebDriver driver;

    public CartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By proceedToCheckoutButton = By.xpath("//a[normalize-space()='Proceed To Checkout']");


    public CheckoutPage navigateToCheckoutPage() {
        driver.element().click(proceedToCheckoutButton);
        driver.assertThat().browser().url().isEqualTo("https://automationexercise.com/view_cart");
        return new CheckoutPage(driver);
    }

    ////// Method to assert /////
    By name = By.xpath("//a[normalize-space()='Blue Top']");
    private By price = By.xpath("//p[normalize-space()='Rs. 500']");

    //11. Verify Address Details and Review Your Order ????????????????????????
    private By productNameINCart = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[1]/td[2]/h4/a");
    private By priceINCart = By.xpath("/html/body/section/div/div[2]/table/tbody/tr[1]/td[3]/p");

    public void getData() {
        String A = driver.element().getText(productNameINCart);
        String B = driver.element().getText(priceINCart);
        System.out.println(A);
        System.out.println(B);

//        List<String> expectedData = new ArrayList<String>();
//        List<String> actualData = new ArrayList<String>();

    }

    public void getname_Cart(String productName) {
        WebElement webElementName = driver.getDriver().findElement(By.xpath("//a[normalize-space()='" + productName + "']"));
        webElementName.getText();
        System.out.println(webElementName.getText());
        Assert.assertEquals(productName, "Blue Top", "Blue Top");
    }


}



