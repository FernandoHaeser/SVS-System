package typesAcess;

public class User extends Person{

    private int id_user;

    public User(String firstName, String lastName, String cpf, String passwd, int id_user) {
        super(firstName, lastName, cpf, passwd);
        this.id_user = id_user;
    }

    public void setId_User(int id_user) {
        this.id_user = id_user;
    }

    public int getId_User() {
        return id_user;
    }
}
