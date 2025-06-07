package Sistema.UI;

import javax.swing.*;

public class Cadastro {

    public static void cadastrar() {

        String[] opcoes = {"Usuário", "Operador", "Voltar"};
        int escolha;

        escolha = JOptionPane.showOptionDialog
                (null,
                        "Qual tipo de cadastro você deseja realizar?",
                        "Menu Cadastro",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);

        if (escolha == 0)
            Cadastros.cadastroUsuario();
        else if (escolha == 1)
            Cadastros.cadastroOperador();
        else
            MenuInicial.telaInicial();
    }

}
