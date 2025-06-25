package Sistema.Controller;

import javax.swing.*;
import Sistema.BancoDados.BancoOperadores;
import Sistema.BancoDados.BancoPacientes;
import Sistema.Models.*;
import Sistema.View.Login;
import Sistema.View.MenuOperador;
import Sistema.View.MenuUsuario;

public class Logins {

    MenuUsuario menuUsuario = new MenuUsuario();
    MenuOperador menuOperador = new MenuOperador();
    Login menu = new Login();

    public void loginPaciente() {
        boolean logado = false;

        while (!logado) {
            JTextField cpfField = new JTextField();
            JPasswordField senhaField = new JPasswordField();

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("CPF:"));
            panel.add(cpfField);
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);

            int result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Login Usuário",
                    JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String cpf = cpfField.getText().trim();
                //o .trim() em Java é um método da classe String que remove os espaços em branco do começo e do fim da string.
                String senha = new String(senhaField.getPassword());

                if (cpf.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    continue; // tenta de novo
                }

                boolean loginSucesso = false;

                for (Paciente p : BancoPacientes.getPacientes()) {
                    if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                                + p.getPrimeiroNome() + " " + p.getUltimoNome());
                        loginSucesso = true;
                        menuUsuario.menuUsuario(p);
                        break;
                    }
                }

                if (loginSucesso) {
                    logado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha inválidos!");
                    // Loop vai repetir e pedir novamente
                }

            } else {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    menu.logar();
                    break; // sai do loop e do método
                }
                // else continua loop
            }
        }
    }


    public void loginOperador() {
        boolean logado = false;

        while (!logado) {
            JTextField idFuncionarioField = new JTextField();
            JPasswordField senhaField = new JPasswordField();

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("ID:"));
            panel.add(idFuncionarioField);
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Login Operador", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String id = idFuncionarioField.getText().trim();
                String senha = new String(senhaField.getPassword());

                if (id.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    continue; // tenta de novo
                }

                boolean loginSucesso = false;

                for (Operador o : BancoOperadores.getOperadores()) {
                    if (o.getIdFuncionario().equals(id) && o.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                                + o.getPrimeiroNome() + " " + o.getUltimoNome());
                        loginSucesso = true;
                        menuOperador.menuOperador(o);
                        break;
                    }
                }

                if (loginSucesso) {
                    logado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "ID ou senha inválidos!");
                    // loop repete pedindo login de novo
                }

            } else {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    menu.logar();
                    break; // sai do loop e método
                }
                // else continua o loop pedindo login de novo
            }
        }
    }
}