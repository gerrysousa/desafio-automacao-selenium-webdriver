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
    public void Test_deveAcessarGerenciar() {
        new MenuPage().clicaBtnGerenciar();

        Assert.assertTrue(new GerenciarVisaoGeralPage().verificarSeAcessouGerenciarVisaoGeralPage());
    }

    //=========================
    @Test
    public void Test_adicionarCategoria() {
        String nomeCategotia = "Categoria "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();

        new GerenciarProjetoPage().escreverNomeCategoria(nomeCategotia);
        new GerenciarProjetoPage().clicarBotaoAddCatergoria();

        Assert.assertTrue(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategotia));
    }

  @Test
    public void Test_adicionarProjeto() {
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
    public void Test_adicionarUsuario() {
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
        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();

        Assert.assertTrue(new GerenciarUsuariosPage().procurarUsuarioNaTabela("user"+aux));
    }

    @Test
    public void Test_adicionarMarcadores() {
        String aux = getDataHoraString();
        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        new GerenciarMarcadoresPage().escreverNomeMarcador("Marcador "+aux);
        new GerenciarMarcadoresPage().escreverDescricaoMarcador("Descricao "+aux);
        new GerenciarMarcadoresPage().clicarBotaoAddMarcador();

        Assert.assertTrue(new GerenciarMarcadoresPage().procuraMarcadorNaTabela("Marcador "+aux));
    }

    @Test
    public void Test_validarCampoNomeProjetoObrigatorio() {
        String nomeProjeto = "Projeto "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().clicarBotaoAddProjeto();
        new GerenciarNovoProjetoPage().escreverDescricaoProjeto("Descrição do "+nomeProjeto);
        new GerenciarNovoProjetoPage().clicarBotaoAddProjeto();

        Assert.assertEquals("Preencha este campo.", new GerenciarNovoProjetoPage().validarCamposNomeObrigatorio());
    }

    @Test
    public void Test_atualizarNomeDoProjeto() {
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
    public void Test_validarCampoNomeMarcadorObrigatorio() {
        String aux = getDataHoraString();
        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        new GerenciarMarcadoresPage().escreverDescricaoMarcador("Descricao "+aux);
        new GerenciarMarcadoresPage().clicarBotaoAddMarcador();

        Assert.assertEquals("Preencha este campo.", new GerenciarMarcadoresPage().validarCamposNomeObrigatorio());
    }

    @Test
    public void Test_atualizarNomeDoMarcador() {
        String nomeMarcarcor = "Marcador "+getDataHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        new GerenciarMarcadoresPage().escreverNomeMarcador(nomeMarcarcor);
        new GerenciarMarcadoresPage().escreverDescricaoMarcador("Descricao "+nomeMarcarcor);
        new GerenciarMarcadoresPage().clicarBotaoAddMarcador();

        Assert.assertTrue(new GerenciarMarcadoresPage().procuraMarcadorNaTabela(nomeMarcarcor));

        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        new GerenciarMarcadoresPage().clicarNomeDoMarcador(nomeMarcarcor);
        String nomeAtualizado = "Marcador Atualizado "+getDataHoraString();

        new GerenciarNovoMarcadorPage().clicarBotaoEditarMarcador();
        new GerenciarNovoMarcadorPage().escreverNomeMarcador(nomeAtualizado);
        new GerenciarNovoMarcadorPage().escreverDescricaoMarcador("Descricao "+nomeAtualizado);
        new GerenciarNovoMarcadorPage().clicarBotaoEditarMarcador();

        new MenuPage().clicaBtnGerenciar();
        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        Assert.assertFalse(new GerenciarMarcadoresPage().procuraMarcadorNaTabela(nomeMarcarcor));
        Assert.assertTrue(new GerenciarMarcadoresPage().procuraMarcadorNaTabela(nomeAtualizado));
    }

    @Test
    public void Test_deveApagarMarcador() {
        String nomeMarcarcor = "Marcador "+getDataHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        new GerenciarMarcadoresPage().escreverNomeMarcador(nomeMarcarcor);
        new GerenciarMarcadoresPage().escreverDescricaoMarcador("Descricao "+nomeMarcarcor);
        new GerenciarMarcadoresPage().clicarBotaoAddMarcador();

        Assert.assertTrue(new GerenciarMarcadoresPage().procuraMarcadorNaTabela(nomeMarcarcor));

        new GerenciarVisaoGeralPage().clicarTabGerenciarMarcadores();
        new GerenciarMarcadoresPage().clicarNomeDoMarcador(nomeMarcarcor);
        new GerenciarNovoMarcadorPage().clicarBotaoApagarMarcador();
        Assert.assertTrue(new GerenciarNovoMarcadorPage().procurarMensagemAlerta("Você tem certeza que quer apagar esse marcador?"));
        new GerenciarNovoMarcadorPage().clicarBotaoApagarMarcador();

        Assert.assertFalse(new GerenciarMarcadoresPage().procuraMarcadorNaTabela(nomeMarcarcor));
    }

    @Test
    public void Test_validarCampoNomeUsuarioObrigatorio() {
        String aux = getDataHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();
        new GerenciarUsuariosPage().clicarBotaoAddNovaConta();

        new GerenciarNovaContaUsuarioPage().escreverNomeRealUsuario("Usuario "+aux);
        new GerenciarNovaContaUsuarioPage().escreverEmail("user"+aux+"@autotest.com");
        //new GerenciarNovaContaUsuarioPage().nivelDeAcesso("relator");
//       new GerenciarNovaContaUsuarioPage().habilitado(true);
//       new GerenciarNovaContaUsuarioPage().protegido(false);
        new GerenciarNovaContaUsuarioPage().clicarBotaoAddNovaConta();

        Assert.assertTrue( new GerenciarNovaContaUsuarioPage().procurarMensagemAlerta("Nomes de usuário podem conter apenas letras, números, espaços, hífens, pontos, sinais de mais e sublinhados."));
    }

    @Test
    public void Test_atualizarUsuario() {
        String nomeUsuario = "user"+getDataHoraString();
        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();
        new GerenciarUsuariosPage().clicarBotaoAddNovaConta();
        new GerenciarNovaContaUsuarioPage().escreverNomeUsuario(nomeUsuario);
        new GerenciarNovaContaUsuarioPage().escreverNomeRealUsuario("Real Name "+nomeUsuario);
        new GerenciarNovaContaUsuarioPage().escreverEmail("user"+nomeUsuario+"@autotest.com");
        new GerenciarNovaContaUsuarioPage().clicarBotaoAddNovaConta();

        new MenuPage().clicaBtnGerenciar();
        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();

        Assert.assertTrue(new GerenciarUsuariosPage().procurarUsuarioNaTabela(nomeUsuario));

        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();
        new GerenciarUsuariosPage().clicarNomeDoUsuario(nomeUsuario);

        String usuarioAtualizado = "atualizado"+nomeUsuario;
        new GerenciarEditarContaUsuarioPage().escreverNomeUsuario(usuarioAtualizado);
        new GerenciarEditarContaUsuarioPage().escreverNomeRealUsuario("Real Name "+usuarioAtualizado);
        new GerenciarEditarContaUsuarioPage().escreverEmail(usuarioAtualizado+"@autotest.com");
        new GerenciarEditarContaUsuarioPage().clicarBotaoAtualizarConta();

        //Assert.assertTrue(new GerenciarNovaContaUsuarioPage().procurarMensagemAlerta("Operação realizada com sucesso."));
        //System.out.println("Se resultado for true pode descomentar, resultado="+new GerenciarNovaContaUsuarioPage().procurarMensagemAlerta("Operação realizada com sucesso."));

        new MenuPage().clicaBtnGerenciar();
        new GerenciarVisaoGeralPage().clicarTabGerenciarUsuarios();
        //Assert.assertFalse(new GerenciarUsuariosPage().procurarUsuarioNaTabela(nomeUsuario));
        Assert.assertTrue(new GerenciarUsuariosPage().procurarUsuarioNaTabela(usuarioAtualizado));
    }

    @Test
    public void Test_validarCampoNomeCategoriaObrigatorio() {
        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().clicarBotaoAddCatergoria();

        Assert.assertTrue(new GerenciarProjetoPage().procurarMensagemAlerta("Um campo necessário 'Categoria' estava vazio. Por favor, verifique novamente suas entradas."));
    }

    @Test
    public void Test_atualizarCategoria() {
        String nomeCategotia = "Categoria "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().escreverNomeCategoria(nomeCategotia);
        new GerenciarProjetoPage().clicarBotaoAddCatergoria();
        Assert.assertTrue(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategotia));

        String categoriaAtualizada = nomeCategotia+" Atualizada";
        new GerenciarProjetoPage().clicarBotaoEditarCategoria(nomeCategotia);
        new GerenciarEditarCategoriaPage().preencherCategoriaNome(categoriaAtualizada);
        new GerenciarEditarCategoriaPage().clicarBotaoAtualizarCategoria();

        //Assert.assertTrue(new GerenciarEditarCategoriaPage().procurarMensagemAlerta("Operação realizada com sucesso."));
        System.out.println("Se resultado for true pode descomentar, resultado="+new GerenciarEditarCategoriaPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        //Assert.assertFalse(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategotia));
        Assert.assertTrue(new GerenciarProjetoPage().procuraCategoriaNaTabela(categoriaAtualizada));
    }

    @Test
    public void Test_apagarCategoria() {
        String nomeCategotia = "Categoria "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().escreverNomeCategoria(nomeCategotia);
        new GerenciarProjetoPage().clicarBotaoAddCatergoria();
        Assert.assertTrue(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategotia));

        new GerenciarProjetoPage().clicarBotaoApagarCategoria(nomeCategotia);
        Assert.assertTrue(new GerenciarProjetoPage().procurarMensagemAlertaConfirmacao("Você tem certeza que deseja deletar a categoria"));
        new GerenciarEditarCategoriaPage().clicarBotaoApagarCategoria();
//        boolean teste = new GerenciarProjetoPage().procurarMensagemAlertaConfirmacao("Você tem certeza que deseja deletar a categoria");
//        System.out.println("se for true deve colocar assert="+teste);

       // new GerenciarProjetoPage().clicarBotaoApagarCategoriaConfirmacao();
        Assert.assertFalse(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategotia));
    }

    @Test
    public void Test_adicionarPerfilGlobal() {
        String aux = "Perfil "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarPerfisGlobais();
        new GerenciarNovoPerfilGlobalPage().preencherPlataforma(aux);
        new GerenciarNovoPerfilGlobalPage().preencherOS("Android");
        new GerenciarNovoPerfilGlobalPage().preencherOSVersao("Android"+aux);
        new GerenciarNovoPerfilGlobalPage().preencherDescricao("Descricao "+aux);
        new GerenciarNovoPerfilGlobalPage().clicarAddPerfilGlobal();

        Assert.assertTrue(new GerenciarNovoPerfilGlobalPage().procuraPerfilNoComboBox(aux));
    }

    @Test
    public void Test_validarApagarCategoriaJaUtilizada() {
      /*  String nomeCategotia = "Categoria "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        new GerenciarProjetoPage().escreverNomeCategoria(nomeCategotia);
        new GerenciarProjetoPage().clicarBotaoAddCatergoria();
        Assert.assertTrue(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategotia));

        cadastrar uma tarefa com a categoria
       */
        String nomeCategoria = "Categoria 0709";

        new GerenciarVisaoGeralPage().clicarTabGerenciarProjetos();
        Assert.assertTrue(new GerenciarProjetoPage().procuraCategoriaNaTabela(nomeCategoria));
        new GerenciarProjetoPage().clicarBotaoApagarCategoria(nomeCategoria);

        Assert.assertTrue( new GerenciarProjetoPage().procurarMensagemAlerta("Categoria \"Categoria 0709\" não pode ser deletada, pois está associada com outro ou mais problemas."));
    }

    @Test
    public void Test_validarCampoPlataformaObrigatorio() {
        String aux = "Perfil "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarPerfisGlobais();
        new GerenciarNovoPerfilGlobalPage().preencherOS("Android");
        new GerenciarNovoPerfilGlobalPage().preencherOSVersao("Android"+aux);
        new GerenciarNovoPerfilGlobalPage().preencherDescricao("Descricao "+aux);
        new GerenciarNovoPerfilGlobalPage().clicarAddPerfilGlobal();

        Assert.assertEquals("Preencha este campo.", new GerenciarNovoPerfilGlobalPage().validarCampoPlataformaObrigatorio());
    }

    @Test
    public void Test_validarCampoSOObrigatorio() {
        String aux = "Perfil "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarPerfisGlobais();
        new GerenciarNovoPerfilGlobalPage().preencherPlataforma(aux);
        //new GerenciarNovoPerfilGlobalPage().preencherOS("Android");
        new GerenciarNovoPerfilGlobalPage().preencherOSVersao("Android"+aux);
        new GerenciarNovoPerfilGlobalPage().preencherDescricao("Descricao "+aux);
        new GerenciarNovoPerfilGlobalPage().clicarAddPerfilGlobal();

        Assert.assertEquals("Preencha este campo.", new GerenciarNovoPerfilGlobalPage().validarCampoSOObrigatorio());
    }

    @Test
    public void Test_validarCampoVersaoSOObrigatorio() {
        String aux = "Perfil "+getHoraString();

        new GerenciarVisaoGeralPage().clicarTabGerenciarPerfisGlobais();
        new GerenciarNovoPerfilGlobalPage().preencherPlataforma(aux);
        new GerenciarNovoPerfilGlobalPage().preencherOS("Android");
       // new GerenciarNovoPerfilGlobalPage().preencherOSVersao("Android"+aux);
        new GerenciarNovoPerfilGlobalPage().preencherDescricao("Descricao "+aux);
        new GerenciarNovoPerfilGlobalPage().clicarAddPerfilGlobal();

        Assert.assertEquals("Preencha este campo.", new GerenciarNovoPerfilGlobalPage().validarCampoVersaoSOObrigatorio());
    }

    @Test
    public void Test_mudarDeProjeto() {
        //To do : Criar projeto 1
        //To do : selecionar projeto 1
        String projetoSelecionado = new MenuPage().obterProjetoSelecionado();
        String outroProjeto = "Projeto 0732";
        //To do : Criar projeto 2
        new MenuPage().selecionarProjetosNoDropdowd(outroProjeto);

        Assert.assertNotEquals(projetoSelecionado, new MenuPage().obterProjetoSelecionado());
        Assert.assertEquals(" "+outroProjeto+" ", new MenuPage().obterProjetoSelecionado());
    }
}
