package pages;

import base.BasePage;

public class VerTodasTarefasPage extends BasePage {
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

    public boolean verificarSeAcessouVerTarefasPage() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("Minha Visão - MantisBT");
        return existe;
    }
    //Fim ações

}
