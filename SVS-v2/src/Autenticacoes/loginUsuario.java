package Autenticacoes;

import javax.swing.*;
import java.sql.*;

import ConexaoBanco.conexaoBD;
import Sistema.*;
import UserScreens.userMenuScreen;

public class loginUsuario {

    public static String primeiroNome = "";
    public static String ultimoNome = "";

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
                    primeiroNome = rs.getString("primeiro_nome");
                    ultimoNome = rs.getString("ultimo_nome");
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido, seja bem-vindo" + primeiroNome + " " + ultimoNome);
                    return userMenuScreen.userView();
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
                    return login();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                Main.main(null);
                return false;
            }

        } else {
            Main.main(null);
        }

        return false;
    }
}
