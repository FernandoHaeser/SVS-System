package Sistema.Models;

import java.util.Date;

public class Vacina {

    private String nomeVacina;
    private String marcaVacina;
    private Date dataAplicacao;
    private String descVacina;

    public Vacina (String nomeVacina, String marcaVacina, Date dataAplicacao, String descVacina) {
        this.nomeVacina = nomeVacina;
        this.marcaVacina = marcaVacina;
        this.dataAplicacao = dataAplicacao;
        this.descVacina = descVacina;
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

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getDescVacina() {
        return descVacina;
    }

    public void setDescVacina(String descVacina) {
        this.descVacina = descVacina;
    }


}
