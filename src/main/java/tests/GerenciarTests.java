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
		
	
	@Test
	public void validarCampoNomeMarcadorObrigatorio() {
		gerenciar.acessarTabGerenciarMarcadores();
		gerenciar.clicarBotaoAddMarcador();
		//novoMarcador.setNomeMarcador("Marcador 02");
		novoMarcador.setDescricaoMarcador("Descricao 02");
		novoMarcador.clicarBotaoAddMarcador();
		
		Assert.assertEquals("Preencha este campo.", novoMarcador.validarCamposObrigatorio());
	}
	
	@Test
	public void atualizarNomeDoMarcador() {
		gerenciar.acessarTabGerenciarMarcadores();
		gerenciar.clicarNomeMarcador("Marcador 02");
		novoMarcador.clicarBotaoEditarMarcador();
		novoMarcador.setNomeMarcador("Marcador 02 Editado");
		novoMarcador.clicarBotaoAtualizarMarcador();
		
		Assert.assertTrue(gerenciar.existeProjetoComNome("Marcador 02 Editado"));
	}
	
	@Test
	public void deveApagarMarcador() {
		gerenciar.acessarTabGerenciarMarcadores();
		gerenciar.clicarNomeMarcador("tag 1");
		novoMarcador.clicarBotaoExcluirMarcador();
		
		Assert.assertTrue(gerenciar.existeProjetoComNome("Você tem certeza que quer apagar esse marcador?"));
		novoMarcador.clicarConfirmarExclusao();
		
		Assert.assertFalse(gerenciar.existeProjetoComNome("tag 1"));
	}
		
	@Test
	public void validarCampoNomeUsuarioObrigatorio() {
		gerenciar.acessarTabGerenciarUsuarios();
		gerenciar.clicarBotaoCriarNovaContaUsuario();
		//novoMarcador.setNomeMarcador("Marcador 02");
		novoUsuario.setNomeUsuario("Fulano User");
		novoUsuario.clicarBotaoAddUsuario();
		
		Assert.assertTrue(novoUsuario.validarCamposObrigatorio("Nomes de usuário podem conter apenas letras, números, espaços, hífens, pontos, sinais de mais e sublinhados."));		
	}
	
	@Test
	public void atualizarUsuario() {
		gerenciar.acessarTabGerenciarUsuarios();
		gerenciar.clicarNomeUsuario("Usuario Atualizador");
		novoUsuario.editarUserName("Usuario Editado");
		novoUsuario.clicarBotaoAtualizarUsuario();
		
		Assert.assertTrue(gerenciar.existeProjetoComNome("Operação realizada com sucesso."));
		
		gerenciar.acessarTabGerenciarUsuarios();
		Assert.assertTrue(gerenciar.existeProjetoComNome("Usuario Editado"));
			
	}
	
	/*===============================
	
	- deveAtualizarCategoriaComSucesso
	- deveApagarCategoria
	================================*/
	
	public void validarCampoNomeCategoriaObrigatorio() {
		gerenciar.acessarTabGerenciarProjetos();
		gerenciar.clicarBotaoAddCatergoria();
		
		Assert.assertTrue(gerenciar.existeProjetoComNome("Um campo necessário 'Categoria' estava vazio. Por favor, verifique novamente suas entradas."));		
	}
	
	@Test
	public void atualizarCategoria() {
		gerenciar.acessarTabGerenciarProjetos();
		Assert.assertTrue(gerenciar.existeProjetoComNome("cat02"));
		
		gerenciar.clicarBotaoEditarCategoria("cat02");
		gerenciar.editarCategoriaNome("Categoria 02 editada"); //proj-category-name
		gerenciar.clicarAtualizarCategoria();
		Assert.assertTrue(gerenciar.existeProjetoComNome("Operação realizada com sucesso."));
		
		gerenciar.acessarTabGerenciarProjetos();
		Assert.assertTrue(gerenciar.existeProjetoComNome("Categoria 02 editada"));
	}
	
	@Test
	public void apagarCategoria() {
		gerenciar.acessarTabGerenciarProjetos();
		Assert.assertTrue(gerenciar.existeProjetoComNome("xxxxxx"));
		
		gerenciar.clicarBotaoApagarCategoria("xxxxxx");
		gerenciar.clicarApagarCategoria();
		Assert.assertTrue(gerenciar.existeProjetoComNome("Operação realizada com sucesso."));
		
		gerenciar.acessarTabGerenciarProjetos();
		Assert.assertFalse(gerenciar.existeProjetoComNome("xxxxxx"));
	}
	
	@Test
	public void validarApagarCategoriaJaUtilizada() {
		gerenciar.acessarTabGerenciarProjetos();
		Assert.assertTrue(gerenciar.existeProjetoComNome("xxxxxx"));
		gerenciar.clicarBotaoApagarCategoria("xxxxxx");
		
		Assert.assertTrue(gerenciar.existeProjetoComNome("Categoria \"categoria1990\" não pode ser deletada, pois está associada com outro ou mais problemas."));
	}
	
	
}
