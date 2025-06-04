package UserScreens;

import javax.swing.*;

import Sistema.Main;

public class userMenuScreen {

    public static boolean userView() {

        String[] opcoes = {"Visualizar Perfil", "Visualizar Vacinas", "Sair"};

        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Sistema",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            JOptionPane.showMessageDialog(null,"Ajustando");
            return userView();
        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null,"Ajustando");
            return userView();
        } else {

            String[] saida = {"Sim", "Não"};

            int escolha2 = JOptionPane.showOptionDialog(null, "Você tem certeza que deseja sair?", "Sair",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, saida, saida[0]);

            if (escolha2 == 0) {
                JOptionPane.showMessageDialog(null,"Saindo...");
                Main.main(null);
            }
            else
                return userView();

        }


        return false;
    }
}
