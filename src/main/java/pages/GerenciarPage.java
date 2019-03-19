package pages;

import static uteis.DriverFactory.getDriver;

import uteis.BasePage;

public class GerenciarPage extends BasePage{
	
	public boolean verificarSeAcessouGerenciar() {
		boolean existe = getDriver().getTitle().contains("Gerenciar - MantisBT");
		
		return	existe;
	}
}
