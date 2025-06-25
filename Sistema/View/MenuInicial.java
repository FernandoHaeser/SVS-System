package Sistema.View;

import javax.swing.JOptionPane;

public class MenuInicial {

    public void telaInicial() {

        String[] opcoes = {"Logar", "Cadastrar-se", "Sair"};
        String[] opcoes2 = {"Continuar", "Voltar"};

        Login menuLogin = new Login();
        Cadastro menuCadastro = new Cadastro();

        int escolha, escolha2;

        boolean continuar = true;


        while (continuar) {
            escolha = JOptionPane.showOptionDialog(null, "O que você deseja fazer?",
                    "Menu Inicial", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }

            switch (escolha) {

                case 0:
                    menuLogin.logar();
                    break;

                case 1:
                    menuCadastro.cadastrar();
                    break;

                case 2:

                    continuar = false;

                    escolha2 = JOptionPane.showOptionDialog(
                            null, "Você está saindo do sistema, tem certeza?",
                            null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes2, opcoes2[0]);

                    if (escolha2 == 0) {
                        JOptionPane.showMessageDialog(null, "Saindo...", null, JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    } else
                        continue;

                    break;

            }
        }
    }
}
