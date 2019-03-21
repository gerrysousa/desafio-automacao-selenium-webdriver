package pages;

import static uteis.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import uteis.BasePage;
import uteis.DriverFactory;

public class GerenciarPerfilGlobalPage extends BasePage{

	public void setNomePlataforma(String nomePlataforma) {
		DriverFactory.getDriver().findElement(By.id("platform")).clear();
		escrever(By.id("platform"), nomePlataforma);		
	}

	public void setSO(String nomeSO) {
		DriverFactory.getDriver().findElement(By.id("os")).clear();
		escrever(By.id("os"), nomeSO);		
	}

	public void setVersaoSO(String versaoSO) {
		DriverFactory.getDriver().findElement(By.id("os-version")).clear();
		escrever(By.id("os-version"), versaoSO);		
	}

	public void setNomeDescricao(String descricao) {
		DriverFactory.getDriver().findElement(By.id("description")).clear();
		escrever(By.id("description"), descricao);		
	}

	public void clicarAdicionarPerfil() {
		clicar(By.xpath("//input[@value='Adicionar Perfil']"));			
	}

	public boolean existeNome(String nomeProcurado) {
		boolean existe =  getDriver().getPageSource().contains(nomeProcurado);
		
		return existe;
	}

	public String validarCampoPlataformaObrigatorio() {
		WebElement element = DriverFactory.getDriver().findElement(By.id("platform"));
		String teste = element.getAttribute("validationMessage");
		
		return teste;
	}

	public String validarCampoSOObrigatorio() {
		WebElement element = DriverFactory.getDriver().findElement(By.id("os"));
		String teste = element.getAttribute("validationMessage");
		
		return teste;
	}

	public String validarCampoVersaoSOObrigatorio() {
		WebElement element = DriverFactory.getDriver().findElement(By.id("os-version"));
		String teste = element.getAttribute("validationMessage");
		
		return teste;
	}
	
	
	
}
