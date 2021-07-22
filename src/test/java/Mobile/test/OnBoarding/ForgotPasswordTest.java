package Mobile.test.OnBoarding;

import Mobile.controller.OTPController;
import Mobile.controller.OnBoarding.Login.ForgotPasswordController;
import Mobile.controller.OnBoarding.Login.LoginController;
import Mobile.controller.OnBoarding.StarActivityController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Mobile.test.BaseTest;
import Mobile.utils.VariableProperties;
import Mobile.utils.listeners.TestListener;

import java.io.IOException;


@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Forgot Password")
public class ForgotPasswordTest extends BaseTest {

    private ForgotPasswordController forgotPasswordController;
    private VariableProperties variableProperties = new VariableProperties();
    private OTPController otpController;
    private LoginController loginController;
    private StarActivityController starActivityController;


    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Start Application and choice menu bahasa")
    @Story("Start Application and choice menu bahasa")
    public void startActivityBahasa() throws InterruptedException {
        starActivityController = new StarActivityController(driver);
        starActivityController
                .click_salam()
                .click_bahasa();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("As a user, I want to skip carousel, so that I can shorten the process")
    @Story("HIJRA-531 [Android-FE] Enable Skip On Carousel - As a user, I want to skip carousel, so that I can shorten the process ")
    public void skipCarousel() throws Exception {
        starActivityController = new StarActivityController(driver);
        starActivityController.skip_button();
        loginController = new LoginController(driver);
        loginController
                .startLogin();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Hijra ID Null")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"validationIdNull"})
    public void validationHijraIDNull(String validationIdNull) throws IOException {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .lupaPassword()
                .sendIDHijra()
                .validationIdNull(validationIdNull);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Hijra ID Not Found")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"validationIdNotfound", "idNotFound"})
    public void validationIDNotFound(String validationIdNotfound, String idNotFound) throws Exception {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .inputID(idNotFound)
                .sendIDHijra()
                .validationIdNotFound(validationIdNotfound);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Hijra ID Format Incorrect")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"validationFormatIncorrect", "formatIncorrect"})
    public void validationIDIncorrect(String validationFormatIncorrect, String formatIncorrect) throws Exception {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearId()
                .inputID(formatIncorrect)
                .sendIDHijra()
                .validationFormatIncorrect(validationFormatIncorrect);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Choose Lupa Password & Input Hijra ID")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    public void inputNumberPhone() throws IOException {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearId()
                .inputID(variableProperties.getHijraID())
                .sendIDHijra();
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation KTP Invalid")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"validationKtpInvalid", "ktpInvalid"})
    public void validationKtpInvalid(String validationKtpInvalid, String ktpInvalid) throws Exception {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .inputKtp(ktpInvalid)
                .inputIbuKandung(variableProperties.IbuKandung())
                .sendStep2()
                .validationKtpInvalid(validationKtpInvalid);

    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Ibu Kandung Invalid")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"validationIbuInvalid", "ibukandungInvalid"})
    public void validationIbuKandungInvalid(String validationIbuInvalid, String ibukandungInvalid) throws Exception {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearTextKtp()
                .inputKtp(variableProperties.getNoKtp())
                .clearTextIbu()
                .inputIbuKandung(ibukandungInvalid)
                .sendStep2()
                .validationNameInvalid(validationIbuInvalid);

    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation ID & Ibu Kandung Invalid")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"validationInvalid", "ktpInvalid"})
    public void validationInputInvalid(String validationInvalid, String ktpInvalid) throws Exception {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearTextKtp()
                .inputKtp(ktpInvalid)
                .sendStep2()
                .validationKtpIbuInvalid(validationInvalid);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Input Number Ktp & Ibu Kandung")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    public void inputKtpKandung() throws Exception {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearTextKtp()
                .inputKtp(variableProperties.getNoKtp())
                .clearTextIbu()
                .inputIbuKandung(variableProperties.IbuKandung())
                .sendStep2();
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Android] OTP Authentication - As a user, I want to be able to receive OTP so that my phone number can be authenticated.")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    public void otpDB() throws Exception {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .allowPermission();
        otpController = new OTPController(driver);
        otpController
                .getOtp();
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Input password is null")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"passNull"})
    public void validationPassNull(String passNull) throws IOException {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .btnSimpan()
                .validationIdNull(passNull);
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("New Password not same Confirm Password")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"passNotsame", "confrimInvalid"})
    public void validationPassNoSame(String passNotsame, String confrimInvalid) throws IOException {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .inputNewPass(variableProperties.getPasswordLogin())
                .inputConfirmNewPass(confrimInvalid)
                .btnSimpan()
                .validationPassNotSame(passNotsame);
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Password must from number &  minimun 8 character ")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"mustNumber", "minimumChar", "inputPassNumber", "inputPassChar"})
    public void validationPassFormat(String mustNumber, String minimumChar, String inputPassNumber, String inputPassChar) throws IOException {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearPassnew()
                .inputNewPass(inputPassNumber)
                .validationPassNumber(mustNumber)
                .clearpassConfirm()
                .inputNewPass(inputPassChar)
                .validationNPassMinimum(minimumChar);
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Password used old password")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"oldPassword"})
    public void validationPassOld(String oldPass) throws IOException {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearPassnew()
                .inputNewPass(variableProperties.getPassword())
                .clearpassConfirm()
                .inputConfirmNewPass(variableProperties.getPassword())
                .btnSimpan()
                .validationCantOldPass(oldPass);
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.NORMAL)
    @Description("Forgot Password Success")
    @Story("HIJRA-253 [Android-FE] Forgot Password - As a user, I want to be able to reset my password, so that I can still access my account when I forgot the password.")
    @Parameters({"forgotPassSuccess"})
    public void validationForgotSuccess(String forgotPassSuccess) throws IOException {
        forgotPasswordController = new ForgotPasswordController(driver);
        forgotPasswordController
                .clearPassnew()
                .inputNewPass(variableProperties.getPasswordLogin())
                .clearpassConfirm()
                .inputConfirmNewPass(variableProperties.getPasswordLogin())
                .btnSimpan()
                .forgotSucces(forgotPassSuccess);
    }


}
