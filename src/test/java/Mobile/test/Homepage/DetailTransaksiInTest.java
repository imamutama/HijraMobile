package Mobile.test.Homepage;

import Mobile.controller.Hompage.AllHistoryController;
import Mobile.controller.Hompage.DetailTransferController;
import Mobile.controller.OnBoarding.Login.LoginController;
import Mobile.controller.OnBoarding.StarActivityController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Mobile.test.BaseTest;
import Mobile.utils.VariableProperties;
import Mobile.utils.listeners.TestListener;


@Listeners({TestListener.class})
@Epic("TRANSACTIONS ")
@Feature("Detail ALL Transaksi IN")
public class DetailTransaksiInTest extends BaseTest {
    VariableProperties vp = new VariableProperties();
    private DetailTransferController detailTransferController;
    private AllHistoryController allHistoryController;
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
                .inputID(vp.getIDLogin())
                .inputPassword(vp.getPasswordLogin())
                .checkbox()
                .click_buttonMasuk();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("List Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"listInOut"})
    public void detailTransferIn(String listInOut) throws Exception {
        allHistoryController = new AllHistoryController(driver);
        allHistoryController
                .allTransaksi()
                .listTransaksi(listInOut)
                .chooseList();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusInNamePenerima() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePenerimaDb(vp.getIDLogin());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusInBank() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationBankDb(vp.getIDLogin(), "Status")
                .scrollEnd();

    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusInRekPenerima() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationRekPenerimaDb(vp.getIDLogin(), "Status");

    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusInDate() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationDateManual("14 Juli 2021,", "Status");
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusInTime() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationTimeDb(vp.getIDLogin(), "TransferIn", "Status");

    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userNamePengirim"})
    public void transferStatusInNamePengirim(String userNamePengirim) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePengirimDb(userNamePengirim);

    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userNamePengirim"})
    public void transferStatusInRekPengirim(String userNamePengirim) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationRekPengirimDb(userNamePengirim);

    }


    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailInAmount() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .lihatBuktiTf()
                .validationAmount(vp.getIDLogin(), "TransferIn");
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailInNamePenerima() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePenerimaDb(vp.getIDLogin());

    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailRekPenerima() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationRekPenerimaDb(vp.getIDLogin(), "Detail");

    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailInBank() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationBankDb(vp.getIDLogin(), "Detail");
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailInDate() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationDateManual("14 Juli 2021,", "Detail");
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailInTime() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationTimeDb(vp.getIDLogin(), "TransferIn", "Detail");
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userDetail"})
    public void transferDetailInNamePengirim(String userDetail) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePengirimDb(userDetail);
    }

    @Test(priority = 18)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userDetail"})
    public void transferDetailInRekPengirim(String userDetail) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .scrollEnd()
                .validationRekPengirimDb(userDetail);

    }

    @Test(priority = 19)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"validationSave"})
    public void transferDetailInValidation(String validationSave) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .saveBuktiTransfer()
                .validationSaveBukti(validationSave)
                .backHomePage();
    }
}
