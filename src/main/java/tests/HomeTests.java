package tests;

import static uteis.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.CriarTarefaPage;
import pages.GerenciarPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MinhaVisaoPage;
import pages.PlanejamentoPage;
import pages.RegistroMudancaPage;
import pages.ResumoPage;
import pages.VerTarefasPage;
import uteis.BaseTests;

public class HomeTests extends BaseTests{

	private HomePage home;
	private LoginPage login;
	private MinhaVisaoPage minhaVisao;
	private VerTarefasPage verTaredas;
	private CriarTarefaPage tarefa;
	private RegistroMudancaPage mudanca;
	private PlanejamentoPage planejamento;
	private ResumoPage resumo;
	private GerenciarPage gerenciar;	
	
	
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
	}	
		
	@Test
	public void acessarMinhaVisao() {
		home.clicaBotaoMinhaVisao();
		
		Assert.assertTrue(minhaVisao.verificarSeAcessouMinhaVisao());				
	}
	
	@Test
	public void acessarVerTarefas() {
		home.clicaBotaoVerTarefas();
		
		Assert.assertTrue(verTaredas.verificarSeAcessouVerTarefasPage());				
	}
	
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
	
	
	
}
