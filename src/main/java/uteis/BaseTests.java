package uteis;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTests {

	public static String getUrlBase(){
		//return "http://192.168.99.100:8989";
		return "https://mantis.glaucia.base2.com.br";
	}
	
	@Rule
	public TestName testName = new TestName();	
	
	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		gerarScreenShot();
		DriverFactory.getDriver().close();
		DriverFactory.killDriver();
	}
	
	public void gerarScreenShot() {
		try {
			File imagem = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem,new File("target/screenShots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperar(long segundos) {
		try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String faker() {
		String aux;
	    //aux = java.time.LocalDateTime.now().toString();	       
	    //String faker = aux.substring(0, aux.length() - 3);
		int i = (int) new Date().getTime();		
		aux = Integer.toString(i); 
		
	    return aux;
	}	
}
