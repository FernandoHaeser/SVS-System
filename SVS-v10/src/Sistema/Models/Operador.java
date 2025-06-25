package Sistema.Models;

import Sistema.Interfaces.Logavel;

/**
 * A classe Operador representa um usuário do tipo operador do sistema,
 * responsável por registrar vacinas e gerenciar dados.
 * Herda atributos e comportamentos da classe abstrata Usuario.
 */

public class Operador extends Usuario implements Logavel {

    // Identificador único do funcionário no sistema
    private String idFuncionario;

    /**
     * Construtor da classe Operador.
     *
     * @param primeiroNome  Primeiro nome do operador
     * @param ultimoNome    Sobrenome do operador
     * @param cpf           CPF do operador
     * @param senha         Senha do operador (com validação interna)
     * @param idFuncionario ID do funcionário
     */

    public Operador(String primeiroNome, String ultimoNome, String cpf, String senha, String idFuncionario) {
        super(primeiroNome, ultimoNome, cpf); // Chama o construtor da superclasse Usuario
        setSenha(senha); // Define a senha com a regra personalizada abaixo
        this.idFuncionario = idFuncionario; // Armazena o ID do operador
    }

    /**
     * Retorna o ID do funcionário (usado no login de operador).
     *
     * @return idFuncionario
     */

    public String getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Sobrescreve o método setSenha da superclasse Usuario.
     * Aqui, adicionamos uma regra: a senha só é aceita se tiver mais de 6 caracteres
     * e conter obrigatoriamente a string "svs".
     * <p>
     * Isso é uma forma de reforçar a segurança para operadores.
     */

    @Override
    public void setSenha(String senha) {
        // Verifica se a senha não é nula, tem mais de 6 caracteres e contém "svs"
        if (senha != null && senha.length() >= 6 && senha.contains("svs"))
            super.setSenha(senha); // Chama o método da superclasse para definir a senha
    }

    /**
     * Exibe as informações formatadas do operador.
     * Esse método é sobrescrito da classe Usuario (polimorfismo).
     *
     * @return String com dados pessoais do operador.
     */


    // Coleta a senha definida do operador.
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void registrarLog() {
        System.out.println("Operador criado: " + getPrimeiroNome() + " " + getUltimoNome()+ " | ID: " + getIdFuncionario()); // DEBUG
    }


    @Override
    public String mostrarInfos() {
        return "ID de Funcionário: " + idFuncionario + "\n" +
                "Nome: " + getPrimeiroNome() + " " + getUltimoNome() + "\n" +
                "CPF: " + getCpf() + "\n\n" +
                "SVS - System";
    }
}
