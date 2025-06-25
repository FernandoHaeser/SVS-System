package Sistema;

import Sistema.View.MenuInicial;

import javax.swing.*;

/**
 * Classe principal que inicia a aplicação.
 */

public class Main {

    /**
     * Método main é o ponto de entrada do programa Java.
     * Aqui inicializamos o sistema mostrando a tela inicial.
     *
     * @param args argumentos de linha de comando (não usados)
     */


    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,
                "Seja bem-vindo ao SVS-SYSTEM!",
                "SVS-SYSTEM", JOptionPane.PLAIN_MESSAGE,
                null);

        // Cria uma instância do MenuInicial para controlar a navegação principal
        MenuInicial m = new MenuInicial();

        // Chama o método que exibe a tela inicial do sistema e controla o fluxo principal
        m.telaInicial(); // Tela inicial que inicia todo o sistema, indo para o Menu Inicial de Opções para o usuário.

        // Dica para debug: se quiser testar se o programa chegou a

    }
}
