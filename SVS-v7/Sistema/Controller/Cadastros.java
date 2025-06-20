package Sistema.Controller;

import javax.swing.*;

import Sistema.Models.*;
import Sistema.BancoDados.*;
import Sistema.View.Cadastro;
import Sistema.View.Login;

public class Cadastros {

    public void cadastroUsuario() {

        /*
         * BancoOperadores bancoOperadores = new BancoOperadores();
         * BancoPacientes bancoPacientes = new BancoPacientes();]
         */

        Login loginMenu = new Login();
        boolean cadastrado = false;

        while (!cadastrado) {
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

            if (result == JOptionPane.OK_OPTION) {
                String nome = nomeField.getText().trim();
                String sobrenome = sobrenomeField.getText().trim();
                String cpf = cpfField.getText().trim();
                String senha = new String(senhaField.getPassword());

                if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    continue; // volta pro começo do loop
                }

                Paciente paciente = new Paciente(nome, sobrenome, cpf, senha);
                BancoPacientes.adicionarPaciente(paciente);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                cadastrado = true;
                loginMenu.logar();
            } else {
                Cadastro menuCadastrar = new Cadastro();
                menuCadastrar.cadastrar();
                break;
            }
        }
    }


    public void cadastroOperador() {

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

            Login login = new Login();
            login.logar();
        } else {
            Cadastro menuLogin = new Cadastro();
            menuLogin.cadastrar();
        }
    }
}
