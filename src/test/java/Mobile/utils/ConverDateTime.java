package Mobile.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ConverDateTime {

    public static String dateConvert(String tgl){
        String date=tgl;
        String output = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy, ");
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

    public static String dateTime(){
        String output = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        try{
            Date parseDate = new Date(System.currentTimeMillis());
            output = sdf1.format(parseDate);
            System.out.println(output);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
