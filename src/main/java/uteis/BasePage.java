package uteis;

import static uteis.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {

	public String getUrlBase(){
		//return "http://192.168.99.100:8989";
		return BaseTests.getUrlBase();
	}
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarTexto(valor);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");		
	}
	
		
	public String obterTituloAlerta() {
		return obterTexto(By.id("alertTitle"));
	}
	
	public String obterMensageAlerta() {
		return obterTexto(By.id("id/message"));
	}
	
	public void esperar(int num) throws InterruptedException {
		Thread.sleep(num);
	}
	

	
}