package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarEditarContaUsuarioPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(id = "edit-username")
    private WebElement txtNomeUsuario;

    @FindBy(id = "edit-realname")
    private WebElement txtNomeRealUsuario;

    @FindBy(id = "email-field")
    private WebElement txtEmail;

    @FindBy(id = "user-access-level")
    private WebElement cbxNivelAcesso;

    @FindBy(id = "user-enabled")
    private WebElement ckbHabilitado;

    @FindBy(id = "user-protected")
    private WebElement ckbProtegido;

   @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement lblMensagemAlertaUsario;

    @FindBy(xpath = "//input[@value='Atualizar Usuário']")
    private WebElement btnAtualizarUsuario;

    //Fim do mapeamento

    //Ações da pagina

    public void escreverEmail(String email) {
        escrever(txtEmail, email);
    }

    public void escreverNomeUsuario(String nome) {
        escrever(txtNomeUsuario, nome);
    }

    public void escreverNomeRealUsuario(String nome) {
        escrever(txtNomeRealUsuario, nome);
    }

    public String validarCamposNomeObrigatorio() {
        String teste = lblMensagemAlertaUsario.getText();//.getAttribute("validationMessage");

        return teste;
    }

    public boolean procurarMensagemAlerta(String mensagem) {
        return verificarSeExisteTextoNoElemento(lblMensagemAlertaUsario, mensagem);
    }

    public void clicarBotaoAtualizarConta() {
        clicar(btnAtualizarUsuario);
    }

}
