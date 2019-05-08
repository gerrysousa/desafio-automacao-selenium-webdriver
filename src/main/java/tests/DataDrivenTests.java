package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Steps.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static utils.Constantes.*;

public class DataDrivenTests extends BaseTests {

    public List<String[]> lerDadosCSV() throws IOException {
        int count = 0;
        String file = pathProjeto+"/src/main/resources/tarefaDDT.csv";
        List<String[]> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(";"));
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        }
        return content;
    }

    @BeforeMethod
    public void beforeTeste(Method method, ITestContext context) {
        new LoginSteps().fazerLogin(loginPadrao,senhaPadrao);
    }

    @Test
    public void Test_DataDrivenTestCadastrarTarefas() throws IOException {

        List<String[]> dadosCSV =  lerDadosCSV();

        int i=0;
        for (String[] registro : dadosCSV) {
            String categoria	    = registro[i];
            String frequencia	    = registro[i+1];
            String gravidade	    = registro[i+2];
            String prioridade	    = registro[i+3];
            String atribuido	    = registro[i+4];
            String resumoTarefa	    = registro[i+5];
            String descricaoTarefa	= registro[i+6];
            String passosTarefa	    = registro[i+7];
            String informacaoTarefa	= registro[i+8];
            String tagTarefa	    = registro[i+9];
            String marcadorTarefa	= registro[i+10];
            String visibilidade     = registro[i+11];

            new MenuPage().clicaBtnCriarTarefas();
            Assert.assertTrue( new CriarTarefasPage().verificarSeAcessouCriarTarefa());
            new TarefaSteps().cadastrarTarefa(categoria, frequencia, gravidade, prioridade, atribuido, resumoTarefa, descricaoTarefa, passosTarefa, informacaoTarefa, tagTarefa, marcadorTarefa, visibilidade, false);
            Assert.assertTrue(new MenuPage().procurarMensagemAlertaSucesso("Operação realizada com sucesso."));

        }

    }
}
