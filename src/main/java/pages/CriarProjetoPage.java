package pages;

import org.openqa.selenium.By;

import uteis.BasePage;

public class CriarProjetoPage extends BasePage{

	public void setNomeProjeto(String nomeProjeto) {
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

	
}
