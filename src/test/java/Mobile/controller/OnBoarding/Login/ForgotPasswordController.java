package Mobile.controller.OnBoarding.Login;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.OnBoarding.Login.ForgotPasswordPage;
import Mobile.utils.GeneratedUtils;

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
        writeText(forgotPasswordPage.getInputHijraID(), hijraID);
        return this;
    }

    @Step("Validation Null")
    public ForgotPasswordController validationIdNull(String idNull) {
        textValidation = readText(forgotPasswordPage.getAlertNullinput());
        Assert.assertTrue(textValidation.equalsIgnoreCase(idNull));
        return this;
    }

    @Step("Validation Hijra ID not found")
    public ForgotPasswordController validationIdNotFound(String idNotFound) {
        textValidation = readText(forgotPasswordPage.getAlertUserNotFound());
        Assert.assertTrue(textValidation.equalsIgnoreCase(idNotFound));
        return this;
    }

    @Step("Validation Hijra ID Format Incorrect")
    public ForgotPasswordController validationFormatIncorrect(String idIncorrect) throws Exception {
        GeneratedUtils.sleep(3000);
        textValidation = readText(forgotPasswordPage.getAlertFormatIDInvalid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(idIncorrect));
        return this;
    }

    @Step("Input Nomor KTP")
    public ForgotPasswordController inputKtp(String ktp) {
        writeText(forgotPasswordPage.getInputIDKtp(), ktp);
        return this;
    }

    @Step("Input Ibu Kandung")
    public ForgotPasswordController inputIbuKandung(String ibuKandung) {
        writeText(forgotPasswordPage.getInputIbuKandung(), ibuKandung);
        return this;
    }

    @Step("Validation KTP Invalid")
    public ForgotPasswordController validationKtpInvalid(String ktpInvalid) {
        textValidation = readText(forgotPasswordPage.getValidationKtpNotValid());
        System.out.println(textValidation);
        Assert.assertTrue(textValidation.equalsIgnoreCase(ktpInvalid));
        return this;
    }

    @Step("Validation Ibu Kandung Invalid")
    public ForgotPasswordController validationNameInvalid(String nameInvalid) {
        textValidation = readText(forgotPasswordPage.getValidationIbuNotValid());
        System.out.println(textValidation);
        Assert.assertTrue(textValidation.equalsIgnoreCase(nameInvalid));
        return this;
    }

    @Step("Validation KTP & Ibu Kandung Invalid")
    public ForgotPasswordController validationKtpIbuInvalid(String ktpIbuInvalid) {
        textValidation = readText(forgotPasswordPage.getValidationIDIbuNotValid());
        System.out.println(textValidation);
        Assert.assertTrue(textValidation.equalsIgnoreCase(ktpIbuInvalid));
        return this;
    }

    @Step("Input new password")
    public ForgotPasswordController inputNewPass(String newPass) {
        writeText(forgotPasswordPage.getInputPassword(), newPass);
        return this;
    }

    @Step("Input confirm new password")
    public ForgotPasswordController inputConfirmNewPass(String newPass) {
        writeText(forgotPasswordPage.getInputKonfirm(), newPass);
        return this;
    }

    @Step("Validation Password Not Same")
    public ForgotPasswordController validationPassNotSame(String passNotSame) {
        textValidation = readText(forgotPasswordPage.getValidationPassNotSame());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passNotSame));
        return this;
    }

    @Step("Validation Password must from number")
    public ForgotPasswordController validationPassNumber(String passNumber) {
        textValidation = readText(forgotPasswordPage.getValidationPassAngka());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passNumber));
        return this;
    }

    @Step("Validation minimun 8 character  ")
    public ForgotPasswordController validationNPassMinimum(String passMinimum) {
        textValidation = readText(forgotPasswordPage.getValidation8char());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passMinimum));
        return this;
    }

    @Step("Validation password cannot be the same as the old password")
    public ForgotPasswordController validationCantOldPass(String passOld) {
        textValidation = readText(forgotPasswordPage.getPasswordEnabled());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passOld));
        return this;
    }

    @Step("Validation Button Simpan")
    public ForgotPasswordController btnSimpan() {
        click(forgotPasswordPage.getBtnSimpan());
        return this;
    }

    @Step("Forgot Password Success")
    public ForgotPasswordController forgotSucces(String success) {
        textValidation = readText(forgotPasswordPage.getValidationSuccess());
        Assert.assertTrue(textValidation.equalsIgnoreCase(success));
        return this;
    }

    @Step("Send ID Hijra")
    public ForgotPasswordController sendIDHijra() {
        click(forgotPasswordPage.getBtnLanjut());
        return this;
    }

    @Step("Send ID & Ibu Kandung")
    public ForgotPasswordController sendStep2() {
        click(forgotPasswordPage.getBtnKirim());
        return this;
    }

    @Step("Clear Text KTP")
    public ForgotPasswordController clearTextKtp() throws Exception {
        clearText(forgotPasswordPage.getInputIDKtp());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Clear Text Ibu Kandung")
    public ForgotPasswordController clearTextIbu() {
        clearText(forgotPasswordPage.getInputIbuKandung());
        return this;
    }

    @Step("Clear Text Pass new")
    public ForgotPasswordController clearPassnew() {
        clearText(forgotPasswordPage.getInputPassword());
        return this;
    }

    @Step("Clear Text Pass Confirm")
    public ForgotPasswordController clearpassConfirm() {
        clearText(forgotPasswordPage.getInputKonfirm());
        return this;
    }

    @Step("Clear Text ID")
    public ForgotPasswordController clearId() {
        clearText(forgotPasswordPage.getInputHijraID());
        return this;
    }

    @Step("Allow Permission")
    public ForgotPasswordController allowPermission() {
        for (int i = 1; i<=2; i++){
            click(forgotPasswordPage.getBtnAllowGalery());
        }
            return this;
    }

}
