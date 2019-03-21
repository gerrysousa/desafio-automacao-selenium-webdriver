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
	public void inicializaTeste(){		
		getDriver().get(getUrlBase());
		login = new LoginPage();		
	}
		
	@Test
	public void deveLogarComSucesso(){
		login.fazerLogin("administrator", "administrator");
		
		Assert.assertTrue(login.verificarSeLogouComSucesso());			
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
	public void deveValidarLoginComSenhaInvalida(){
		login.setUsername("administrator");
		login.botaoEntrar();
		login.setSenha("errada");
		login.botaoEntrar();
		
		Assert.assertTrue(login.verificarAlerta("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."));			
	}
}
