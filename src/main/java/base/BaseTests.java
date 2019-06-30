package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;

import static base.DriverFactory.*;
import static utils.Constantes.*;
import static utils.Utils.*;

public class BaseTests {

    public static ExtentHtmlReporter relatorio; // =new ExtentHtmlReporter("./output/Reports/learn_automation2.html");
    public static ExtentReports reporter;// = new ExtentReports();
    public static ExtentTest log;
    public static String fileName;
    public WebDriver driver;


    public static String getUrlBase() {
        return urlBase;
    }

    @BeforeSuite
    public static void beforeSuite() {
        fileName = pathProjeto+"\\output\\Reports\\Relatorio_"+getDataString()+"_"+getHoraString()+".html";
        relatorio =new ExtentHtmlReporter(fileName);
        reporter = new ExtentReports();
        reporter.attachReporter(relatorio);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "environment" })
    public void beforeMethod(@Optional("chrome") String browser, @Optional("local") String environment, Method method, ITestContext context) {
        // Create Driver
        DriverFactory factory = new DriverFactory(browser);
        if (environment.equals("grid")) {
            driver = factory.createDriverGrid();
        } else {
            driver = factory.createDriver();
        }

        // maximize browser window
        getDriver().manage().window().maximize();

        // Set up test name and Logger
        setCurrentThreadName();
        //String testName = context.getCurrentXmlTest().getName();



        getDriver().get(getUrlBase());
        Test mt = method.getDeclaredAnnotation(Test.class);
        String description = mt.description();
        String testName = method.getName();
        String className = getClass().getName().substring(6);
        log=reporter.createTest(testName, description);
        //Reporter.createTest(testName,description,className);

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            if (driverLocal==true) {
                log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            }
        }

        if(result.getStatus()==ITestResult.SUCCESS)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            if (driverLocal==true){
                //  log.pass(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            }
            log.log(Status.PASS, "Title verified");
        }
        log.info("[Closing driver]");
        reporter.flush();
        killDriver();
        //getDriver().quit();
    }

    /** Sets thread name which includes thread id */
    private void setCurrentThreadName() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        String threadId = String.valueOf(thread.getId());
        if (!threadName.contains(threadId)) {
            thread.setName(threadName + " " + threadId);
        }
    }
}
