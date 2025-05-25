import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLite {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db";  // SQLite database file

        String query = "SELECT id, name, age FROM students";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Age: %d%n",
                                  rs.getInt("id"),
                                  rs.getString("name"),
                                  rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
