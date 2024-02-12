package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {
    SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By signupButton = By.xpath("//a[normalize-space()='Signup / Login']");
    private By deleteAccountButton = By.xpath("//a[normalize-space()='Delete Account']");
    private By logoutButton = By.xpath("//a[normalize-space()='Logout']");
    private By viewCartButton = By.xpath("//u[normalize-space()='View Cart']");
    public By cartButton = By.xpath("(//i[@class='fa fa-shopping-cart'])[1]");
    private By continueShoppingButton = By.xpath("//button[normalize-space()='Continue Shopping']");


    //dynamic data  7. Add products to cart
    // first Element in DOM  ( 1. hover mouse to image 2. click to add to cart ) two steps to add element to cart .
    public static By hoverProduct(String productnumber) {
        return By.xpath("(//img[@alt='ecommerce website products'])[" + productnumber + "]");
    }

    public static By addToCartButton(String number) {
        return By.xpath("(//a[contains(text(),'Add to cart')])[" + number + "]");
    }

    private By hoverSecondElement = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]");
    private By addTOCartSecondElement = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a");
    private By hoverFirstElement = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]");
    private By addTOCartFirstElement = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a");
//    >>> Men >> second Element
//            /html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]
//            /html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a
//
//   >> blue  >> first Element
//            /html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]
//            /html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a


    public CartPage navigateToCartPage() {
//        driver.element().hover(hoverProduct("3"));
//        driver.element().scrollToElement(hoverProduct("3"));
//        driver.element().click(addToCartButton("1"));
        driver.element().scrollToElement(hoverSecondElement).hover(hoverSecondElement).getText(hoverSecondElement);
        driver.element().click(addTOCartSecondElement).getText(addTOCartSecondElement);
        driver.element().click(viewCartButton);
//      driver.element().click(cartButton);
        return new CartPage(driver);
    }
    /////////////*********************************************///////////////////////////////

    public SignupPage navigateToSignupPage() {
        driver.element().click(signupButton);
        return new SignupPage(driver);
    }

    public static By userLoginName(String firstName_OfUser) {
        return By.xpath("//b[normalize-space()='" + firstName_OfUser + "']");
        // return By.xpath("//b[normalize-space()='SarahTest']");
    }

    public DeletePage navigateToDeletePage(String firstName) {
        driver.element().isElementDisplayed(userLoginName(firstName));
        driver.element().click(deleteAccountButton);
        return new DeletePage(driver);

    }


    public HomePage navigateToLogout() {
        driver.element().click(logoutButton);
        return this;
    }


}
