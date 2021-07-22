package Mobile.utils;

import java.io.*;

public class ReadWriteText {

    public static void writeFileText(String validationText, String File) {
        try {
            FileWriter writer = new FileWriter(File, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(validationText);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileText(String FileRead) {
        String textRead = null;
        try {
            FileReader reader = new FileReader(FileRead);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                textRead = line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textRead;
    }

    public static void deleteFile(String FileRead) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(FileRead);
        writer.print("");
        writer.close();
    }



}
