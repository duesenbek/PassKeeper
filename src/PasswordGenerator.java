import java.util.Random;

//Single Responsibility Principle
public class PasswordGenerator {
    private int length;
    private boolean includeSpecialChars;

    public PasswordGenerator(int length, boolean includeSpecialChars) {
        this.length = length;
        this.includeSpecialChars = includeSpecialChars;
    }

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String specialChars = "!@#$%^&*()-_=+";
        String allowedChars = characters;

        if (includeSpecialChars) {
            allowedChars += specialChars;
        }

        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }
}