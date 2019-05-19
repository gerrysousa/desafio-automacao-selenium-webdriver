package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.ExcelUtils;
import utils.Steps.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


import static base.DriverFactory.getDriver;
import static utils.Constantes.pathProjeto;


import static base.DriverFactory.getDriver;
import static utils.Constantes.*;

public class DataDrivenTests extends BaseTests {

    @DataProvider
    public Object[][] obterTarefas() throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray(pathProjeto+"/src/main/resources/TestData.xlsx","tarefas");
        return (testObjArray);
    }

    @BeforeMethod
    public void beforeTeste(Method method, ITestContext context) {
        new LoginSteps().fazerLogin(loginPadrao,senhaPadrao);
    }

    @Test(dataProvider="obterTarefas")
    public void Test_DataDrivenTestCadastrarTarefas(String categoria, String frequencia, String gravidade,String prioridade,
                                                    String atribuido,String resumoTarefa,String descricaoTarefa,String passosTarefa,String informacaoTarefa,
                                                    String tagTarefa,String marcadorTarefa,String visibilidade) throws IOException {
            new MenuPage().clicaBtnCriarTarefas();
            Assert.assertTrue( new CriarTarefasPage().verificarSeAcessouCriarTarefa());
            new TarefaSteps().cadastrarTarefa(categoria, frequencia, gravidade, prioridade, atribuido, resumoTarefa, descricaoTarefa, passosTarefa, informacaoTarefa, tagTarefa, marcadorTarefa, visibilidade, false);
            Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));
    }

    @Test(dataProvider="Authentication")
    public void Registration_data(String sUserName,String sPassword)throws  Exception{
  /*
        getDriver().findElement(By.xpath(".//*[@id='account']/a")).click();
        getDriver().findElement(By.id("log")).sendKeys(sUserName);
        System.out.println(sUserName);
        getDriver().findElement(By.id("pwd")).sendKeys(sPassword);
        System.out.println(sPassword);
        getDriver().findElement(By.id("login")).click();
        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
        getDriver().findElement(By.xpath(".//*[@id='account_logout']/a")).click();
    */
        new LoginPage().preencherUsername(sUserName);
        new LoginPage().clicarBotaoLogin();
        new LoginPage().preencherSenha(sPassword);
        new LoginPage().clicarBotaoLogin();

        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }

    @DataProvider
    public Object[][] Authentication() throws Exception{
        Object[][] testObjArray = ExcelUtils.getTableArray(pathProjeto+"/src/main/resources/TestDataL.xlsx","loginSheet");
        return (testObjArray);
    }

}
