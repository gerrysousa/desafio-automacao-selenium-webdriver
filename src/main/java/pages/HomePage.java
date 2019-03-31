package pages;

import static base.DriverFactory.getDriver;

import org.openqa.selenium.By;

import base.BasePage;

public class HomePage extends BasePage {

	/* Menu Lateral */

	public void clicaBotaoMinhaVisao() {
		getDriver().get(getUrlBase() + "/my_view_page.php");
	}

	public void clicaBotaoVerTarefas() {
		getDriver().get(getUrlBase() + "/view_all_bug_page.php");
	}

	public void clicaBotaoCriarTarefas() {
		getDriver().get(getUrlBase() + "/bug_report_page.php");
	}

	public void clicaBotaoRegistroDeMudancas() {
		getDriver().get(getUrlBase() + "/changelog_page.php");
	}

	public void clicaBotaoPlanejamento() {
		getDriver().get(getUrlBase() + "/roadmap_page.php");
	}

	public void clicaBotaoResumo() {
		getDriver().get(getUrlBase() + "/summary_page.php");
	}

	public void clicaBotaoGerenciar() {
		getDriver().get(getUrlBase() + "/manage_overview_page.php");
		// clicar(By.cssSelector("#sidebar > ul > li:nth-child(7) > a > span"));
	}

	public String obterUsuarioLogado() {

		return obterTexto(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span"));
	}

	public boolean projetoSelecionado(String nomeProcurado) {
		boolean existe = getDriver().findElement(By.className("dropdown-toggle")).getText().contains(nomeProcurado); // getPageSource().contains(nomeProcurado);

		return existe;
	}

	public void selecionarDropDownProjetos(String nomeProjeto) {
		clicar(By.linkText(nomeProjeto));
	}

	/*
	 * Metodos public void clicaBotaoZZZ() { clicar(by); }
	 * 
	 * public void clicaBotaoNaoAtribuidos() { uteis.clicaBotao(BotaoNaoAtribuidos,
	 * uteis.RetornaNomeVariavel(() => BotaoNaoAtribuidos)); }
	 * 
	 * public void clicaBotaoRelatadosPorMim() {
	 * uteis.clicaBotao(BotaoRelatadosPorMim, uteis.RetornaNomeVariavel(() =>
	 * BotaoRelatadosPorMim)); }
	 * 
	 * public void clicaBotaoResolvidos() { uteis.clicaBotao(BotaoResolvidos,
	 * uteis.RetornaNomeVariavel(() => BotaoResolvidos)); }
	 * 
	 * public void clicaBotaoModificadosRecentemente() {
	 * uteis.clicaBotao(BotaoModificadosRecentemente, uteis.RetornaNomeVariavel(()
	 * => BotaoModificadosRecentemente)); }
	 * 
	 * public void clicaBotaoMonitoradosPorMim() {
	 * uteis.clicaBotao(BotaoMonitoradosPorMim, uteis.RetornaNomeVariavel(() =>
	 * BotaoMonitoradosPorMim)); }
	 * 
	 */

}
