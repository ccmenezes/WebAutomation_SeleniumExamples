/************************************************************************************************************
 *  Criado por - Danilo Zagato (daniloti.zagato@gmail.com)
 *
 *  Projeto criado somente com o objetivo de estudo, sem nenhum vinculo com os sites e/ou nomes aqui citados
 *  Caso sinta que algo neste projeto está em desacordo com a sua opinião ou companhia, por gentileza
 *  Entre em contato via e-mail
 *
 *  Obrigado
 *
 ************************************************************************************************************/
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
        setWebDriver(System.getProperty("os.name"));
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }

    private void setWebDriver(String osName) {

        if (osName.equals("Mac OS X")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/webDrivers/osx/chromedriver");
            System.setProperty("webdriver.gecko.driver", "src/main/resources/webDrivers/osx/geckodriver");

        } else if (osName.equals("Linux")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/webDrivers/linux/chromedriver");
            System.setProperty("webdriver.gecko.driver", "src/main/resources/webDrivers/linux/geckodriver");

        } else if (osName.contains("Windows")) {
        } else {
            System.out.println(osName);
        }

    }

    private WebDriver generateChromeDriver() {
        setWebDriver(System.getProperty("os.name"));
        ChromeOptions chromeOptions = new ChromeOptions().addArguments();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;

    }
}
