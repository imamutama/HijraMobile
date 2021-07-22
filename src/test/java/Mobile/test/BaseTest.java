package Mobile.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver<MobileElement> driver;
    AppiumDriverLocalService service;


    public AndroidDriver getDriver() {

        return this.driver;
    }

    @BeforeTest
    public void setUpDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"SM-J730G");
        caps.setCapability(MobileCapabilityType.UDID,"52006084fe18840b");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hijrabank");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.hijrabank.MainActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url,caps);
    }

//    public void startAppiumService(String portNumber) {
//        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
//        serviceBuilder.withIPAddress("127.0.0.1");
//        serviceBuilder.usingPort(Integer.parseInt(portNumber));
//        service = AppiumDriverLocalService.buildService(serviceBuilder);
//        service.start();
//        System.out.println("service has been started with port" + portNumber);
//    }
//
    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }


}
