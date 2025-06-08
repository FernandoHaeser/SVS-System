package Sistema.Models;

import javax.swing.*;
import Sistema.BancoDados.BancoPacientes;

public class Operador extends Usuario{

    private String idFuncionario;

    public Operador(String primeiroNome, String ultimoNome, String cpf, String senha, String idFuncionario) {
        super(primeiroNome, ultimoNome, cpf, senha);
        this.idFuncionario = idFuncionario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void RegistrarVacina() {
        String cpfPaciente = JOptionPane.showInputDialog("Digite o CPF do paciente:");

        Paciente paciente = BancoPacientes.buscarPorCpf(cpfPaciente);

        if (paciente != null) {
            String vacina = JOptionPane.showInputDialog("Digite o nome da vacina:");
            paciente.adicionarVacina(vacina); // supondo que tenha esse método

            JOptionPane.showMessageDialog(null, "Vacina registrada com sucesso para " + paciente.getPrimeiroNome());
        } else {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado!");
        }
    }


    @Override
    public String toString() {
        return "ID de Funcionario: " + idFuncionario + "\n" +
                "Nome: " + getPrimeiroNome() + getUltimoNome() + "\n" +
                "CPF: " + getCpf() + "\n\n" +
                "SVS - System";
    }
}
