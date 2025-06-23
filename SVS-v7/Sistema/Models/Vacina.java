package Sistema.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vacina {

    private String nomeVacina;
    private String marcaVacina;
    private String dataAplicacao; // armazenando como String no formato dd/MM/yyyy

    public Vacina(String nomeVacina, String marcaVacina, String dataAplicacao) {
        this.nomeVacina = nomeVacina;
        this.marcaVacina = marcaVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getMarcaVacina() {
        return marcaVacina;
    }

    public void setMarcaVacina(String marcaVacina) {
        this.marcaVacina = marcaVacina;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    @Override
    public String toString() {
        // Aqui a gente tenta transformar a String em Date só pra formatar bonitinho no toString
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy"); // só pra garantir a formatação

        String dataFormatada = dataAplicacao; // fallback caso dê erro

        try {
            Date data = inputFormat.parse(dataAplicacao);
            dataFormatada = outputFormat.format(data);
        } catch (ParseException e) {
            // Se não conseguir parsear, mantém o valor original da String mesmo
        }

        return "Vacina{" +
                "nomeVacina='" + nomeVacina + '\'' +
                ", marcaVacina='" + marcaVacina + '\'' +
                ", dataAplicacao='" + dataFormatada + '\'' +
                '}';
    }
}
