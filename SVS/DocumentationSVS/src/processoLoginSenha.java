package Sistema;  // Pacote onde está localizada a classe Main

import javax.swing.*;          // Importa os componentes gráficos (JOptionPane)
import Autenticacoes.*;       // Importa as classes de autenticação (cadastro e login)

public class Main {           // Classe principal que inicia o sistema
    public static void main(String[] args) {  // Método principal, executado ao iniciar o programa

        // Cria um array com as opções que o usuário pode escolher na tela inicial
        String[] opcoes = {"Login", "Cadastro"};

        // Exibe uma janela de opção perguntando se o usuário quer fazer login ou se cadastrar
        int escolha = JOptionPane.showOptionDialog(
                null,                          // Janela sem "pai"
                "O que deseja fazer?",         // Texto da pergunta
                "Sistema",                     // Título da janela
                JOptionPane.DEFAULT_OPTION,    // Tipo de opção
                JOptionPane.PLAIN_MESSAGE,     // Estilo da mensagem
                null,                          // Ícone (null = sem ícone)
                opcoes,                        // Array com as opções ("Login" e "Cadastro")
                opcoes[0]                      // Opção selecionada por padrão ("Login")
        );

        // Se a escolha for a segunda opção ("Cadastro"), chama o método de cadastro
        if (escolha == 1) {
            cadastroUsuario.cadastrar();  // Chama a tela de cadastro
        }

        // Independente da escolha, o sistema tenta logar
        if (loginUsuario.login()) {  // Se o login for bem-sucedido
            if (loginUsuario.tipoUsuario.equals("cliente")) {
                // Se o usuário for cliente, exibe mensagem de boas-vindas ao cliente
                JOptionPane.showMessageDialog(null, "Bem-vindo, cliente!");
            } else {
                // Se for operador, exibe mensagem de boas-vindas ao operador
                JOptionPane.showMessageDialog(null, "Bem-vindo, operador!");
            }
        }
    }
}
