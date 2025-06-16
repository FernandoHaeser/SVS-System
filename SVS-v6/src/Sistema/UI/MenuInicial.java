package Sistema.UI;

import javax.swing.JOptionPane;

public class MenuInicial {

    public static void telaInicial() {

        String[] opcoes = {"Logar", "Cadastrar-se", "Sair"};
        String[] opcoes2 = {"Continuar", "Voltar"};
        int escolha, escolha2;

        boolean continuar = true;

        while (continuar) {
            escolha = JOptionPane.showOptionDialog(null, "O que você deseja fazer?",
                    "Menu Inicial", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {

                case 0:

                    Login.logar();
                    break;

                case 1:

                    Cadastro.cadastrar();
                    break;

                case 2:

                    escolha2 = JOptionPane.showOptionDialog(
                            null, "Você está saindo do sistema, tem certeza?",
                            null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes2, opcoes2[0]);

                    if (escolha2 == 0) {
                        JOptionPane.showMessageDialog(null, "Saindo...", null, JOptionPane.INFORMATION_MESSAGE);
                        continuar = false;
                        System.exit(0);
                    } else
                        continue;

                    break;

            }
        }
    }
}
