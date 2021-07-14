package controller.OnBoarding.Login;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.OnBoarding.Login.ForgotHijraPage;

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

    @Step("Validation KTP Invalid")
    public ForgotHijraController validationKtpInvalid(String ktpInvalid) {
        textValidation = readText(forgotHijraPage.getValidationKtpNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(ktpInvalid));
        return this;
    }

    @Step("Validation Ibu Kandung Invalid")
    public ForgotHijraController validationNameInvalid(String nameInvalid) {
        textValidation = readText(forgotHijraPage.getValidationIDIbuNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(nameInvalid));
        return this;
    }

    @Step("Validation Hijra ID Display")
    public ForgotHijraController valdiationHijraIDDisplay(){
        Assert.assertTrue(waitVisibility(forgotHijraPage.getValidationHijraIDDisplay()).isDisplayed());
        return this;

    }

    @Step("Back Login Page")
    public ForgotHijraController backLogin(){
        click(forgotHijraPage.getKembaliLogin());
        return this;
    }


}
