package Mobile.test.OnBoarding;

import Mobile.controller.OTPController;
import Mobile.controller.OnBoarding.Login.ForgotHijraController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Mobile.test.BaseTest;
import Mobile.utils.GeneratedUtils;
import Mobile.utils.VariableProperties;
import Mobile.utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Forgot username")
public class ForgotHijraIDTest extends BaseTest {
    private VariableProperties variableProperties = new VariableProperties();
    private OTPController otpController;
    private ForgotHijraController forgotHijraController;

    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Number Phone Null")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    @Parameters({"phoneNull"})
    public void validationNumberPhoneNull(String phoneNull) {
        forgotHijraController = new ForgotHijraController(driver)
                .chooseLupaHijra()
                .sendVerifikasiPhone()
                .validationPhoneNull(phoneNull);

    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Number Phone Null")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    @Parameters({"validationPhoneInvalid", "phoneInvalid"})
    public void validationNumberPhoneInvalid(String validationPhoneInvalid, String phoneInvalid) {
        forgotHijraController = new ForgotHijraController(driver)
                .inputNoHp(phoneInvalid)
                .sendVerifikasiPhone()
                .validationPhoneNotFound(validationPhoneInvalid);

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Number Phone Format Incorrect")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    @Parameters({"validationFormatIncorrect", "formatIncorrect"})
    public void validationFormatPhone(String validationFormatIncorrect, String formatIncorrect) {
        forgotHijraController = new ForgotHijraController(driver)
                .inputNoHp(formatIncorrect)
                .sendVerifikasiPhone()
                .validationFormatInvalid(validationFormatIncorrect);

    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Input Phone Number")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    public void inputPhoneNumber() throws Exception {
        forgotHijraController = new ForgotHijraController(driver)
                .inputNoHp(variableProperties.getNoHp())
                .sendVerifikasiPhone();
        GeneratedUtils.sleep(2000);

    }


    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation KTP Invalid")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    @Parameters({"validationKtpInvalid", "ktpInvalid"})
    public void validationKtpInvalid(String validationKtpInvalid, String ktpInvalid) throws Exception {
        forgotHijraController = new ForgotHijraController(driver);
        forgotHijraController
                .inputKtp(ktpInvalid)
                .inputIbuKandung(variableProperties.IbuKandung())
                .sendStep2()
                .validationKtpInvalid(validationKtpInvalid);

    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation Ibu Kandung Invalid")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    @Parameters({"validationIbuInvalid", "ibukandungInvalid"})
    public void validationIbuKandungInvalid(String validationIbuInvalid, String ibukandungInvalid) throws Exception {
        forgotHijraController = new ForgotHijraController(driver);
        forgotHijraController
                .clearTextKtp()
                .inputKtp(variableProperties.getNoKtp())
                .clearTextIbu()
                .inputIbuKandung(ibukandungInvalid)
                .sendStep2()
                .validationNameInvalid(validationIbuInvalid);

    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation ID & Ibu Kandung Invalid")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    @Parameters({"validationInvalid", "ktpInvalid"})
    public void validationInputInvalid(String validationInvalid, String ktpInvalid) throws Exception {
        forgotHijraController = new ForgotHijraController(driver);
        forgotHijraController
                .clearTextKtp()
                .inputKtp(ktpInvalid)
                .sendStep2()
                .validationKtpIbuInvalid(validationInvalid);
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Input Number Ktp & Ibu Kandung")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    public void inputKtpKandung() throws Exception {
        forgotHijraController = new ForgotHijraController(driver);
        forgotHijraController
                .clearTextKtp()
                .inputKtp(variableProperties.getNoKtp())
                .clearTextIbu()
                .inputIbuKandung(variableProperties.IbuKandung())
                .sendStep2();
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Get OTP")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    public void getOtp() throws Exception {
        forgotHijraController = new ForgotHijraController(driver);
        forgotHijraController
                .allowPermission();
        otpController = new OTPController(driver);
        otpController
                .getOtp();
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validation ID Display")
    @Story("HIJRA-249 [Android-FE] Forgot Username - As a user, I want to be able to recover my username, so that I can still access my account when I forgot the username.")
    @Parameters({"validationIdDisplay"})
    public void validationIdDisplay() {
        forgotHijraController = new ForgotHijraController(driver);
        forgotHijraController
                .valdiationHijraIDDisplay()
                .backLogin();
    }


}
