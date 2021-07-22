package Mobile.controller.OnBoarding.Login;

import Mobile.controller.BaseController;
import Mobile.utils.GeneratedUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.OnBoarding.Login.ForgotHijraPage;

public class ForgotHijraController extends BaseController {
    private ForgotHijraPage forgotHijraPage = new ForgotHijraPage();
    String textValidation;

    public ForgotHijraController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Choose Lupa Hijra ID")
    public ForgotHijraController chooseLupaHijra() {
        click(forgotHijraPage.getLupaHijra());
        return this;
    }

    @Step("Input Number phone")
    public ForgotHijraController inputNoHp(String noHp) {
        writeText(forgotHijraPage.getInputHp(), noHp);
        return this;
    }

    @Step("Validation Number phone Null")
    public ForgotHijraController validationPhoneNull(String phoneNull) {
        textValidation = readText(forgotHijraPage.getAlertNullinput());
        Assert.assertTrue(textValidation.equalsIgnoreCase(phoneNull));
        return this;
    }

    @Step("Validation Number phone not found")
    public ForgotHijraController validationPhoneNotFound(String phoneNotFound) {
        textValidation = readText(forgotHijraPage.getAlertUserNotFound());
        Assert.assertTrue(textValidation.equalsIgnoreCase(phoneNotFound));
        return this;
    }

    @Step("Validation Number phone Format Invalid")
    public ForgotHijraController validationFormatInvalid(String formatInvalid) {
        textValidation = readText(forgotHijraPage.getInputFormatNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(formatInvalid));
        return this;
    }

    @Step("Input Nomor KTP")
    public ForgotHijraController inputKtp(String ktp) {
        writeText(forgotHijraPage.getInputIDKtp(), ktp);
        return this;
    }

    @Step("Input Nomor Ibu Kandung")
    public ForgotHijraController inputIbuKandung(String ibuKandung) {
        writeText(forgotHijraPage.getInputIbuKandung(), ibuKandung);
        return this;
    }

    @Step("Validation KTP & Ibu Kandung Invalid")
    public ForgotHijraController validationKtpIbuInvalid(String ktpIbuInvalid) {
        textValidation = readText(forgotHijraPage.getValidationIDIbuNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(ktpIbuInvalid));
        return this;
    }

    @Step("Validation KTP Invalid")
    public ForgotHijraController validationKtpInvalid(String ktpInvalid) {
        textValidation = readText(forgotHijraPage.getValidationKtpNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(ktpInvalid));
        return this;
    }

    @Step("Validation Ibu Kandung Invalid")
    public ForgotHijraController validationNameInvalid(String nameInvalid) {
        textValidation = readText(forgotHijraPage.getValidationIbuNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(nameInvalid));
        return this;
    }

    @Step("Validation Hijra ID Display")
    public ForgotHijraController valdiationHijraIDDisplay() {
        Assert.assertTrue(waitVisibility(forgotHijraPage.getValidationHijraIDDisplay()).isDisplayed());
        return this;

    }

    @Step("Send Verifikasi Phone Number")
    public ForgotHijraController sendVerifikasiPhone() {
        click(forgotHijraPage.getKirimVerifikasi());
        return this;
    }

    @Step("Back Login Page")
    public ForgotHijraController backLogin() {
        click(forgotHijraPage.getKembaliLogin());
        return this;
    }


    @Step("Allow Permission")
    public ForgotHijraController allowPermission() {
        for (int i = 1; i <= 2; i++) {
            click(forgotHijraPage.getBtnAllowGalery());
        }
        return this;
    }

    @Step("Clear Text KTP")
    public ForgotHijraController clearTextKtp() throws Exception {
        clearText(forgotHijraPage.getInputIDKtp());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Clear Text Ibu Kandung")
    public ForgotHijraController clearTextIbu() {
        clearText(forgotHijraPage.getInputIbuKandung());
        return this;
    }

    @Step("Send ID & Ibu Kandung")
    public ForgotHijraController sendStep2() {
        click(forgotHijraPage.getBtnKirim());
        return this;
    }


}
