/************************************************************************************************************
 *
 *
 *
 ************************************************************************************************************/

import Utils.ManageTest;
import Utils.PropertiesHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

import static java.lang.System.setProperty;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class LoginFarfetch extends ManageTest {
    private Properties properties;

    @BeforeClass
    public void prepareTest() {
        properties = PropertiesHelper.getProperties("src/main/resources/properties/login.properties");
        setProperty("webdriver.chrome.driver", "src/main/resources/webDrivers/chromedriver");
        get(properties.getProperty("url"));

    }

    @Test
    public void loginInFarfetch() {
        sendKeys(id("Email"), "daniloti.zagato@gmail.com");
        sendKeys(id("Password"), "TesteDeSoftware");
        click(xpath("//button[@data-original='Login']"));
        printScreen("loginInFarfetch");
    }

    @Test
    public void createAccount() {
        sendKeys(id("Name"),"Danilo Zagato");
        sendKeys(id("Email"),"daniloti.zagato@gmail.com");
        sendKeys(id("Password"),"TesteDeSoftware");
        sendKeys(id("ConfirmPassword"),"TesteDeSoftware");
        click(xpath("//label[@class='ffInput' and @for='SubscribeMeToNewsletter']"));
        printScreen("createAccount");
    }

}
