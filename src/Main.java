import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/passkeeper";
        String user = "postgres";
        String password = "Bekzat077@";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connecting to the database...");

            String sql = "SELECT * FROM passwords WHERE account_name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "Facebook");
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String retrievedPassword = rs.getString("password");
                    System.out.println("Retrieved Password: " + retrievedPassword);
                } else {
                    System.out.println("No data found for the given account name.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

