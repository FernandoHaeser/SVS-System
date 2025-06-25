package Sistema.View;

import Sistema.Models.Paciente;

import javax.swing.*;

public class MenuUsuario {

    public void menuUsuario(Paciente paciente) {

        MenuInicial menuInicial = new MenuInicial();

        String[] opcoes = {"Visualizar seus dados", "Verificar histórico de vacinação", "Sair"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Qual ação você deseja realizar?",
                "Menu do Usuário",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, paciente.mostrarInfos());

                break;

            case 1:
                String historico = paciente.exibirHistoricoVacinas();
                JOptionPane.showMessageDialog(null, historico);
                break;

            case 2:
                menuInicial.telaInicial();
                break;
        }
    }
}
