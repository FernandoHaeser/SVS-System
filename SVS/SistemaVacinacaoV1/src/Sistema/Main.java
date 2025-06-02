package Sistema;

import javax.swing.*;
import Autenticacoes.*;

public class Main {
    public static void main(String[] args) {
        String[] opcoes = {"Login", "Cadastro"};
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Sistema",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 1) {
            cadastroUsuario.cadastrar();
        }


        if (loginUsuario.login()) {
            if (loginUsuario.tipoUsuario.equals("cliente")) {
                // Tela do cliente
                JOptionPane.showMessageDialog(null, "Bem-vindo, cliente!");
            } else {
                // Tela do operador
                JOptionPane.showMessageDialog(null, "Bem-vindo, operador!");
            }
        }
    }
}
