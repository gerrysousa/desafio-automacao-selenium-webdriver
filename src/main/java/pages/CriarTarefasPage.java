package pages;

import base.BasePage;

public class CriarTarefasPage extends BasePage {
    //Mapeamento de elementoe
/*    @FindBy(id = "username")
    private WebElement txtEmail;

    @FindBy(id = "password")
    private WebElement txtSenha;

    @FindBy(xpath = "//input[@value='Entrar']")
    private WebElement btnLogin;

 */

    //Fim do mapeamento

    //Ações da pagina

    public boolean verificarSeAcessouCriarTarefa() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("Criar Tarefa - MantisBT");
        return existe;
    }
    //Fim ações


}
