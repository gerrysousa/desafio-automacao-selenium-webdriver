package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarNovaContaUsuarioPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(id = "user-username")
    private WebElement txtNomeUsuario;

    @FindBy(id = "user-realname")
    private WebElement txtNomeRealUsuario;

    @FindBy(id = "email-field")
    private WebElement txtEmail;

    @FindBy(id = "user-access-level")
    private WebElement cbxNivelAcesso;

    @FindBy(id = "user-enabled")
    private WebElement ckbHabilitado;

    @FindBy(id = "user-protected")
    private WebElement ckbProtegido;

    @FindBy(xpath = "//input[@value='Criar Usuário']")
    private WebElement btnCriarUsuario;

    //Fim do mapeamento

    //Ações da pagina
    public void clicarBotaoAddNovaConta() {
        clicar(btnCriarUsuario);
    }

    public void escreverEmail(String email) {
        escrever(txtEmail, email);
    }

    public void escreverNomeUsuario(String nome) {
        escrever(txtNomeUsuario, nome);
    }

    public void escreverNomeRealUsuario(String nome) {
        escrever(txtNomeRealUsuario, nome);
    }





    //Fim ações
}
