package LogoutTests;

import BaseTest.BaseTest;
import Pages.HomePage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    SHAFT.TestData.JSON LoginData;
    String emailLogin;
    String passwordLogin;
    SHAFT.TestData.JSON LogoutData;
    String expectedURL;

    @BeforeMethod
    public void prepareDataLogoutTest() {
        LoginData = new SHAFT.TestData.JSON("LoginData.json");
        emailLogin = LoginData.getTestData("ValidLogin.Email_Login");
        passwordLogin = LoginData.getTestData("ValidLogin.Password_Login");
        LogoutData = new SHAFT.TestData.JSON("LogoutData.json");
        expectedURL = LogoutData.getTestData("Home_URL");
    }

    @Test
    public void LogoutTC4() {
        new HomePage(driver)
                .navigateToSignupPage()
                .navigateToHomePage_validLogin(emailLogin, passwordLogin)
                .navigateToLogout();
        driver.assertThat().browser().url().contains(expectedURL).perform();
    }
}
