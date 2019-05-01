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
import static base.DriverFactory.getDriver;
import static base.DriverFactory.killDriver;
import static utils.Constantes.pathProjeto;
import static utils.Constantes.urlBase;
import static utils.Utils.*;

public class BaseTests {

    public static ExtentHtmlReporter relatorio; // =new ExtentHtmlReporter("./output/Reports/learn_automation2.html");
    public static ExtentReports reporter;// = new ExtentReports();
    public static ExtentTest log;
    protected static WebDriver driver;
    public  static String fileName;

    public static String getUrlBase() {
        // return "http://192.168.99.100:8989";
        return urlBase;
    }

    @BeforeSuite
    public static void beforeSuite() {
        fileName = pathProjeto+"\\output\\Reports\\Relatorio_"+getDataString()+"_"+getHoraString()+".html";
        relatorio =new ExtentHtmlReporter(fileName);
        reporter = new ExtentReports();
        reporter.attachReporter(relatorio);
 }

    @BeforeMethod
    public void beforeMethod(Method method, ITestContext context) {
        getDriver().get(getUrlBase());
        Test mt = method.getDeclaredAnnotation(Test.class);
        String description = mt.description();
        String testName = method.getName();
        String className = getClass().getName().substring(6);
        log=reporter.createTest(testName, description);
        //Reporter.createTest(testName,description,className);

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        if(result.getStatus()==ITestResult.SUCCESS)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            log.log(Status.PASS, "Title verified");
        }

        reporter.flush();
        killDriver();
    }

}
