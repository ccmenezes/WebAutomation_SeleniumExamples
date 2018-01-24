
/*
 * Criado para fins de testes, pode usar e compartilhar desde que não cobre por isso
 */

package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import testesBasicos.Browser;
import testesBasicos.DriverFactory;

import java.io.File;
import java.io.IOException;


public class ManageTest {
    private static WebDriver driver;

    protected boolean get(String url) {
        this.getWebDriver().get(url);
        return true;
    }

    protected WebDriver getWebDriver() {
        if (driver == null) driver = new DriverFactory().getWebDriver(Browser.GOOGLECHROME);
        return driver;
    }

    protected WebElement findElement(By by) {
        return this.getWebDriver().findElement(by);
    }

    protected void click(By by) {
        this.findElement(by).click();
    }

    protected void sendKeys(By by, CharSequence... charSequences) {
        this.findElement(by).sendKeys(charSequences);
    }

    protected void printScreen(String printname) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("/src/main/resources/" + printname + ".png"));
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
