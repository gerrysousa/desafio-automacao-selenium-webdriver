package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarNovoProjetoPage extends BasePage {

    //Mapeamento de elementoe
    @FindBy(id = "project-name")
    private WebElement txtNomeProjeto;

    @FindBy(id = "project-status")
    private WebElement cbxStatusProjeto;

    @FindBy(id = "project-description")
    private WebElement txtDescricao;

    @FindBy(xpath = "//input[@value='Adicionar projeto']")
    private WebElement btnAddProjeto;

    @FindBy(xpath = "//input[@value='Atualizar Projeto']")
    private WebElement btnAtualizarProjeto;
    //Fim do mapeamento

    //Ações da pagina


    public void escreverNomeProjeto(String nomeProjeto) {
        escrever(txtNomeProjeto, nomeProjeto);
    }

    public void selecionaStatusProjeto(String status) {
        escrever(cbxStatusProjeto, status);
    }

    public void herdarCategoriasGlobais(boolean herdar) {
        // TODO contruir if e else

    }

    public void escreverDescricaoProjeto(String descricaoProjeto) {
        escrever(txtDescricao, descricaoProjeto);
    }

    public void clicarBotaoAddProjeto() {
        clicar(btnAddProjeto);
    }

    public String validarCamposNomeObrigatorio() {
        String teste = txtNomeProjeto.getAttribute("validationMessage");

        return teste;
    }

    public void clicarBotaoAtualizarProjeto() {
        clicar(btnAtualizarProjeto);
    }
    /*

    public void clicarBotaoEditarProjeto() {
        clicar(By.xpath("//*[@id=\"manage-proj-update-form\"]/div/div[3]/input"));
    }

     */
}
