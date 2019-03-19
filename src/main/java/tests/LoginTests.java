package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.LoginPage;
import uteis.BaseTests;
import static uteis.DriverFactory.getDriver;

public class LoginTests extends BaseTests{
	
	private LoginPage login;
		
	@Before
	public void inicializaTeste() {
		getDriver().get("https://mantis.glaucia.base2.com.br/login_page.php");
		login = new LoginPage();		
	}
	
	
	@Test
	public void deveLogarComSucesso() throws InterruptedException{
		login.fazerLogin("administrator", "duarte");
		
		Assert.assertTrue(login.verficarSeLogouComSucesso());			
	}
	
	@Test
	public void deveValidarLoginSemEmailESenha() throws InterruptedException{
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Email ou senha incorretos."));			
	}
	
	@Test
	public void deveValidarLoginSemEmail() throws InterruptedException{
		login.setSenha("ssssss");
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Email ou senha incorretos."));			
	}
	
	@Test
	public void deveValidarLoginSemSenha() throws InterruptedException{
		login.setUsername("avaliacao_qa_samba@sambatech.com.br");
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Email ou senha incorretos."));			
	}
	
	@Test
	public void deveValidarLoginComSenhaInvalida() throws InterruptedException{
		login.fazerLogin("avaliacao_qa_samba@sambatech.com.br", "errado");
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Email ou senha incorretos."));			
	}
}
