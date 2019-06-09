package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CriarTarefasPage;
import pages.MenuPage;
import pages.VerTodasTarefasPage;
import utils.ConexaoDB.ConexaoBD;
import utils.ConexaoDB.MassasBD;
import utils.Steps.LoginSteps;
import utils.Steps.TarefaSteps;

import java.lang.reflect.Method;

import static utils.Constantes.loginPadrao;
import static utils.Constantes.senhaPadrao;
import static utils.Utils.getDataHoraString;

public class MassaBDTests extends BaseTests {
    @BeforeMethod
    public void beforeTeste(Method method, ITestContext context) {
        ConexaoBD.resetBD();
        MassasBD.criarNovoProjetoDB();
        MassasBD.criarNovasTarefasDB();

        new LoginSteps().fazerLogin(loginPadrao,senhaPadrao);
        new MenuPage().clicaBtnCriarTarefas();
    }
    @Test
    public void Test_adicionarTarefa() {
        String resumo = "Resumo Tarefa BD teste 1";
//        /* "[Todos os Projetos] General","sempre","texto","alta","administrator","resumo da tarefa","Descricao da tarefa","passoss","info","tag 1","Marcador 01","publico"*/
//        new TarefaSteps().cadastrarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumo,"Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);
//
//        Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));
        new MenuPage().clicaBtnVerTarefas();
        Assert.assertTrue(new VerTodasTarefasPage().procurarTarefaNaTabela(resumo));
    }
}
