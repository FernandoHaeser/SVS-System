package Sistema.UI;

import javax.swing.JOptionPane;

public class Login {

	public static void logar() {
		
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
	        	Logins.LoginPaciente();
	        else if(escolha == 1)
	        	Logins.LoginOperador();
	        else
	        	MenuInicial.telaInicial();
	}
}
