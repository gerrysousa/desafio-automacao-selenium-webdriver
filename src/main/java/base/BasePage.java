package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constantes;

import java.util.concurrent.TimeUnit;

import static base.DriverFactory.getDriver;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;
import static utils.Constantes.urlBase;

public class BasePage {
    private static ExtentTest log;
    private static WebDriverWait wait;

    public BasePage() {
        this.log = BaseTests.log;
        wait =  new WebDriverWait(getDriver(), 5);
        PageFactory.initElements(getDriver(), this);
    }

    public void escrever(WebElement element, String texto) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            log.info("Ação: '" + metodoChamada + "' com o valor: '"+texto+"'");
            wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
            element.sendKeys(texto);
        }
        catch (Exception e){
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
            try {
                // log.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.captureScreen()).build());
                log.error(e.toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void clicar(By by) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            log.info("Ação: '" + metodoChamada + "'");
            getDriver().findElement(by).click();
        }catch (Throwable e) {
            //log que não conseguiu clicar
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
        }
    }

    public void clicar(WebElement element) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            log.info("Ação: '"+ metodoChamada+"'");
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
        catch (Throwable e) {
            //log que não conseguiu clicar
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
        }
    }

    public void clicarPorTexto(String texto) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            log.info("Ação: '" + metodoChamada + "'");
            getDriver().findElement(By.xpath("//*[text()='"+texto+"']")).click();
        }catch (Throwable e) {
            //log que não conseguiu clicar
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
        }
    }

    public void selecionarComboBox(WebElement element, String texto) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            log.info("Ação: '" + metodoChamada + "' com o valor: '"+texto+"'");
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            getDriver().findElement(By.xpath("//*[text()='"+texto+"']")).click();
        }
        catch (Throwable e) {
            //log que não conseguiu clicar
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
        }
    }

    public void navegarParaURL(String url) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            log.info("Ação: '" + metodoChamada + "' para o link: '"+url+"'");
            getDriver().get(url);
        }
        catch (Throwable e) {
            //log que não conseguiu clicar
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
        }
    }

    public void esperarElementoSerClicavel(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Constantes.defaultTimeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));}
        catch (Throwable ex){
            log.fail(ex.getMessage());
        }
    }

    public  void esperarElementoEstarVisivel(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Constantes.defaultTimeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Throwable ex){
            log.fail(ex.getMessage());
        }
    }

    public void esperarAteElementoSumir(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    element.isDisplayed();
                    return false;
                }
                catch (NoSuchElementException e ) {
                    return true;
                }
                catch (StaleElementReferenceException f) {
                    return true;
                }
            }
        };
        wait.until(elementIsDisplayed);
    }

    public void esperarElementoSerExibidoEClicavel(final WebElement element) {
        wait = new WebDriverWait(getDriver(), 10);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    element.isDisplayed();
                    element.isEnabled();
                    return true;
                }
                catch (NoSuchElementException e ) {
                    return false;
                }
                catch (StaleElementReferenceException f) {
                    return false;
                }
            }
        };
        wait.until(elementIsDisplayed);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


//===========Precisa ser Refatorado================

    public void clicar2(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarTexto(String texto) {
        clicar2(By.xpath("//*[text()='"+texto+"']"));
    }

//    public void selecionarNoComboBox(WebElement element, String texto) {
//        try {
//           clicar(element);
//
//        }
//        catch (Throwable e) {
//            //log que não conseguiu escrever
//
//        }
//        return  "";
//    }


   /* public void clicarTexto(String texto) {
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
    }*/


}