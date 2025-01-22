import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private List<Password> passwords;

    public PasswordManager() {
        passwords = new ArrayList<>();
    }

    public void addPassword(String accountName, String password) {
        passwords.add(new Password(accountName, password));
    }

    public Password findPassword(String accountName) {
        for (Password password : passwords) {
            if (password.getAccountName().equals(accountName)) {
                return password;
            }
        }
        return null;
    }

    public void displayPasswords() {
        for (Password password : passwords) {
            System.out.println(password);
        }
    }
}
