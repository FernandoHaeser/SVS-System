package Sistema.Controller;

import Sistema.BancoDados.BancoPacientes;
import Sistema.Models.Operador;
import Sistema.Models.Paciente;
import Sistema.View.MenuOperador;

import javax.swing.*;

/**
 * Classe responsável por permitir a edição dos dados de um paciente já cadastrado no sistema.
 * A edição é feita a partir do CPF, e o operador pode alterar nome, sobrenome e senha.
 * O CPF é utilizado como identificador único e não pode ser alterado.
 * <p>
 * Esta classe usa formulários interativos com JOptionPane para fornecer uma interface simples ao operador.
 * <p>
 * Requisitos:
 * - Validação de campos obrigatórios
 * - Verificação se as senhas coincidem
 * - Tamanho mínimo da senha
 * - Confirmação final antes de aplicar as alterações
 * <p>
 * Após a edição ou cancelamento, o sistema retorna ao menu do operador.
 *
 * @author Mano Fefe
 */
public class EditarPaciente {

    /**
     * Método principal que executa a edição de um paciente.
     * Recebe o operador logado para poder retornar ao menu após a operação.
     *
     * @param operador Operador atualmente logado no sistema
     */
    public void editarPaciente(Operador operador) {

        MenuOperador menuOperador = new MenuOperador();

        System.out.println("[DEBUG] Início do método editarPaciente.");

        // Solicita o CPF do paciente a ser editado
        String cpfBusca = JOptionPane.showInputDialog("Digite o CPF do paciente a ser editado:");
        System.out.println("[DEBUG] CPF informado para busca: " + cpfBusca);

        // Busca paciente no banco
        Paciente paciente = BancoPacientes.buscarPorCpf(cpfBusca);

        if (paciente == null) {
            System.out.println("[DEBUG] Paciente não encontrado para o CPF: " + cpfBusca);
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
            return;
        }

        System.out.println("[DEBUG] Paciente encontrado: " + paciente.getPrimeiroNome() + " " + paciente.getUltimoNome());

        boolean editado = false;

        // Criação dos campos preenchidos com dados atuais
        JTextField nomeField = new JTextField(paciente.getPrimeiroNome());
        JTextField sobrenomeField = new JTextField(paciente.getUltimoNome());
        JTextField cpfField = new JTextField(paciente.getCpf());
        cpfField.setEditable(false); // CPF é fixo
        JPasswordField senhaField = new JPasswordField(paciente.getSenha());
        JPasswordField senhaField2 = new JPasswordField(paciente.getSenha());

        // Loop até os dados serem editados corretamente ou operação ser cancelada
        while (!editado) {
            System.out.println("[DEBUG] Exibindo formulário de edição.");

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Nome:"));
            panel.add(nomeField);
            panel.add(new JLabel("Sobrenome:"));
            panel.add(sobrenomeField);
            panel.add(new JLabel("CPF:"));
            panel.add(cpfField);
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);
            panel.add(new JLabel("Repita a Senha:"));
            panel.add(senhaField2);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Editar Paciente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            System.out.println("[DEBUG] Resultado da caixa de diálogo: " + (result == JOptionPane.OK_OPTION ? "OK" : "CANCELAR"));

            if (result == JOptionPane.OK_OPTION) {
                String nome = nomeField.getText().trim();
                String sobrenome = sobrenomeField.getText().trim();
                String senha = new String(senhaField.getPassword());
                String senha2 = new String(senhaField2.getPassword());

                System.out.println("[DEBUG] Dados informados - Nome: '" + nome + "', Sobrenome: '" + sobrenome + "', Senha: '" + senha + "'");

                // Validações básicas
                if (nome.isEmpty() || sobrenome.isEmpty() || senha.isEmpty()) {
                    System.out.println("[DEBUG] Falha na validação: campos obrigatórios vazios.");
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    continue;
                }

                if (!senha.equals(senha2)) {
                    System.out.println("[DEBUG] Falha na validação: senhas não coincidem.");
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem.");
                    continue;
                }

                if (senha.length() < 6) {
                    System.out.println("[DEBUG] Falha na validação: senha muito curta.");
                    JOptionPane.showMessageDialog(null, "A senha deve ter pelo menos 6 caracteres.");
                    continue;
                }

                // Exibe confirmação das mudanças
                String dados =
                        "Deseja confirmar as alterações?\n\n" +
                                "Nome: " + nome + "\n" +
                                "Sobrenome: " + sobrenome + "\n" +
                                "CPF: " + paciente.getCpf() + "\n" +
                                "Senha: " + senha + "\n";

                System.out.println("[DEBUG] Solicitando confirmação final para atualizar os dados.");

                int escolha = JOptionPane.showConfirmDialog(null,
                        dados,
                        "Confirmação",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                System.out.println("[DEBUG] Resposta da confirmação: " + (escolha == JOptionPane.OK_OPTION ? "Confirmado" : "Cancelado"));

                if (escolha == JOptionPane.OK_OPTION) {
                    // Atualiza os dados no objeto paciente
                    paciente.setPrimeiroNome(nome);
                    paciente.setUltimoNome(sobrenome);
                    paciente.setSenha(senha);

                    JOptionPane.showMessageDialog(null, "Dados do paciente atualizados com sucesso!");
                    System.out.println("[DEBUG] Paciente atualizado: " + paciente.getPrimeiroNome() + " " + paciente.getUltimoNome());
                    editado = true;

                    // Retorna ao menu
                    System.out.println("[DEBUG] Retornando ao menu do operador após edição.");
                    menuOperador.menuOperador(operador);
                }

            } else {
                System.out.println("[DEBUG] Edição cancelada pelo operador.");
                JOptionPane.showMessageDialog(null, "Edição cancelada.");
                menuOperador.menuOperador(operador);
                break;
            }
        }

        System.out.println("[DEBUG] Método editarPaciente finalizado.");
    }
}
