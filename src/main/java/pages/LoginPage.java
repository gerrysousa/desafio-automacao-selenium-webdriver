package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    @FindBy(id = "username")
    private WebElement txtEmail;

    @FindBy(id = "password")
    private WebElement txtSenha;

    @FindBy(xpath = "//input[@value='Entrar']")
    private WebElement btnLogin;



    public void preencherEmail(String email) {
        escrever(txtEmail, email);
    }

    public void preencherSenha(String senha) {
        escrever(txtSenha, senha);
    }

    public void clicarBotaoLogin() {
        clicar(btnLogin);
    }



//    public boolean verficarSeLogouComSucesso() {
//        clicar(By.id("mn-dashboard"));
//        boolean existe = getDriver().getPageSource().contains("Processo Seletivo");
//
//        return	existe;
//    }
//
//    public boolean verificarAlerta(String alerta){
//        boolean existe = getDriver().getPageSource().contains(alerta);
//
//        return	existe;
//    }
}
