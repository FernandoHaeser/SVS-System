package Autenticacoes;  // Pacote onde essa classe de autenticação está organizada

import javax.swing.*;  // Biblioteca para criar interfaces gráficas (JOptionPane, JTextField etc)
import java.sql.*;  // Importa tudo de SQL: Connection, PreparedStatement, ResultSet
import ConexaoBanco.conexaoBD;  // Importa sua classe de conexão com banco de dados

public class loginUsuario {  // Classe responsável por realizar o login do usuário

    public static String tipoUsuario = "";  // Armazena o tipo de usuário (cliente, operador...) após o login

    public static boolean login() {  // Método que realiza o processo de login
        // Campos para o usuário digitar CPF e senha
        JTextField cpfField = new JTextField();
        JPasswordField senhaField = new JPasswordField();  // Campo de senha oculta

        // Painel de entrada com layout vertical (empilhado)
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);

        // Mostra uma janela modal com botões OK e Cancelar
        int result = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION);

        // Se o usuário clicar em OK, tenta fazer login
        if (result == JOptionPane.OK_OPTION) {
            try (Connection con = conexaoBD.conectar()) {  // Tenta abrir conexão com o banco
                // SQL para buscar usuário com o CPF e senha fornecidos
                String sql = "SELECT * FROM users WHERE cpf = ? AND senha = ?";
                PreparedStatement stmt = con.prepareStatement(sql);  // Prepara a query com segurança
                stmt.setString(1, cpfField.getText());  // Define o valor do CPF na query
                stmt.setString(2, new String(senhaField.getPassword()));  // Define a senha (converte para String)

                ResultSet rs = stmt.executeQuery();  // Executa a consulta no banco

                // Se encontrou um registro, login está correto
                if (rs.next()) {
                    tipoUsuario = rs.getString("tipo_usuario");  // Pega o tipo de usuário (ex: cliente, operador)
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido como " + tipoUsuario);
                    return true;  // Login OK
                } else {
                    // Se não encontrou registro, CPF ou senha estão errados
                    JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
                    return false;
                }
            } catch (Exception e) {
                // Caso aconteça algum erro de conexão ou SQL
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                return false;
            }
        }

        // Se o usuário clicou em "Cancelar", retorna false
        return false;
    }
}
