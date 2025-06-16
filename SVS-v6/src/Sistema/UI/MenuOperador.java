package Sistema.UI;

import javax.swing.*;

import Sistema.Models.Vacina;

public class MenuOperador {

    public static void menuOperador() {

        Operador operador = new Operador(null, null, null, null, null);

        String[] opcoes = {"Visualizar seus dados", "Registrar vacina em paciente", "Sair"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Qual ação você deseja realizar?",
                "Menu do Operador",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, Vacina.toString());
                break;
            case 1:
                operador.RegistrarVacina();
                break;
            case 2:
                MenuInicial.telaInicial();
                break;
        }
    }
}

