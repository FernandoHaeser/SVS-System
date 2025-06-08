package Sistema.UI;

import javax.swing.*;

public class MenuUsuario {

    public static void menuUsuario() {

        String[] opcoes = {"Visualizar seus dados", "Verificar histórico de vacinação"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Qual ação você deseja realizar?",
                "Menu do Usuário",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,opcoes, opcoes[0]);

        if (escolha == 0)
            JOptionPane.showMessageDialog(null, "Trabalhando..");
        else
            JOptionPane.showMessageDialog(null, "Trabalhando..");
    }
}
