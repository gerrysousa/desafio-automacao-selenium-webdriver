package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import static base.DriverFactory.getDriver;

public class LoginTests extends BaseTests {

    private LoginPage login;


    @Test (priority = 1, description = "Testa login com sucesso")
    public void deveLogarComSucesso() throws InterruptedException{
        login = new LoginPage();
        login.preencherEmail("administrator");
        login.clicarBotaoLogin();
        login.preencherSenha("duarte");
        login.clicarBotaoLogin();

        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }

    @Test (priority = 1, description = "Testa login com falha")
    public void devefalhar() throws InterruptedException{
        login = new LoginPage();
        login.preencherEmail("administrator");
        login.clicarBotaoLogin();
        login.preencherSenha("errada");
        login.clicarBotaoLogin();

        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }

}
