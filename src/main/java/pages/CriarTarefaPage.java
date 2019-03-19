package pages;

import static uteis.DriverFactory.getDriver;

import uteis.BasePage;

public class CriarTarefaPage extends BasePage{
		
	public boolean verificarSeAcessouCriarTarefa() {
		boolean existe = getDriver().getTitle().contains("Criar Tarefa - MantisBT");
			
		return	existe;
	}
	
	
	
	
}
