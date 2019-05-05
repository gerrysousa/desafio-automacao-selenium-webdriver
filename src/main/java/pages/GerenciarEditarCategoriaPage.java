package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarEditarCategoriaPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(id = "proj-category-name")
    private WebElement txtCategoriaNome;

    @FindBy(id = "proj-category-assigned-to")
    private WebElement cbxAtribuidoPara;

    @FindBy(xpath = "//input[@value='Atualizar Categoria']")
    private WebElement btnAtualizarCategoria;

    @FindBy(xpath = "//input[@value='Apagar Categoria']")
    private WebElement btnApagarCategoria;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement lblMensagemAlerta;

    @FindBy(xpath = "//div[@class='alert alert-success center']")
    private WebElement lblMensagemAlertaSucesso;

    //Fim do mapeamento

    //Ações da pagina
    public void preencherCategoriaNome(String email) {
        escrever(txtCategoriaNome, email);
    }

    public void clicarBotaoAtualizarCategoria() {
        clicar(btnAtualizarCategoria);
    }

    public void clicarBotaoApagarCategoria() {
        clicar(btnApagarCategoria);
    }

    public boolean procurarMensagemAlerta(String mensagem) {
        return verificarSeExisteTextoNoElemento(lblMensagemAlerta, mensagem);
    }

    public boolean procurarMensagemAlertaSucesso(String mensagem) {
        return verificarSeExisteTextoNoElemento(lblMensagemAlertaSucesso, mensagem);
    }
    //Fim ações
}
