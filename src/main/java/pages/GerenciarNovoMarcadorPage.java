package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarNovoMarcadorPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(xpath = "//input[@value='Atualizar Marcador']")
    private WebElement btnAtualizarMarcador;

    @FindBy(xpath = "//input[@value='Apagar Marcador']")
    private WebElement btnApagarMarcador;

    @FindBy(id = "tag-name")
    private WebElement txtNomeMarcador;

    @FindBy(id = "tag-description")
    private WebElement txtDescricaoMarcador;

    @FindBy(id = "tag-user-id")
    private WebElement cbxCriador;

    @FindBy(xpath = "//div[@class='alert alert-warning center']")
    private WebElement lblMensagemAlerta;
    //Fim do mapeamento

    //Ações da pagina

    public void clicarBotaoEditarMarcador() {
        clicar(btnAtualizarMarcador);
    }

    public void clicarBotaoApagarMarcador() {
        clicar(btnApagarMarcador);
    }

    public void escreverNomeMarcador(String nome) {
        escrever(txtNomeMarcador, nome);
    }

    public void escreverDescricaoMarcador(String descricao) {
        escrever(txtDescricaoMarcador, descricao);
    }

    public boolean procurarMensagemAlerta(String mensagem) {
        return verificarSeExisteTextoNoElemento(lblMensagemAlerta, mensagem);
    }
}
