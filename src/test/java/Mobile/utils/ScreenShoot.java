package Mobile.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ScreenShoot {

    static String FilePath = System.getProperty("user.dir");
    static String FullPath = FilePath + "/screenShot/";

    @Step("Take ScreenShot")
    public static void takeScreenShot(String nameScrShot, WebDriver driver) throws IOException {
        int rand = ThreadLocalRandom.current().nextInt();

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcFile, new File(FullPath + nameScrShot + rand + ".jpg"));
        Allure.addAttachment("ScreenShot ",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
}

