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

import Utils.ManageTest;
import Utils.PropertiesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class LoginFarfetch extends ManageTest {
    private Properties properties = PropertiesHelper.getProperties("src/main/resources/properties/login.properties");

    @BeforeClass
    public void prepareTest() {
        get(properties.getProperty("url"));
    }

    @Test(priority = 2)
    public void loginInFarfetch() {
        WebElement loginModal = findElement(By.id("login-signIn"));
        loginModal.findElement(id("Email")).sendKeys("daniloti.zagato@gmail.com");
        loginModal.findElement(id("Password")).sendKeys("TesteDeSoftware");
        click(xpath("//button[@data-original='Login']"));
        printScreen("loginInFarfetch");
    }

    @Test(priority = 1)
    public void createAccount() {
        WebElement createAccountModal = findElement(id("login-register"));
        createAccountModal.findElement(id("Name")).sendKeys( "Danilo Zagato");
        createAccountModal.findElement(id("Email")).sendKeys( "daniloti.zagato@gmail.com");
        createAccountModal.findElement(id("Password")).sendKeys("TesteDeSoftware");
        createAccountModal.findElement(id("ConfirmPassword")).sendKeys("TesteDeSoftware");
        click(xpath("//label[@class='ffInput' and @for='SubscribeMeToNewsletter']"));
        printScreen("createAccount");
    }

    @AfterClass
    public void close() {
        getWebDriver().close();
        getWebDriver().quit();
    }


}
