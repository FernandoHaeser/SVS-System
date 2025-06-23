package Sistema.Controller;
// Pacote onde estão os controladores (lógica do sistema)

import javax.swing.*;
// Importa os componentes gráficos (JOptionPane, JPanel, JTextField, etc.)

import Sistema.BancoDados.BancoOperadores;
import Sistema.BancoDados.BancoPacientes;
// Importa os "bancos de dados" simulados com listas estáticas

import Sistema.Models.*;
// Importa os modelos de usuário: Paciente e Operador

import Sistema.View.Login;
import Sistema.View.MenuOperador;
import Sistema.View.MenuUsuario;
// Importa as telas de interface gráfica do usuário e do operador

public class Logins {
    // Classe responsável por gerenciar o login de pacientes e operadores

    MenuUsuario menuUsuario = new MenuUsuario(); // Tela de menu para o usuário
    MenuOperador menuOperador = new MenuOperador(); // Tela de menu para o operador
    Login menu = new Login(); // Tela de login principal (onde escolhe o tipo de login)

    public void loginPaciente() {
        // Método que gerencia o login do paciente

        boolean logado = false; // Flag de controle para manter o loop até login correto

        while (!logado) {
            // Criação dos campos de entrada
            JTextField cpfField = new JTextField();
            JPasswordField senhaField = new JPasswordField();

            // Painel com campos
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("CPF:"));
            panel.add(cpfField);
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);

            // Mostra o diálogo de login
            int result = JOptionPane.showConfirmDialog(
                    null, panel, "Login Usuário", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Se o usuário clicou em OK, pega os valores digitados
                String cpf = cpfField.getText().trim(); // remove espaços antes e depois
                String senha = new String(senhaField.getPassword());

                // Valida se os campos estão vazios
                if (cpf.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    continue; // volta pro começo do loop
                }

                boolean loginSucesso = false;

                // Percorre a lista de pacientes cadastrados
                for (Paciente p : BancoPacientes.getPacientes()) {
                    if (p.getCpf().equals(cpf) && p.autenticar(senha)) {
                        // Se CPF e senha conferem, login é bem-sucedido
                        JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                                + p.getPrimeiroNome() + " " + p.getUltimoNome());

                        loginSucesso = true;
                        menuUsuario.menuUsuario(p); // Vai para o menu do paciente
                        break;
                    }
                }

                if (loginSucesso) {
                    logado = true; // sai do loop
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha inválidos!");
                }

            } else {
                // Se clicou em "Cancelar"
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    menu.logar(); // Volta para o menu inicial de login
                    break;
                }
            }
        }
    }

    public void loginOperador() {
        // Método que gerencia o login de operador

        boolean logado = false; // Controle do loop

        while (!logado) {
            // Campos de entrada
            JTextField idFuncionarioField = new JTextField();
            JPasswordField senhaField = new JPasswordField();

            // Painel com os campos
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("ID:"));
            panel.add(idFuncionarioField);
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);

            // Mostra a janela de login
            int result = JOptionPane.showConfirmDialog(null, panel, "Login Operador", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Pega os dados digitados
                String id = idFuncionarioField.getText().trim();
                String senha = new String(senhaField.getPassword());

                // Validação de campos
                if (id.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    continue; // volta pro início do loop
                }

                boolean loginSucesso = false;

                // Procura o operador pelo ID e senha
                for (Operador o : BancoOperadores.getOperadores()) {
                    if (o.getIdFuncionario().equals(id) && o.autenticar(senha)) {
                        JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                                + o.getPrimeiroNome() + " " + o.getUltimoNome());

                        loginSucesso = true;
                        menuOperador.menuOperador(o); // Abre menu do operador
                        break;
                    }
                }

                if (loginSucesso) {
                    logado = true; // login OK, sai do loop
                } else {
                    JOptionPane.showMessageDialog(null, "ID ou senha inválidos!");
                }

            } else {
                // Se clicou em "Cancelar"
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    menu.logar(); // Volta pro menu de login
                    break;
                }
            }
        }
    }
}
