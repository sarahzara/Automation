package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountInformationPage {
    SHAFT.GUI.WebDriver driver ;

    public AccountInformationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

                /////////ENTER ACCOUNT INFORMATION/////////////////////
    private By titleButton = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By date_DateofBirth = By.id("days");
    private By months_DateofBirth = By.id("months");
    private By years_DateofBirth = By.id("years");
    private By newsletterButton = By.id("newsletter");
    private By optinButton = By.id("optin");

              /////////////ADDRESS INFORMATION/////////////////
    private By firstnameField = By.id("first_name");
    private By lastnameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field =By.id("address1");
    private By countryDropList = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[normalize-space()='Create Account']");

    //////////// Assert ////////////////////////
    public static By assert_EnterAccountInformation() {
        return By.xpath("//b[normalize-space()='Enter Account Information']");
    }

    public static By assert_AddressInformation() {
        return By.xpath("//b[normalize-space()='Address Information']");
    }

    public AccountCreatedPage navigateToAccountCreatedPage(String password, String selectDate, String selectMonths,
                                                           String selectYears,
                                                           String firstName, String lastName,
                                                           String address1, String selectCountry, String state
            , String city, String zipCode, String mobileNumber) {
        driver.element().click(titleButton);
        driver.element().type(passwordField, password);
        driver.element().select(date_DateofBirth, selectDate);
        driver.element().select(months_DateofBirth, selectMonths);
        driver.element().select(years_DateofBirth, selectYears);
        driver.element().click(newsletterButton);
        driver.element().click(optinButton);

        driver.element().type(firstnameField, firstName);
        driver.element().type(lastnameField, lastName);
        driver.element().type(address1Field, address1);
        driver.element().select(countryDropList, selectCountry);
        driver.element().type(stateField, state);
        driver.element().type(cityField, city);
        driver.element().type(zipcodeField, zipCode);
        driver.element().type(mobileNumberField, mobileNumber);
        driver.element().click(createAccountButton);

        return new AccountCreatedPage(driver);
    }

}
