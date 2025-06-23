package Sistema.Controller;
// Pacote controlador do sistema, onde ficam as classes que controlam a lógica de cadastro, login, etc.

import javax.swing.*;
// Importa a biblioteca Swing para interface gráfica (JOptionPane, JPanel, JTextField, etc.)
import Sistema.Models.*;
// Importa todas as classes do pacote Models (Paciente, Operador...)
import Sistema.BancoDados.*;
// Importa classes responsáveis pelo banco de dados (listas) dos operadores e pacientes
import Sistema.View.Cadastro;
// Importa a view de cadastro para navegar entre telas
import Sistema.View.Login;
// Importa a view de login para navegar para tela de login

public class Cadastros {

    public void cadastroUsuario() {
        // Método que abre um formulário para cadastrar um paciente/usuário

        Login loginMenu = new Login(); // Instancia a tela de login
        boolean cadastrado = false; // Flag para controlar o loop do cadastro

        while (!cadastrado) {
            // Campos do formulário
            JTextField nomeField = new JTextField();
            JTextField sobrenomeField = new JTextField();
            JTextField cpfField = new JTextField();
            JPasswordField senhaField = new JPasswordField();

            // Painel do formulário
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

            // Exibe o formulário
            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Pega os dados digitados
                String nome = nomeField.getText().trim();
                String sobrenome = sobrenomeField.getText().trim();
                String cpf = cpfField.getText().trim();
                String senha = new String(senhaField.getPassword());

                // Validação simples
                if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    continue; // Volta pro começo do loop
                }

                // Validação: CPF já existe?
                boolean cpfExiste = BancoPacientes.getPacientes().stream()
                        .anyMatch(p -> p.getCpf().equals(cpf));
                if (cpfExiste) {
                    JOptionPane.showMessageDialog(null, "Já existe um usuário com esse CPF!");
                    continue;
                }

                // Cria o objeto Paciente com os dados preenchidos
                Paciente paciente = new Paciente(nome, sobrenome, cpf, senha);

                // Adiciona no banco
                BancoPacientes.adicionarPaciente(paciente);

                // Mensagem de sucesso e redirecionamento pro login
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                cadastrado = true;
                loginMenu.logar();

            } else {
                // Se o usuário cancelar, volta para o menu de cadastro
                new Cadastro().cadastrar();
                break;
            }
        }
    }

    public void cadastroOperador() {
        // Método que abre formulário para cadastrar um operador

        // Campos do formulário
        JTextField nomeField = new JTextField();
        JTextField sobrenomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField idFuncionario = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        // Monta painel com os campos
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

        // Exibe o formulário
        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Operador", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Recupera os valores preenchidos
            String nome = nomeField.getText().trim();
            String sobrenome = sobrenomeField.getText().trim();
            String cpf = cpfField.getText().trim();
            String idFunc = idFuncionario.getText().trim();
            String senha = new String(senhaField.getPassword());

            // Validação simples
            if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty() || idFunc.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            // Cria o operador com os dados já preenchidos
            Operador operador = new Operador(nome, sobrenome, cpf, senha, idFunc);

            // Adiciona no banco
            BancoOperadores.adicionarOperador(operador);

            // Mensagem de sucesso e redirecionamento para login
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            JOptionPane.showMessageDialog(null, "Clique em OK para ser direcionado ao login");

            new Login().logar();
        } else {
            // Se cancelar, volta pro menu de cadastro
            new Cadastro().cadastrar();
        }
    }
}
