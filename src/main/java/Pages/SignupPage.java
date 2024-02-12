package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignupPage {
    SHAFT.GUI.WebDriver driver ;

    public SignupPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By nameSignUpField = By.xpath("//input[@placeholder='Name']");
    private By emailSignUpField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[normalize-space()='Signup']");

    private By emailLoginField = By.xpath("//input[@data-qa='login-email']");
    private By passwordLoginField = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");

    public static By assert_errorMessage() {
        return By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
    }

    public AccountInformationPage navigateToAccountInformationPage_SignUp(String nameSignUp, String emailSignUp) {
        driver.element().type(nameSignUpField, nameSignUp);
        driver.element().type(emailSignUpField, emailSignUp);
        driver.element().click(signupButton);
        return new AccountInformationPage(driver);
    }

    public HomePage navigateToHomePage_validLogin(String emailLogin, String passwordLogin) {
        driver.element().type(emailLoginField, emailLogin);
        driver.element().type(passwordLoginField, passwordLogin);
        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    public SignupPage navigateToSignupPage_invalidLogin(String emailLogin, String passwordLogin) {
        driver.element().type(emailLoginField, emailLogin);
        driver.element().type(passwordLoginField, passwordLogin);
        driver.element().click(loginButton);
        return this;
    }


}
