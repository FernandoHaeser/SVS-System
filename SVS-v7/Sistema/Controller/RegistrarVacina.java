package Sistema.Controller;

import Sistema.Models.Paciente;
import Sistema.Models.Vacina;
import Sistema.BancoDados.BancoPacientes;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class RegistrarVacina {

    public void registrarVacina() {
        // Pede o CPF do paciente para buscar no banco
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");

        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF não pode estar vazio.");
            return;
        }

        // Busca paciente pelo CPF informado
        Paciente paciente = BancoPacientes.buscarPorCpf(cpf.trim());

        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
            return;
        }

        // Cria campos para entrada dos dados da vacina
        JTextField nomeVacina = new JTextField();
        JTextField marcaVacina = new JTextField();
        JTextField dataVacina = new JTextField();

        // Monta painel para entrada
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nome da Vacina:"));
        panel.add(nomeVacina);
        panel.add(new JLabel("Marca da Vacina:"));
        panel.add(marcaVacina);
        panel.add(new JLabel("Data de Aplicação (dd/MM/aaaa):"));
        panel.add(dataVacina);

        // Mostra diálogo para o usuário preencher os dados
        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Vacina", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Pega dados informados e tira espaços desnecessários
            String nome = nomeVacina.getText().trim();
            String marca = marcaVacina.getText().trim();
            String dataAplicacao = dataVacina.getText().trim();

            // Verifica se algum campo está vazio
            if (nome.isEmpty() || marca.isEmpty() || dataAplicacao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                return;
            }

            // Valida se a data está no formato correto dd/MM/yyyy
            if (!validarData(dataAplicacao)) {
                JOptionPane.showMessageDialog(null, "Data inválida. Use o formato dd/MM/aaaa.");
                return;
            }

            // Cria objeto Vacina com os dados (data como String mesmo)
            Vacina novaVacina = new Vacina(nome, marca, dataAplicacao);

            // Adiciona a vacina na lista do paciente
            paciente.adicionarVacina(novaVacina);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Vacina registrada com sucesso para " +
                    paciente.getPrimeiroNome() + ".");

            // Mostra todas as vacinas cadastradas do paciente
            exibirVacinasPaciente(paciente);

        } else {
            // Usuário cancelou o cadastro da vacina
            JOptionPane.showMessageDialog(null, "Registro de vacina cancelado.");
        }
    }

    // Método que valida a data para garantir o formato dd/MM/yyyy e validade real
    private boolean validarData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // evita datas inválidas tipo 31/02/2024

        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Exibe todas as vacinas cadastradas do paciente em uma caixa de mensagem
    private void exibirVacinasPaciente(Paciente paciente) {
        List<Vacina> vacinas = paciente.getVacinas();

        if (vacinas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma vacina registrada ainda.");
            return;
        }

        StringBuilder sb = new StringBuilder("Vacinas registradas para " + paciente.getPrimeiroNome() + ":\n\n");

        for (int i = 0; i < vacinas.size(); i++) {
            Vacina v = vacinas.get(i);
            sb.append((i + 1)).append(") ")
                    .append(v.getNomeVacina()).append(" - ")
                    .append(v.getMarcaVacina()).append(" - ")
                    .append(v.getDataAplicacao()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
