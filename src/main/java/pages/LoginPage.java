package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //Mapeamento de elementoe
    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtSenha;

    @FindBy(xpath = "//input[@value='Entrar']")
    private WebElement btnLogin;

    @FindBy(linkText = "Perdeu a sua senha?")
    private WebElement linkPerdeuSenha;


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

    //Fim ações
}
