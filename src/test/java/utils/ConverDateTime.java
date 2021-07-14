package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverDateTime {

    public static String dateConvert(String tgl){
        String date=tgl;
        String output = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd yyyy ");
        try{
            Date parseDate = sdf.parse(date);
            output = sdf1.format(parseDate);
            System.out.println(output);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String timeConvert(String time){
        String timeStamp = time;
        String output = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        try{
            Date parseDate = sdf.parse(timeStamp);
            output = sdf1.format(parseDate);
            System.out.println(output);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String dateTime(String datetime){
        String datetime1 = datetime;
        String output = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd yyyy, HH:mm");
        try{
            Date parseDate = sdf.parse(datetime1);
            output = sdf1.format(parseDate);
            System.out.println(output);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
