package test;

import helper.DatabaseConnection;
import org.aspectj.weaver.ast.Var;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConverDateTime;
import utils.VariableProperties;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDatabase {

    VariableProperties vp = new VariableProperties();

    @org.testng.annotations.Test
    public void testDB() throws SQLException, IOException {
        DatabaseConnection.DBConnect();
        String sql = "SELECT generated_token FROM otp_token WHERE user_id IN(SELECT user_id FROM user_login WHERE username = 'Akuntransfer8')";
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

    public static String currencyID(double nominal){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID );
        String split1 = formatRupiah.format((double)nominal).split("Rp")[1];
        String test = String.valueOf(split1);
        return test;
    }
    @Test
    public void convert(){
        Assert.assertTrue(currencyID(10000).contains("10.000"));

    }

    @Test
    public void Date(){
        System.out.println(ConverDateTime.dateConvert("2021-07-13 17:02:00"));
        System.out.println(ConverDateTime.dateTime("2021-07-13 17:02:00"));
        Assert.assertTrue(ConverDateTime.timeConvert("2021-07-13 17:02:00").contains("17:02"));
    }


}
