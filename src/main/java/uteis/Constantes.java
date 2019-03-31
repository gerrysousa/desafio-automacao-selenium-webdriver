package uteis;

public class Constantes {

	//Configurando a nossa conexão com um banco de dados//
	public static String driverBD = "com.mysql.jdbc.Driver";  
	public static String serverName = "localhost";    //caminho do servidor do BD
	public static String porta = "3306";    //numero da porta do BD
	public static String mydatabase ="bugtracker";        //nome do seu banco de dados
	public static String url = "jdbc:mysql://" + serverName +":"+porta+"/" + mydatabase;
	public static String username = "root";        //nome de um usuário de seu BD      
	public static String password = "root";      //sua senha de acesso
	
	public static String pathBKP = "C:\\mantis\\mantis_base.sql";      //backup mantis
	
	// manipulação do banco de dados  
	public static String insertBD = "INSERT INTO `bugtracker`.`mantis_project_table` (`id`, `name`, `status`, `enabled`, `view_state`, `access_min`, `file_path`, `description`, `category_id`, `inherit_global`) "
			+ "VALUES ('3', 'projeto 3', '10', '1', '10', '10', ' ', 'decricao', '1', '1');";
	public static String deleteBD = "DELETE FROM `bugtracker`.`mantis_project_table` WHERE (`id` = '3');";
	public static String updateBD = "UPDATE `bugtracker`.`mantis_project_table` SET `description` = ' update descria' WHERE (`id` = '2');";
	
	
}
