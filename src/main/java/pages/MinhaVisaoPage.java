package pages;

import static uteis.DriverFactory.getDriver;

import uteis.BasePage;

public class MinhaVisaoPage extends BasePage{

	public boolean verificarSeAcessouMinhaVisao() {
		boolean existe = getDriver().getTitle().contains("Minha Vis�o - MantisBT");
		
		return	existe;
	}
}
