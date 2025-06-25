package Sistema.Controller;

import Sistema.Models.Paciente;
import Sistema.Models.Vacina;
import Sistema.BancoDados.BancoPacientes;
import Sistema.Models.Operador;
import Sistema.View.MenuOperador;

import javax.print.MultiDocPrintService;
import javax.swing.*;

public class RegistrarVacina {

    /**
     * Método responsável por registrar uma nova vacina para um paciente.
     * Requer que um operador esteja logado para registrar.
     */

    public void registrarVacina(Operador operador) {

        MenuOperador menu = new MenuOperador(); // Instância do menu do operador para retornar ao final
        boolean registrada = false; // Controla se a vacina foi registrada com sucesso

        System.out.println("Iniciando processo de registro de vacina..."); // DEBUG

        // Criação dos campos de entrada da vacina
        JTextField nomeVacina = new JTextField();
        JTextField marcaVacina = new JTextField();
        JTextField dataVacina = new JTextField();

        // Executa ao menos uma vez até registrar uma vacina corretamente
        do {
            // Solicita o CPF do paciente
            String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");

            // Busca o paciente no banco (ArrayList)
            Paciente paciente = BancoPacientes.buscarPorCpf(cpf);

            if (paciente == null) {
                // Se não encontrar o paciente, exibe aviso e volta para o loop
                JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
                System.out.println("Paciente com CPF " + cpf + " não encontrado."); // DEBUG
                continue;
            }

            // Cria um painel para exibir os campos no JOptionPane
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Nome da Vacina:"));
            panel.add(nomeVacina);
            panel.add(new JLabel("Marca da Vacina:"));
            panel.add(marcaVacina);
            panel.add(new JLabel("Data de Aplicação:"));
            panel.add(dataVacina);

            JOptionPane.showMessageDialog(null,
                    "Você está registrando uma vacina no user: " +
                            paciente.getPrimeiroNome() + " " + paciente.getUltimoNome(),
                    "Atenção!", JOptionPane.WARNING_MESSAGE);

            // Exibe o formulário
            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Cadastrar Vacina no usuário " + paciente.getPrimeiroNome() + " " + paciente.getUltimoNome(),
                    JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Pega os valores dos campos e remove espaços com .trim()
                String nome = nomeVacina.getText().trim(); // evita que espaços interfiram nos dados
                String marca = marcaVacina.getText().trim();
                String dataAplicacao = dataVacina.getText().trim();

                // Verifica se todos os campos foram preenchidos
                if (nome.isEmpty() || marca.isEmpty() || dataAplicacao.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                    System.out.println("Campos da vacina vazios ou incompletos."); // DEBUG
                    continue; // Volta pro início do loop
                }

                // Cria o objeto vacina com os dados fornecidos
                Vacina novaVacina = new Vacina(nome, marca, dataAplicacao);

                // Adiciona a vacina à lista de vacinas do paciente
                paciente.adicionarVacina(novaVacina);
                System.out.println("Vacina registrada: " + nome + " | " + marca + " | " + dataAplicacao); // DEBUG
                System.out.println("Paciente: " + paciente.getPrimeiroNome() + " " + paciente.getUltimoNome()); // DEBUG

                // Mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Vacina registrada com sucesso para " +
                        paciente.getPrimeiroNome() + " " + paciente.getUltimoNome() + ".");

                registrada = true; // Marca como registrada para sair do loop
            }

            // Após a tentativa, retorna ao menu do operador
            menu.menuOperador(operador);

        } while (!registrada);

        System.out.println("Processo de registro de vacina finalizado."); // DEBUG
    }
}
