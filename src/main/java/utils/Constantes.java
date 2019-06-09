package utils;

public class Constantes {
    public static String pathProjeto= System.getProperty("user.dir");
    public static String pathChrome= pathProjeto+"/src/main/resources/chromedriver.exe";
    public static String pathFirefox= pathProjeto+"/src/main/resources/geckodriver.exe";

    public static String urlBase= "http://192.168.99.100:8989/login_page.php"; //"https://mantis.glaucia.base2.com.br/login_page.php";
    public static int defaultTimeout= 30;
    public static boolean driverLocal= true;
    public static String driverRemoteDefault= "chrome";//firefox, iexplore

    public static String loginPadrao= "administrator";
    public static String senhaPadrao= "administrator";

    //Configurando a nossa conexão com um banco de dados//
    public static String driverBD = "com.mysql.jdbc.Driver";
    public static String serverName = "localhost";    //caminho do servidor do BD
    public static String porta = "3306";    //numero da porta do BD
    public static String mydatabase ="bugtracker";        //nome do seu banco de dados
    public static String url = "jdbc:mysql://" + serverName +":"+porta+"/" + mydatabase;
    public static String username = "root";        //nome de um usuário de seu BD
    public static String password = "root";      //sua senha de acesso
    public static String pathBKP = "C:\\mantis\\mantis_base.sql";      //backup mantis
}
