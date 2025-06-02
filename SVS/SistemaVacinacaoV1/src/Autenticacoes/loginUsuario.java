package Autenticacoes;

import javax.swing.*;
import java.sql.*;
import ConexaoBanco.conexaoBD;

public class loginUsuario {

    public static String tipoUsuario = "";

    public static boolean login() {
        JTextField cpfField = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try (Connection con = conexaoBD.conectar()) {
                String sql = "SELECT * FROM users WHERE cpf = ? AND senha = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cpfField.getText());
                stmt.setString(2, new String(senhaField.getPassword())); // **hash depois!**

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    tipoUsuario = rs.getString("tipo_usuario");
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido como " + tipoUsuario);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}
