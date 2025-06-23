package Sistema.Models;

import Sistema.Interfaces.Autenticavel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Classe que representa um Paciente no sistema,
 * herdando de Usuario e implementando autenticação.
 */
public class Paciente extends Usuario {

    // Lista que armazena todas as vacinas registradas para o paciente
    private ArrayList<Vacina> vacinas;

    /**
     * Construtor da classe Paciente, inicializa dados básicos e lista de vacinas.
     *
     * @param primeiroNome Primeiro nome do paciente
     * @param ultimoNome Sobrenome do paciente
     * @param cpf CPF do paciente
     * @param senha Senha do paciente
     */
    public Paciente(String primeiroNome, String ultimoNome, String cpf, String senha) {
        super(primeiroNome, ultimoNome, cpf);
        this.vacinas = new ArrayList<>(); // Inicializa a lista de vacinas vazia
    }

    /**
     * Seta a senha do paciente.
     * Exibe mensagem alertando sobre tamanho da senha (pode melhorar aqui futuramente).
     *
     * @param senha Nova senha a ser definida
     */
    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
        JOptionPane.showMessageDialog(null, "A senha precisa ser maior!");
    }

    /**
     * Adiciona uma vacina à lista de vacinas do paciente.
     *
     * @param vacina Objeto Vacina a ser adicionado
     */
    public void adicionarVacina(Vacina vacina) {
        if (vacina != null) {
            vacinas.add(vacina);
        }
    }

    /**
     * Retorna a lista de vacinas do paciente.
     *
     * @return ArrayList com as vacinas cadastradas
     */
    public ArrayList<Vacina> getVacinas() {
        return vacinas;
    }

    /**
     * Retorna uma String formatada contendo o histórico de vacinação.
     *
     * @return Histórico das vacinas em formato texto
     */
    public String exibirHistoricoVacinas() {
        if (vacinas.isEmpty()) {
            return "Nenhuma vacina registrada.";
        }

        StringBuilder historico = new StringBuilder("Histórico de Vacinação:\n");
        for (Vacina vacina : vacinas) {
            historico.append(vacina.toString()).append("\n");
        }

        return historico.toString();
    }

    /**
     * Método para autenticar paciente comparando senhas.
     *
     * @param senha Senha informada para autenticação
     * @return true se senha correta, false caso contrário
     */
    @Override
    public boolean autenticar(String senha) {
        return getSenha().equals(senha);
    }

    /**
     * Retorna informações do paciente formatadas em String.
     *
     * @return Informações básicas do paciente
     */
    @Override
    public String mostrarInfos() {
        return "Paciente:\n" +
                "Nome: " + getPrimeiroNome() + " " + getUltimoNome() + "\n" +
                "CPF: " + getCpf();
    }
}
