package Sistema.Controller;

import javax.swing.*;

import Sistema.Models.*;
import Sistema.BancoDados.*;
import Sistema.View.Cadastro;
import Sistema.View.Login;

public class Cadastros {

    /**
     * Método responsável por cadastrar um novo paciente (usuário).
     * Utiliza uma interface gráfica com JOptionPane para entrada dos dados.
     * Só finaliza quando os dados forem válidos e o paciente for cadastrado com sucesso.
     */

    public void cadastroUsuario() {

        Login loginMenu = new Login(); // Cria instância da tela de login
        boolean cadastrado = false; // Controla se o cadastro foi feito

        System.out.println("Iniciando cadastro de paciente..."); // DEBUG

        // Campos de entrada de dados
        JTextField nomeField = new JTextField();
        JTextField sobrenomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JPasswordField senhaField2 = new JPasswordField();

        while (!cadastrado) {

            // Monta painel com os campos na vertical
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
            panel.add(new JLabel("Repita a Senha:"));
            panel.add(senhaField2);

            // Exibe caixa de diálogo para preenchimento
            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Pega os dados digitados, removendo espaços antes/depois com .trim()
                String nome = nomeField.getText().trim();
                String sobrenome = sobrenomeField.getText().trim();
                String cpf = cpfField.getText().trim();
                String senha = new String(senhaField.getPassword());
                String senha2 = new String(senhaField2.getPassword());

                // Valida se todos os campos foram preenchidos
                if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    System.out.println("Tentativa de cadastro com campos vazios."); // DEBUG
                    continue;
                }

                //Valida se as senhas são as mesmas
                if (!senha.equals(senha2)) {
                    JOptionPane.showMessageDialog(
                            null,
                            "AS SENHAS NÃO COINCIDEM!",
                            "ERRO!",
                            JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                // Verifica tamanho mínimo da senha
                if (senha.length() < 6) {
                    JOptionPane.showMessageDialog(null,
                            "A senha deve ter mais de 6 dígitos!",
                            "ERRO",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println("Senha inválida (menos de 6 caracteres)."); // DEBUG

                } else {

                    // Cria objeto paciente com os dados informados
                    Paciente paciente = new Paciente(nome, sobrenome, cpf, senha);
                    System.out.println("Paciente criado: " + nome + " " + sobrenome + " | CPF: " + cpf); // DEBUG

                    String dados =
                            "Seus dados estão de acordo?" + "\n\n" +
                                    "Nome: " + nome + "\n" +
                                    "Sobrenome: " + sobrenome + "\n" +
                                    "CPF: " + cpf + "\n" +
                                    "Senha: " + senha + "\n";

                    int escolha = JOptionPane.showConfirmDialog(null,
                            dados,
                            "ATENÇÃO!",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (escolha == JOptionPane.CANCEL_OPTION) {
                        continue;

                    } else {
                        // Cadastra o paciente no banco de dados simulado
                        BancoPacientes.adicionarPaciente(paciente);
                        System.out.println("Paciente adicionado ao banco."); // DEBUG

                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                        JOptionPane.showMessageDialog(null,
                                "Direcionando você ao menu de login...");
                        cadastrado = true;

                        // Redireciona para o login
                        loginMenu.logar();

                        // Limpa os campos
                        nomeField.setText("");
                        sobrenomeField.setText("");
                        cpfField.setText("");
                        senhaField.setText("");
                        senhaField2.setText("");
                    }
                }
            } else {
                // Se o usuário cancelar o cadastro
                Cadastro menuCadastrar = new Cadastro();
                menuCadastrar.cadastrar();
                System.out.println("Cadastro cancelado."); // DEBUG
                break;
            }
            System.out.println("Cadastro de paciente finalizado."); // DEBUG
        }
    }

    /**
     * Método responsável por cadastrar um novo operador do sistema.
     * Valida os campos e adiciona o operador no banco em memória.
     */

    public void cadastroOperador() {

        Login loginMenu = new Login(); // Instância da tela de login
        boolean cadastrado = false;

        System.out.println("Iniciando cadastro de operador..."); // DEBUG

        // Campos de entrada
        JTextField nomeField = new JTextField();
        JTextField sobrenomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField idFuncionarioField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JPasswordField senhaField2 = new JPasswordField();

        while (!cadastrado) {

            // Painel com os campos
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Nome:"));
            panel.add(nomeField);
            panel.add(new JLabel("Sobrenome:"));
            panel.add(sobrenomeField);
            panel.add(new JLabel("CPF:"));
            panel.add(cpfField);
            panel.add(new JLabel("ID Funcionário:"));
            panel.add(idFuncionarioField);
            panel.add(new JLabel("Senha:"));
            panel.add(senhaField);
            panel.add(new JLabel("Repita Senha:"));
            panel.add(senhaField2);
            // Caixa de diálogo
            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Operador", JOptionPane.OK_CANCEL_OPTION);


            if (result == JOptionPane.OK_OPTION) {
                // Pega e limpa os dados
                String nome = nomeField.getText().trim();
                String sobrenome = sobrenomeField.getText().trim();
                String cpf = cpfField.getText().trim();
                String idFuncionario = idFuncionarioField.getText().trim();
                String senha = new String(senhaField.getPassword());
                String senha2 = new String(senhaField2.getPassword());

                // Verifica se todos os campos estão preenchidos
                if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty() || idFuncionario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    System.out.println("Tentativa de cadastro de operador com campos vazios."); // DEBUG
                    continue;
                }

                //Valida se as senhas são as mesmas
                if (!senha.equals(senha2)) {
                    JOptionPane.showMessageDialog(
                            null,
                            "AS SENHAS NÃO COINCIDEM!",
                            "ERRO!",
                            JOptionPane.ERROR_MESSAGE);
                    continue;
                }


                // Valida CPF: o mesmo deve ter 11 dígitos no total.
                if (cpf.length() != 11) {
                    JOptionPane.showMessageDialog(
                            null,
                            "O CPF deve ter 11 dígitos!",
                            "ERRO!",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println("CPF inserido inválido! Tamanho deve ser de 11."); // DEBUG
                }

                // Valida senha: precisa ter mais de 6 caracteres E conter "svs"
                if (senha.length() <= 6 || !senha.contains("svs")) {
                    JOptionPane.showMessageDialog(null,
                            "A senha deve ter mais ou ser igual a 6 caracteres e conter a abreviação 'svs'!",
                            "ERRO",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println("Senha de operador inválida."); // DEBUG
                    continue;

                } else {
                    // Cria o operador
                    Operador operador = new Operador(nome, sobrenome, cpf, senha, idFuncionario);
                    System.out.println("Operador criado: " + nome + " " + sobrenome + " | ID: " + idFuncionario); // DEBUG

                    String dados =
                            "Seus dados estão de acordo?" + "\n\n" +
                                    "Nome: " + nome + "\n" +
                                    "Sobrenome: " + sobrenome + "\n" +
                                    "ID de Funcionário: " + idFuncionario + "\n" +
                                    "CPF:" + cpf + "\n" +
                                    "Senha: " + senha + "\n";

                    int escolha = JOptionPane.showConfirmDialog(null,
                            dados,
                            "ATENÇÃO!",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (escolha == JOptionPane.CANCEL_OPTION) {
                        continue;
                    } else {
                        // Adiciona ao banco
                        BancoOperadores.adicionarOperador(operador);
                        System.out.println("Operador adicionado ao banco."); // DEBUG

                        // Mensagens e redirecionamento
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                        JOptionPane.showMessageDialog(null,
                                "Direcionando você ao menu de login...");

                        cadastrado = true;
                        loginMenu.logar();

                        //Limpa os campos
                        nomeField.setText("");
                        sobrenomeField.setText("");
                        cpfField.setText("");
                        senhaField.setText("");
                        senhaField2.setText("");
                    }
                }
            } else {
                Cadastro menuCadastrar = new Cadastro();
                menuCadastrar.cadastrar();
                System.out.println("Cadastro de operador cancelado."); // DEBUG
                break;
            }
            System.out.println("Cadastro de operador finalizado."); // DEBUG
        }
    }
}
