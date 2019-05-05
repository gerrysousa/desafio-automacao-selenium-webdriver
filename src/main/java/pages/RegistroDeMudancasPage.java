package pages;

import base.BasePage;

public class RegistroDeMudancasPage extends BasePage {
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

    public boolean verificarSeAcessouRegistroMudanca() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("Registro de Mudanças - MantisBT");
        return existe;
    }
    //Fim ações


}
