package Mobile.test.Transaction;

import Mobile.controller.OnBoarding.Login.LoginController;
import Mobile.controller.OnBoarding.StarActivityController;
import Mobile.controller.Transaction.ReceiptController;
import Mobile.controller.Transaction.TransferHijraController;
import Mobile.test.BaseTest;
import Mobile.utils.VariableProperties;
import Mobile.utils.listeners.TestListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners({TestListener.class})
@Epic("TRANSACTIONS ")
@Feature("Transfer To Hijra Via Favorit List")
public class TransferNegativeTest extends BaseTest {

    TransferHijraController transferHijraController;
    private VariableProperties variableProperties = new VariableProperties();
    private StarActivityController starActivityController;
    private LoginController loginController;
    private ReceiptController receiptController;

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
    @Severity(SeverityLevel.NORMAL)
    @Description("Enabling users to log in or sign-up to the account.")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    public void loginValid() throws Exception {
        loginController = new LoginController(driver);
        loginController
                .startLogin()
                .inputID(variableProperties.getIDLogin())
                .inputPassword(variableProperties.getPasswordLogin())
                .checkbox()
                .click_buttonMasuk();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Rekening Null")
    @Story("HIJRA-461 [Android-FE] Transfer to Hijra - As a user, I want to transfer my money to another Hijra account, so that I can do transactions within Hijra app.")
    @Parameters({"validationRekNull"})
    public void validationRekNull(String validationRekNull) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .transferToHijra()
                .clickbtnLanjut()
                .validationRekIdNull(validationRekNull);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Rekening Invalid")
    @Story("HIJRA-461 [Android-FE] Transfer to Hijra - As a user, I want to transfer my money to another Hijra account, so that I can do transactions within Hijra app.")
    @Parameters({"validationRekInvalid", "rekInvalid", "rekPenerima"})
    public void validationInvaildRek(String validationRekInvalid, String rekInvalid, String rekPenerima) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .inputRekHijraID(rekInvalid)
                .clickbtnLanjut()
                .validationRekIdInvalid(validationRekInvalid)
                .clearRek()
                .inputRekHijraID(rekPenerima)
                .clickbtnLanjut();
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Validation Nominal Null")
    @Story("HIJRA-461 [Android-FE] Transfer to Hijra - As a user, I want to transfer my money to another Hijra account, so that I can do transactions within Hijra app.")
    @Parameters({"validationNominalNull"})
    public void validationNullNominal(String validationNominalNull) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .clickbtnLanjut()
                .validationNominalNull(validationNominalNull);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Validation Nominal Null")
    @Story("HIJRA-461 [Android-FE] Transfer to Hijra - As a user, I want to transfer my money to another Hijra account, so that I can do transactions within Hijra app.")
    @Parameters({"validationNominalLimitMin", "validationNominalLimitMax"})
    public void validationLimitNominal(String validationNominalLimitMin, String validationNominalLimitMax) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .inputNominal("5000")
                .clickbtnLanjut()
                .validationNominalLimit(validationNominalLimitMin, validationNominalLimitMax, "5000")
                .clearNominal()
                .inputNominal("26000000")
                .clickbtnLanjut()
                .validationNominalLimit(validationNominalLimitMin, validationNominalLimitMax, "26000000")
                .clearNominal()
                .inputNominal("10000")
                .clickbtnLanjut();
    }


    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer Authentication")
    @Story("HIJRA-463 [Android-FE] Transfer Authentication - As a user, I want to input password or biometrics before finalizing the transfer, so that I can ensure its security")
    @Parameters({"authOptions","validationParam", "validationParam1", "validationParam2", "passNull", "formatInvalid", "validationFormatInvalid", "passLock", "validationParam3"})
    public void transferAuthentication(String authOptions, String validationParam, String validationParam1, String validationParam2, String passNull, String formatInvalid, String validationFormatInvalid, String passLock, String validationParam3) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .btnLanjutKirim()
                .transferAuthenticationNegative(authOptions,validationParam, validationParam1, validationParam2, passNull, formatInvalid,validationFormatInvalid, passLock, validationParam3 )
                .updateCountLogin(variableProperties.getIDLogin());
    }
}
