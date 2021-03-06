package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class VerTodasTarefasPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(id = "handler_id_filter_target")
    private WebElement lblAtribuidoA;

    @FindBy(id = "reporter_id_filter_target")
    private WebElement lblRelatoPor;

    @FindBy(id = "show_status_filter_target")
    private WebElement lblStatus;

    @FindBy(id = "do_filter_by_last_updated_date_filter_target")
    private WebElement lblDatadeAtualizacao;

    @FindBy(id = "user_monitor_filter_target")
    private WebElement lblMonitoradoPor;

    //@FindBy(xpath = "//div[@class='table-responsive']")
    @FindBy(id ="buglist")
    private WebElement tabelaDeTarefas;

    //Fim do mapeamento

    //Ações da pagina

    public boolean verificarSeAcessouVerTarefasPage() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("Ver Tarefas - MantisBT");
        return existe;
    }

    public String obterFiltroAtribuidoA() {
        return obterTextoDoElemento(lblAtribuidoA);
    }

    public String obterFiltroRelatoPor() {
        return obterTextoDoElemento(lblRelatoPor);
    }

    public String obterFiltroStatus() {
        return obterTextoDoElemento(lblStatus);
    }

    public String obterFiltroDatadeAtualizacao() {
        return obterTextoDoElemento(lblDatadeAtualizacao);
    }

    public String obterFiltroMonitoradoPor() {
        return obterTextoDoElemento(lblMonitoradoPor);
    }

    public void clicarEditarTarefa(String resumo) {
        By editar = By.xpath("//td[text()='"+resumo+"']/preceding-sibling::td[@class='column-edit']/a");
        clicar(editar);
    }

    public boolean procurarTarefaNaTabela(String tarefa) {
        return verificarSeExisteTextoNoElemento(tabelaDeTarefas, tarefa);
    }

    public void clicarVerDetalhesTarefa(String resumo) {
        By editar = By.xpath("//td[text()='"+resumo+"']/preceding-sibling::td[@class='column-id']/a");
        clicar(editar);
    }




    //Fim ações

}
