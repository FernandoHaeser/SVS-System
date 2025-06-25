package Sistema.BancoDados;

// Importa a lista dinâmica ArrayList para armazenar pacientes
import java.util.ArrayList;

// Importa a classe Paciente que será armazenada aqui
import Sistema.Models.Paciente;

public class BancoPacientes {

    // Lista estática que armazena todos os pacientes cadastrados no sistema
    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    /**
     * Método para adicionar um novo paciente à lista.
     * É estático para poder ser usado sem instanciar BancoPacientes.
     *
     * @param paciente Objeto Paciente que será adicionado à lista
     */

    public static void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente); // Adiciona paciente ao final da lista

        // Debug: imprime o nome do paciente adicionado no console
        System.out.println("Paciente adicionado: " + paciente.getPrimeiroNome());
    }

    /**
     * Busca e retorna o paciente com o CPF informado.
     * Se não encontrar, retorna null.
     *
     * @param cpf CPF a ser buscado
     * @return Paciente com o CPF correspondente ou null se não achar
     */

    public static Paciente buscarPorCpf(String cpf) {

        // Percorre cada paciente da lista para comparar CPF
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p; // Se o CPF bater, retorna o paciente encontrado
            }
        }

        // Se nenhum paciente foi encontrado com esse CPF, retorna null
        return null;
    }

    /**
     * Retorna a lista completa de pacientes cadastrados.
     *
     * @return ArrayList de Paciente com todos os pacientes
     */

    public static ArrayList<Paciente> getPacientes() {
        return pacientes; // Retorna a lista para consulta externa
    }
}
