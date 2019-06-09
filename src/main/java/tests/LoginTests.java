package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.RecuperarSenhaPage;
import utils.Steps.LoginSteps;
import static base.DriverFactory.getDriver;
import static utils.Constantes.*;


public class LoginTests extends BaseTests {

    @Test (priority = 1, description = "Testa login com sucesso")
    public void Test_deveLogarComSucesso() throws InterruptedException{
        //Ações do Teste
        new LoginSteps().fazerLogin(loginPadrao,senhaPadrao);

        //Verificação do Teste
        Assert.assertTrue(new MenuPage().verificarSeExisteTextoNoTituloDaPagina("- MantisBT"));//"Minha Visão - MantisBT"
    }

    @Test (priority = 1, description = "Testa login sem colocar email ou  nome")
    public void Test_deveValidarLoginSemUsername() {
        //Ações do Teste
        new LoginPage().clicarBotaoLogin();

        //Verificação do Teste
        Assert.assertTrue(new LoginPage().verificarSeExisteTextoNaPagina(
                "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."));
    }

    @Test(priority = 1, description = "Testa login sem colocar a senha")
    public void Test_deveValidarLoginSemSenha() {
        //Ações do Teste
        new LoginPage().preencherUsername("administrator");
        new LoginPage().clicarBotaoLogin();

        new LoginPage().clicarBotaoLogin();

        //Verificação do Teste
        Assert.assertTrue(new LoginPage().verificarSeExisteTextoNaPagina(
                "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."));
    }

    @Test(priority = 1, description = "Testa login com senha errada")
    public void Test_deveValidarLoginComSenhaInvalida() {
        //Ações do Teste
        new LoginPage().preencherUsername("administrator");
        new LoginPage().clicarBotaoLogin();
        new LoginPage().preencherSenha("senhaErrada");
        new LoginPage().clicarBotaoLogin();

        //Verificação do Teste
        Assert.assertTrue(new LoginPage().verificarSeExisteTextoNaPagina(
                "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."));
    }

    @Test(priority = 1, description = "Testa login, verifica se acessou a pagina de recuperação de senha")
    public void Test_deveAcessarRecuperarSenha() {
        new LoginPage().preencherUsername(loginPadrao);
        new LoginPage().clicarBotaoLogin();
        new LoginPage().clicarLinkPerdeuSenha();

        Assert.assertTrue(new RecuperarSenhaPage().verificarSeExisteTextoNaPagina("Reajuste de Senha"));
    }


}
