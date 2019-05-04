package utils.Steps;

import pages.*;

import static utils.Utils.getDataHoraString;

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

    public void cadastrarUsuario(String nomeUsuario, String nomeRealUsuario, String email, String nivelAcesso, boolean habilitado, boolean protegido) {
        new MenuPage().clicaBtnGerenciar();
        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();
        new GerenciarUsuariosPage().clicarBotaoAddNovaConta();

        new GerenciarNovaContaUsuarioPage().escreverNomeUsuario(nomeUsuario);
        new GerenciarNovaContaUsuarioPage().escreverNomeRealUsuario(nomeRealUsuario);
        new GerenciarNovaContaUsuarioPage().escreverEmail(email);
        //new GerenciarNovaContaUsuarioPage().nivelDeAcesso(nivelAcesso);
//       new GerenciarNovaContaUsuarioPage().habilitado(habilitado);
//       new GerenciarNovaContaUsuarioPage().protegido(protegido);
        new GerenciarNovaContaUsuarioPage().clicarBotaoAddNovaConta();
    }

}
