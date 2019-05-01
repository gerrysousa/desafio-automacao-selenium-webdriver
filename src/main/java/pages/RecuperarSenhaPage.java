package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecuperarSenhaPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "email-field")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@value='Enviar']")
    private WebElement btnEnviar;
    //Fim do mapeamento

    //Ações da pagina
    public void preencherEmails(String email) {
        escrever(txtEmail, email);
    }

    public void preencherUsername(String username) {
        escrever(txtUsername, username);
    }

    public void clicarBotaoEnviar() {
        clicar(btnEnviar);
    }


    //Fim ações
}
