package pages;

import static uteis.DriverFactory.getDriver;

import uteis.BasePage;

public class PlanejamentoPage extends BasePage{
	
	public boolean verificarSeAcessouPlanejamento() {
		boolean existe = getDriver().getTitle().contains("Planejamento - MantisBT");
		
		return	existe;
	}
}
