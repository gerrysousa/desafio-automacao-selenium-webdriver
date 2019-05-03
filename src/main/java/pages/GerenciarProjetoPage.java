package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarProjetoPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(name = "name")
    private WebElement txtCategoria;

    @FindBy(xpath = "//input[@value='Adicionar Categoria']")
    private WebElement btnAddCategoria;

    @FindBy(xpath = "//button[text()='Criar Novo Projeto']")
    private WebElement btnAddProjeto;

    @FindBy(xpath = "//div[2][@class='table-responsive']")
    private WebElement tabelaDeProjetos;

    @FindBy(id = "categories")
    private WebElement tabelaDeCategorias;
    //Fim do mapeamento

    //Ações da pagina
    public void escreverNomeCategoria(String nomeCategoria) {
        escrever(txtCategoria, nomeCategoria);
    }

    public void clicarBotaoAddCatergoria() {
        clicar(btnAddCategoria);
    }

    public void clicarBotaoAddProjeto() {
        clicar(btnAddProjeto);
    }

    public boolean procuraProjetoNaTabela(String projeto) {
        return verificarSeExisteTextoNoElemento(tabelaDeProjetos, projeto);
    }

    public boolean procuraCategoriaNaTabela(String categoria) {
        return verificarSeExisteTextoNoElemento(tabelaDeCategorias, categoria);
    }

    public void clicarNomeDoProjeto(String nomeProjeto) {
        By linkNomeProjeto = By.linkText(nomeProjeto);
        clicar(linkNomeProjeto);
    }
    //Fim das Acoes
}
