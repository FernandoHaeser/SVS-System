package Sistema.Models;

import Sistema.UI.Logins;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Paciente extends Usuario {

    public Paciente(String primeiroNome, String ultimoNome, String cpf, String senha) {
        super(primeiroNome, ultimoNome, cpf, senha);
    }


    public static void adicionarVacina() {

        JTextField nomeVacina = new JTextField();
        JTextField marcaVacina = new JTextField();
        JTextField dataVacina = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nome da Vacina:"));
        panel.add(nomeVacina);
        panel.add(new JLabel("Marca da Vacina:"));
        panel.add(marcaVacina);
        panel.add(new JLabel("Data de Aplicação (dd/MM/aaaa):"));
        panel.add(dataVacina);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Cadastrar Vacina", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String nome = nomeVacina.getText();
            String marca = marcaVacina.getText();
            String dataAplicacao = dataVacina.getText();

            Vacina novaVacina = new Vacina(nome, marca, dataAplicacao, null);

            // Aqui você pode salvar a vacina no sistema, mostrar mensagem, etc.
            JOptionPane.showMessageDialog(null, "Vacina cadastrada com sucesso!");
            System.out.println("Vacina adicionada: " + novaVacina);
        }
    }
}


