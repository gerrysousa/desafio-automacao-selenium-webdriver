package pages;

import static uteis.DriverFactory.getDriver;

import uteis.BasePage;

public class RegistroMudancaPage extends BasePage{
	
	public boolean verificarSeAcessouRegistroMudanca() {
		boolean existe = getDriver().getTitle().contains("Registro de Mudanças - MantisBT");
			
		return	existe;
	}
}
