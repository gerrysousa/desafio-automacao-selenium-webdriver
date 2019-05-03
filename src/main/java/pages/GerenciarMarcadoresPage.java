package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarMarcadoresPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(xpath = "//input[@value='Criar Marcador']")
    private WebElement btnAddNovoMarcador;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-condensed table-hover']")
    private WebElement tabelaDeMarcadores;

    @FindBy(id = "tag-name")
    private WebElement txtNomeMarcador;

    @FindBy(id = "tag-description")
    private WebElement txtDescricaoMarcador;



    //Fim do mapeamento

    //Ações da pagina
    
    public void escreverNomeMarcador(String nome) {
        escrever(txtNomeMarcador, nome);
    }

    public void escreverDescricaoMarcador(String descricao) {
        escrever(txtDescricaoMarcador, descricao);
    }

    public void clicarBotaoAddMarcador() {
        clicar(btnAddNovoMarcador);
    }

    public boolean procuraMarcadorNaTabela(String projeto) {
        return verificarSeExisteTextoNoElemento(tabelaDeMarcadores, projeto);
    }

    public String validarCamposNomeObrigatorio() {
        String teste = txtNomeMarcador.getAttribute("validationMessage");

        return teste;
    }
}
