package controller;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.PinPage;
import utils.GeneratedUtils;

public class PinController extends BaseController{
    private PinPage pinPage = new PinPage();
    String textValidation;
    public PinController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Input Pin")
    public PinController inputPin() throws Exception {
        for(int i = 1; i<=6; i++){
            click(pinPage.getBtnInputPin1());
            GeneratedUtils.sleep(2000);
        }
        return this;
    }

    @Step("Invalid Pin")
    public PinController invalidPin(String validationParam) throws Exception {
        for(int i = 1; i<=6; i++){
            click(pinPage.getBtnInputPin2());
            GeneratedUtils.sleep(2000);
        }
        textValidation = readText(pinPage.getInvalidPin());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationParam));
        return this;
    }

    @Step("Invalid Pin 3x ")
    public PinController invalidPin3x(String validationParam1, String validationParam2) throws Exception {
        for(int i = 1; i<=6; i++){
            click(pinPage.getBtnInputPin2());
            GeneratedUtils.sleep(2000);
        }
        textValidation = readText(pinPage.getAkunTerkunci());
       if(textValidation.equalsIgnoreCase(validationParam1)){
           Assert.assertTrue(readText(pinPage.getPinInvalid3x()).equalsIgnoreCase(validationParam2));
           click(pinPage.getKeluarApp());
       }
        return this;
    }
}
