package utils.ConexaoDB;

import org.omg.PortableInterceptor.ServerRequestInfo;
import utils.ConexaoDB.ObjetosDB.ProjetoObj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utils.ConexaoDB.ConexaoBD.getConexaoMySQL;

public class MassasBD {

    // manipulação do banco de dados
    public static String insertProjetoBD = "INSERT INTO `bugtracker`.`mantis_project_table` (`id`, `name`, `status`, `enabled`, `view_state`, `access_min`, `file_path`, `description`, `category_id`, `inherit_global`) "
            + "VALUES ('1', 'Projeto de Teste BD', '10', '1', '10', '10', ' ', 'Massa BD', '1', '1');";
    public static String deleteBD = "DELETE FROM `bugtracker`.`mantis_project_table` WHERE (`id` = '3');";
    public static String updateBD = "UPDATE `bugtracker`.`mantis_project_table` SET `description` = ' update descria' WHERE (`id` = '2');";


    public static void criarNovoProjetoDB()
    {
        try{
            if (selecionaProjetosPorNome("Projeto de Teste BD").size()==0){
                ConexaoBD.executeSql(insertProjetoBD);
            }
        }
        catch (Exception e){
            System.out.print("Faiô!!!");
        }

    }

    public static void criarNovasTarefasDB()
    {
        String insertTarefasBD = "INSERT INTO `mantis_bug_table` (`id`, `project_id`, `reporter_id`, `handler_id`, `duplicate_id`, `priority`, `severity`, `reproducibility`, `status`, `resolution`, `projection`, `eta`, `bug_text_id`, `os`, `os_build`, `platform`, `version`, `fixed_in_version`, `build`, `profile_id`, `view_state`, `summary`, `sponsorship_total`, `sticky`, `target_version`, `category_id`, `date_submitted`, `due_date`, `last_updated`) VALUES "
                    + " (1, 1, 1, 1, 0, 30, 50, 70, 50, 10, 10, 10, 1, '', '', '', '', '', '', 0, 10, 'Resumo Tarefa BD teste 1', 0, 0, '', 1, 1538000103, 1, 1538000103),"
                    + "(2, 1, 1, 0, 0, 30, 80, 70, 10, 10, 10, 10, 2, '', '', '', '', '', '', 0, 10, 'Resumo Tarefa BD teste 2', 0, 0, '', 1, 1538000823, 1, 1538000823),"
                    + "(3, 1, 1, 0, 0, 30, 50, 70, 10, 10, 10, 10, 3, '', '', '', '', '', '', 0, 10, 'Resumo Tarefa BD teste 3', 0, 0, '', 1, 1538000859, 1, 1538000859);";
        try{
            if (selecionaProjetosPorNome("Projeto de Teste BD").size()==0){
                ConexaoBD.executeSql(insertProjetoBD);
            }
            ConexaoBD.executeSql(insertTarefasBD);
        }
        catch (Exception e){
            System.out.print("Faiô!!!");
        }
    }

    @SuppressWarnings("finally")
    public static List<ProjetoObj> selecionaProjetosPorNome(String nomeProjetoProcurado) {
        String selectSql = "SELECT * FROM bugtracker.mantis_project_table where name =  '"+nomeProjetoProcurado+"' ;";
        List<ProjetoObj> projetos = new ArrayList<ProjetoObj>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConexaoMySQL();
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(selectSql);

            if (result != null) {
                while (result.next()) {
                    int projetoId = result.getInt("id");
                    String nomeProjeto = result.getString("name");
                    String descricaoProjeto = result.getString("description");

                    ProjetoObj projeto = new ProjetoObj();
                    projeto.setId(projetoId);
                    projeto.setName(nomeProjeto);
                    projeto.setdescrition(descricaoProjeto);

                    projetos.add(projeto);
                    System.out.println(projeto.getId() + "," + projeto.getName() + "," + projeto.geDescrition());
                }
            }
            System.out.println("Execute sql successfuly, " + selectSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBD.FecharConexao();
            return projetos;
        }
    }
}
