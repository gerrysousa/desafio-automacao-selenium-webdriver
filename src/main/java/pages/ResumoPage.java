package pages;

import static base.DriverFactory.getDriver;

import base.BasePage;

public class ResumoPage extends BasePage {

	public boolean verificarSeAcessouResumo() {
		boolean existe = getDriver().getTitle().contains("Resumo - MantisBT");

		return existe;
	}
}
