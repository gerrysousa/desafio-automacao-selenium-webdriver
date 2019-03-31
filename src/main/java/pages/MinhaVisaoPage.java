package pages;

import static base.DriverFactory.getDriver;

import org.openqa.selenium.By;

import base.BasePage;

public class MinhaVisaoPage extends BasePage{

	public boolean verificarSeAcessouMinhaVisao() {
		boolean existe = getDriver().getTitle().contains("Minha Vis�o - MantisBT");
		
		return	existe;
	}

	public void acessarTarefasAtribuidasAMim() {
		clicar(By.linkText("Atribu�dos a Mim (n�o resolvidos)"));		
	}

	public void acessarTarefasNaoAtribuidas() {
		clicar(By.linkText("N�o Atribu�dos"));
	}

	public void acessarTarefasRelatadasPorMim() {
		clicar(By.linkText("Relatados por Mim"));
	}

	public void acessarTarefasResolvidas() {
		clicar(By.linkText("Resolvidos"));
	}

	public void acessarTarefasModificadasRecente() {
		clicar(By.linkText("Modificados Recentemente (30 Dias)"));
	}

	public void acessarTarefasMonitoradasPorMim() {
		clicar(By.linkText("Monitorados por Mim"));
	}
	
	
	
}
