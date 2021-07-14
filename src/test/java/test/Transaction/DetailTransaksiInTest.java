package test.Transaction;

import controller.BaseController;
import controller.Transaction.AllHistoryController;
import controller.Transaction.DetailTransferController;
import controller.Transaction.ReceiptController;
import controller.Transaction.TransferHijraController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;
import utils.VariableProperties;
import utils.listeners.TestListener;


@Listeners({TestListener.class})
@Epic("TRANSACTIONS ")
@Feature("Detail ALL Transaksi IN")
public class DetailTransaksiInTest extends BaseTest {
    VariableProperties vp = new VariableProperties();
    private DetailTransferController detailTransferController;
    private AllHistoryController allHistoryController;

    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    @Description("List Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"listInOut"})
    public void detailTransferIn(String listInOut) throws Exception {
        allHistoryController = new AllHistoryController(driver);
        allHistoryController
                .scroolText()
                .allTransaksi()
                .listTransaksi(listInOut)
                .chooseList();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"namePengirim", "rekPengirim"})
    public void transferStatusIn(String namePengirim, String rekPengirim) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePenerimaDb(vp.getIDLogin())
                .validationBankDb(vp.getIDLogin())
                .scrollText("Tanggal Transaksi")
                .validationRekPenerimaDb(vp.getIDLogin())
                .validationDateDb(vp.getIDLogin())
                .validationTimeDb(vp.getIDLogin())
                .validationNamePengirimDb(namePengirim)
                .validationRekPengirimDb(rekPengirim)
                .scrollText("Lihat Bukti Transfer")
                .lihatBuktiTf();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"namePengirim", "rekPengirim"})
    public void transferDetailIn(String namePengirim, String rekPengirim) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationAmount(vp.getIDLogin())
                .validationNamePenerimaDb(vp.getIDLogin())
                .validationBankDb(vp.getIDLogin())
                .validationRekPenerimaDb(vp.getIDLogin())
                .validationDateDb(vp.getIDLogin())
                .validationTimeDb(vp.getIDLogin())
                .validationNamePengirimDb(namePengirim)
                .validationRekPengirimDb(rekPengirim)
                .scrollText("Simpan")
                .saveBuktiTransfer();
    }

}
