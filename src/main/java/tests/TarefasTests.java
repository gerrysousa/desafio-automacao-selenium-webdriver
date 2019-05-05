package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Steps.*;


import java.lang.reflect.Method;

import static utils.Constantes.loginPadrao;
import static utils.Constantes.senhaPadrao;
import static utils.Utils.getDataHoraString;

public class TarefasTests extends BaseTests {

    @BeforeMethod
    public void beforeTeste(Method method, ITestContext context) {
        new LoginSteps().fazerLogin(loginPadrao,senhaPadrao);
        new MenuPage().clicaBtnCriarTarefas();
        Assert.assertTrue( new CriarTarefasPage().verificarSeAcessouCriarTarefa());
    }
    @Test
    public void adicionarTarefa() {
        String resumo = "Resumo "+getDataHoraString();
        /* "[Todos os Projetos] General","sempre","texto","alta","administrator","resumo da tarefa","Descricao da tarefa","passoss","info","tag 1","Marcador 01","publico"*/
        new TarefaSteps().cadastrarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumo,"Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);

        Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));
        new MenuPage().clicaBtnVerTarefas();
        Assert.assertTrue(new VerTodasTarefasPage().procurarTarefaNaTabela(resumo));
    }

    @Test
    public void validarCampoResumoObrigatorio() {
        new CriarTarefasPage().clicarBotaoNovaTarefa();

        Assert.assertEquals("Preencha este campo.", new CriarTarefasPage().validarCampoResumoObrigatorio());
    }

    @Test
    public void validarCampoDescricaoObrigatorio() {
        new CriarTarefasPage().escreverResumoTarefa("resumo da tarefa");
        new CriarTarefasPage().clicarBotaoNovaTarefa();
        Assert.assertEquals("Preencha este campo.", new CriarTarefasPage().validarCampoDescricaoObrigatorio());
    }

    @Test
    public void validarCampoCategoriaObrigatorio() {
        new TarefaSteps().cadastrarTarefa("(selecione)","sempre","texto","alta","administrator","resumo da tarefa","Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);

        Assert.assertTrue(new MenuPage().procurarMensagemAlertaErro("Um campo necessário 'category' estava vazio. Por favor, verifique novamente suas entradas."));
    }

    @Test
    public void atualizarResumoTarefa() {
        String resumo = "Resumo "+getDataHoraString();
        /* "[Todos os Projetos] General","sempre","texto","alta","administrator","resumo da tarefa","Descricao da tarefa","passoss","info","tag 1","Marcador 01","publico"*/
        new TarefaSteps().cadastrarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumo,"Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);
        Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));

        new VerTodasTarefasPage().clicarEditarTarefa(resumo);

        String resumoAtualizado = "Resumo Atualizado "+getDataHoraString();
        new TarefaSteps().editarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumoAtualizado,"Descricao da tarefa","passoss","info","anotacao", false);

        new MenuPage().clicaBtnVerTarefas();
        Assert.assertTrue(new VerTodasTarefasPage().procurarTarefaNaTabela(resumoAtualizado));
    }

    @Test
    public void atualizarStatusTarefaParaAdmitido() {
        String resumo = "Resumo "+getDataHoraString();
        new TarefaSteps().cadastrarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumo,"Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);
        Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));

        new VerTodasTarefasPage().clicarVerDetalhesTarefa(resumo);
        new TarefaSteps().atualizarStatusTarefa(resumo, "admitido");

        Assert.assertEquals("admitido", new CriarTarefasPage().obterStatusTarefa());
    }

    @Test
    public void monitorarUmaTarefa() {
        String resumo = "Resumo "+getDataHoraString();
        new TarefaSteps().cadastrarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumo,"Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);
        Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));

        new VerTodasTarefasPage().clicarVerDetalhesTarefa(resumo);
        new CriarTarefasPage().clicarBtnMonitorarTarefa();

        Assert.assertTrue( new CriarTarefasPage().verificarSeExisteTextoNaPagina("Parar de Monitorar"));
    }

    @Test
    public void marcarTarefaComoPegajosa() {
        String resumo = "Resumo "+getDataHoraString();
        new TarefaSteps().cadastrarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumo,"Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);
        Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));

        new VerTodasTarefasPage().clicarVerDetalhesTarefa(resumo);
        new CriarTarefasPage().clicarBtnMarcarTarefaComoPegajosa();

        Assert.assertTrue( new CriarTarefasPage().verificarSeExisteTextoNaPagina("Desmarcar como Pegajoso"));
    }

    @Test
    public void fecharTarefaResolucaoNaoSeraCorrigida() {
        String resumo = "Resumo "+getDataHoraString();
        new TarefaSteps().cadastrarTarefa("[Todos os Projetos] General","sempre","texto","alta","administrator",resumo,"Descricao da tarefa","passoss","info","tag03","marcador01","publico", false);
        Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));

        new VerTodasTarefasPage().clicarVerDetalhesTarefa(resumo);
        new CriarTarefasPage().clicarBtnFecharTarefa();
        new TarefaSteps().fecharTarefa("não será corrigido", "numeroDuplicado", "Anotacao");

        Assert.assertEquals("fechado", new CriarTarefasPage().obterStatusTarefa());
    }

    /*
	 - addUmNovoMarcadorATarefa
	 -atribuirTarefaParaUmUsuario
	 - clonarTarefa
	 - apagarTarefa
	 - moverTarefaDeProjeto
	 - fecharTarefa (status= Não será corrigido)
	 - resolverTarefa
	 - acesarImprimirTarefas
	 - salvarNovoFiltro

     */
}
