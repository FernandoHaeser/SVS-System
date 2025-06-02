package ConexaoBanco;  // Define o pacote onde está essa classe (organização do projeto)

import java.sql.Connection;         // Classe que representa uma conexão com o banco
import java.sql.DriverManager;      // Classe responsável por gerenciar os drivers e conexões
import java.sql.SQLException;       // Exceção que trata erros de banco de dados

public class conexaoBD {  // Classe que cuida da conexão com o banco de dados

    // URL de conexão: tipo do banco (jdbc:mysql), local (localhost), porta (3306), e nome do banco (sistema_vacinacao)
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_vacinacao";

    // Usuário do banco de dados — normalmente é "root" em ambientes locais
    private static final String USER = "root";

    // Senha do banco — vazia nesse caso (mas não é recomendado em produção!)
    private static final String PASSWORD = "";

    // Método público e estático que pode ser chamado de qualquer lugar pra obter uma conexão com o banco
    public static Connection conectar() throws SQLException {
        // Retorna uma conexão ativa com os dados passados (URL, usuário, senha)
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
