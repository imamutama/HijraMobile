package controller.OnBoarding.Register;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.OnBoarding.Register.SelfiePage;
import utils.GeneratedUtils;

public class SelfieController extends BaseController {

    private SelfiePage selfiePage = new SelfiePage();
    String textValidation;

    public SelfieController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Continue Selfie")
    public SelfieController continue_Selfie() {
        click(selfiePage.getContinueTakeSelfie());
        return this;
    }

    @Step("Take selfie dan Take selfie with ktp")
    public SelfieController take_Selfie() throws Exception {
        try {
            GeneratedUtils.sleep(2000);
            click(selfiePage.getBtnSelfieCamera());
            GeneratedUtils.sleep(2000);
            click(selfiePage.getBtnUpload());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Take selfie dan Take selfie with ktp")
    public SelfieController take_SelfieContinue() throws Exception {
        try {
            click(selfiePage.getBtnAllowGalery());
            GeneratedUtils.sleep(2000);
            click(selfiePage.getBtnAllowGalery());
            GeneratedUtils.sleep(2000);
            click(selfiePage.getBtnSelfieCamera());
            GeneratedUtils.sleep(2000);
            click(selfiePage.getBtnUpload());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

}
