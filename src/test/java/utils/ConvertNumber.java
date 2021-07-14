package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class ConvertNumber {
    public static String currencyID(double nominal) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format((double) nominal);
    }
}
