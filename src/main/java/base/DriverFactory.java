package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static utils.Constantes.*;

public class DriverFactory {

    //private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static WebDriver driver;// = new WebDriver();
    private static String browser;

    public DriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    @Parameters({"browser"})
    public static WebDriver getDriver() {

        if (driver==null){
            if (driverLocal==true){
                DriverFactory.createDriver();
            }
            else {
                DriverFactory.createDriverGrid();
            }
        }
        return driver;

    }

    public static WebDriver createDriver() {
        System.out.println("Starting " + browser + " locally");

        // Creating driver
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", pathChrome);
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", pathFirefox);
                driver= new FirefoxDriver();
                break;
        }

        return driver;
    }


    public static WebDriver createDriverGrid() {
        String hubUrl = "http://192.168.99.100:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("Starting " + browser + " on grid");

        // Creating driver
        switch (browser) {
            case "chrome":
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.LINUX);
                ChromeOptions options = new ChromeOptions();
                options.merge(capabilities);
                break;

            case "firefox":
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(Platform.LINUX);
                FirefoxOptions options2 = new FirefoxOptions();
                options2.merge(capabilities);
                break;
        }

        try {
            driver= new RemoteWebDriver(new URL(hubUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public static void killDriver()     {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }


}
