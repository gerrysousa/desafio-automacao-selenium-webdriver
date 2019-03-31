package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import base.DriverFactory;

public class CriarMarcadorPage extends BasePage {

	public void setNomeMarcador(String nomeMarcador) {
		DriverFactory.getDriver().findElement(By.id("tag-name")).clear();
		escrever(By.id("tag-name"), nomeMarcador);
	}

	public void setDescricaoMarcador(String descricao) {
		escrever(By.id("tag-description"), descricao);
	}

	public void clicarBotaoAddMarcador() {
		clicar(By.name("config_set"));
	}

	public String validarCamposObrigatorio() {
		WebElement element = DriverFactory.getDriver().findElement(By.id("tag-name"));
		String teste = element.getAttribute("validationMessage");

		return teste;
	}

	public void clicarBotaoEditarMarcador() {
		// clicar(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[3]/form[1]/fieldset/input[1]"));
		clicar(By.cssSelector(
				"#main-container > div.main-content > div.page-content > div > div > div.widget-box.widget-color-blue2 > div.widget-body > div > div:nth-child(3) > form:nth-child(1) > fieldset > input.btn.btn-primary.btn-white.btn-round"));
	}

	public void clicarBotaoAtualizarMarcador() {
		clicar(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/form/div/div[3]/input"));
	}

	public void clicarBotaoExcluirMarcador() {
		clicar(By.cssSelector(
				"#main-container > div.main-content > div.page-content > div > div > div.widget-box.widget-color-blue2 > div.widget-body > div > div:nth-child(3) > form:nth-child(2) > fieldset > input.btn.btn-primary.btn-white.btn-round"));
	}

	public void clicarConfirmarExclusao() {
		clicar(By.cssSelector(
				"#main-container > div.main-content > div.page-content > div > div > div.alert.alert-warning.center > form > input.btn.btn-primary.btn-white.btn-round"));

	}

}
