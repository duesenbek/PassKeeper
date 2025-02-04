public class Password {
    private String accountName;
    private String password;

    public Password(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }
    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account: " + accountName + ", Password: " + password;
    }
}
