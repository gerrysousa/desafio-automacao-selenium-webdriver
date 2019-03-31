package pages;

import static base.DriverFactory.getDriver;

import base.BasePage;

public class RegistroMudancaPage extends BasePage {

	public boolean verificarSeAcessouRegistroMudanca() {
		boolean existe = getDriver().getTitle().contains("Registro de Mudan�as - MantisBT");

		return existe;
	}
}
