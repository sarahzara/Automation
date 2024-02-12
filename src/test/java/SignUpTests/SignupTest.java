package SignUpTests;

import BaseTest.BaseTest;
import Pages.HomePage;
import com.shaft.driver.SHAFT;
import org.stringtemplate.v4.ST;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {
    String newUserSignup_Name;
    String newUserSignup_email;
    String accountInformation_Password;
    String accountInformation_DateDateofBirth;
    String accountInformation_MonthsDateofBirth;
    String accountInformation_YearsDateofBirth;
    String accountInformation_FirstName;
    String accountInformation_LastName;
    String accountInformation_Address1;
    String accountInformation_Country;
    String accountInformation_State;
    String accountInformation_City;
    String accountInformation_Zipcode;
    String accountInformation_MobileNumber;

    SHAFT.TestData.JSON AccountInformation;
    SHAFT.TestData.JSON NewUserSignup;

    @BeforeMethod
    public void prepareDataSignupTest() {
        NewUserSignup = new SHAFT.TestData.JSON("NewUserSignup.json");
        newUserSignup_Name = NewUserSignup.getTestData("Signup_Name");
        newUserSignup_email = NewUserSignup.getTestData("Signup_email");

        AccountInformation = new SHAFT.TestData.JSON("AccountInformation.json");
        accountInformation_Password = AccountInformation.getTestData("Password_SignUP");
        accountInformation_DateDateofBirth = AccountInformation.getTestData("DateDateofBirth_SignUP");
        accountInformation_MonthsDateofBirth = AccountInformation.getTestData("MonthsDateofBirth_SignUP");
        accountInformation_YearsDateofBirth = AccountInformation.getTestData("YearsDateofBirth_SignUP");
        accountInformation_FirstName = AccountInformation.getTestData("FirstName_SignUP");
        accountInformation_LastName = AccountInformation.getTestData("LastName_SignUP");
        accountInformation_Address1 = AccountInformation.getTestData("Address1_SignUP");
        accountInformation_Country = AccountInformation.getTestData("Country_SignUP");
        accountInformation_State = AccountInformation.getTestData("State_SignUP");
        accountInformation_City = AccountInformation.getTestData("City_SignUP");
        accountInformation_Zipcode = AccountInformation.getTestData("ZipCode_SignUP");
        accountInformation_MobileNumber = AccountInformation.getTestData("MobileNumber_SignUP");

    }

    @Test
    public void registerUserTC1() {
        new HomePage(driver).navigateToSignupPage()
                .navigateToAccountInformationPage_SignUp(newUserSignup_Name, newUserSignup_email)
                .navigateToAccountCreatedPage(accountInformation_Password, accountInformation_DateDateofBirth, accountInformation_MonthsDateofBirth, accountInformation_YearsDateofBirth, accountInformation_FirstName, accountInformation_LastName, accountInformation_Address1, accountInformation_Country, accountInformation_State, accountInformation_City, accountInformation_Zipcode, accountInformation_MobileNumber)
                .navigateToHomePage()
                .navigateToDeletePage(newUserSignup_Name)
                .navigateTohomePage();
       // driver.assertThat().element(AccountInformationPage.assert_EnterAccountInformation()).exists().perform();
       // driver.assertThat().element(AccountInformationPage.assert_AddressInformation()).isEnabled().perform();
        //driver.assertThat().element(AccountCreatedPage.assert_AccountCreated()).exists().perform();
        driver.assertThat().element(HomePage.userLoginName(newUserSignup_Name)).text().isEqualTo(newUserSignup_Name);


    }
}
