package test;

import helper.DatabaseConnection;
import org.aspectj.weaver.ast.Var;
import utils.VariableProperties;

import java.io.IOException;
import java.sql.SQLException;

public class TestDatabase {
    DatabaseConnection db;
    VariableProperties vp = new VariableProperties();

    @org.testng.annotations.Test
    public void testDB() throws SQLException, IOException {
        DatabaseConnection.DBConnect();
        String sql = "SELECT generated_token FROM otp_token WHERE user_id IN(SELECT user_id FROM user_login WHERE username = 'Test2019')";
        System.out.println(DatabaseConnection.QuerySql(sql,1));
        String testString = String.valueOf(DatabaseConnection.QuerySql(sql,1));
        String[] as = {testString};
        for (int i = 1; i <= 4; i++) {
            for (String test : as) {
                if (i == 1) {
                    System.out.println(test.charAt(0));
                } else if (i == 2) {
                    System.out.println(test.charAt(1));
                }
            }
        }
    }


}
