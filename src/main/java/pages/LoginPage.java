package pages;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import static base.DriverFactory.getDriver;
import static utils.Constantes.loginPadrao;
import static utils.Constantes.senhaPadrao;

public class LoginPage extends BasePage {

    //Mapeamento de elementoe
    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtSenha;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnLogin;

    @FindBy(linkText = "Perdeu a sua senha?")
    private WebElement linkPerdeuSenha;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement msgAlerta;

    //Fim do mapeamento

    //Ações da pagina
    public void preencherUsername(String email) {
        escrever(txtUsername, email);
    }

    public void preencherSenha(String senha) {
        escrever(txtSenha, senha);
    }

    public void clicarBotaoLogin() {
        clicar(btnLogin);
    }

    public void clicarLinkPerdeuSenha() {
        clicar(linkPerdeuSenha);
    }

    public String retornaMensagemDoAlerta() {

        return "";
    }

    public void preencherLoginViaJavaScript(String username)
    {
//        IJavaScriptExecutor jse = (IJavaScriptExecutor) DriverFactory.INSTANCE;
//        jse.ExecuteScript("arguments[0].value='"+ ConfigurationManager.AppSettings["login"].ToString()+"';", InputLogin);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + username + "';",txtUsername);

    }


    public void preencherSenhaViaJavaScript(String senha)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + senha + "';",txtSenha);
    }

    public void clicarBotaoLoginViaJavaScript()
    {
       // wait.ElementToBeClickable(BotaoEntrar);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", btnLogin);

    }


    public boolean procuraMensagemAlerta(String alerta) {
        return verificarSeExisteTextoNoElemento(msgAlerta, alerta);
    }
    //Fim ações
}
