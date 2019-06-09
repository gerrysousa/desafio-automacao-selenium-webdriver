package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.*;

import static utils.Constantes.*;

public class JavaScriptTests extends BaseTests {

    @Test(priority = 1, description = "Testa login Com injeção de JavaScript")
    public void Test_deveValidarLoginSemSenha() {
        //Ações do Teste
        new LoginPage().preencherLoginViaJavaScript(loginPadrao);
        new LoginPage().clicarBotaoLoginViaJavaScript();
        new LoginPage().preencherSenhaViaJavaScript(senhaPadrao);
        new LoginPage().clicarBotaoLoginViaJavaScript();

        //Verificação do Teste
        Assert.assertTrue(new MenuPage().verificarSeExisteTextoNoTituloDaPagina("- MantisBT"));//"Minha Visão - MantisBT"
    }
}
