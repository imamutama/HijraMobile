package controller.OnBoarding.Register;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.OnBoarding.Register.SelfiePage;
import pages.OnBoarding.Register.SelfieWithKtpPage;
import utils.GeneratedUtils;

public class SelfieWithKtpController extends BaseController {

    private SelfieWithKtpPage selfieWithKtpPage = new SelfieWithKtpPage();
    String textValidation;

    public SelfieWithKtpController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Continue Selfie")
    public SelfieWithKtpController continue_SelfieWithKtp() {
        click(selfieWithKtpPage.getContinueTakeSelfieKTP());
        return this;
    }


    @Step("Take selfie dan Take selfie with ktp")
    public SelfieWithKtpController take_SelfieContinueKtp() throws Exception {
        try {
            click(selfieWithKtpPage.getBtnAllowGalery());
            GeneratedUtils.sleep(2000);
            click(selfieWithKtpPage.getBtnAllowGalery());
            GeneratedUtils.sleep(2000);
            click(selfieWithKtpPage.getBtnSelfieCamera());
            GeneratedUtils.sleep(2000);
            click(selfieWithKtpPage.getBtnUpload());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    @Step("Take selfie dan Take selfie with ktp")
    public SelfieWithKtpController take_SelfieKtp() throws Exception {
        try {
            GeneratedUtils.sleep(2000);
            click(selfieWithKtpPage.getBtnSelfieCamera());
            GeneratedUtils.sleep(2000);
            click(selfieWithKtpPage.getBtnUpload());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

}
