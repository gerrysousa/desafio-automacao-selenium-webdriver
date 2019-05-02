package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GerenciarVisaoGeralPage extends BasePage {

    //Mapeamento de elementoe
    @FindBy(linkText = "Gerenciar Projetos")
    private WebElement tabGerenciarProjetos;

    @FindBy(linkText = "Gerenciar Usuários")
    private WebElement tabGerenciarUsuarios;

    @FindBy(linkText = "Gerenciar Marcadores")
    private WebElement tabGerenciarMarcadores;

    @FindBy(linkText = "Gerenciar Campos Personalizados")
    private WebElement tabGerenciarCamposPersonalizados;

    @FindBy(linkText = "Gerenciar Perfís Globais")
    private WebElement tabGerenciarPerfisGlobais;

    @FindBy(linkText = "Gerenciar Plugins")
    private WebElement tabGerenciarPlugins;

    @FindBy(linkText = "Gerenciar Configuração")
    private WebElement tabGerenciarConfiguracao;


    //Fim do mapeamento

    //Ações da pagina
    public void clicarTabGerenciarUsuarios () {
        clicar(tabGerenciarUsuarios);
    }

    public void clicarTabGerenciarProjetos() {
        clicar(tabGerenciarProjetos);
    }

    public void clicarTabGerenciarMarcadores () {
        clicar(tabGerenciarMarcadores );
    }
    public void clicarTabGerenciarCamposPersonalizados () {
        clicar(tabGerenciarCamposPersonalizados);
    }
    public void clicarTabGerenciarPerfisGlobais () {
        clicar(tabGerenciarPerfisGlobais);
    }
    public void clicarTabGerenciarPlugins () {
        clicar(tabGerenciarPlugins);
    }
    public void clicarTabGerenciarConfiguracao () {
        clicar(tabGerenciarConfiguracao);
    }



    public boolean verificarSeAcessouGerenciarVisaoGeralPage() {
        boolean existe = verificarSeExisteTextoNoTituloDaPagina("Gerenciar - MantisBT");//getDriver().getTitle().contains("Gerenciar - MantisBT");

        return existe;
    }
}
