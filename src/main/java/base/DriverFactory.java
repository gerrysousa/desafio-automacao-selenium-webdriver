package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static utils.Constantes.pathChrome;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            createDrive();
        }
        WebDriverWait wait = new WebDriverWait(driver, 30);

        return driver;
    }

    private static void createDrive() {
        try {
            System.setProperty("webdriver.chrome.driver", pathChrome);
            driver = new ChromeDriver();

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void killDriver() 	{
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}
