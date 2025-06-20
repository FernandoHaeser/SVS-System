package Sistema.Models;

import Sistema.Interfaces.Autenticavel;

public abstract class Usuario implements Autenticavel {

    private String primeiroNome;
    private String ultimoNome;
    private String cpf;
    private String senha;

    public Usuario(String primeiroNome, String ultimoNome, String cpf) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos!");
        } else {
            this.cpf = cpf;
        }
    }

    // Implementação da interface Autenticavel
    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public boolean autenticar(String senha) {
        return this.senha != null && this.senha.equals(senha);
    }

    // Método abstrato
    public abstract String mostrarInfos();
}
