import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private List<Password> passwords;
    private Database database;
    public PasswordManager(Database database) {
        passwords = new ArrayList<>();
        this.database = database;
    }


    public void addPassword(String accountName, String password) {
        Password newPassword = new Password(accountName, password);
        passwords.add(newPassword);
        database.savePasswordToDatabase(newPassword);
    }


    public Password findPassword(String accountName) {
        for (Password password : passwords) {
            if (password.getAccountName().equals(accountName)) {
                return password;
            }
        }
        return database.retrievePasswordFromDatabase(accountName);
    }


    public void displayPasswords() {
        for (Password password : passwords) {
            System.out.println(password);
        }
    }
}
