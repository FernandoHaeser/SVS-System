package Sistema.View;

// Importa a classe que contém os métodos de cadastro
import Sistema.Controller.Cadastros;

import javax.swing.*;

/**
 * Classe responsável por exibir o menu de cadastro.
 * Permite ao usuário escolher entre cadastrar um Paciente, um Operador ou voltar ao menu inicial.
 */

public class Cadastro {

    /**
     * Método que exibe o menu de opções de cadastro com um JOptionPane.
     */

    public void cadastrar() {

        // Instancia o controlador de cadastros (lógica do sistema)
        Cadastros cadastros = new Cadastros();

        // Instancia o menu inicial para retornar se o usuário escolher "Voltar"
        MenuInicial menuInicial = new MenuInicial();

        // Opções apresentadas no JOptionPane
        String[] opcoes = {"Usuário", "Operador", "Voltar"};

        // Variável que vai guardar a escolha do usuário
        int escolha;

        // Exibe o painel com as opções de cadastro
        escolha = JOptionPane.showOptionDialog(
                null,
                "Qual tipo de cadastro você deseja realizar?", // mensagem
                "Menu Cadastro",                                // título da janela
                JOptionPane.YES_NO_OPTION,                      // tipo de opção (pode ignorar aqui)
                JOptionPane.QUESTION_MESSAGE,                   // ícone de interrogação
                null,                                           // sem ícone personalizado
                opcoes,                                         // array de opções
                opcoes[0]);                                     // opção padrão (pré-selecionada)

        // Verifica a escolha e redireciona para o cadastro correspondente
        if (escolha == 0)
            cadastros.cadastroUsuario(); // Chama o cadastro de Paciente
        else if (escolha == 1)
            cadastros.cadastroOperador(); // Chama o cadastro de Operador
        else
            menuInicial.telaInicial(); // Retorna ao menu inicial
    }
}
