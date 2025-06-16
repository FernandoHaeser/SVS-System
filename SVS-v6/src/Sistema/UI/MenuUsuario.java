package Sistema.UI;

import Sistema.Models.Vacina;

import javax.swing.*;

public class MenuUsuario {

    public static void menuUsuario() {

        Vacina novaVacina = new Vacina(Paciente, dataAplicacao, null);

        String[] opcoes = {"Visualizar seus dados", "Verificar histórico de vacinação", "Sair"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Qual ação você deseja realizar?",
                "Menu do Usuário",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,opcoes, opcoes[0]);

        if (escolha == 0)
            JOptionPane.showMessageDialog(null, Vacina.t);
        else if (escolha == 1)
            JOptionPane.showMessageDialog(null, "Trabalhando..");
        else
            MenuInicial.telaInicial();
    }
}
