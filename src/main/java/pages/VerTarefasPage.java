package pages;

import static base.DriverFactory.getDriver;

import org.openqa.selenium.By;

import base.BasePage;

public class VerTarefasPage extends BasePage {

	public boolean verificarSeAcessouVerTarefasPage() {
		boolean existe = getDriver().getTitle().contains("Ver Tarefas - MantisBT");

		return existe;
	}

	public String verificaFiltroAtribuidoA() {
		// return
		// obterTexto(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a/span"));
		return obterTexto(By.id("handler_id_filter_target"));
	}

	public String verificaFiltroRelatoPor() {

		return obterTexto(By.id("reporter_id_filter_target"));
	}

	public String verificaFiltroStatus() {

		return obterTexto(By.id("show_status_filter_target"));
	}

	public String verificaFiltroPorAtualizacao() {

		return obterTexto(By.id("do_filter_by_last_updated_date_filter_target"));
	}

	public Object verificaFiltroMonitoradoPor() {

		return obterTexto(By.id("user_monitor_filter_target"));
	}
}
