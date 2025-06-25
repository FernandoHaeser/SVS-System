package Sistema.Controller;

import Sistema.BancoDados.BancoPacientes;
import Sistema.Models.Operador;
import Sistema.Models.Paciente;
import Sistema.View.MenuOperador;

import javax.swing.*;

/**
 * Classe responsável por realizar a exclusão de pacientes do sistema.
 * <p>
 * Através do CPF informado pelo operador, o sistema busca o paciente
 * cadastrado no banco de dados (ArrayList), exibe uma confirmação
 * e, caso o operador confirme, remove o paciente da lista.
 * <p>
 * Ao final da operação, o sistema retorna automaticamente ao menu do operador.
 * <p>
 * Funcionalidades:
 * - Busca por CPF
 * - Confirmação de exclusão
 * - Remoção do paciente da estrutura de dados
 * - Retorno ao menu do operador após operação
 * <p>
 * Requisitos atendidos:
 * - Manipulação de objetos em ArrayList
 * - Encapsulamento
 * - Fluxo interativo com JOptionPane
 *
 * @author Mano Fefe
 */
public class DeletarPaciente {

    /**
     * Método principal que executa o processo de exclusão de um paciente do sistema.
     * <p>
     * Solicita o CPF, realiza a busca no ArrayList de pacientes,
     * exibe os dados para confirmação, e caso aprovado,
     * remove o paciente do banco.
     *
     * @param operador Operador atualmente logado, utilizado para retorno ao menu
     */
    public void deletarPaciente(Operador operador) {

        MenuOperador menuOperador = new MenuOperador();
        boolean registrada = false;

        do {
            System.out.println("[DEBUG] Iniciando loop de exclusão do paciente.");

            // Solicita o CPF do paciente
            String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
            System.out.println("[DEBUG] CPF informado: " + cpf);

            if (cpf == null || cpf.trim().isEmpty()) {
                System.out.println("[DEBUG] CPF inválido ou cancelado. Retornando ao menu do operador.");
                JOptionPane.showMessageDialog(null, "CPF inválido ou operação cancelada.");
                menuOperador.menuOperador(operador);
                break; // Sai do loop, pois não faz sentido continuar
            }

            // Busca o paciente no banco (ArrayList)
            Paciente paciente = BancoPacientes.buscarPorCpf(cpf);
            System.out.println("[DEBUG] Resultado da busca pelo paciente: " + (paciente == null ? "Paciente não encontrado" : paciente.getPrimeiroNome() + " " + paciente.getUltimoNome()));

            if (paciente == null) {
                // Se não encontrar o paciente, exibe aviso e volta para o loop
                JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
                System.out.println("[DEBUG] Paciente com CPF " + cpf + " não encontrado.");
                continue;
            }

            // Caixa de confirmação
            String[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Certeza que deseja deletar o paciente " + paciente.getPrimeiroNome() + " " + paciente.getUltimoNome() + "?",
                    "ATENÇÃO!",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            System.out.println("[DEBUG] Escolha do operador na confirmação: " + (escolha == 0 ? "Sim" : "Não"));

            if (escolha == 0) {
                // Remove o paciente da lista
                BancoPacientes.removerPaciente(paciente);
                System.out.println("[DEBUG] Paciente " + paciente.getPrimeiroNome() + " " + paciente.getUltimoNome() + " removido do banco.");

                JOptionPane.showMessageDialog(null, "Paciente removido com sucesso.");
                registrada = true; // Encerra o loop

                // Retorna ao menu do operador
                System.out.println("[DEBUG] Retornando ao menu do operador após exclusão.");
                menuOperador.menuOperador(operador);
            } else {
                // Caso cancele a remoção
                System.out.println("[DEBUG] Exclusão cancelada pelo operador. Retornando ao menu.");
                menuOperador.menuOperador(operador);
                registrada = true; // Para não ficar no loop
            }

        } while (!registrada);

        System.out.println("[DEBUG] Método deletarPaciente finalizado.");
    }
}

