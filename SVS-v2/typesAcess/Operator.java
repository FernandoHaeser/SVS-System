package typesAcess;

public class Operator extends Person{

    private int id_operator;

    public Operator(String firstName, String lastName, String passwd, String cpf, int id_operator) {
        super(firstName, lastName, passwd, cpf);
        this.id_operator = id_operator;
    }

    public void setId_Operator(int id_operator) {
        this.id_operator = id_operator;
    }

    public int getId_Operator() {
        return id_operator;
    }
}
