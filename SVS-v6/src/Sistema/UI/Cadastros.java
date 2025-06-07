package Sistema.UI;

import javax.swing.*;
import Sistema.Models.*;
import Sistema.BancoDados.*;

public class Cadastros {

	public static void cadastroUsuario() {

		Paciente paciente = new Paciente(null, null, null, null);

		JTextField nomeField = new JTextField();
		JTextField sobrenomeField = new JTextField();
		JTextField cpfField = new JTextField();
		JPasswordField senhaField = new JPasswordField();

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

		int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION);

		paciente.setPrimeiroNome(nomeField.getText());
		paciente.setUltimoNome(sobrenomeField.getText());
		paciente.setCpf(cpfField.getText());
		String senha = new String(senhaField.getPassword());
		paciente.setSenha(senha);

		if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return;
		} else if (result == JOptionPane.OK_OPTION) {
			BancoPacientes.adicionarPaciente(paciente);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			JOptionPane.showMessageDialog(null, "Clique em " + "OK" + " para ser direcionado ao login");
			Login.logar();
		} else
			Cadastro.cadastrar();
	}

	/*
	 * for (Paciente p : BancoPacientes.getPacientes()) {
	 * System.out.println("Paciente cadastrado: " + p.getPrimeiroNome() + " " +
	 * p.getUltimoNome() + " | CPF: " + p.getCpf() + " | SENHA: " + p.getSenha()); }
	 * 
	 * }
	 */

	public static void cadastroOperador() {

		Operador operador = new Operador(null, null, null, null, null);

		JTextField nomeField = new JTextField();
		JTextField sobrenomeField = new JTextField();
		JTextField cpfField = new JTextField();
		JTextField idFuncionario = new JTextField();
		JPasswordField senhaField = new JPasswordField();

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Nome:"));
		panel.add(nomeField);
		panel.add(new JLabel("Sobrenome:"));
		panel.add(sobrenomeField);
		panel.add(new JLabel("CPF:"));
		panel.add(cpfField);
		panel.add(new JLabel("ID Funcionário:"));
		panel.add(idFuncionario);
		panel.add(new JLabel("Senha:"));
		panel.add(senhaField);

		int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Operador", JOptionPane.OK_CANCEL_OPTION);

		operador.setPrimeiroNome(nomeField.getText());
		operador.setUltimoNome(sobrenomeField.getText());
		operador.setCpf(cpfField.getText());
		operador.setIdFuncionario(idFuncionario.getText());
		String senha = new String(senhaField.getPassword());
		operador.setSenha(senha);

		if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return;
		} else if (result == JOptionPane.OK_OPTION) {
			BancoOperadores.adicionarOperador(operador);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			JOptionPane.showMessageDialog(null, "Clique em " + "OK" + " para ser direcionado ao login");
			Login.logar();
		} else
			Cadastro.cadastrar();
	}
}
