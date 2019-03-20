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


public class GerenciarTests extends BaseTests{

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
	
	@Before
	public void inicializaTeste() {
		getDriver().get("http://192.168.99.100:8989");
		login = new LoginPage();		
		login.fazerLogin("administrator", "administrator");
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
		
		home.clicaBotaoGerenciar();		
		Assert.assertTrue(gerenciar.verificarSeAcessouGerenciar());	
	}	
		
	@Test
	public void adicionarCategoria() {
		gerenciar.acessarTabGerenciarProjetos();
		gerenciar.setNomeCategoria("Categoria 02");
		gerenciar.clicarBotaoAddCatergoria();
		
		//Assert.assertTrue(verificar se existe categoria na tabela);				
	}
	
	@Test
	public void adicionarProjeto() {
		gerenciar.acessarTabGerenciarProjetos();
		gerenciar.clicarBotaoCriarProjeto();
		novoProjeto.setNomeProjeto("Projeto 02");
		novoProjeto.selecionaStatusProjeto("Desenvolvimento");
		novoProjeto.herdarCategoriasGlobais(true);
		novoProjeto.setDescricaoProjeto("Descrição 01");		
		novoProjeto.clicarBotaoAddProjeto();
		
		//Assert.assertTrue(verificar se existe projeto na tabela);				
	}
	
	@Test
	public void adicionarUsuario() {
		gerenciar.acessarTabGerenciarUsuarios();
		gerenciar.clicarBotaoCriarNovaContaUsuario();
		novoUsuario.setUserName("user.nome");
		novoUsuario.setNomeUsuario("Fulano User");
		novoUsuario.setEmail("user@email.com");
		novoUsuario.nivelDeAcesso("relator");
		novoUsuario.habilitado(true);
		novoUsuario.protegido(false);		
		novoUsuario.clicarBotaoAddUsuario();
	
		//Assert.assertTrue(verificar se existe categoria na tabela);				
	}
	
	
	@Test
	public void adicionarMarcadores() {
		gerenciar.acessarTabGerenciarMarcadores();
		gerenciar.clicarBotaoAddMarcador();
		novoMarcador.setNomeMarcador("Marcador 02");
		novoMarcador.setDescricaoMarcador("Descricao 02");
		novoMarcador.clicarBotaoAddMarcador();
		
		//Assert.assertTrue(verificar se existe categoria na tabela);				
	}
	//===============================
		
	@Test
	public void validarCampoNomeProjetoObrigatorio() {
		gerenciar.acessarTabGerenciarProjetos();
		gerenciar.clicarBotaoCriarProjeto();
		novoProjeto.setDescricaoProjeto("Descrição 01");		
		novoProjeto.clicarBotaoAddProjeto();
		
		Assert.assertEquals("Preencha este campo.", novoProjeto.validarCamposObrigatorio());
	}
	
	@Test
	public void atualizarNomeDoProjeto() {
		gerenciar.acessarTabGerenciarProjetos();
		gerenciar.clicarNomeProjeto("Projeto 02");
		
		novoProjeto.setNomeProjeto("Projeto 02 Editado");
		novoProjeto.clicarBotaoEditarProjeto();
		
		Assert.assertTrue(gerenciar.existeProjetoComNome("Projeto 02 Editado"));
	}
	
	@Test
	public void mudarDeProjeto() {
		gerenciar.acessarTabGerenciarProjetos();
		Assert.assertTrue(home.projetoSelecionado("Projeto 01"));		
		home.selecionarDropDownProjetos("Projeto 02 Editado");
		
		Assert.assertTrue(home.projetoSelecionado("Projeto 02 Editado"));
	}
	

	
}
