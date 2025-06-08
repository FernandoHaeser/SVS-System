package Sistema.UI;

import javax.swing.*;
import Sistema.Models.Operador;

public class MenuOperador {

    public static void menuOperador() {

        Operador operador = new Operador(null,null,null,null,null);

        String[] opcoes = {"Visualizar seus dados", "Registrar vacina em paciente"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Qual ação você deseja realizar?",
                "Menu do Operador",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        if (escolha == 0)
            JOptionPane.showMessageDialog(null, operador.toString());
        else
            operador.RegistrarVacina();
    }
}

