package pages;

import static uteis.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import uteis.BasePage;
	
public class CriarTarefaPage extends BasePage{
		
	public boolean verificarSeAcessouCriarTarefa() {
		boolean existe = getDriver().getTitle().contains("Criar Tarefa - MantisBT");
			
		return	existe;
	}

	public void selecionarCategoria(String categoria) {
		Select dropdown = new Select(getDriver().findElement(By.id("category_id")));
		dropdown.selectByVisibleText(categoria);	
	}

	public void selecionarFrequencia(String frequencia) {
		Select dropdown = new Select(getDriver().findElement(By.id("reproducibility")));
		dropdown.selectByVisibleText(frequencia);		
	}

	public void selecionarGravidade(String gravidade) {
		Select dropdown = new Select(getDriver().findElement(By.id("severity")));
		dropdown.selectByVisibleText(gravidade);			
	}

	public void selecionarPrioridade(String prioridade) {
		Select dropdown = new Select(getDriver().findElement(By.id("priority")));
		dropdown.selectByVisibleText(prioridade);			
	}

	public void selecionarAtribuirA(String responsavel) {
		Select dropdown = new Select(getDriver().findElement(By.id("handler_id")));
		dropdown.selectByVisibleText(responsavel);			
	}

	public void setResumo(String resumo) {
		escrever(By.id("summary"), resumo);		
	}

	public void setDescricao(String decricao) {
		escrever(By.id("description"), decricao);			
	}

	public void setPassosParaReproduzir(String passos) {
		escrever(By.id("steps_to_reproduce"), passos);		
	}

	public void setInfoAdicional(String infoAdicional) {
		escrever(By.id("additional_info"), infoAdicional);	
		
	}

	public void setMarcador(String marcador) {
		escrever(By.id("tag_string"), marcador);	
		
	}

	public void selecionarMarcador(String selecionarMarcador) {
		Select dropdown = new Select(getDriver().findElement(By.id("tag_select")));
		dropdown.selectByVisibleText(selecionarMarcador);		
	}

	public void selecionarVisibilidade(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clicarBotaoNovaTarefa() {
		clicar(By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input"));	
	}
	
	
	
	
}
