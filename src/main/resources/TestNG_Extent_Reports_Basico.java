import java.io.IOException;
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
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println("title is "+driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Mukesh"));
    }

    // This will run after testcase and it will capture screenshot and add in report
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp=Utility.getScreenshot(driver);
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        extent.flush();
        driver.quit();
    }
}
==========================================================
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utility
{
    public static String getScreenshot(WebDriver driver)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
        File destination=new File(path);

        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }
        return path;
    }
}
=============================================================
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.tentativa.mil</groupId>
    <artifactId>TentativaMil</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>


        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>3.1.5</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.10</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>3.141.59</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-io -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-io</artifactId>
            <version>1.3.2</version>
        </dependency>

    </dependencies>
</project>