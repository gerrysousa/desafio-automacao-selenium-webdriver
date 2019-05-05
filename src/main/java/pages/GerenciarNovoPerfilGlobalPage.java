package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarNovoPerfilGlobalPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(id = "platform")
    private WebElement txtPlataforma;

    @FindBy(id = "os")
    private WebElement txtOs;

    @FindBy(id = "os-version")
    private WebElement txtOsVersão;

    @FindBy(id = "description")
    private WebElement txtDescricao;

    @FindBy(xpath = "//input[@value='Adicionar Perfil']")
    private WebElement btnAddPerfilGlobal;

    @FindBy(id = "select-profile")
    private WebElement cbxSelecionaPerfilGlobal;

    //Fim do mapeamento

    //Ações da pagina
    public void preencherPlataforma(String plataforma) {
        escrever(txtPlataforma, plataforma);
    }

    public void preencherOS(String OS) {
        escrever(txtOs, OS);
    }

    public void preencherOSVersao(String OSVersão) {
        escrever(txtOsVersão, OSVersão);
    }

    public void preencherDescricao(String descricao) {
        escrever(txtDescricao, descricao);
    }

    public void clicarAddPerfilGlobal() {
        clicar(btnAddPerfilGlobal);
    }

    public String validarCampoPlataformaObrigatorio() {
        String teste = txtPlataforma.getAttribute("validationMessage");

        return teste;
    }

    public String validarCampoSOObrigatorio() {
        String teste = txtOs.getAttribute("validationMessage");

        return teste;
    }

    public String validarCampoVersaoSOObrigatorio() {
        String teste = txtOsVersão.getAttribute("validationMessage");

        return teste;
    }

    public boolean procuraPerfilNoComboBox(String nomePerfil) {
        clicar(cbxSelecionaPerfilGlobal);
        return verificarSeExisteTextoNoElemento(cbxSelecionaPerfilGlobal, nomePerfil);
    }


    //Fim ações
}
