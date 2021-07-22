package Mobile.utils;

import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ConvertNumber {
    public static String currencyID(double nominal) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        String split1 = formatRupiah.format((double) nominal).split("Rp")[1];
        String test = String.valueOf(split1);
        String spilt2 = test.split(",00")[0];
        return spilt2;
    }

    @Test
    public static int parseCurrency(String valueAmount) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number = format.parse(valueAmount);
        int parseInt = number.intValue();
        System.out.println(parseInt);
        return parseInt;
    }
}
