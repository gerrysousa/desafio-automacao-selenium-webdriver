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
	public void deveValidarLoginSemUsername(){
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."));			
	}
	
	@Test
	public void deveValidarLoginSemSenha(){
		login.setUsername("administrator");
		login.botaoEntrar();
		
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."));			
	}
	
	
	@Test
	public void deveValidarLoginComSenhaInvalida() throws InterruptedException{
		login.setUsername("administrator");
		login.botaoEntrar();
		login.setSenha("errada");
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."));			
	}
}
