package test.Transaction;

import controller.BaseController;
import controller.OnBoarding.Login.LoginController;
import controller.OnBoarding.StarActivityController;
import controller.Transaction.FavoriteTransferController;
import controller.Transaction.ReceiptController;
import controller.Transaction.TransferHijraController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.VariableProperties;
import utils.listeners.TestListener;

import java.io.IOException;



@Listeners({TestListener.class})
@Epic("TRANSACTIONS ")
@Feature("Transfer To Hijra used Password")
public class TransfetHijraFavTest extends BaseController {
    public TransfetHijraFavTest(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    TransferHijraController transferHijraController;
    private VariableProperties variableProperties = new VariableProperties();
    private StarActivityController starActivityController;
    private LoginController loginController;
    private ReceiptController receiptController;
    private FavoriteTransferController favoriteTransferController;

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
    public void loginValid() throws IOException {
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
    @Story("HIJRA-460 [Android-FE] Transfer Option - As a user, I want to have the options in transferring my money to the desired account, so that I can choose whether to send it to Hijra account or other banks or my favorite account")
    @Parameters({"rekPenerima", "nominalTf", "catatan", "account"})
    public void transferHijraFavorit(String rekPenerima, String nominalTf, String catatan, String account) throws Exception {
        favoriteTransferController = new FavoriteTransferController(driver);
        favoriteTransferController
                .listSemua()
                .searchAccount(account)
                .chooseAccount();
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .inputNominal(nominalTf)
                .inputCatatan(catatan)
                .clickbtnLanjut()
                .validationDtlNamePenerima(rekPenerima, variableProperties.getIDLogin())
                .validationDetailRekPenerima(rekPenerima, variableProperties.getIDLogin())
                .btnLanjutKirim()
                .usePassword()
                .inputPassowrd(variableProperties.getPasswordLogin())
                .kirimSekarang();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    @Parameters({"validationStatus", "idPenerimaReceipt"})
    public void transferHijraSuccess(String validationStatus, String idPenerimaReceipt) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .statusTransfer(validationStatus)
                .scrollText("Lihat Receipt")
                .viewReceipt();
        receiptController = new ReceiptController(driver);
        receiptController
                .validationAmountOUT(variableProperties.getIDLogin())
                .validationNamePenerimaDb(idPenerimaReceipt)
                .validationRekPenerimaInDb(idPenerimaReceipt)
                .validationDateTimeDb(variableProperties.getIDLogin())
                .validationBankDb(variableProperties.getIDLogin())
                .validationNamePengirimDb(variableProperties.getIDLogin())
                .validationRekPengirimDb(variableProperties.getIDLogin())
                .backNavigate();
        transferHijraController.backHome();
    }
}
