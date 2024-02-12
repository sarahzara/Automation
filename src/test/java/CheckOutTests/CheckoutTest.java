package CheckOutTests;

import BaseTest.BaseTest;
import Pages.*;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    SHAFT.TestData.JSON LoginData;
    String emailLogin;
    String passwordLogin;
    SHAFT.TestData.JSON PaymentData;
    String cardName, cardNumber, cvc, mm_Expiration, yyyy_Expiration , assert_SuccessMessage;
    String newUserSignup_Name, newUserSignup_email;
    SHAFT.TestData.JSON NewUserSignup;
    SHAFT.TestData.JSON AccountInformation;
    String accountInformation_Password, accountInformation_DateDateofBirth, accountInformation_MonthsDateofBirth, accountInformation_YearsDateofBirth, accountInformation_FirstName, accountInformation_LastName, accountInformation_Address1, accountInformation_State, accountInformation_Country, accountInformation_City, accountInformation_Zipcode, accountInformation_MobileNumber;


    @BeforeMethod
    public void prepareDataCheckoutTest() {
        LoginData = new SHAFT.TestData.JSON("LoginData.json");
        emailLogin = LoginData.getTestData("ValidLogin.Email_Login");
        passwordLogin = LoginData.getTestData("ValidLogin.Password_Login");

        PaymentData = new SHAFT.TestData.JSON("PaymentData.json");
        cardName = PaymentData.getTestData("CardName");
        cardNumber = PaymentData.getTestData("CardNumber");
        cvc = PaymentData.getTestData("CVC");
        mm_Expiration = PaymentData.getTestData("MM_Expiration");
        yyyy_Expiration = PaymentData.getTestData("YYYY_Expiration");
        assert_SuccessMessage = PaymentData.getTestData("Assert_SuccessMessage");

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

    //11. Verify Address Details and Review Your Order
    ///        ???? validation ???
    @Test
    public void verfiyDataTC() {
        new HomePage(driver).navigateToSignupPage()
                .navigateToHomePage_validLogin(emailLogin,passwordLogin)
                .navigateToCartPage().getData();

        new HomePage(driver).navigateToSignupPage()
                .navigateToHomePage_validLogin(emailLogin,passwordLogin)
                .navigateToCartPage().navigateToCheckoutPage().getData();


    }

    @Test
    public void loginBeforeCheckoutTc16() {
        new HomePage(driver)
                .navigateToSignupPage()
                .navigateToHomePage_validLogin(emailLogin, passwordLogin)
                .navigateToCartPage()
                .navigateToCheckoutPage()
                .navigateToPaymentPage()
                .navigateToPaymentDonePage(cardName, cardNumber, cvc, mm_Expiration, yyyy_Expiration);
                //.navigateToHomePage_afterPayment();
        driver.assertThat().element(PaymentPage.successMessage()).text().contains(assert_SuccessMessage).perform();


    }

    @Test
    public void placeOrderBeforeCheckoutTC15() {
        new HomePage(driver)
                .navigateToSignupPage()
                .navigateToAccountInformationPage_SignUp(newUserSignup_Name, newUserSignup_email)
                .navigateToAccountCreatedPage(accountInformation_Password, accountInformation_DateDateofBirth, accountInformation_MonthsDateofBirth, accountInformation_YearsDateofBirth, accountInformation_FirstName, accountInformation_LastName, accountInformation_Address1, accountInformation_Country, accountInformation_State, accountInformation_City, accountInformation_Zipcode, accountInformation_MobileNumber)
                .navigateToHomePage()
                .navigateToCartPage()
                .navigateToCheckoutPage()
                .navigateToPaymentPage()
                .navigateToPaymentDonePage(cardName, cardNumber, cvc, mm_Expiration, yyyy_Expiration)
                .navigateToHomePage_afterPayment();
        driver.assertThat().element(PaymentPage.successMessage()).text().contains(assert_SuccessMessage).perform();

    }

    @Test
    public void placeOrderBeforeCheckoutTC14() {
        new HomePage(driver)
                .navigateToCartPage()
                .navigateToCheckoutPage()
                .navigateToSignupPage_loginAfterCheckout()
                .navigateToAccountInformationPage_SignUp(newUserSignup_Name, emailLogin)
                .navigateToAccountCreatedPage(accountInformation_Password, accountInformation_DateDateofBirth, accountInformation_MonthsDateofBirth, accountInformation_YearsDateofBirth, accountInformation_FirstName, accountInformation_LastName, accountInformation_Address1, accountInformation_Country, accountInformation_State, accountInformation_City, accountInformation_Zipcode, accountInformation_MobileNumber)
                .navigateToHomePage()
                .navigateToCartPage()
                .navigateToCheckoutPage()
                .navigateToPaymentPage()
                .navigateToPaymentDonePage(cardName, cardNumber, cvc, mm_Expiration, yyyy_Expiration)
                .navigateToHomePage_afterPayment();
        driver.assertThat().element(PaymentPage.successMessage()).text().contains(assert_SuccessMessage).perform();

    }




}
