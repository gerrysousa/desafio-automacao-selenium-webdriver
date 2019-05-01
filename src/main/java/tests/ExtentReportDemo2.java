package tests;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utils.Utils;

import static utils.Constantes.pathChrome;

public class ExtentReportDemo2
{   // Create global variable which will be used in all method
    ExtentReports extent;
    ExtentTest logger;
    WebDriver driver;

    // This code will run before executing any testcase
    @BeforeMethod
    public void setup()
    {
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger=extent.createTest("LoginTest");
    }

    // Actual Test which will start the application and verify the title
    @Test
    public void loginTest() throws IOException
    {
        ExtentTest logger=extent.createTest("Logoff Test");

        logger.log(Status.FAIL, "Title verified");

        System.setProperty("webdriver.chrome.driver", pathChrome);
        driver=new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println("title is "+driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    @Test
    public void loginTest2() throws IOException
    {
        ExtentTest logger=extent.createTest("Logoff Test dassdfa");

        logger.log(Status.FAIL, "Title verified");
        System.setProperty("webdriver.chrome.driver", pathChrome);
        driver=new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println("title is "+driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }


    // This will run after testcase and it will capture screenshot and add in report
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= utils.Utils.getScreenshot(driver);
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        extent.flush();
        driver.quit();
    }
    /*
ExtentHtmlReporter relatorio=new ExtentHtmlReporter("./Reports/learn_automation2.html");
ExtentReports reporter = new ExtentReports();
reporter.attachReporter(relatorio);
ExtentTest log;

----
log=reporter.createTest("LoginTest");

log.log(Status.INFO, "Login to amazon");
reporter.flush();
*/

}