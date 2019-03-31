package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

      public static String status = "Não conectou...";

      public ConexaoBD() {

      }
	
      //Método de Conexão//
      public static java.sql.Connection getConexaoMySQL() {
    	  
    	  Connection connection = null; //atributo do tipo Connection
    	  try {
    		  //Carregando o JDBC Driver padrão
    		  String driverName = "com.mysql.jdbc.Driver";                        
    		  Class.forName(driverName);
				
    		  //Configurando a nossa conexão com um banco de dados//
			  String serverName = "localhost:3306";    //caminho do servidor do BD
			  String mydatabase ="bugtracker";        //nome do seu banco de dados
			  String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			  String username = "root";        //nome de um usuário de seu BD      
			  String password = "root";      //sua senha de acesso
			  
		      connection = DriverManager.getConnection(url, username, password);
		      //Testa sua conexão//  
		      if (connection != null) {
		    	  status = ("STATUS--->Conectado com sucesso!");
		      } 
		      else {
		    	  status = ("STATUS--->Não foi possivel realizar conexão");
		      }
		
		      return connection;
    	  } 
    	  catch (ClassNotFoundException e) {  //Driver não encontrado
    		  System.out.println("O driver expecificado nao foi encontrado.");
		      System.out.println(e.getMessage());
		      return null;
	      } 
    	  catch (SQLException e) {
    		  //Não conseguindo se conectar ao banco
		      System.out.println("Nao foi possivel conectar ao Banco de Dados.");
		      return null;
		  }
      }
      //Método que retorna o status da sua conexão//
	  public static String statusConection() {
	      return status;
	  }
		
	  //Método que fecha sua conexão//
	  public static boolean FecharConexao() {
	      try {
	          ConexaoBD.getConexaoMySQL().close();
	          return true;
	      } catch (SQLException e) {
	          return false;
	      }
	  }
		 //Método que reinicia sua conexão//
	  public static java.sql.Connection ReiniciarConexao() {
	      FecharConexao();
	      return ConexaoBD.getConexaoMySQL();
	  }
//==================================
	  /*
	   *    String url = "jdbc:msql://200.210.220.1:1114/Demo";
            Connection conn = DriverManager.getConnection(url,"","");
            Statement stmt = conn.createStatement();
            ResultSet rs;
  	  */
	  
	    public static void executaQuery(String query) {
	        try {
	        	Connection conn = getConexaoMySQL();
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT * FROM bugtracker.mantis_project_table;");
	            while ( rs.next() ) {
	                String nomeProjeto = rs.getString("name");
	                String descricaoProjeto = rs.getString("description");	                
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	    }
	  
	  
	  
	  
	  
}