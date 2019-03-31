package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import base.DriverFactory;

public class CriarProjetoPage extends BasePage{

	public void setNomeProjeto(String nomeProjeto) {
		//driver.find_element_by_id('foo').clear()
		DriverFactory.getDriver().findElement(By.id("project-name")).clear();
		escrever(By.id("project-name"), nomeProjeto);		
	}

	public void selecionaStatusProjeto(String status) {
		escrever(By.id("project-status"), status);
	}

	public void herdarCategoriasGlobais(boolean herdar) {
		// TODO contruir if e else
		
	}

	public void setDescricaoProjeto(String descricaoProjeto) {
		escrever(By.id("project-description"), descricaoProjeto);
	}

	public void clicarBotaoAddProjeto() {
		
		clicar(By.xpath("//*[@id=\"manage-project-create-form\"]/div/div[3]/input"));
	}

	public String validarCamposObrigatorio() {
		WebElement element = DriverFactory.getDriver().findElement(By.id("project-name"));
		String teste = element.getAttribute("validationMessage");
		
		return teste;
	}

	public void clicarBotaoEditarProjeto() {		
		clicar(By.xpath("//*[@id=\"manage-proj-update-form\"]/div/div[3]/input"));
	}
	
	
	
}
