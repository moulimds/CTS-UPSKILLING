import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    // Insert a new student record
    public boolean insertStudent(int id, String name, int age) {
        String insertSQL = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update student's name and age by ID
    public boolean updateStudent(int id, String newName, int newAge) {
        String updateSQL = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, newName);
            pstmt.setInt(2, newAge);
            pstmt.setInt(3, id);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Main method to test insert and update
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        boolean inserted = dao.insertStudent(4, "David", 21);
        System.out.println("Insert success: " + inserted);

        boolean updated = dao.updateStudent(2, "Robert", 23);
        System.out.println("Update success: " + updated);
    }
}
