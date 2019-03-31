package pages;

import static base.DriverFactory.getDriver;

import org.openqa.selenium.By;

import base.BasePage;
import base.DriverFactory;

public class GerenciarPage extends BasePage {

	public boolean verificarSeAcessouGerenciar() {
		boolean existe = getDriver().getTitle().contains("Gerenciar - MantisBT");

		return existe;
	}

	// Tabs do gerenciar
	public void acessarTabGerenciarUsuarios() {
		getDriver().get(getUrlBase() + "/manage_user_page.php");
	}

	public void acessarTabGerenciarProjetos() {
		getDriver().get(getUrlBase() + "/manage_proj_page.php");
	}

	public void acessarTabGerenciarMarcadores() {
		clicar(By.linkText("Gerenciar Marcadores"));
		// getDriver().get(getUrlBase()+"/manage_tags_page.php");
	}

	public void acessarTabGerenciarCamposPersonalizados() {
		getDriver().get(getUrlBase() + "/manage_custom_field_page.php");
	}

	public void acessarTabGerenciarPerfisGlobais() {
		getDriver().get(getUrlBase() + "/manage_prof_menu_page.php");
	}

	public void acessarTabGerenciarConfiguracoes() {
		getDriver().get(getUrlBase() + "/adm_permissions_report.php");
	}
	// Fim das taps

	// region Menu Projeto
	public void clicarBotaoCriarProjeto() {
		getDriver().get(getUrlBase() + "/manage_proj_create_page.php");
	}

	public void clicarBotaoAddCatergoria() {
		clicar(By.xpath("//*[@id=\"categories\"]/div/div[2]/form/div/input[4]"));
		// clicarTexto("Adicionar Categoria");
	}

	public void clicarBotaoAddEditarCatergoria() {
		clicarTexto("Adicionar e editar Categoria");
	}

	public void setNomeCategoria(String nomeCategoria) {
		escrever(By.name("name"), nomeCategoria);
	}

	public void clicarBotaoCriarNovaContaUsuario() {
		getDriver().get(getUrlBase() + "/manage_user_create_page.php");
	}

	public void clicarBotaoAddMarcador() {
		getDriver().get(getUrlBase() + "/manage_tags_page.php#tagcreate");
	}

	public void clicarNomeProjeto(String nomeProjeto) {
		clicar(By.linkText(nomeProjeto));
	}

	public boolean existeProjetoComNome(String nomeProcurado) {
		boolean existe = getDriver().getPageSource().contains(nomeProcurado);

		return existe;
	}

	public void clicarNomeMarcador(String nomeMarcador) {
		clicar(By.linkText(nomeMarcador));
	}

	public void clicarNomeUsuario(String nomeUsuario) {
		clicar(By.linkText(nomeUsuario));

	}

	public void clicarBotaoEditarCategoria(String categoriaNome) {
		//// atualizar aqui
		//// //td[contains(text(),"cat01")]/following-sibling::td[2]//button[text()='Alterar']
		// clicar(By.xpath("//input[@value='20190321qQO_lPsH1rKye4KTBhidv0DSlt8ZVmIR']"));

		clicar(By.xpath(
				"//td[contains(text(),'" + categoriaNome + "')]/following-sibling::td[2]//button[text()='Alterar']"));
	}

	public void editarCategoriaNome(String novoNome) {
		DriverFactory.getDriver().findElement(By.id("proj-category-name")).clear();
		escrever(By.id("proj-category-name"), novoNome);
	}

	public void clicarAtualizarCategoria() {
		clicar(By.xpath("//input[@value='Atualizar Categoria']"));
	}

	public void clicarBotaoApagarCategoria(String categoriaNome) {
		clicar(By.xpath(
				"//td[contains(text(),'" + categoriaNome + "')]/following-sibling::td[2]//button[text()='Apagar']"));
	}

	public void clicarApagarCategoria() {
		clicar(By.xpath("//input[@value='Apagar Categoria']"));
	}

	// endregion
}
