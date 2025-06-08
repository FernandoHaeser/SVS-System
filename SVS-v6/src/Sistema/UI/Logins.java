package Sistema.UI;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Sistema.BancoDados.BancoOperadores;
import Sistema.BancoDados.BancoPacientes;
import Sistema.Models.*;

public class Logins {

    public static void LoginPaciente() {
        JTextField cpfField = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Login Usuário", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String cpf = cpfField.getText();
            String senha = new String(senhaField.getPassword());

            boolean loginSucesso = false;

            for (Paciente p : BancoPacientes.getPacientes()) {
                if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                            + p.getPrimeiroNome() + " " + p.getUltimoNome());
                    loginSucesso = true;
                    MenuUsuario.menuUsuario();
                    break;
                }
            }

            if (!loginSucesso) {
                JOptionPane.showMessageDialog(null, "CPF ou senha inválidos!");
                Logins.LoginPaciente(); // Tenta de novo
            }

        } else {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

            if (confirm == JOptionPane.OK_OPTION)
                Login.logar(); // volta pro menu de login principal
            else
                Logins.LoginPaciente(); // tenta login de novo
        }
    }

    public static void LoginOperador() {
        JTextField idFuncionarioField = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID:"));
        panel.add(idFuncionarioField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Login Operador", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String id = idFuncionarioField.getText();
            String senha = new String(senhaField.getPassword());
            boolean loginSucesso = false;

            for (Operador o : BancoOperadores.getOperadores()) {
                if (o.getIdFuncionario().equals(id) && o.getSenha().equals(senha)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                            + o.getPrimeiroNome() + " " + o.getUltimoNome());
                    loginSucesso = true;
                    MenuOperador.menuOperador();
                    break;
                }
            }

            if (!loginSucesso) {
                JOptionPane.showMessageDialog(null, "ID ou senha inválidos!");
                Logins.LoginOperador(); // Tenta de novo
            }

        } else {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

            if (confirm == JOptionPane.OK_OPTION)
                Login.logar(); // volta pro menu principal
            else
                Logins.LoginOperador(); // tenta login de novo
        }
    }

}
