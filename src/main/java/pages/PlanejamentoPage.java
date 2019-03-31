package pages;

import static base.DriverFactory.getDriver;

import base.BasePage;

public class PlanejamentoPage extends BasePage {

	public boolean verificarSeAcessouPlanejamento() {
		boolean existe = getDriver().getTitle().contains("Planejamento - MantisBT");

		return existe;
	}
}
