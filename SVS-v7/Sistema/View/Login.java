package Sistema.View;

import Sistema.Controller.Logins;

import javax.swing.JOptionPane;

public class Login {

	public void logar() {

		Logins formaLogin = new Logins();
		MenuInicial menuInicial = new MenuInicial();

		 String[] opcoes = {"Usuário", "Operador", "Voltar"};
	        int escolha;

	        escolha = JOptionPane.showOptionDialog
	                (null,
	                        "Qual tipo de login você deseja realizar?",
	                        "Menu Login",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE,
	                        null,
	                        opcoes,
	                        opcoes[0]);
	        
	        if (escolha == 0)
	        	formaLogin.loginPaciente();
	        else if(escolha == 1)
	        	formaLogin.loginOperador();
	        else
	        	menuInicial.telaInicial();
	}
}
