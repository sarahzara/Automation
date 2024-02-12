package BaseTest;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static final String BASEURL = System.getProperty("BASE_URL");

    protected SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    public void init() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(BASEURL);
    }

    @AfterMethod
    public void flush() {
        driver.quit();
    }





}
