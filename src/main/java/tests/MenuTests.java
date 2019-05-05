package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Steps.*;
import java.lang.reflect.Method;
import static utils.Constantes.*;
import static utils.Utils.*;

public class MenuTests extends BaseTests {
    @BeforeMethod
    public void beforeTeste(Method method, ITestContext context) {
        new LoginSteps().fazerLogin(loginPadrao,senhaPadrao);
    }


    @Test
    public void acessarMinhaVisao() {
        new MenuPage().clicaBtnMinhaVisao();

        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
    }

    @Test
    public void acessarVerTarefas() {
        new MenuPage().clicaBtnVerTarefas();

        Assert.assertTrue(new VerTodasTarefasPage().verificarSeAcessouVerTarefasPage());
    }


  /*
    private HomePage home;
    private LoginPage login;
    private MinhaVisaoPage minhaVisao;
    private VerTarefasPage verTarefas;
    private CriarTarefaPage tarefa;
    private RegistroMudancaPage mudanca;
    private PlanejamentoPage planejamento;
    private ResumoPage resumo;
    private GerenciarPage gerenciar;


    @Test
    public void acessarCriarTarefas() {
        home.clicaBotaoCriarTarefas();

        Assert.assertTrue(tarefa.verificarSeAcessouCriarTarefa());
    }

    @Test
    public void acessarRegistroMudanca() {
        home.clicaBotaoRegistroDeMudancas();

        Assert.assertTrue(mudanca.verificarSeAcessouRegistroMudanca());
    }

    @Test
    public void acessarPlanejamento() {
        home.clicaBotaoPlanejamento();

        Assert.assertTrue(planejamento.verificarSeAcessouPlanejamento());
    }

    @Test
    public void acessarResumo() {
        home.clicaBotaoResumo();

        Assert.assertTrue(resumo.verificarSeAcessouResumo());
    }

    @Test
    public void acessarGerenciar() {
        home.clicaBotaoGerenciar();

        Assert.assertTrue(gerenciar.verificarSeAcessouGerenciar());
    }

    @Test
    public void acessarTarefasAtribuidasAMim() {
        home.clicaBotaoMinhaVisao();
        Assert.assertTrue(minhaVisao.verificarSeAcessouMinhaVisao());
        minhaVisao.acessarTarefasAtribuidasAMim();

        Assert.assertEquals(home.obterUsuarioLogado(), verTarefas.verificaFiltroAtribuidoA());
    }

    @Test
    public void acessarTarefasNaoAtribuidas() {
        home.clicaBotaoMinhaVisao();
        Assert.assertTrue(verTarefas.verificarSeAcessouVerTarefasPage());
        minhaVisao.acessarTarefasNaoAtribuidas();

        Assert.assertEquals("nenhum", verTarefas.verificaFiltroAtribuidoA());
    }

    @Test
    public void acessarTarefasRelatadasPorMim() {
        home.clicaBotaoMinhaVisao();
        Assert.assertTrue(minhaVisao.verificarSeAcessouMinhaVisao());
        minhaVisao.acessarTarefasRelatadasPorMim();

        Assert.assertEquals(home.obterUsuarioLogado(), verTarefas.verificaFiltroRelatoPor());
    }

    @Test
    public void acessarTarefasResolvidas() {
        home.clicaBotaoMinhaVisao();
        Assert.assertTrue(minhaVisao.verificarSeAcessouMinhaVisao());
        minhaVisao.acessarTarefasResolvidas();

        Assert.assertEquals("resolvido", verTarefas.verificaFiltroStatus());
    }

    @Test
    public void acessarTarefasModificadasRecente() {
        home.clicaBotaoMinhaVisao();
        Assert.assertTrue(minhaVisao.verificarSeAcessouMinhaVisao());
        minhaVisao.acessarTarefasModificadasRecente();

        Assert.assertNotEquals("Não", verTarefas.verificaFiltroPorAtualizacao());
    }

    @Test
    public void acessarTarefasMonitoradasPorMim() {
        home.clicaBotaoMinhaVisao();
        Assert.assertTrue(minhaVisao.verificarSeAcessouMinhaVisao());
        minhaVisao.acessarTarefasMonitoradasPorMim();

        Assert.assertEquals(home.obterUsuarioLogado(), verTarefas.verificaFiltroMonitoradoPor());
    }

   */
}
