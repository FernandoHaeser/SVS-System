package Sistema.Controller;

import javax.swing.*;

import Sistema.BancoDados.BancoOperadores;
import Sistema.BancoDados.BancoPacientes;
import Sistema.Models.*;
import Sistema.View.Login;
import Sistema.View.MenuOperador;
import Sistema.View.MenuUsuario;

public class Logins {

    // Objetos para chamar os menus após login
    MenuUsuario menuUsuario = new MenuUsuario();
    MenuOperador menuOperador = new MenuOperador();
    Login menu = new Login();

    /**
     * Método responsável por realizar o login de um paciente (usuário).
     * Verifica se o CPF e a senha existem no "banco" (ArrayList).
     */

    public void loginPaciente() {
        boolean logado = false;

        System.out.println("Iniciando login de paciente..."); // DEBUG

        // Campos de entrada
        JTextField cpfField = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        while (!logado) {

            // Painel que vai organizar os campos
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("CPF:"));
            panel.add(cpfField);
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);

            // Exibe caixa de login
            int result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Login Usuário",
                    JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String cpf = cpfField.getText().trim(); // remove espaços antes/depois
                String senha = new String(senhaField.getPassword()); // transforma em String

                System.out.println("Tentando login com CPF: " + cpf); // DEBUG

                if (cpf.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    System.out.println("Campos vazios no login."); // DEBUG
                    continue;
                }

                boolean loginSucesso = false;

                // Verifica se algum paciente cadastrado tem o mesmo CPF e senha
                for (Paciente p : BancoPacientes.getPacientes()) {
                    if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                                + p.getPrimeiroNome() + " " + p.getUltimoNome());

                        System.out.println("Login realizado para: " + p.getPrimeiroNome()); // DEBUG

                        loginSucesso = true;
                        menuUsuario.menuUsuario(p); // Chama o menu do paciente
                        break;
                    }
                }

                if (loginSucesso) {
                    logado = true; // Sai do loop
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou senha inválidos!");
                    System.out.println("CPF ou senha inválidos."); // DEBUG
                    // Loop continua
                }

            } else {
                // Se o usuário clicar em "Cancelar" ou fechar
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    System.out.println("Usuário cancelou login. Voltando..."); // DEBUG
                    menu.logar(); // Volta pro menu de login
                    break;
                }
            }
        }

        System.out.println("Finalizando login de paciente."); // DEBUG
    }

    /**
     * Método responsável por realizar o login de um operador.
     * Compara ID e senha com os dados do banco de operadores.
     */

    public void loginOperador() {

        boolean logado = false;

        // Campos de entrada
        JTextField idFuncionarioField = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        System.out.println("Iniciando login de operador..."); // DEBUG

        while (!logado) {
            // Painel com os campos
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

                System.out.println("Tentando login com ID: " + id); // DEBUG

                if (id.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    System.out.println("Campos vazios no login de operador."); // DEBUG
                    continue;
                }

                boolean loginSucesso = false;

                // Busca nos operadores cadastrados
                for (Operador o : BancoOperadores.getOperadores()) {
                    if (o.getIdFuncionario().equals(id) && o.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, "
                                + o.getPrimeiroNome() + " " + o.getUltimoNome());

                        System.out.println("Login de operador realizado: " + o.getPrimeiroNome()); // DEBUG

                        loginSucesso = true;
                        menuOperador.menuOperador(o); // Vai pro menu do operador
                        break;
                    }
                }

                if (loginSucesso) {
                    logado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "ID ou senha inválidos!");
                    System.out.println("ID ou senha inválidos no login de operador."); // DEBUG
                }

            } else {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Você tem certeza que quer voltar?", null, JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    System.out.println("Login cancelado. Voltando ao menu."); // DEBUG
                    menu.logar();
                    break;
                }
            }
        }

        System.out.println("Finalizando login de operador."); // DEBUG
    }
}
