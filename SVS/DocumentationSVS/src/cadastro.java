package Autenticacoes;  // Pacote onde essa classe está organizada (ajuda a manter o projeto arrumado)

import javax.swing.*;  // Importa componentes para interface gráfica (JOptionPane, JTextField, etc)
import java.sql.Connection;  // Importa para trabalhar com conexão ao banco de dados
import java.sql.PreparedStatement;  // Importa para preparar comandos SQL seguros (evita SQL Injection)
import ConexaoBanco.conexaoBD;  // Importa sua classe que gerencia conexão com banco

public class cadastroUsuario {  // Classe que gerencia o cadastro dos usuários
    public static void cadastrar() {  // Método estático para abrir a tela e salvar o usuário no banco

        // Criando os campos de texto para o usuário preencher os dados:
        JTextField nomeField = new JTextField();  // Campo para o primeiro nome
        JTextField sobrenomeField = new JTextField();  // Campo para o sobrenome
        JTextField cpfField = new JTextField();  // Campo para CPF (identificação)
        JPasswordField senhaField = new JPasswordField();  // Campo para senha (texto oculto)

        // Criando um painel para organizar os campos e labels na interface
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  // Layout vertical para os componentes ficarem empilhados

        // Adicionando os labels e os campos ao painel na ordem que aparecem para o usuário
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Sobrenome:"));
        panel.add(sobrenomeField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);

        // Exibe o formulário em uma janela modal com botões OK e Cancelar
        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION);

        // Verifica se o usuário clicou em OK para continuar o cadastro
        if (result == JOptionPane.OK_OPTION) {
            // Tenta conectar ao banco de dados e inserir os dados
            try (Connection con = conexaoBD.conectar()) {  // Abre conexão com banco, fecha automaticamente ao final

                // SQL para inserir um novo registro na tabela 'users'
                String sql = "INSERT INTO users (primeiro_nome, ultimo_nome, cpf, senha, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);  // Prepara a query para evitar SQL Injection

                // Seta os valores nos '?' da query, usando os textos que o usuário digitou
                stmt.setString(1, nomeField.getText());
                stmt.setString(2, sobrenomeField.getText());
                stmt.setString(3, cpfField.getText());
                stmt.setString(4, new String(senhaField.getPassword()));  // Converte a senha de char[] para String (atenção: salvar senha em texto puro é inseguro, ideal usar hash)
                stmt.setString(5, "cliente");  // Define o tipo de usuário como "cliente" por padrão

                stmt.executeUpdate();  // Executa a inserção no banco

                // Mostra mensagem de sucesso para o usuário
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

            } catch (Exception e) {
                // Se ocorrer erro, mostra mensagem com a descrição do problema
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }
}