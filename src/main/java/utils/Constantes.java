package utils;

public class Constantes {
    public static String pathProjeto= System.getProperty("user.dir");
    public static String pathChrome= pathProjeto+"/src/main/resources/chromedriver.exe";
    public static String pathFirefox= pathProjeto+"/src/main/resources/geckodriver.exe";

    public static String urlBase= "https://mantis.glaucia.base2.com.br/login_page.php";
    public static int defaultTimeout= 30;
    public static boolean driverLocal= false;
    public static String driverRemoteDefault= "chrome";//firefox, iexplore

    public static String loginPadrao= "administrator";
    public static String senhaPadrao= "duarte";
}
