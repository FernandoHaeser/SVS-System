package Sistema.Models;

public class Operador extends Usuario {

    private String idFuncionario;

    public Operador(String primeiroNome, String ultimoNome, String cpf, String senha, String idFuncionario) {
        super(primeiroNome, ultimoNome, cpf);
        this.idFuncionario = idFuncionario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public boolean autenticar(String senha) {
        return getSenha().equals(senha);
    }

    @Override
    public String mostrarInfos() {
        return "ID de Funcionário: " + idFuncionario + "\n" +
                "Nome: " + getPrimeiroNome() + " " + getUltimoNome() + "\n" +
                "CPF: " + getCpf() + "\n\n" +
                "SVS - System";
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);

    }
}