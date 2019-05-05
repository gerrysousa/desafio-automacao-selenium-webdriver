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

    @Test
    public void acessarCriarTarefas() {
        new MenuPage().clicaBtnCriarTarefas();

        Assert.assertTrue(new CriarTarefasPage().verificarSeAcessouCriarTarefa());
    }

    @Test
    public void acessarRegistroMudanca() {
        new MenuPage().clicaBtnRegistroDeMudancas();

        Assert.assertTrue(new RegistroDeMudancasPage().verificarSeAcessouRegistroMudanca());
    }

    @Test
    public void acessarPlanejamento() {
        new MenuPage().clicaBtnPlanejamento();

        Assert.assertTrue(new PlanejamentoPage().verificarSeAcessouPlanejamento());
    }

    @Test
    public void acessarResumo() {
        new MenuPage().clicaBtnResumo();

        Assert.assertTrue(new ResumoPage().verificarSeAcessouResumo());
    }

    @Test
    public void acessarGerenciar() {
        new MenuPage().clicaBtnGerenciar();

        Assert.assertTrue(new GerenciarVisaoGeralPage().verificarSeAcessouGerenciarVisaoGeralPage());
    }

    @Test
    public void acessarTarefasAtribuidasAMim() {
        new MenuPage().clicaBtnMinhaVisao();
        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
        new MinhaVisaoPage().acessarTarefasAtribuidasAMim();

        Assert.assertEquals(new MenuPage().obterUsuarioLogado(), new VerTodasTarefasPage().obterFiltroAtribuidoA());
    }

    @Test
    public void acessarTarefasNaoAtribuidas() {
        new MenuPage().clicaBtnMinhaVisao();
        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
        //Assert.assertTrue(new VerTodasTarefasPage().verificarSeAcessouVerTarefasPage());
        new MinhaVisaoPage().acessarTarefasNaoAtribuidas();

        Assert.assertEquals("nenhum", new VerTodasTarefasPage().obterFiltroAtribuidoA());
    }

    @Test
    public void acessarTarefasRelatadasPorMim() {
        new MenuPage().clicaBtnMinhaVisao();
        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
        new MinhaVisaoPage().acessarTarefasRelatadasporMim();

        Assert.assertEquals(new MenuPage().obterUsuarioLogado(), new VerTodasTarefasPage().obterFiltroRelatoPor());
    }

    @Test
    public void acessarTarefasResolvidas() {
        new MenuPage().clicaBtnMinhaVisao();
        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
        new MinhaVisaoPage().acessarTarefasResolvidas();

        Assert.assertEquals("resolvido", new VerTodasTarefasPage().obterFiltroStatus());
    }

    @Test
    public void acessarTarefasModificadasRecente() {
        new MenuPage().clicaBtnMinhaVisao();
        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
        new MinhaVisaoPage().acessarTarefasModificadasRecentemente();

        Assert.assertNotEquals("Não", new VerTodasTarefasPage().obterFiltroDatadeAtualizacao());
    }

    @Test
    public void acessarTarefasMonitoradasPorMim() {
        new MenuPage().clicaBtnMinhaVisao();
        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
        new MinhaVisaoPage().acessarTarefasMonitoradasPorMim();

        Assert.assertEquals(new MenuPage().obterUsuarioLogado(), new VerTodasTarefasPage().obterFiltroMonitoradoPor());
    }


}
