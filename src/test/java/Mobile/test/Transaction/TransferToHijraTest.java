package Mobile.test.Transaction;

import Mobile.controller.Hompage.HomePageController;
import Mobile.controller.OnBoarding.Login.LoginController;
import Mobile.controller.OnBoarding.StarActivityController;
import Mobile.controller.Transaction.ReceiptController;
import Mobile.controller.Transaction.TransferHijraController;
import Mobile.test.OnBoarding.LoginSucces;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Mobile.test.BaseTest;
import Mobile.utils.VariableProperties;
import Mobile.utils.listeners.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
@Epic("TRANSACTIONS ")
@Feature("Transfer To Hijra Used Password ")
public class TransferToHijraTest extends BaseTest {
    private TransferHijraController transferHijraController;
    private VariableProperties variableProperties = new VariableProperties();
    private ReceiptController receiptController;
    private LoginController loginController;
    private StarActivityController starActivityController;
    private HomePageController homePageController;


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
    @Description("Transfer To Hijra")
    @Story("HIJRA-461 [Android-FE] Transfer to Hijra - As a user, I want to transfer my money to another Hijra account, so that I can do transactions within Hijra app.")
    @Parameters({"rekPenerima", "nominalTf", "catatan"})
    public void transferHijra(String rekPenerima, String nominalTf, String catatan) throws Exception {
        homePageController = new HomePageController(driver);
        homePageController.balancedSaldo();
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .transferToHijra()
                .inputRekHijraID(rekPenerima)
                .clickbtnLanjut()
                .inputNominal(nominalTf)
                .inputCatatan(catatan)
                .clickbtnLanjut()
                .validationDtlNamePenerima(rekPenerima, variableProperties.getIDLogin())
                .validationDetailRekPenerima(rekPenerima, variableProperties.getIDLogin())
                .btnLanjutKirim();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer Authentication")
    @Story("HIJRA-463 [Android-FE] Transfer Authentication - As a user, I want to input password or biometrics before finalizing the transfer, so that I can ensure its security")
    @Parameters({"optionAuth"})
    public void transferAuthentication(String optionAuth) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .transferAuthentication(optionAuth, variableProperties.getPasswordLogin());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Status")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    @Parameters({"validationStatus"})
    public void transferHijraStatus(String validationStatus) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .statusTransfer(validationStatus)
                .scrollEnd()
                .viewReceipt();
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Amount)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptAmount() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationAmountOUT(variableProperties.getIDLogin());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Nama Penerima)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    @Parameters({"idPenerimaReceipt"})
    public void transferHijraReceiptNamePenerima(String idPenerimaReceipt) throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationNamePenerimaDb(idPenerimaReceipt)
                .validationRekPenerimaInDb(idPenerimaReceipt);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Rekening Penerima)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    @Parameters({"idPenerimaReceipt"})
    public void transferHijraReceiptRekPenerima(String idPenerimaReceipt) throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationRekPenerimaInDb(idPenerimaReceipt);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Tanggal Transaksi)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptDateTime() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationDateTimeDb();
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (BANK)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptBank() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationBankDb(variableProperties.getIDLogin());
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Name Pengirim)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptNamePengirim() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationNamePengirimDb(variableProperties.getIDLogin());
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Rekening Pengirim)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptRekPengirim() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationRekPengirimDb(variableProperties.getIDLogin())
                .backNavigate()
                .backHome();
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Saldo Balanced")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void validationBalancesAmount() throws Exception {
        homePageController = new HomePageController(driver);
        homePageController.validationBalanced(10000);
    }
}
