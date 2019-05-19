package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Constantes.pathProjeto;

public  class CsvUtils {
    public static List<String[]> lerDadosCSV() throws IOException {

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


/* a chamada do metodo deve ser como abaixo
     List<String[]> dadosCSV =  lerDadosCSV();
        int i=0;
        for (String[] registro : dadosCSV) {
            String categoria	    = registro[i];
            String frequencia	    = registro[i+1];
        }*/
    }
}
