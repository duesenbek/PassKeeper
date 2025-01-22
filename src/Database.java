public class Database {
    public void savePasswordToDatabase(Password password) {
        System.out.println("Password for account '" + password.getAccountName() + "' saved to database.");
    }

    public Password retrievePasswordFromDatabase(String accountName) {
        return new Password(accountName, "retrieved_password_from_db");
    }
}
