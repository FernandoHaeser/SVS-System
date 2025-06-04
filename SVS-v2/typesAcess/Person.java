package typesAcess;

public class Person {

    private String firstName;
    private String lastName;
    private String cpf;
    private String passwd;

    public Person(String firstName, String lastName, String passwd, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwd = passwd;
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
