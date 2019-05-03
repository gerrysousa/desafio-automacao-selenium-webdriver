package utils.Steps;

import pages.*;

public class GerenciarSteps {
    public void cadastrarProjeto(String nomeProjeto, String descricao, String status, boolean herdarCategoria) {
        //Ações do Login
        new GerenciarNovoProjetoPage().escreverNomeProjeto(nomeProjeto);
        //new GerenciarNovoProjetoPage().selecionaStatusProjeto("Desenvolvimento");
        //novoProjeto.herdarCategoriasGlobais(true);
        new GerenciarNovoProjetoPage().escreverDescricaoProjeto(descricao);
        new GerenciarNovoProjetoPage().clicarBotaoAddProjeto();
    }

    public void atualizarProjeto(String nomeProjeto, String descricao, String status, boolean herdarCategoria) {
        //Ações do Login
        new GerenciarNovoProjetoPage().escreverNomeProjeto(nomeProjeto);
        //new GerenciarNovoProjetoPage().selecionaStatusProjeto("Desenvolvimento");
        //novoProjeto.herdarCategoriasGlobais(true);
        new GerenciarNovoProjetoPage().escreverDescricaoProjeto(descricao);
        new GerenciarNovoProjetoPage().clicarBotaoAtualizarProjeto();
    }
}
