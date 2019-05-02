package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.lang.reflect.Method;

import static base.DriverFactory.getDriver;

public class ExampleTests extends BaseTests {

    @Test(priority = 1, description = "Testa login com sucesso")
    public void deveLogarComSucesso(){
        //Ações do Teste
        new LoginPage().preencherUsername("administrator");
        new LoginPage().clicarBotaoLogin();
        new LoginPage().preencherSenha("duarte");
        new LoginPage().clicarBotaoLogin();

        //Verificação do Teste
        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }

    @Test (priority = 5, description = "Testa login com falha")
    public void devefalhar() throws InterruptedException{
        //Ações do Teste
        new LoginPage().preencherUsername("administrator");
        new LoginPage().clicarBotaoLogin();
        new LoginPage().preencherSenha("senhaErrada");
        new LoginPage().clicarBotaoLogin();

        //Verificação do Teste
        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }
}
