package pages;

import org.openqa.selenium.By;
import uteis.BasePage;
import static uteis.DriverFactory.getDriver;

public class LoginPage extends BasePage{
	
	public void setUsername(String email) {
		escrever(By.id("username"), email);
	}

	public void setSenha(String senha) {
		escrever(By.id("password"), senha);
	}
	
	public void botaoEntrar() {
		clicar(By.xpath("//input[@value='Entrar']"));
	}

	public void fazerLogin(String username, String senha) {
		setUsername(username);
		botaoEntrar();
		setSenha(senha);
		botaoEntrar();
	}
	
	public boolean verificarSeLogouComSucesso() {
		boolean existe = getDriver().getPageSource().contains("Minha Visão");//("Minha Visão - MantisBT");
		
		return	existe;
	}
	
	public boolean verificarAlerta(String alerta){
		boolean existe = getDriver().getPageSource().contains(alerta);
		
		return	existe;
	}
}
