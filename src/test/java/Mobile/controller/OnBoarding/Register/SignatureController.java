package Mobile.controller.OnBoarding.Register;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import Mobile.pages.OnBoarding.Register.SignaturePage;
import Mobile.utils.GeneratedUtils;

public class SignatureController extends BaseController {
    private SignaturePage signaturePage = new SignaturePage();
    String textValidation;

    public SignatureController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Continue Signature")
    public SignatureController continue_Signature() {
        textValidation = readText(signaturePage.getContinueSignature());
        if (textValidation.equalsIgnoreCase("Lanjut Tanda Tangan")) {
            click(signaturePage.getContinueSignature());
        }
        return this;
    }

    @Step("Create signature with choose image")
    public SignatureController signature_Image() throws Exception {
        GeneratedUtils.sleep(3000);
        click(signaturePage.getBtnUploadSignature());
        click(signaturePage.getBtnPilihGalery());
        click(signaturePage.getBtnAllowGalery());
        click(signaturePage.getChooseImage());
        return this;
    }

    @Step("Create signature thread")
    public SignatureController signatureThread() throws Exception {
        GeneratedUtils.sleep(10000);
        click(signaturePage.getBtnLanjutSignature());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Click Lanjut Siganture")
    public SignatureController lanjut_signature() throws Exception {
        click(signaturePage.getBtnLanjutSignature());
        GeneratedUtils.sleep(2000);
        return this;
    }

}
