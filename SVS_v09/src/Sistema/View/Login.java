package Sistema.View;

// Importa o controlador responsável pela lógica de login
import Sistema.Controller.Logins;
import javax.swing.JOptionPane;

/**
 * Classe Login representa o menu de seleção de tipo de login do sistema.
 * Permite ao usuário escolher se quer logar como Usuário, Operador ou voltar.
 */

public class Login {

	/**
	 * Método que exibe o menu de login usando um JOptionPane.
	 * Redireciona o usuário para o tipo de login apropriado.
	 */

	public void logar() {

		// Cria uma instância da classe responsável por realizar os logins
		Logins formaLogin = new Logins();

		// Instancia o menu inicial para retornar se o usuário escolher "Voltar"
		MenuInicial menuInicial = new MenuInicial();

		// Define as opções disponíveis no menu
		String[] opcoes = {"Usuário", "Operador", "Voltar"};

		// Variável que armazena a opção escolhida
		int escolha;

		// Exibe a janela de seleção com as opções
		escolha = JOptionPane.showOptionDialog(
				null,                                           // Componente pai (null = centralizado)
				"Qual tipo de login você deseja realizar?",     // Mensagem
				"Menu Login",                                   // Título da janela
				JOptionPane.YES_NO_OPTION,                      // Tipo de botão (pouco relevante aqui)
				JOptionPane.QUESTION_MESSAGE,                   // Ícone com interrogação
				null,                                           // Sem ícone personalizado
				opcoes,                                         // Opções exibidas
				opcoes[0]);                                     // Opção selecionada por padrão ("Usuário")

		// Verifica a escolha e redireciona para o login correspondente
		if (escolha == 0)
			formaLogin.loginPaciente(); // Login como Paciente
		else if (escolha == 1)
			formaLogin.loginOperador(); // Login como Operador
		else
			menuInicial.telaInicial(); // Volta para o menu principal
	}
}
