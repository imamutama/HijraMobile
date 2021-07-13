package helper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadToastMessage {
    AndroidDriver<MobileElement>driver;
    public ReadToastMessage(AndroidDriver<MobileElement>driver){
        this.driver =driver;
    }
    static String scrShotDir = "screenshots";
    File scrFile;
    static File scrShotDirPath = new File("./"+ scrShotDir+ "//");
    String destFile;

    public String readToastMessage(String textValidation) throws TesseractException {
        String imgName = takeScreenShot();
        String result = null;
        File imageFile = new File(scrShotDirPath, imgName);
        System.out.println("Image name is :" + imageFile.toString());
        ITesseract instance = new Tesseract();

        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts
        instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData
        // path

        result = instance.doOCR(imageFile);
        if(result.contains(textValidation)){
            System.out.println(" TEST CASE PASSED");
        }else{
            System.out.println("NOT PASSED / ERROR");
        }

        System.out.println(result);
        return result;
    }

    /**
     * Takes screenshot of active screen
     *
     * @return ImageFileName
     */
    public String takeScreenShot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(scrShotDir).mkdirs(); // Create folder under project with name
        // "screenshots" if doesn't exist
        destFile = dateFormat.format(new Date()) + ".png"; // Set file name

        try {
            FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile)); // Copy
        } catch (IOException e) {
            System.out.println("Image not transfered to screenshot folder");
            e.printStackTrace();
        }
        return destFile;
    }
}
