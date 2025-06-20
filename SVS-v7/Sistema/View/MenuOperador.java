package Sistema.View;

import javax.swing.*;
import Sistema.Models.Operador;
import Sistema.Controller.RegistrarVacina;

public class MenuOperador {

    public void menuOperador(Operador operador) {

        MenuInicial menuInicial = new MenuInicial();

        String[] opcoes = {"Visualizar seus dados", "Registrar vacina em paciente", "Sair"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Qual ação você deseja realizar?",
                "Menu do Operador",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, operador.mostrarInfos());
                menuOperador(operador);
                break;

            case 1:
                RegistrarVacina registrarVacina = new RegistrarVacina();
                registrarVacina.registrarVacina();
                break;

            case 2:
                menuInicial.telaInicial();
                break;
        }
    }
}
