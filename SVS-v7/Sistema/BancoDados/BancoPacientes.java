package Sistema.BancoDados;
// Define o pacote onde essa classe está no projeto

import java.util.ArrayList;
// Importa a classe ArrayList, para guardar uma lista dinâmica de objetos

import Sistema.Models.Paciente;

import javax.swing.*;
// Importa a classe Paciente, que representa os pacientes do sistema

public class BancoPacientes {
    // Declara a classe BancoPacientes, que vai gerenciar os pacientes cadastrados

    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    // Cria uma lista estática para armazenar os objetos Paciente

    public static void adicionarPaciente(Paciente paciente) {
        // Método para adicionar um paciente na lista
        pacientes.add(paciente);
        // Adiciona o paciente recebido no parâmetro dentro da lista 'pacientes'
    }

    public static Paciente buscarPorCpfESenha(String cpf, String senha) {
        // Método para buscar um paciente pelo CPF e senha, usado para login

        for (Paciente p : pacientes) {
            // Loop que percorre todos os pacientes na lista
            if (p.getCpf().equals(cpf) && p.getSenha().equals(senha))
                // Se o CPF e a senha do paciente 'p' forem iguais aos fornecidos
                return p;
            // Retorna o paciente encontrado
        }
        return null;
        // Se nenhum paciente combinar com CPF e senha, retorna null
    }

    public static Paciente buscarPorCpf(String cpf) {
        // Método para buscar paciente só pelo CPF, sem senha (pode ser pra cadastro ou verificação)

        //boolean loginSucesso = true;
        // Comentado, provavelmente não está sendo usado

        for (Paciente p : pacientes) {
            // Percorre a lista de pacientes
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        // Caso a verificaça
        JOptionPane.showMessageDialog(null, "CPF inválido! Tente novamente.");

        return null;
        // Se não encontrar, retorna null
    }

    public static ArrayList<Paciente> getPacientes() {
        // Retorna a lista completa de pacientes cadastrados
        return pacientes;
    }
}
