package tests;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static base.DriverFactory.createRemoteDrive;
import static base.DriverFactory.getDriver;

public class GridLoginTests extends BaseTests {
    @BeforeTest
    @Parameters("myBrowser")
    public void setup(String myBrowser) throws MalformedURLException {
        createRemoteDrive(myBrowser);
    }

    @Test(priority = 1, description = "Testa login com sucesso Utilizando Selenium Grid")
    public void Test_LoginSeleniumGrid() throws InterruptedException{
        Assert.assertTrue(getDriver().getTitle().contains("MantisBT"));
        getDriver().findElement(By.id("username")).sendKeys("administrator");
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.id("password")).sendKeys("duarte");
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }
}
