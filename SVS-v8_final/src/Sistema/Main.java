package Sistema;

import Sistema.View.MenuInicial;

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

        // Cria uma instância do MenuInicial para controlar a navegação principal
        MenuInicial m = new MenuInicial();

        // Chama o método que exibe a tela inicial do sistema e controla o fluxo principal
        m.telaInicial(); // Tela inicial que inicia todo o sistema, indo para o Menu Inicial de Opções para o usuário.

        // Dica para debug: se quiser testar se o programa chegou aqui, pode usar:
        // System.out.println("Sistema iniciado: Tela inicial carregada");
    }
}
