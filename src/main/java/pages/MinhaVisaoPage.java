package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MinhaVisaoPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(linkText = "Atribuídos a Mim (não resolvidos)")
    private WebElement linkAtribuidosAMim;

    @FindBy(linkText = "Não Atribuídos")
    private WebElement linkNaoAtribuidos;

    @FindBy(linkText = "Relatados por Mim")
    private WebElement linkRelatadosporMim;

    @FindBy(linkText = "Resolvidos")
    private WebElement linkResolvidos;

    @FindBy(linkText = "Modificados Recentemente (30 Dias)")
    private WebElement linkModificadosRecentemente;

    @FindBy(linkText = "Monitorados por Mim")
    private WebElement linkMonitoradosporMim;
    //Fim do mapeamento

    //Ações da pagina

    public boolean verificarSeAcessouMinhaVisao() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("Minha Visão - MantisBT");
        return existe;
    }

    public void acessarTarefasAtribuidasAMim() {
        clicar(linkAtribuidosAMim);
    }

    public void acessarTarefasNaoAtribuidas() {
        clicar(linkNaoAtribuidos);
    }

    public void acessarTarefasRelatadasporMim() {
        clicar(linkRelatadosporMim);
    }

    public void acessarTarefasResolvidas() {
        clicar(linkResolvidos);
    }

    public void acessarTarefasModificadasRecentemente() {
        clicar(linkModificadosRecentemente);
    }

    public void acessarTarefasMonitoradasPorMim() {
        clicar(linkMonitoradosporMim);
    }
    //Fim ações
}
