package Sistema.UI;

import javax.swing.JOptionPane;

public class MenuInicial {

    public static void telaInicial() {

        String[] opcoes = {"Logar", "Cadastrar-se", "Sair"};
        String[] opcoes2 = {"Continuar", "Voltar"};
        int escolha, escolha2;

        escolha = JOptionPane.showOptionDialog(null,"O que você deseja fazer?",
                "Menu Inicial", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0)
            Login.logar();
        else if (escolha == 1)
            Cadastro.cadastrar();
        else {
            escolha2 = JOptionPane.showOptionDialog(
                    null, "Você está saindo do sistema, tem certeza?",
                    null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes2, opcoes2[0]);

            if (escolha2 == 0) {
                JOptionPane.showMessageDialog(null,"Saindo...", null, JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else
                telaInicial();

        }
    }
}
