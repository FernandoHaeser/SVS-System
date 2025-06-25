package Sistema.Models;

import Sistema.Interfaces.Logavel;

/**
 * A classe Vacina representa uma dose de vacina aplicada a um paciente.
 * Contém informações básicas como o nome da vacina, sua marca e a data de aplicação.
 */

public class Vacina implements Logavel {

    // Atributos privados para garantir o encapsulamento dos dados
    private String nomeVacina;
    private String marcaVacina;
    private String dataAplicacao;

    /**
     * Construtor da classe Vacina.
     *
     * @param nomeVacina     Nome da vacina (ex: COVID-19, Febre Amarela)
     * @param marcaVacina    Marca ou fabricante da vacina (ex: Pfizer, Butantan)
     * @param dataAplicacao  Data em que a vacina foi aplicada (ex: "24/06/2025")
     */

    public Vacina(String nomeVacina, String marcaVacina, String dataAplicacao) {
        this.nomeVacina = nomeVacina;
        this.marcaVacina = marcaVacina;
        this.dataAplicacao = dataAplicacao;
    }

    /**
     * Sobrescreve o método toString() para formatar os dados da vacina
     * de forma legível ao usuário (exibido nos históricos).
     *
     * @return String formatada com os dados da vacina.
     */

    @Override
    public String toString() {
        return  "\n" + "• Nome da Vacina: " + nomeVacina + "\n" +
                "• Marca da Vacina: " + marcaVacina + "\n" +
                "• Data de Aplicação: " + dataAplicacao + "\n";
    }

    @Override
    public void registrarLog() {
        System.out.println("Vacina registrada: " + nomeVacina + " | " + marcaVacina + " | " + dataAplicacao); // DEBUG
    }
}
