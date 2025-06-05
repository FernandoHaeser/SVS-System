package Sistema.UI;

import javax.swing.*;
import Sistema.Models.*;

public class Cadastros {

    public static void cadastroUsuario() {

        UsuarioComum user = new UsuarioComum(null, null, null, null);

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

        user.setPrimeiroNome(nomeField.getText());
        user.setUltimoNome(sobrenomeField.getText());
        user.setCpf(cpfField.getText());
        user.setSenha(senhaField.getText());
    }

    public static void cadastroOperador() {

        Operador operador = new Operador(null,null,null,null,null);

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

        System.out.println(operador.getSenha());
    }
}
