package Sistema.Models;

public class Operador extends Usuario{

    private String idFuncionario;

    public Operador(String primeiroNome, String ultimoNome, String cpf, String senha, String idFuncionario) {
        super(primeiroNome, ultimoNome, cpf, senha);
        this.idFuncionario = idFuncionario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
