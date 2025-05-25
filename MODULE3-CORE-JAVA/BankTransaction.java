import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankTransaction {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    // Transfer money from one account to another
    public boolean transferMoney(int fromAccount, int toAccount, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
             PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

            // Start transaction
            conn.setAutoCommit(false);

            // Debit from source account
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);
            int debitCount = debitStmt.executeUpdate();

            // Credit to destination account
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);
            int creditCount = creditStmt.executeUpdate();

            // Check if both updates affected one row each
            if (debitCount == 1 && creditCount == 1) {
                conn.commit();
                System.out.println("Transaction committed successfully.");
                return true;
            } else {
                conn.rollback();
                System.out.println("Transaction rolled back: account not found or insufficient rows updated.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("Rolling back transaction due to error.");
                // rollback on exception
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                conn.rollback();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public static void main(String[] args) {
        BankTransaction bt = new BankTransaction();

        // Example transfer: transfer 100.0 from account 1 to account 2
        boolean success = bt.transferMoney(1, 2, 100.0);
        System.out.println("Transfer success: " + success);
    }
}
