package tests;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;

import static base.DriverFactory.createDriverGrid;
import static base.DriverFactory.getDriver;

public class GridLoginTests extends BaseTests {
    @BeforeTest
    @Parameters("myBrowser")
    public void setup(String myBrowser) throws MalformedURLException {
       // createDriverGrid(myBrowser);
    }

    @Test(priority = 1, description = "Testa login com sucesso Utilizando Selenium Grid")
    public void Test_LoginSeleniumGrid() throws InterruptedException{
        Assert.assertTrue(getDriver().getTitle().contains("MantisBT"));
        new LoginPage().preencherUsername("administrator");
        new LoginPage().clicarBotaoLogin();
        new LoginPage().preencherSenha("duarte");
        new LoginPage().clicarBotaoLogin();
        System.out.print("titulo é = "+getDriver().getTitle());
        Assert.assertTrue(getDriver().getTitle().contains("- MantisBT"));
    }
}
