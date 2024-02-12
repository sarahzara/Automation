package LoginTests;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.SignupPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    SHAFT.TestData.JSON LoginData;
    String emailLogin;
    String passwordLogin;
    String invalid_Email;
    String invalid_Passwd;
    String errorMessage;
    SHAFT.TestData.JSON NewUserSignup;
    String newUserSignup_Name;


    @BeforeMethod
    public void prepareDataLoginData() {

        LoginData = new SHAFT.TestData.JSON("LoginData.json");
//        emailLogin = String.valueOf(LoginData.getTestDataAsList("ValidLogin.Email_Login"));
//        passwordLogin = String.valueOf(LoginData.getTestDataAsList("ValidLogin.Password_Login"));
        emailLogin = LoginData.getTestData("ValidLogin.Email_Login");
        passwordLogin = LoginData.getTestData("ValidLogin.Password_Login");
        System.out.println(emailLogin);
        System.out.println("////////*********************************");
        System.out.println(passwordLogin);

        invalid_Email = LoginData.getTestData("InvalidLogin.Email_Login");
        invalid_Passwd = LoginData.getTestData("InvalidLogin.Password_Login");
        errorMessage = LoginData.getTestData("ErrorMessage.errorMessage");

        NewUserSignup = new SHAFT.TestData.JSON("NewUserSignup.json");
        newUserSignup_Name = NewUserSignup.getTestData("Signup_Name");

    }

    @Test
    public void validLoginTC2() {
        new HomePage(driver).navigateToSignupPage().navigateToHomePage_validLogin(emailLogin, passwordLogin);
        driver.assertThat().element(HomePage.userLoginName(newUserSignup_Name)).text().isEqualTo(newUserSignup_Name).perform();

    }

    @Test
    public void invalidLoginTC3() {
        new HomePage(driver).navigateToSignupPage().navigateToSignupPage_invalidLogin(invalid_Email, invalid_Passwd);
        driver.assertThat().element(SignupPage.assert_errorMessage()).text().contains(errorMessage).perform();
    }

}
