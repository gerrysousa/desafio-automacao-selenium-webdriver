package pages;

import static uteis.DriverFactory.getDriver;

import org.openqa.selenium.By;

import uteis.BasePage;

public class GerenciarPage extends BasePage{
	
	public boolean verificarSeAcessouGerenciar() {
		boolean existe = getDriver().getTitle().contains("Gerenciar - MantisBT");
		
		return	existe;
	}
	
	
	// Tabs do gerenciar
	public void acessarTabGerenciarUsuarios() { 
		getDriver().get(getUrlBase()+"/manage_user_page.php");
	}
	
	public void acessarTabGerenciarProjetos() { 
		getDriver().get(getUrlBase()+"/manage_proj_page.php");
	}
	
	public void acessarTabGerenciarMarcadores() { 
		clicar(By.linkText("Gerenciar Marcadores"));
		//getDriver().get(getUrlBase()+"/manage_tags_page.php");
	}
	
	public void acessarTabGerenciarCamposPersonalizados() { 
		getDriver().get(getUrlBase()+"/manage_custom_field_page.php");
	}
	
	public void acessarTabGerenciarPerfisGlobais() { 
		getDriver().get(getUrlBase()+"/manage_prof_menu_page.php");
	}
	
	public void acessarTabGerenciarConfiguracoes() { 
		getDriver().get(getUrlBase()+"/adm_permissions_report.php");
	}
	//Fim das taps
	
	
	//region Menu Projeto
	public void clicarBotaoCriarProjeto() { 
		getDriver().get(getUrlBase()+"/manage_proj_create_page.php");
	}
	
	public void clicarBotaoAddCatergoria() { 
		clicar(By.xpath("//*[@id=\"categories\"]/div/div[2]/form/div/input[4]"));
		//clicarTexto("Adicionar Categoria");
	}
	
	public void clicarBotaoAddEditarCatergoria() { 
		clicarTexto("Adicionar e editar Categoria");
	}

	public void setNomeCategoria(String nomeCategoria) {
		escrever(By.name("name"), nomeCategoria);
	}

	public void clicarBotaoCriarNovaContaUsuario() {
		getDriver().get(getUrlBase()+"/manage_user_create_page.php");
	}


	public void clicarBotaoAddMarcador() {
		getDriver().get(getUrlBase()+"/manage_tags_page.php#tagcreate");	
	}


	public void clicarNomeProjeto(String nomeProjeto) {
		clicar(By.linkText(nomeProjeto));		
	}


	public boolean existeProjetoComNome(String nomeProcurado) {
		boolean existe =  getDriver().getPageSource().contains(nomeProcurado);
		
		return existe;
	}

	public void clicarNomeMarcador(String nomeMarcador) {
		clicar(By.linkText(nomeMarcador));		
	}

	public void clicarNomeUsuario(String nomeUsuario) {
		clicar(By.linkText(nomeUsuario));	
		
	}
	
	
	
	
	
	
	
	//endregion
}
