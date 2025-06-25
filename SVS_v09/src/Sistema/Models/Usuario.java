package Sistema.Models;

// Importa a interface que define o contrato de autenticação
import Sistema.Interfaces.Autenticavel;

/**
 * Classe abstrata que representa um usuário genérico do sistema (superclasse).
 * É implementada pelas classes concretas Paciente e Operador.
 * Também implementa a interface Autenticavel.
 */

public abstract class Usuario implements Autenticavel {

    // Atributos protegidos por encapsulamento (visibilidade privada)
    private String primeiroNome;
    private String ultimoNome;
    private String cpf;
    private String senha;

    /**
     * Construtor da classe Usuario.
     *
     * @param primeiroNome Primeiro nome do usuário
     * @param ultimoNome   Sobrenome do usuário
     * @param cpf          CPF do usuário
     */

    public Usuario(String primeiroNome, String ultimoNome, String cpf) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.cpf = cpf;
    }

    // Getters permitem o acesso controlado aos atributos privados

    /**
     * Retorna o primeiro nome do usuário.
     */

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     * Retorna o sobrenome do usuário.
     */

    public String getUltimoNome() {
        return ultimoNome;
    }

    /**
     * Retorna o CPF do usuário.
     */

    public String getCpf() {
        return cpf;
    }

    // Implementação do método da interface Autenticavel

    /**
     * Define a senha do usuário.
     * Esse método pode ser sobrescrito nas classes filhas para aplicar validações específicas.
     *
     * @param senha A nova senha
     */

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
        System.out.println("Senha definida para usuário: " + primeiroNome + " " + ultimoNome);
    }

    /**
     * Retorna a senha do usuário (usada para autenticação).
     * OBS: Em sistemas reais, nunca se retorna a senha em texto plano!
     */

    public String getSenha() {
        return senha;
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     * Serve para exibir as informações específicas do tipo de usuário.
     *
     * @return String formatada com as informações.
     */

    public abstract String mostrarInfos();
}
