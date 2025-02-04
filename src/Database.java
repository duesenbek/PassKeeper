import java.sql.*;
import org.postgresql.Driver;

public class Database {
    private Connection connection;

    public Database() {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/passkeeper";
            String user = "postgres";
            String password = "Bekzat077@"; // пароль

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void savePasswordToDatabase(Password password) {
        String query = "INSERT INTO passwords (account_name, password) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, password.getAccountName());
            stmt.setString(2, password.getPassword());
            stmt.executeUpdate();
            System.out.println("Password saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Password retrievePasswordFromDatabase(String accountName) {
        String query = "SELECT * FROM passwords WHERE account_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, accountName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                return new Password(accountName, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
