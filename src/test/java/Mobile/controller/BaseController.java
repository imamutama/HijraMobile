package Mobile.controller;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class BaseController {
    public AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    public BaseController(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
    }

    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    //Clear Text
    public void clearText(By by) {
        waitVisibility(by).clear();
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //SplitText
    public String getSplitText(By elementText, String textCondition) {
        String text = waitVisibility(elementText).getText();
        String[] getIndex = text.split(textCondition);
        String getTotal = getIndex[1];
        return getTotal;
    }

    //UploadFile
    public void uploadFile(By elementText, String filename) {
        String FullPath = System.getProperty("user.dir");
        String FilePath = FullPath + "/fileUpload";
        waitVisibility(elementText).sendKeys(FilePath + filename);
    }

    public void swipeHorizontal(AppiumDriver<MobileElement> driver, double start_xd, double start_yd, double end_xd, double end_yd) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int start_x = (int) (size.width * start_xd);
        int start_y = (int) (size.height * start_yd);
        int end_x = (int) (size.width * end_xd);
        int end_y = (int) (size.height * end_yd);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();
    }

    public void scrollAndClickbyId() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "down");
            js.executeScript("mobile: scroll", scrollObject);
            System.out.println("Swipe Successfully");

        } catch (
                Exception e) {
            System.out.println("Image Swipe was not successful.");

        }
    }


        public String getTextValidation (By elementBy){
            String getElement = driver.findElement(elementBy).getText();
            return getElement;
        }

        public void scrollAndClickBytext (String visibleText){
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
        }

        public void scrollDate (String visibleText){
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))").click();
        }


    }
