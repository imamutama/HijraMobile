package Mobile;

import Mobile.helper.DatabaseConnection;
import Mobile.utils.ConvertNumber;
import Mobile.utils.ReadWriteText;
import org.testng.Assert;
import org.testng.annotations.Test;
import Mobile.utils.ConverDateTime;
import Mobile.utils.VariableProperties;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TestDatabase {

    VariableProperties vp = new VariableProperties();

    @org.testng.annotations.Test
    public void testDB() throws SQLException, IOException {
        DatabaseConnection.DBConnect();
        String sql = "SELECT generated_token FROM otp_token WHERE user_id IN(SELECT user_id FROM user_login WHERE username = 'Akuntransfer8')";
        System.out.println(DatabaseConnection.QuerySql(sql, 1));

    }

    public static String currencyID(double nominal) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        String split1 = formatRupiah.format((double) nominal).split("Rp")[1];
        String test = String.valueOf(split1);
        String spilt2 = test.split(",00")[0];
        return spilt2;
    }

    @Test
    public void convert() {
      String textValidation = "Rp 10.000";
      String splitText = textValidation.split("Rp ")[1];
        System.out.println(splitText);

    }

    @Test
    public void parseInt() throws ParseException {
        String splitAmount = "76,352,000";
        int parseAmount = ConvertNumber.parseCurrency(splitAmount);
        int totalAmount = parseAmount - 10000;
        String textAmount = String.valueOf(totalAmount);
        String textGetBalanced = "76,342,000";
        int parseAmountTotal = ConvertNumber.parseCurrency(textGetBalanced);
        String textAmountTotal = String.valueOf(parseAmountTotal);
        Assert.assertEquals(textAmount,textAmountTotal);
    }

    @Test
    public void Date() {
        System.out.println(ConverDateTime.dateConvert("2021-07-13 09:02:00"));
        System.out.println(ConverDateTime.dateTime());
        Assert.assertTrue(ConverDateTime.timeConvert("2021-07-13 09:02:00").contains("17:02"));
    }

    @Test
    public void test2(){
       int test = 40000;
       int angkat = test-10000;
        System.out.println(angkat);
    }


}
