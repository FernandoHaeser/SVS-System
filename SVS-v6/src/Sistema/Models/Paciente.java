package Sistema.Models;

public class Paciente extends Usuario {

    public Paciente(String primeiroNome, String ultimoNome, String cpf, String senha) {
        super(primeiroNome, ultimoNome, cpf, senha);
    }

    public static void adicionarVacina(Vacina vacina) {
            vacinas.add(vacina);
            System.out.println("Vacina adicionada: " + vacina);
        }

    }
}
