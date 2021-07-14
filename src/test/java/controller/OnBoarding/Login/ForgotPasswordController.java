package controller.OnBoarding.Login;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.OnBoarding.Login.ForgotHijraPage;
import pages.OnBoarding.Login.ForgotPasswordPage;
import utils.GeneratedUtils;

public class ForgotPasswordController extends BaseController {
    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    String textValidation;

    public ForgotPasswordController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Pilih lupa password")
    public ForgotPasswordController lupaPassword() {
        click(forgotPasswordPage.getLupaPassword());
        return this;
    }

    @Step("Input Hijra ID")
    public ForgotPasswordController inputID(String hijraID) {
        writeText(forgotPasswordPage.getInputHijraID(),hijraID);
        return this;
    }
    @Step("Validation Null")
    public ForgotPasswordController validationIdNull(String idNull){
        textValidation = readText(forgotPasswordPage.getAlertNullinput());
        Assert.assertTrue(textValidation.equalsIgnoreCase(idNull));
        return this;
    }

    @Step("Validation Hijra ID not found")
    public ForgotPasswordController validationIdNotFound(String idNotFound){
        textValidation = readText(forgotPasswordPage.getAlertUserNotFound());
        Assert.assertTrue(textValidation.equalsIgnoreCase(idNotFound));
        return this;
    }

    @Step("Validation Hijra ID Format Incorrect")
    public ForgotPasswordController validationFormatIncorrect(String idIncorrect){
        textValidation = readText(forgotPasswordPage.getAlertFormatIDInvalid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(idIncorrect));
        return this;
    }
    @Step("Click button Lanjut")
    public ForgotPasswordController ButtonLanjut(){
        click(forgotPasswordPage.getBtnLanjut());
        return this;
    }

    @Step("Input Nomor KTP")
    public ForgotPasswordController inputKtp(String ktp){
        writeText(forgotPasswordPage.getInputIDKtp(),ktp);
        return this;
    }

    @Step("Input Nomor Ibu Kandung")
    public ForgotPasswordController inputIbuKandung(String ibuKandung){
        writeText(forgotPasswordPage.getInputIbuKandung(), ibuKandung);
        return this;
    }

    @Step("Validation KTP Invalid")
    public ForgotPasswordController validationKtpInvalid(String ktpInvalid){
        textValidation = readText(forgotPasswordPage.getValidationKtpNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(ktpInvalid));
        return this;
    }
    @Step("Validation Ibu Kandung Invalid")
    public ForgotPasswordController validationNameInvalid(String nameInvalid){
        textValidation = readText(forgotPasswordPage.getValidationIDIbuNotValid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(nameInvalid));
        return this;
    }

    @Step("Input new password")
    public ForgotPasswordController inputNewPass(String newPass){
        writeText(forgotPasswordPage.getInputPassword(),newPass);
        return this;
    }
    @Step("Input confirm new password")
    public ForgotPasswordController inputConfirmNewPass(String newPass){
        writeText(forgotPasswordPage.getInputKonfirm(),newPass);
        return this;
    }

    @Step("Validation Password Not Same")
    public ForgotPasswordController validationPassNotSame(String passNotSame){
        textValidation = readText(forgotPasswordPage.getValidationPassNotSame());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passNotSame));
        return this;
    }
    @Step("Validation Password must from number")
    public ForgotPasswordController validationPassNumber(String passNumber){
        textValidation = readText(forgotPasswordPage.getValidationPassAngka());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passNumber));
        return this;
    }
    @Step("Validation minimun 8 character  ")
    public ForgotPasswordController validationNPassMinimum(String passMinimum){
        textValidation = readText(forgotPasswordPage.getValidation8char());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passMinimum));
        return this;
    }
    @Step("Validation password cannot be the same as the old password")
    public ForgotPasswordController validationCantOldPass(String passOld){
        textValidation = readText(forgotPasswordPage.getPasswordEnabled());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passOld));
        return this;
    }
    @Step("Validation Button Simpan")
    public ForgotPasswordController btnSimpan(){
        click(forgotPasswordPage.getBtnSimpan());
        return this;
    }
    @Step("Forgot Password Success")
    public ForgotPasswordController forgotSucces(String success){
        textValidation = readText(forgotPasswordPage.getValidationSuccess());
        Assert.assertTrue(textValidation.equalsIgnoreCase(success));
        return this;
    }

}
