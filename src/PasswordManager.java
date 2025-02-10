import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Open/Closed Principle
public class PasswordManager {
    private List<Password> passwords;
    private Database database;
    private PasswordGenerator passwordGenerator;

    public PasswordManager(Database database) {
        passwords = new ArrayList<>();
        this.database = database;
        this.passwordGenerator = new PasswordGenerator(12, true); // Default length: 12, includes special chars
    }

    public void addPassword(String accountName, boolean generatePassword) {
        String password;
        if (generatePassword) {
            password = passwordGenerator.generatePassword();
            System.out.println("Generated password: " + password);
        } else {
            System.out.print("Enter password: ");
            Scanner scanner = new Scanner(System.in);
            password = scanner.nextLine();
        }

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