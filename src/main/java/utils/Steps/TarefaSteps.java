package utils.Steps;

import pages.*;

public class TarefaSteps {
    public void cadastrarTarefa(
            String categoria, String frequencia, String gravidade,String prioridade,
            String atribuidoA,String resumo,String descricao,String passos,String infoAdicional,
            String tag,String marcador,String visibilidade,boolean continuarRelatando) {

        new CriarTarefasPage().selecionarCategoria(categoria);
        new CriarTarefasPage().selecionarFrequencia(frequencia);
        new CriarTarefasPage().selecionarGravidade(gravidade);
        new CriarTarefasPage().selecionarPrioridade(prioridade);
        new CriarTarefasPage().selecionarAtribuirA(atribuidoA);
        new CriarTarefasPage().escreverResumoTarefa(resumo);
        new CriarTarefasPage().escreverDescricao(descricao);
        new CriarTarefasPage().escreverPassosParaReproduzir(passos);
        new CriarTarefasPage().escreverInfoAdicional(infoAdicional);
        new CriarTarefasPage().escreverMarcador(tag);
        new CriarTarefasPage().selecionarMarcador(marcador);
        new CriarTarefasPage().selecionarVisibilidade(visibilidade);

        new CriarTarefasPage().clicarBotaoNovaTarefa();
        // Assert.assertTrue(verificar se existe categoria na tabela);
    }

    public void editarTarefa(
            String categoria, String frequencia, String gravidade,String prioridade,
            String atribuidoA,String resumo,String descricao,String passos,String infoAdicional,
            String anotacao,boolean anotacaoPrivado) {

        new CriarTarefasPage().selecionarCategoria(categoria);
        new CriarTarefasPage().selecionarFrequencia(frequencia);
        new CriarTarefasPage().selecionarGravidade(gravidade);
        new CriarTarefasPage().selecionarPrioridade(prioridade);
        new CriarTarefasPage().selecionarAtribuirA(atribuidoA);
        new CriarTarefasPage().escreverResumoTarefa(resumo);
        new CriarTarefasPage().escreverDescricao(descricao);
        new CriarTarefasPage().escreverPassosParaReproduzir(passos);
        new CriarTarefasPage().editarInfoAdicional(infoAdicional);
        new CriarTarefasPage().escreverAnotacao(anotacao);
        //new CriarTarefasPage().clicarCheBoxPrivado(anotacaoPrivado);
        new CriarTarefasPage().clicarBtnAtualizarInformacoes();
    }

    public void atualizarStatusTarefa(String anotacao, String novoStatus) {
        new CriarTarefasPage().selecionarStatus(novoStatus);
        new CriarTarefasPage().clicarBtnAlterarStatus();
        new CriarTarefasPage().escreverAnotacao(anotacao);
        new CriarTarefasPage().clicarBtnStatusPrincipal();
        //new CriarTarefasPage().clicarBtnAdimitirTarefa();
    }

    public void fecharTarefa(String resolucao, String numeroDuplicado, String anotacao) {
        new CriarTarefasPage().selecionarResolucao(resolucao);
        new CriarTarefasPage().escreverAnotacao(anotacao);
        new CriarTarefasPage().clicarBtnStatusPrincipal();
    }
}
