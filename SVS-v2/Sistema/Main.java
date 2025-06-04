package Sistema;

import javax.swing.*;

import Autenticacoes.*;
import UserScreens.userMenuScreen;

public class Main {

    public static void main(String[] args) {

        String[] opcoes = {"Login", "Cadastro", "Sair"};
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Sistema",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0)
            userMenuScreen.userView();
            //loginUsuario.login();
        else if (escolha == 1)
            cadastroUsuario.cadastrar();
        else
            JOptionPane.showMessageDialog(null, "Saindo...");

    }
}

