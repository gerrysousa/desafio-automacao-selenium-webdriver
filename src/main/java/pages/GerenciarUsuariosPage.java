package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarUsuariosPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(xpath = "//button[text()='Criar nova conta']")
    private WebElement btnAddNovoUsuario;

    @FindBy(xpath = "//div[@class='table-responsive']")
    private WebElement tabelaDeUsuarios;

    //Fim do mapeamento

    //Ações da pagina
    public void clicarBotaoAddNovaConta() {
        clicar(btnAddNovoUsuario);
    }

    public boolean procurarUsuarioNaTabela(String projeto) {
        return verificarSeExisteTextoNoElemento(tabelaDeUsuarios, projeto);
    }

    public void clicarNomeDoUsuario(String nomeUsuario) {
        By linkNomeUsuario = By.linkText(nomeUsuario);
        clicar(linkNomeUsuario);
    }

    //Fim ações
}
