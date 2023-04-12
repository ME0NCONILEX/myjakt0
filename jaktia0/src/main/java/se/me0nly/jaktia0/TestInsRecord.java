package se.me0nly.jaktia0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsRecord {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jaktia0";
    static final String USER = "root";
    static final String PASS = "Test1234";

    public static void main(String[] args) throws RuntimeException {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
                // Execute a query - insert one ore more records -- Obs! no duplicates
                System.out.println("Inserting records into the table...");
                String sql = "INSERT INTO Registration VALUES (1, 'FirstN Hunter1', 'LastN Hunter1', 31, 0123123456, 'hunter1@hunter1mail.io', 'hunter leader', 'first relative', 0123123457)";
                stmt.executeUpdate(sql);
                sql = "INSERT INTO Registration VALUES (2, 'FirstN Hunter2', 'LastN Hunter2', 32, 0123234567, 'hunter2@hunter1mail.io', 'new hunter', 'first relative', 0123234568)";
                stmt.executeUpdate(sql);
                System.out.println("Inserted records into the table!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
