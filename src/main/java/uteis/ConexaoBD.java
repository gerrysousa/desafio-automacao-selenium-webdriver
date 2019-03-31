package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uteis.objetos.ProjetoObj;

public class ConexaoBD {

      public static String status = "N�o conectou...";

      public ConexaoBD() {

      }
	
      //M�todo de Conex�o//
      public static java.sql.Connection getConexaoMySQL() {
    	  
    	  Connection connection = null; //atributo do tipo Connection
    	  try { //Carregando o JDBC Driver padr�o
    		  Class.forName(Constantes.driverBD);
				
    		  //Configurando a nossa conex�o com um banco de dados//
			  String url = Constantes.url;
			  String username = Constantes.username;        //nome de um usu�rio de seu BD      
			  String password = Constantes.password;      //sua senha de acesso
			  
		      connection = DriverManager.getConnection(url, username, password);
		      //Testa sua conex�o//  
		      if (connection != null) {
		    	  status = ("STATUS--->Conectado com sucesso!");
		      } 
		      else {
		    	  status = ("STATUS--->N�o foi possivel realizar conex�o");
		      }
		
		      return connection;
    	  } 
    	  catch (ClassNotFoundException e) {  //Driver n�o encontrado
    		  System.out.println("O driver expecificado nao foi encontrado.");
		      System.out.println(e.getMessage());
		      return null;
	      } 
    	  catch (SQLException e) {
    		  //N�o conseguindo se conectar ao banco
		      System.out.println("Nao foi possivel conectar ao Banco de Dados.");
		      return null;
		  }
      }
      //M�todo que retorna o status da sua conex�o//
	  public static String statusConection() {
	      return status;
	  }
		
	  //M�todo que fecha sua conex�o//
	  public static boolean FecharConexao() {
	      try {
	          ConexaoBD.getConexaoMySQL().close();
	          return true;
	      } catch (SQLException e) {
	          return false;
	      }
	  }
		 //M�todo que reinicia sua conex�o//
	  public static java.sql.Connection ReiniciarConexao() {
	      FecharConexao();
	      return ConexaoBD.getConexaoMySQL();
	  }
//==================================

	  
	    @SuppressWarnings("finally")
		public static List selecionaTodosProjetos()
		{
	    	String selectSql = "SELECT * FROM bugtracker.mantis_project_table;"; 
			List projetos = new ArrayList();
			Connection conn = null;
			Statement stmt = null;
			try
			{		
				conn = getConexaoMySQL();
				stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(selectSql);
				
				if(result!=null)
				{
					while(result.next())
					{
						int projetoId = result.getInt("id");					
						String nomeProjeto = result.getString("name");
		                String descricaoProjeto = result.getString("description");

						ProjetoObj projeto = new ProjetoObj();
						projeto.setId(projetoId);
						projeto.setName(nomeProjeto);
						projeto.setdescrition(descricaoProjeto);
						
						projetos.add(projeto);
						System.out.println(projeto.getId()+"," + projeto.getName()+"," + projeto.geDescrition());
					}
				}				
				System.out.println("Execute sql successfuly, " + selectSql);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				ConexaoBD.FecharConexao();
				return projetos;
			}			
		}
	    
	    public static void executeSql(String sql)
		{
	    	Connection conn = null;
			Statement stmt = null;
			try
			{
				conn = getConexaoMySQL();
				stmt = conn.createStatement();				
				/* The method can execute insert, update and delete dml command. */
				stmt.execute(sql);				
				System.out.println("Execute sql successfuly, " + sql);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				ConexaoBD.FecharConexao();
			}
		}
	    
	    
	  
	  
	  
}


