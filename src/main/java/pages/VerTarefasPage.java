package pages;

import static uteis.DriverFactory.getDriver;

import uteis.BasePage;

public class VerTarefasPage extends BasePage{
	
	public boolean verificarSeAcessouVerTarefasPage() {
		boolean existe = getDriver().getTitle().contains("Ver Tarefas - MantisBT");
		
		return	existe;
	}
}
