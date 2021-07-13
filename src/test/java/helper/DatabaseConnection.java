package helper;

import org.aspectj.weaver.ast.Var;
import utils.VariableProperties;

import java.sql.*;

public class DatabaseConnection {
    // JDBC driver name and database URL
    static VariableProperties vp = new VariableProperties();
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void DBConnect() {

        try {
            Class.forName(vp.getJDBC());
            System.out.println("Connecting to database…");
            conn = DriverManager.getConnection(vp.getDbUrl(), vp.getUserDB(), vp.getPassDB());
            System.out.println("Creating statement…");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String QuerySql(String query, int index) throws SQLException {
        String sql;
        String model = null;
        sql = query;
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            model = rs.getString(index);
        }
        return model;
    }

    public static void CloseConnectionDB() throws SQLException {
        try {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Close Connectiom");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

