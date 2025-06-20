package Sistema.Controller;

import Sistema.Models.Paciente;
import Sistema.Models.Vacina;
import Sistema.BancoDados.BancoPacientes;
import Sistema.Models.Operador;

import javax.swing.*;

public class RegistrarVacina {

    public void registrarVacina() {

        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        Paciente paciente = BancoPacientes.buscarPorCpf(cpf);

        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
            return;
        }

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

            Vacina novaVacina = new Vacina(nome, marca, dataAplicacao);

            paciente.adicionarVacina(novaVacina);

            JOptionPane.showMessageDialog(null, "Vacina registrada com sucesso para " +
                    paciente.getPrimeiroNome() + ".");


        }
    }
}
