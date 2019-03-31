package pages;

import static base.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import base.DriverFactory;

public class CriarUsuarioPage extends BasePage {

	public void setUserName(String userName) {
		DriverFactory.getDriver().findElement(By.id("user-username")).clear();
		escrever(By.id("user-username"), userName);

	}

	public void setNomeUsuario(String nomeRealUsuario) {
		DriverFactory.getDriver().findElement(By.id("user-realname")).clear();
		escrever(By.id("user-realname"), nomeRealUsuario);

	}

	public void setEmail(String email) {
		DriverFactory.getDriver().findElement(By.id("email-field")).clear();
		escrever(By.id("email-field"), email);
	}

	public void nivelDeAcesso(String string) {
		// TODO estrutura IF e Else

	}

	public void habilitado(boolean b) {
		// TODO estrutura IF e Else

	}

	public void protegido(boolean b) {
		// TODO estrutura IF e Else

	}

	public void clicarBotaoAddUsuario() {
		clicar(By.xpath("//*[@id=\"manage-user-create-form\"]/div/div[3]/input"));
	}

	public boolean validarCamposObrigatorio(String nomeProcurado) {
		boolean existe = getDriver().getPageSource().contains(nomeProcurado);
		return existe;
	}

	public void clicarBotaoAtualizarUsuario() {
		clicar(By.xpath("//*[@id=\"edit-user-form\"]/div/div[2]/div[2]/input"));
	}

	public void editarUserName(String novoNome) {
		DriverFactory.getDriver().findElement(By.id("edit-username")).clear();
		escrever(By.id("edit-username"), novoNome);
	}

}
