package database;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class H2DatabaseTest {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test11";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    static Connection conn = null;
    static Statement stmt = null;

    @BeforeClass
    public static void init() throws SQLException {
//            // STEP 1: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
        //STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully.");


        //STEP 3: Execute a query
        System.out.println("Creating Connection Statement...");
        stmt = conn.createStatement();
    }


    @Test
    public void testCRUDTable() {
        try {
            String sql = "CREATE TABLE   REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database.");

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'REGISTRATION'");
            Assert.assertTrue("Asserted table created", resultSet.next());



            stmt.executeUpdate("INSERT INTO Registration " + "VALUES (100, 'Zara', 'Ali', 18)");
            ResultSet rs = stmt.executeQuery("SELECT id, first, last, age FROM Registration where id = 100");
            while (rs.next()) {
                Assert.assertEquals(100, rs.getInt("id"));
            }



            stmt.executeUpdate("DROP TABLE REGISTRATION");
            ResultSet resultSet1 = stmt.executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'REGISTRATION'");
            Assert.assertFalse("Asserted table dropped", resultSet1.next());


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }


    @AfterClass
    public static void close() throws SQLException {
        if(stmt != null) {
            stmt.close();
            System.out.println("Connection closed.");
        }

        if(conn != null) {
            conn.close();
            System.out.println("Connection closed.");
        }
    }
}
