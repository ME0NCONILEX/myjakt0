package se.me0nly.jaktia0;

import java.sql.*;

public class TestTablApp {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jaktia0";
    static final String USER = "root";
    static final String PASS = "Test1234";
    private static PreparedStatement stmt;

    public static void main(String[] args) throws RuntimeException {
        // Open a connection & create a new dbase "REGISTRATION" is already created
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE REGISTRATION " +
                        "(id INTEGER not NULL, " +
                        " firstname VARCHAR(255), " +
                        " lastname VARCHAR(255), " +
                        " age INTEGER, " +
                        " tel INTEGER, " +
                        " mail VARCHAR(255), " +
                        " roll VARCHAR(255), " +
                        " relative VARCHAR(255), " +
                        " tel1 INTEGER, " +
                        " PRIMARY KEY ( id ))";

                stmt.executeUpdate(sql);
                System.out.println("Created table in given database...");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

