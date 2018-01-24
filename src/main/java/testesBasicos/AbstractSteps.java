/*
 * Criado para fins de testes, pode usar e compartilhar desde que não cobre por isso
 */

/*
 * Criado para fins de testes, pode usar e compartilhar desde que não cobre por isso
 */

/*
 * Criado para fins de testes, pode usar e compartilhar desde que não cobre por isso
 */

package testesBasicos;

import org.openqa.selenium.WebDriver;


public class AbstractSteps {
    private WebDriver driver;

    private WebDriver getWebDriver(Browser browser) {
        if (driver == null) {
            driver = new DriverFactory().getWebDriver(browser);
        }
        return driver;
    }

    protected void get(String uri) {
        getWebDriver(Browser.GOOGLECHROME).get(uri);
    }
}
