//polymorphism
public class Password extends Account {
    private String password;

    public Password(String accountName, String password) {
        super(accountName); // Calls the base class constructor
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() + ", Password: " + password;
    }
}