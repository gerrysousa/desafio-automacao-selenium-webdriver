package utils.Steps;

import pages.LoginPage;

public class LoginSteps  {

    public void fazerLogin(String email, String senha) {
        //Ações do Login
        new LoginPage().preencherEmail(email);
        new LoginPage().clicarBotaoLogin();
        new LoginPage().preencherSenha(senha);
        new LoginPage().clicarBotaoLogin();
    }
}
