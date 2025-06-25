package Sistema.View;

import Sistema.Controller.Cadastros;

import javax.swing.*;

public class Cadastro {

    public void cadastrar() {

        Cadastros cadastros = new Cadastros();
        MenuInicial menuInicial = new MenuInicial();

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
            cadastros.cadastroUsuario();
        else if (escolha == 1)
            cadastros.cadastroOperador();
        else
            menuInicial.telaInicial();
    }
}
