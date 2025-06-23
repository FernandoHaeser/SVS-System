package Sistema.BancoDados;
// Define o pacote onde essa classe está, organizando o projeto

import java.util.ArrayList;
// Importa a classe ArrayList, que é uma lista dinâmica para guardar objetos

import Sistema.Models.Operador;
// Importa a classe Operador, que provavelmente representa os operadores do sistema

public class BancoOperadores {
	// Declara a classe BancoOperadores, que será responsável por gerenciar os operadores

	private static ArrayList<Operador> operadores = new ArrayList<>();
	// Cria uma lista estática para guardar os operadores cadastrados no sistema

	public static void adicionarOperador(Operador operador) {
		// Método público e estático para adicionar um operador na lista
		operadores.add(operador);
		// Adiciona o operador recebido como parâmetro na lista de operadores
	}

	public static Operador buscarPorCpfESenha(String cpf, String senha) {
		// Método para buscar um operador na lista que tenha o CPF e a senha passados
		for (Operador o : operadores) {
			// Para cada operador 'o' dentro da lista operadores
			if (o.getCpf().equals(cpf) && o.getSenha().equals(senha))
				// Se o CPF e a senha do operador 'o' forem iguais aos passados como argumento
				return o;
			// Retorna o operador encontrado
		}
		return null;
		// Se nenhum operador for encontrado com esse CPF e senha, retorna null
	}

	public static ArrayList<Operador> getOperadores() {
		// Método para pegar a lista completa de operadores cadastrados
		return operadores;
		// Retorna a lista estática de operadores
	}
}
