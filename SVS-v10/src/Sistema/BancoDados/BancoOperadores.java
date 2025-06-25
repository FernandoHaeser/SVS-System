package Sistema.BancoDados;

// Importa a classe ArrayList, que é uma lista dinâmica que pode crescer conforme adicionamos elementos
import java.util.ArrayList;

// Importa a classe Operador, que representa os operadores que vamos armazenar nesta "tabela"
import Sistema.Models.Operador;

public class BancoOperadores {

    // Declara uma lista estática e privada que armazena objetos do tipo Operador
    // 'static' significa que essa lista é compartilhada por toda a classe e não por instâncias
    private static ArrayList<Operador> operadores = new ArrayList<>();

    /**
     * Adiciona um novo Operador à lista de operadores.
     * Método estático para poder ser chamado sem criar um objeto da classe BancoOperadores.
     *
     * @param operador O objeto Operador que será adicionado na lista
     */

    public static void adicionarOperador(Operador operador) {
        operadores.add(operador);  // Adiciona o operador ao final da lista

        // Dica para debugar: imprime o nome do operador cadastrado no console
        System.out.println("Operador adicionado: " + operador.getPrimeiroNome());
    }

    /**
     * Retorna a lista completa de operadores cadastrados.
     *
     * @return ArrayList contendo todos os objetos Operador armazenados
     */

    public static ArrayList<Operador> getOperadores() {
        return operadores;  // Retorna a lista para consulta ou manipulação externa
    }
}
