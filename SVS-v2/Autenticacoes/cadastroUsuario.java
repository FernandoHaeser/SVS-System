package Autenticacoes;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import ConexaoBanco.conexaoBD;
import Sistema.Main;

public class cadastroUsuario {

    public static void cadastrar() {

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
            try (Connection con = conexaoBD.conectar()) {
                String sql = "INSERT INTO users (primeiro_nome, ultimo_nome, cpf, senha, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nomeField.getText());
                stmt.setString(2, sobrenomeField.getText());
                stmt.setString(3, cpfField.getText());
                stmt.setString(4, new String(senhaField.getPassword())); // **use hash depois!**
                stmt.setString(5, "cliente"); // por padrão

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastrado realizado com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
        else
            Main.main(null);
    }
}


