package Sistema.BancoDados;

import java.util.ArrayList;
import Sistema.Models.Operador;

public class BancoOperadores {
	private static ArrayList<Operador> operadores = new ArrayList<>();

	public static void adicionarOperador(Operador operador) {
		operadores.add(operador);
	}

	public static Operador buscarPorCpfESenha(String cpf, String senha) {
		for (Operador o : operadores) {

			if (o.getCpf().equals(cpf) && o.getSenha().equals(senha))
				return o;

		}
		return null;
	}

	public static ArrayList<Operador> getOperadores() {
		return operadores;
	}
}
