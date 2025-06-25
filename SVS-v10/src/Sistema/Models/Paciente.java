package Sistema.Models;

import Sistema.Interfaces.Logavel;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Paciente representa um usuário do tipo paciente no sistema,
 * contendo informações pessoais herdadas da classe Usuario e
 * um histórico de vacinas aplicadas.
 */

public class Paciente extends Usuario implements Logavel {

    // Lista para armazenar todas as vacinas aplicadas ao paciente
    private List<Vacina> vacinas;

    /**
     * Construtor do paciente.
     *
     * @param primeiroNome Primeiro nome do paciente
     * @param ultimoNome   Sobrenome do paciente
     * @param cpf          CPF do paciente
     * @param senha        Senha do paciente
     */

    public Paciente(String primeiroNome, String ultimoNome, String cpf, String senha) {
        super(primeiroNome, ultimoNome, cpf); // Chamada ao construtor da superclasse Usuario
        this.vacinas = new ArrayList<>(); // Cria uma lista vazia de vacinas
        setSenha(senha); // Define a senha do paciente com validação (mínimo 7 caracteres)
    }

    public void setPrimeiroNome(String primeiroNome) {
        super.setPrimeiroNome(primeiroNome);
    }

    public void setUltimoNome(String ultimoNome) {
        super.setUltimoNome(ultimoNome);
    }

    /**
     * Define a senha do paciente.
     * A senha só é aceita se tiver mais de 6 caracteres.
     * <p>
     * Isso protege contra senhas fracas, como "123".
     *
     * @param senha A nova senha
     */

    @Override
    public void setSenha(String senha) {
        if (senha != null && senha.length() >= 6) {
            super.setSenha(senha);
        } else {
            System.out.println("Senha inválida para paciente: deve ter mais de 6 caracteres.");
        }
    }

    public String getSenha() {
        return super.getSenha();
    }

    /**
     * Adiciona uma vacina ao histórico do paciente.
     *
     * @param vacina A vacina a ser adicionada
     */

    public void adicionarVacina(Vacina vacina) {
        if (vacina != null) {
            vacinas.add(vacina);
            System.out.println("Vacina adicionada com sucesso para o paciente: " + getPrimeiroNome());
        }
    }

    /**
     * Exibe todas as vacinas registradas para o paciente.
     *
     * @return Texto formatado com o histórico ou uma mensagem informando que está vazio
     */

    public String exibirHistoricoVacinas() {
        if (vacinas.isEmpty()) {
            return "Nenhuma vacina registrada.";
        }

        StringBuilder historico = new StringBuilder("Histórico de Vacinação:");
        historico.append("\n");
        // Percorre a lista de vacinas e adiciona suas informações no texto
        for (Vacina vacina : vacinas) {
            historico.append(vacina.toString()).append("\n-----------------------------\n");
        }

        historico.append("\n\nSVS-SYSTEM");

        return historico.toString();
    }

    /**
     * Método sobrescrito da superclasse Usuario para exibir informações específicas do paciente.
     *
     * @return Informações básicas do paciente formatadas como string.
     */

    @Override
    public void registrarLog() {
        System.out.println("Paciente criado: " + getPrimeiroNome() + " " + getUltimoNome() + " | CPF: " + getCpf()); // DEBUG
    }

    @Override
    public String mostrarInfos() {
        return "Paciente\n" +
                "Nome: " + getPrimeiroNome() + " " + getUltimoNome() + "\n" +
                "CPF: " + getCpf() + "\n\n" +
                "SVS-SYSTEM";
    }
}
