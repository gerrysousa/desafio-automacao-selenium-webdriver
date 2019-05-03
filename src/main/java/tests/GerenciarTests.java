package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Steps.*;
import java.lang.reflect.Method;
import static utils.Constantes.*;
import static utils.Utils.*;


public class GerenciarTests extends BaseTests {

    @BeforeMethod
    public void beforeTeste(Method method, ITestContext context) {
        new LoginSteps().fazerLogin(loginPadrao,senhaPadrao);
        new MenuPage().clicaBtnGerenciar();
    }

    @Test
    public void deveAcessarGerenciar() {
        new MenuPage().clicaBtnGerenciar();

        Assert.assertTrue(new GerenciarVisaoGeralPage().verificarSeAcessouGerenciarVisaoGeralPage());
    }

    //=========================
    @Test
    public void adicionarCategoria() {
        String nomeCategotia = "Categoria "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();

        new GerenciarProjetoPage().escreverNomeCategoria(nomeCategotia);
        new GerenciarProjetoPage().clicarBotaoAddCatergoria();

        Assert.assertTrue(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategotia));
    }

  @Test
    public void adicionarProjeto() {
        String nomeProjeto = "Projeto "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().clicarBotaoAddProjeto();
        new GerenciarNovoProjetoPage().escreverNomeProjeto(nomeProjeto);
        //new GerenciarNovoProjetoPage().selecionaStatusProjeto("Desenvolvimento");
        //novoProjeto.herdarCategoriasGlobais(true);
        new GerenciarNovoProjetoPage().escreverDescricaoProjeto("Descrição do "+nomeProjeto);
        new GerenciarNovoProjetoPage().clicarBotaoAddProjeto();

         Assert.assertTrue(new GerenciarProjetoPage().procuraProjetoNaTabela(nomeProjeto)); //Operação realizada com sucesso.
    }

    @Test
    public void adicionarUsuario() {
        String aux = getDataHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();
        new GerenciarUsuariosPage().clicarBotaoAddNovaConta();

        new GerenciarNovaContaUsuarioPage().escreverNomeUsuario("user"+aux);
        new GerenciarNovaContaUsuarioPage().escreverNomeRealUsuario("Usuario "+aux);
        new GerenciarNovaContaUsuarioPage().escreverEmail("user"+aux+"@autotest.com");
        //new GerenciarNovaContaUsuarioPage().nivelDeAcesso("relator");
//       new GerenciarNovaContaUsuarioPage().habilitado(true);
//       new GerenciarNovaContaUsuarioPage().protegido(false);
        new GerenciarNovaContaUsuarioPage().clicarBotaoAddNovaConta();

        Assert.assertTrue(new GerenciarUsuariosPage().procurarUsuarioNaTabela("user"+aux));
    }

    @Test
    public void adicionarMarcadores() {
        String aux = getDataHoraString();
        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        new GerenciarMarcadoresPage().escreverNomeMarcador("Marcador "+aux);
        new GerenciarMarcadoresPage().escreverDescricaoMarcador("Descricao "+aux);
        new GerenciarMarcadoresPage().clicarBotaoAddMarcador();

        Assert.assertTrue(new GerenciarMarcadoresPage().procuraMarcadorNaTabela("Marcador "+aux));
    }

    @Test
    public void validarCampoNomeProjetoObrigatorio() {
        String nomeProjeto = "Projeto "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().clicarBotaoAddProjeto();
        //new GerenciarNovoProjetoPage().escreverNomeProjeto(nomeProjeto);
        new GerenciarNovoProjetoPage().escreverDescricaoProjeto("Descrição do "+nomeProjeto);
        new GerenciarNovoProjetoPage().clicarBotaoAddProjeto();

        Assert.assertEquals("Preencha este campo.", new GerenciarNovoProjetoPage().validarCamposNomeObrigatorio());
    }

    @Test
    public void atualizarNomeDoProjeto() {
        String nomeProjeto = "Projeto "+getHoraString();
        String descricao = "Descrição do "+nomeProjeto;
        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().clicarBotaoAddProjeto();
        new GerenciarSteps().cadastrarProjeto(nomeProjeto, descricao, "desenvolvimento", true);

        Assert.assertTrue(new GerenciarProjetoPage().procuraProjetoNaTabela(nomeProjeto));

        String nomeAtualizado = nomeProjeto+" Atualizado";
        new GerenciarProjetoPage().clicarNomeDoProjeto(nomeProjeto); //        gerenciar.clicarNomeProjeto("Projeto 02");
        new GerenciarSteps().atualizarProjeto(nomeAtualizado, descricao+" Atualizada", "desenvolvimento", true);

        Assert.assertTrue(new GerenciarProjetoPage().procuraProjetoNaTabela(nomeAtualizado)); //Operação realizada com sucesso.
    }

    @Test
    public void validarCampoNomeMarcadorObrigatorio() {
        String aux = getDataHoraString();
        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        //new GerenciarMarcadoresPage().escreverNomeMarcador("Marcador "+aux);
        new GerenciarMarcadoresPage().escreverDescricaoMarcador("Descricao "+aux);
        new GerenciarMarcadoresPage().clicarBotaoAddMarcador();

        Assert.assertEquals("Preencha este campo.", new GerenciarMarcadoresPage().validarCamposNomeObrigatorio());
    }
/*
    @Test
    public void mudarDeProjeto() {
        gerenciar.acessarTabGerenciarProjetos();
        Assert.assertTrue(home.projetoSelecionado("Projeto 01"));
        home.selecionarDropDownProjetos("Projeto 02 Editado");

        Assert.assertTrue(home.projetoSelecionado("Projeto 02 Editado"));
    }



    @Test
    public void atualizarNomeDoMarcador() {
        gerenciar.acessarTabGerenciarMarcadores();
        gerenciar.clicarNomeMarcador("Marcador 02");
        novoMarcador.clicarBotaoEditarMarcador();
        novoMarcador.setNomeMarcador("Marcador 02 Editado");
        novoMarcador.clicarBotaoAtualizarMarcador();

        Assert.assertTrue(gerenciar.existeProjetoComNome("Marcador 02 Editado"));
    }

    @Test
    public void deveApagarMarcador() {
        gerenciar.acessarTabGerenciarMarcadores();
        gerenciar.clicarNomeMarcador("tag 1");
        novoMarcador.clicarBotaoExcluirMarcador();

        Assert.assertTrue(gerenciar.existeProjetoComNome("Você tem certeza que quer apagar esse marcador?"));
        novoMarcador.clicarConfirmarExclusao();

        Assert.assertFalse(gerenciar.existeProjetoComNome("tag 1"));
    }

    @Test
    public void validarCampoNomeUsuarioObrigatorio() {
        gerenciar.acessarTabGerenciarUsuarios();
        gerenciar.clicarBotaoCriarNovaContaUsuario();
        // novoMarcador.setNomeMarcador("Marcador 02");
        novoUsuario.setNomeUsuario("Fulano User");
        novoUsuario.clicarBotaoAddUsuario();

        Assert.assertTrue(novoUsuario.validarCamposObrigatorio(
                "Nomes de usuário podem conter apenas letras, números, espaços, hífens, pontos, sinais de mais e sublinhados."));
    }

    @Test
    public void atualizarUsuario() {
        gerenciar.acessarTabGerenciarUsuarios();
        gerenciar.clicarNomeUsuario("Usuario Atualizador");
        novoUsuario.editarUserName("Usuario Editado");
        novoUsuario.clicarBotaoAtualizarUsuario();

        Assert.assertTrue(gerenciar.existeProjetoComNome("Operação realizada com sucesso."));

        gerenciar.acessarTabGerenciarUsuarios();
        Assert.assertTrue(gerenciar.existeProjetoComNome("Usuario Editado"));

    }

    @Test
    public void validarCampoNomeCategoriaObrigatorio() {
        gerenciar.acessarTabGerenciarProjetos();
        gerenciar.clicarBotaoAddCatergoria();

        Assert.assertTrue(gerenciar.existeProjetoComNome(
                "Um campo necessário 'Categoria' estava vazio. Por favor, verifique novamente suas entradas."));
    }

    @Test
    public void atualizarCategoria() {
        gerenciar.acessarTabGerenciarProjetos();
        Assert.assertTrue(gerenciar.existeProjetoComNome("cat02"));

        gerenciar.clicarBotaoEditarCategoria("cat02");
        gerenciar.editarCategoriaNome("Categoria 02 editada"); // proj-category-name
        gerenciar.clicarAtualizarCategoria();
        Assert.assertTrue(gerenciar.existeProjetoComNome("Operação realizada com sucesso."));

        gerenciar.acessarTabGerenciarProjetos();
        Assert.assertTrue(gerenciar.existeProjetoComNome("Categoria 02 editada"));
    }

    @Test
    public void apagarCategoria() {
        gerenciar.acessarTabGerenciarProjetos();
        Assert.assertTrue(gerenciar.existeProjetoComNome("xxxxxx"));

        gerenciar.clicarBotaoApagarCategoria("xxxxxx");
        gerenciar.clicarApagarCategoria();
        Assert.assertTrue(gerenciar.existeProjetoComNome("Operação realizada com sucesso."));

        gerenciar.acessarTabGerenciarProjetos();
        Assert.assertFalse(gerenciar.existeProjetoComNome("xxxxxx"));
    }

    @Test
    public void validarApagarCategoriaJaUtilizada() {
        gerenciar.acessarTabGerenciarProjetos();
        Assert.assertTrue(gerenciar.existeProjetoComNome("xxxxxx"));
        gerenciar.clicarBotaoApagarCategoria("xxxxxx");

        Assert.assertTrue(gerenciar.existeProjetoComNome(
                "Categoria \"categoria1990\" não pode ser deletada, pois está associada com outro ou mais problemas."));
    }

    @Test
    public void adicionarPerfilGlobal() {
        gerenciar.acessarTabGerenciarPerfisGlobais();
        novoPerfilGlobal.setNomePlataforma("Plataforma 01");
        novoPerfilGlobal.setSO("Android");
        novoPerfilGlobal.setVersaoSO("8.1.0");
        novoPerfilGlobal.setNomeDescricao("Descriçao 010");
        novoPerfilGlobal.clicarAdicionarPerfil();

        Assert.assertTrue(novoPerfilGlobal.existeNome("Plataforma 01"));
    }

    @Test
    public void validarCampoPlataformaObrigatorio() {
        gerenciar.acessarTabGerenciarPerfisGlobais();
        novoPerfilGlobal.clicarAdicionarPerfil();

        Assert.assertEquals("Preencha este campo.", novoPerfilGlobal.validarCampoPlataformaObrigatorio());
    }

    @Test
    public void validarCampoSOObrigatorio() {
        gerenciar.acessarTabGerenciarPerfisGlobais();
        novoPerfilGlobal.setNomePlataforma("Plataforma 01");
        novoPerfilGlobal.clicarAdicionarPerfil();

        Assert.assertEquals("Preencha este campo.", novoPerfilGlobal.validarCampoSOObrigatorio());
    }

    @Test
    public void validarCampoVersaoSOObrigatorio() {
        gerenciar.acessarTabGerenciarPerfisGlobais();
        novoPerfilGlobal.setNomePlataforma("Plataforma 02");
        novoPerfilGlobal.setSO("Android Kit Kat");
        novoPerfilGlobal.clicarAdicionarPerfil();

        Assert.assertEquals("Preencha este campo.", novoPerfilGlobal.validarCampoVersaoSOObrigatorio());
    }
*/
}
