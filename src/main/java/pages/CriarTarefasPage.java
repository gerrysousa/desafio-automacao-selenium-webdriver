package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static base.DriverFactory.getDriver;

public class CriarTarefasPage extends BasePage {
    //Mapeamento de elementoe
    @FindBy(id = "category_id")
    private WebElement cbxCategoria;

    @FindBy(id = "reproducibility")
    private WebElement cbxFrequencia;

    @FindBy(id = "severity")
    private WebElement cbxGravidade;

    @FindBy(id = "priority")
    private WebElement cbxPrioridade;

    @FindBy(id = "profile_id")
    private WebElement cbxPerfilGlobal;

    @FindBy(id = "handler_id")
    private WebElement cbxAtribuirA;

    @FindBy(id = "summary")
    private WebElement txtResumo;

    @FindBy(id = "description")
    private WebElement txtDescricao;

    @FindBy(id = "steps_to_reproduce")
    private WebElement txtPassosParaReproduzir;

    @FindBy(id = "additional_info")
    private WebElement txtAdicionaInfo;

    @FindBy(id = "additional_information")
    private WebElement txtEditaInfo;

    @FindBy(id = "tag_string")
    private WebElement txtMarcadoEscrito;

    @FindBy(id = "tag_select")
    private WebElement cbxMarcadorSelecionar;

    @FindBy(xpath = "//input[@name='view_state' and @value='10']")
    private WebElement rbdPublico;

    @FindBy(xpath = "//input[@name='view_state' and @value='50']")
    private WebElement rbdPrivado;

    @FindBy(xpath = "//input[@value='Criar Nova Tarefa']")
    private WebElement btnCriarTarefa;

    @FindBy(xpath = "//input[@value='Atualizar Informação']")
    private WebElement btnAtualizarInformacoes;

    @FindBy(id = "bugnote_text")
    private WebElement txtAnotacao;

    @FindBy(id = "private")
    private WebElement ckbAnotacaoPrivado;

    @FindBy(xpath = "//select[@name='new_status']")
    private WebElement cbxStatus;

    @FindBy(xpath = "//input[@value='Alterar Status:']")
    private WebElement btnAlterarStatus;

    @FindBy(xpath = "//input[@value='Admitir Tarefa']")
    private WebElement btnAdmitirTarefa;

    @FindBy(xpath = "//td[@class='bug-status']")
    private WebElement lblStatusTarefa;

    @FindBy(xpath = "//input[@value='Monitorar']")
    private WebElement btnMonitorarTarefa;

    @FindBy(xpath = "//input[@value='Parar de Monitorar']")
    private WebElement btnPararDeMonitorarTarefa;

    @FindBy(xpath = "//input[@value='Marcar como Pegajoso']")
    private WebElement btnMarcarTarefaComoPegajosa;

    @FindBy(xpath = "//input[@value='Fechar']")
    private WebElement btnFecharTarefa;

    @FindBy(xpath = "//input[@class='btn btn-primary btn-white btn-round']")
    private WebElement btnStatusPrincipal;

    @FindBy(xpath = "//select[@name='resolution']")
    private WebElement cbxResolucao;

    @FindBy(xpath = "//input[@value='Apagar']")
    private WebElement btnApagarTarefa;

    @FindBy(xpath = "//input[@value='Aplicar']")
    private WebElement btnAplicarMarcador;

    @FindBy(xpath = "//td[@class='bug-tags']")
    private WebElement lblMarcadoresTarefa;

    //Fim do mapeamento

    //Ações da pagina

    public boolean verificarSeAcessouCriarTarefa() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("Criar Tarefa - MantisBT");
        return existe;
    }

    public void selecionarCategoria(String categoria) {
        selecionarComboBox(cbxCategoria, categoria);
    }

    public void selecionarFrequencia(String frequencia) {
        selecionarComboBox(cbxFrequencia, frequencia);
    }

    public void selecionarGravidade(String gravidade) {
        selecionarComboBox(cbxGravidade, gravidade);

    }

    public void selecionarPrioridade(String prioridade) {
        selecionarComboBox(cbxPrioridade, prioridade);
    }

    public void selecionarAtribuirA(String responsavel) {
        String test = responsavel+"'  and @value='1";//administrator'  and @value='1
        //*[text()='administrator'  and @value]
        //*[@value and text()='administrator']
        selecionarComboBox(cbxAtribuirA, test);
    }

    public void escreverResumoTarefa(String resumo) {
        escrever(txtResumo, resumo);
    }

    public void escreverDescricao(String decricao) {
        escrever(txtDescricao, decricao);
    }

    public void escreverPassosParaReproduzir(String passos) {
        escrever(txtPassosParaReproduzir, passos);
    }

    public void escreverInfoAdicional(String infoAdicional) {
        escrever(txtAdicionaInfo, infoAdicional);
    }

    public void escreverMarcador(String marcador) {
        escrever(txtMarcadoEscrito, marcador);
    }

    public void selecionarMarcador(String selecionarMarcador) {
        selecionarComboBox(cbxMarcadorSelecionar, selecionarMarcador);
    }

    public void clicarBotaoNovaTarefa() {
        clicar(btnCriarTarefa);
    }



	public void selecionarVisibilidade(String string) {
		// TODO Auto-generated method stub

	}

    public String validarCampoResumoObrigatorio() {
        String teste = txtResumo.getAttribute("validationMessage");
        return teste;
    }

    public String validarCampoDescricaoObrigatorio() {
        String teste = txtDescricao.getAttribute("validationMessage");
        return teste;
    }

    public void clicarBtnAtualizarInformacoes() {
        clicar(btnAtualizarInformacoes);
    }

    public void editarInfoAdicional(String infoAdicional) {
        escrever(txtEditaInfo, infoAdicional);
    }

    public void escreverAnotacao(String anotacao) {
        escrever(txtAnotacao, anotacao);
    }

    public void clicarCheBoxPrivado(boolean anotacaoPrivado) {
        clicar(ckbAnotacaoPrivado);
    }

    public void selecionarStatus(String novoStatus) {
        selecionarComboBox(cbxStatus, novoStatus);
    }

    public void clicarBtnAlterarStatus() {
        clicar(btnAlterarStatus);
    }

    public void clicarBtnAdimitirTarefa() {
        clicar(btnAdmitirTarefa);
    }

    public String obterStatusTarefa() {
        return obterTextoDoElemento(lblStatusTarefa);
    }

    public void clicarBtnMonitorarTarefa() {
        clicar(btnMonitorarTarefa);
    }

    public void clicarBtnMarcarTarefaComoPegajosa() {
        clicar(btnMarcarTarefaComoPegajosa);
    }

    public void clicarBtnFecharTarefa() {
        clicar(btnFecharTarefa);
    }

    public void clicarBtnStatusPrincipal() {
        clicar(btnStatusPrincipal);
    }

    public void selecionarResolucao(String resolucao) {
        selecionarComboBox(cbxResolucao, resolucao);
    }

    public void clicarBtnApagarTarefa() {
        clicar(btnApagarTarefa);
    }

    public void clicarBtnAplicarMarcador() {
        clicar(btnAplicarMarcador);
    }

    public boolean procuraMarcadoresDaTarefa(String marcador) {
        return verificarSeExisteTextoNoElemento(lblMarcadoresTarefa, marcador);
    }


    //Fim ações


}
