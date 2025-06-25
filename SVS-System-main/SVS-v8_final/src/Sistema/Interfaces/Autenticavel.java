package Sistema.Interfaces;

/**
 * A interface Autenticavel define um contrato que obriga qualquer classe que a implemente
 * a possuir um método para definir a senha.
 *
 * Isso é útil para garantir que diferentes tipos de usuários (como Paciente, Operador, etc.)
 * tenham um comportamento comum quando se trata de autenticação.
 */

public interface Autenticavel {

    /**
     * Define ou atualiza a senha do objeto.
     *
     * @param senha A nova senha a ser definida.
     */

    void setSenha(String senha);

}
