import java.util.Scanner;

public class Main {
    public static void
    main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        PasswordManager manager = new PasswordManager(database);

        while (true) {
            System.out.println("\n--- PassKeeper Menu ---");
            System.out.println("1. Add a new password");
            System.out.println("2. Search for a password");
            System.out.println("3. Display all passwords");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account name: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    manager.addPassword(accountName, password);
                    break;
                case 2:
                    System.out.print("Enter account name to search: ");
                    accountName = scanner.nextLine();
                    Password foundPassword = manager.findPassword(accountName);
                    if (foundPassword != null) {
                        System.out.println(foundPassword);
                    } else {
                        System.out.println("Password not found.");
                    }
                    break;
                case 3:
                    manager.displayPasswords();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    database.closeConnection();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
