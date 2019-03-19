package pages;

import org.openqa.selenium.By;

import uteis.BasePage;

public class CriarUsuarioPage extends BasePage{

	public void setUserName(String userName) {
		escrever(By.id("user-username"), userName);
		
	}

	public void setNomeUsuario(String nomeRealUsuario) {
		escrever(By.id("user-realname"), nomeRealUsuario);
		
	}
	
	public void setEmail(String email) {
		escrever(By.id("email-field"), email);		
	}
		
	public void nivelDeAcesso(String string) {
		// TODO estrutura IF e Else
		
	}

	public void habilitado(boolean b) {
		//  TODO estrutura IF e Else
		
	}

	public void protegido(boolean b) {
		// TODO  estrutura IF e Else
		
	}

	public void clicarBotaoAddUsuario() {
		clicar(By.xpath("//*[@id=\"manage-user-create-form\"]/div/div[3]/input"));
	}

}
