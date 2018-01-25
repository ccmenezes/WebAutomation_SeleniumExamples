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
