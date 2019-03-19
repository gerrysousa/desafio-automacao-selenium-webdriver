package pages;

import static uteis.DriverFactory.getDriver;

import uteis.BasePage;

public class ResumoPage extends BasePage{
	
	public boolean verificarSeAcessouResumo() {
		boolean existe = getDriver().getTitle().contains("Resumo - MantisBT");
			
		return	existe;
	}
}
