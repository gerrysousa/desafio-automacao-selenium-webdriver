package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    //Mapeamento de elementoe

    @FindBy(xpath = "//span[text()=' Minha Visão ']")
    private WebElement btnMinhaVisao;

    @FindBy(xpath = "//span[text()=' Ver Tarefas ']")
    private WebElement btnVerTarefas;

    @FindBy(xpath = "//span[text()=' Criar Tarefa ']")
    private WebElement btnCriarTarefa;

    @FindBy(xpath = "//span[text()=' Registro de Mudanças ']")
    private WebElement btnRegistroDeMudancas;

    @FindBy(xpath = "//span[text()=' Planejamento ']")
    private WebElement btnPlanejamento;

    @FindBy(xpath = "//span[text()=' Resumo ']")
    private WebElement btnResumo;

    @FindBy(xpath = "//span[text()=' Gerenciar ']")
    private WebElement btnGerenciar;

    @FindBy(xpath = "//li[@id='dropdown_projects_menu']/a[@class='dropdown-toggle']")
    private WebElement lblProjetoSelecionado;

    @FindBy(xpath = "//span[@class='user-info']")
    private WebElement lblUsuarioLogado;

    @FindBy(xpath = "//div[@class='alert alert-success center']")
    private WebElement lblMensagemAlertaSucesso;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement lblMensagemAlertaErro;
    //Fim do mapeamento

    //Ações da pagina

    /* Menu Lateral */
    public void clicaBtnMinhaVisao() {
        clicar(btnMinhaVisao);
    }

    public void clicaBtnVerTarefas() {
        clicar(btnVerTarefas);
    }

    public void clicaBtnCriarTarefas() {
        clicar(btnCriarTarefa);
    }

    public void clicaBtnRegistroDeMudancas() {
        clicar(btnRegistroDeMudancas);
    }

    public void clicaBtnPlanejamento() {
        clicar(btnPlanejamento);
    }

    public void clicaBtnResumo() {
        clicar(btnResumo);
    }

    public void clicaBtnGerenciar() {
        clicar(btnGerenciar);
    }

    public String obterProjetoSelecionado() {
        //String teste = lblProjetoSelecionado.getText();
        String teste = obterTextoDoElemento(lblProjetoSelecionado);

        return teste;
    }

    public void selecionarProjetosNoDropdowd(String nomeProjeto) {
        clicar(lblProjetoSelecionado);
        By linkNomeProjeto = By.linkText(nomeProjeto);
        clicar(linkNomeProjeto);
    }

    public String obterUsuarioLogado() {
        return obterTextoDoElemento(lblUsuarioLogado);
    }

    public boolean procurarMensagemAlertaSucesso(String mensagem) {
        return verificarSeExisteTextoNoElemento(lblMensagemAlertaSucesso, mensagem);
    }

    public boolean procurarMensagemAlertaErro(String mensagem) {
        return verificarSeExisteTextoNoElemento(lblMensagemAlertaErro, mensagem);
    }
}
