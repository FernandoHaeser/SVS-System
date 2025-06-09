package Sistema.BancoDados;

import java.util.ArrayList;
import Sistema.Models.Paciente;
import Sistema.UI.RegistrarVacina;

import javax.swing.*;

public class BancoPacientes {
	
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    public static void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static Paciente buscarPorCpfESenha(String cpf, String senha) {
    	
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) 
                return p;
        }
        return null;
    }

    public static Paciente buscarPorCpf(String cpf) {

        boolean loginSucesso = true;

        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf));
            return p;
        }

        if (!loginSucesso) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            RegistrarVacina.registroVacina();
        }

        return null;
    }

    public static ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
