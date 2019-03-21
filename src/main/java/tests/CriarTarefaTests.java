package tests;

import static uteis.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.CriarMarcadorPage;
import pages.CriarProjetoPage;
import pages.CriarTarefaPage;
import pages.CriarUsuarioPage;
import pages.GerenciarPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MinhaVisaoPage;
import pages.PlanejamentoPage;
import pages.RegistroMudancaPage;
import pages.ResumoPage;
import pages.VerTarefasPage;
import uteis.BaseTests;

public class CriarTarefaTests extends BaseTests{
	private HomePage home;
	private LoginPage login;
	private MinhaVisaoPage minhaVisao;
	private VerTarefasPage verTaredas;
	private CriarTarefaPage tarefa;
	private RegistroMudancaPage mudanca;
	private PlanejamentoPage planejamento;
	private ResumoPage resumo;
	private GerenciarPage gerenciar;
	private CriarProjetoPage novoProjeto;
	private CriarUsuarioPage novoUsuario;
	private CriarMarcadorPage novoMarcador;
	private CriarTarefaPage novaTarefa;
	
	@Before
	public void inicializaTeste() {
		getDriver().get(getUrlBase());
		login = new LoginPage();		
		login.fazerLogin("administrator", "duarte");
		Assert.assertTrue(login.verificarSeLogouComSucesso());	
		
		home = new HomePage();
		tarefa = new CriarTarefaPage(); 
		minhaVisao = new MinhaVisaoPage();
		verTaredas = new VerTarefasPage();
		mudanca = new RegistroMudancaPage();
		planejamento = new PlanejamentoPage();
		resumo = new ResumoPage();
		gerenciar = new GerenciarPage();
		novoProjeto = new CriarProjetoPage();
		novoUsuario = new CriarUsuarioPage();
		novoMarcador = new CriarMarcadorPage();
		novaTarefa = new CriarTarefaPage();
		
		home.clicaBotaoCriarTarefas();
		Assert.assertTrue(novaTarefa.verificarSeAcessouCriarTarefa());	
	}	
		
	@Test
	public void adicionarTarefa() {
		novaTarefa.selecionarCategoria("[Todos os Projetos] General");
		novaTarefa.selecionarFrequencia("sempre");
		novaTarefa.selecionarGravidade("texto");
		novaTarefa.selecionarPrioridade("alta");
		novaTarefa.selecionarAtribuirA("administrator");
		novaTarefa.setResumo("resumo da tarefa");
		novaTarefa.setDescricao("Descricao da tarefa");
		novaTarefa.setPassosParaReproduzir("passoss");
		novaTarefa.setInfoAdicional("info");
		novaTarefa.setMarcador("tag 1");
		novaTarefa.selecionarMarcador("Marcador 01");
		//novaTarefa.selecionarVisibilidade("publico");
		
		novaTarefa.clicarBotaoNovaTarefa();
		//Assert.assertTrue(verificar se existe categoria na tabela);				
	}
	
}
