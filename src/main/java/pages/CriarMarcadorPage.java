package pages;

import org.openqa.selenium.By;

import uteis.BasePage;

public class CriarMarcadorPage extends BasePage{

	public void setNomeMarcador(String nomeMarcador) {
		escrever(By.id("tag-name"), nomeMarcador);		
	}

	public void setDescricaoMarcador(String descricao) {
		escrever(By.id("tag-description"), descricao);	
	}

	public void clicarBotaoAddMarcador() {
		clicar(By.name("config_set"));
	}
	

}
