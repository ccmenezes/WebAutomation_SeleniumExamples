

package testesBasicos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;

    public WebDriver getWebDriver(Browser browser) {

        switch (browser) {
            case FIREFOX: {
                return generateFirefoxDriver();
            }
            case GOOGLECHROME: {
                return generateChromeDriver();
            }
            default: {
                return generateChromeDriver();
            }
        }
    }

    private WebDriver generateFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/zagato/IdeaProjects/automationWeb/src/main/webDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }

    private WebDriver generateChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/zagato/IdeaProjects/automationWeb/src/main/webDrivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions().addArguments();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;

    }
}
