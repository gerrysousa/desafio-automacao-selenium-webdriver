package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static utils.Constantes.*;

public class DriverFactory {

    private static WebDriver driver;
    private static String nodeUrl;

    public static WebDriver getDriver() {
        if (driver == null) {
            if(driverLocal==true) {
                createDrive();
            }
            else{
                createRemoteDrive(driverRemoteDefault);
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 30);

        return driver;
    }

    public static void killDriver() 	{
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
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

    public static void createRemoteDrive(String browser) {
        try {
            if(browser.equals("iexplore")){
                nodeUrl = "http://localhost:4444/wd/hub";
                DesiredCapabilities capability = new DesiredCapabilities();
                capability.setBrowserName("internet explorer");
                capability.setPlatform(Platform.WINDOWS);
                InternetExplorerOptions options2 = new InternetExplorerOptions();
                options2.merge(capability);
                driver = new RemoteWebDriver(new URL(nodeUrl), capability);
                // driver.manage().window().maximize();
            }
            else if(browser.equals("chrome")){
                nodeUrl = "http://192.168.99.100:4444/wd/hub";
                //nodeUrl = "http://localhost:4444/wd/hub";

                DesiredCapabilities capability = new DesiredCapabilities();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.LINUX);
                //capability.setPlatform(Platform.WIN10);
                ChromeOptions options = new ChromeOptions();
                options.merge(capability);
                driver = new RemoteWebDriver(new URL(nodeUrl), capability);

            }
            else if(browser.equals("firefox")){
                nodeUrl = "http://192.168.99.100:4444/wd/hub";
                //nodeUrl = "http://localhost:4444/wd/hub";
                DesiredCapabilities capability = new DesiredCapabilities();
                capability.setBrowserName("firefox");
                capability.setCapability("marionette",true);
                //capability.setCapability(FirefoxDriver.BINARY, pathFirefox);
                capability.setPlatform(Platform.LINUX);
                //capability.setPlatform(Platform.WIN10);
                FirefoxOptions options = new FirefoxOptions();

                //options.setBinary(pathFirefox);
                options.merge(capability);
                driver = new RemoteWebDriver(new URL(nodeUrl), capability);

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


}
