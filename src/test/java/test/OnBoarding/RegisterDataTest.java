package test.OnBoarding;

import controller.OTPController;
import controller.OnBoarding.Register.RegisterDataController;
import controller.OnBoarding.StarActivityController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;
import utils.GeneratedUtils;
import utils.VariableProperties;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Register Data")
public class RegisterDataTest extends BaseTest {

    private StarActivityController starActivityController;
    private RegisterDataController registerController;
    private OTPController otpController;
    private VariableProperties vp = new VariableProperties();


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
    public void skipCarousel() throws InterruptedException {
        starActivityController = new StarActivityController(driver);
        starActivityController.skip_button();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Term and Conditon")
    @Story("HIJRA-14 [Android-FE] T&C Page - As a user, I want to know the terms & conditions so that I know the legal matters and the limitations of the product.")
    public void termCondition() throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .click_daftar()
                .click_mulai()
                .click_checkbox();

    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Hijrah ID, Email, Password, NO HP is not entered in the personal data form ")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters({"formNull"})
    public void formInputNull(String formNull) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .click_lanjut()
                .validation_FormNull(formNull);

    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Hijrah ID is not entered in the personal data form ")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters({"hijraIDNull"})
    public void hijraIDNull(String hijraIDNull) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .input_Email(vp.getEmail())
                .inputPassword(vp.getPassword())
                .inputKonfirmPswrd(vp.getPassword())
                .scrollNoHp()
                .inputNoHp(vp.getNoHp())
                .scrollHijraID()
                .click_lanjut()
                .validation_HijraIDNull(hijraIDNull);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Hijrah ID Hijrah ID has been used ")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters({"validationHijraEnabled", "hijraEnabled"})
    public void hijraIDUsed(String validationHijraEnabled, String hijraEnabled) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .input_HijraID(hijraEnabled)
                .click_lanjut()
                .validation_HijraIDterpakai(validationHijraEnabled);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Hijra ID invalid ")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters({"validationHijraInvalid", "hijraInvalid"})
    public void hijraIdInvalid(String validationHijraInvalid, String hijraInvalid) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .clearHijra()
                .input_HijraID(hijraInvalid)
                .click_lanjut()
                .validation_HijraInvalid(validationHijraInvalid);
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Email is not entered in the personal data form ")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters({"emailNull"})
    public void emailNull(String emailNull) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .clearHijra()
                .input_HijraID(vp.getHijraID())
                .clear_Email()
                .click_lanjut()
                .validation_EmailNull(emailNull);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Password is not entered in the personal data form ")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters("passwordNull")
    public void passwordNull(String passwordNull) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .input_Email(vp.getEmail())
                .clear_Password()
                .click_lanjut()
                .validation_passwordNull(passwordNull);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Konfirm is not entered in the personal data form ")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters("confirmNull")
    public void confirmNUll(String confirmNull) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .inputPassword(vp.getPassword())
                .clear_Confirm()
                .click_lanjut()
                .validation_KonfirmNull(confirmNull);
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Password does not match the criteria")
    @Story("HIJRA-426 [Android-FE] Case-sensitive Password - As a user, I want to know the requirement of the password, so that I can setup the password as required")
    @Parameters({"validationPassInvalid", "passInvalid"})
    public void passwordInvalid(String validationPassInvalid, String passInvalid) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .clear_Password()
                .inputPassword(passInvalid)
                .inputKonfirmPswrd(passInvalid)
                .click_lanjut()
                .validation_passwordInvalid(validationPassInvalid);
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Password is not the same as confirm")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters({"validationPassNotSame", "passNotSame"})
    public void passwordNotSame(String validationPassNotSame, String passNotSame) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .clear_Password()
                .inputPassword(vp.getPassword())
                .clear_Confirm()
                .inputKonfirmPswrd(passNotSame)
                .click_lanjut()
                .validation_PassKonfirmNotSame(validationPassNotSame);
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("No HP Null is not entered in the personal data form")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters("noHpNull")
    public void noHpNull(String noHpNull) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .clear_Password()
                .inputPassword(vp.getPassword())
                .clear_Confirm()
                .inputKonfirmPswrd(vp.getPassword())
                .clear_NoHp()
                .click_lanjut()
                .validation_NoHPNull(noHpNull);

    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("No HP is Enabled")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    @Parameters({"validationNoHpEnabled", "noHpEnabled"})
    public void noHpEnabled(String validationNoHpEnabled, String noHpEnabled) throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .inputNoHp(noHpEnabled)
                .click_lanjut()
                .validation_NoHPEnabled(validationNoHpEnabled);

    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Enabling the users to have personified data to log in to the account.")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    public void inputFormDaftar() throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .clear_NoHp()
                .inputNoHp(vp.getNoHp())
                .click_lanjut();
        GeneratedUtils.sleep(3000);
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Android] OTP Authentication - As a user, I want to be able to receive OTP so that my phone number can be authenticated.")
    @Story("HIJRA-260 [Android-FE] OTP Authentication - As a user, I want to be able to receive OTP so that my phone number can be authenticated.")
    @Parameters("validationCitcall")
    public void otpDB(String validationCitcall) throws Exception {
        otpController = new OTPController(driver);
        otpController
                .validationCitcall(validationCitcall)
                .getOtp();
    }
}
