package test.Transaction;

import controller.Transaction.AllHistoryController;
import controller.Transaction.DetailTransferController;
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
public class DetailTransaksiOutTest extends BaseTest {

    VariableProperties vp = new VariableProperties();
    private DetailTransferController detailTransferController;
    private AllHistoryController allHistoryController;

    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    @Description("List Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters()
    public void listTransaksiOut(String listInOut) throws Exception {
        allHistoryController = new AllHistoryController(driver);
        allHistoryController
                .listTransaksi(listInOut)
                .chooseList();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"namePengirim", "rekPengirim"})
    public void transferStatusOut(String namePengirim, String rekPengirim) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePenerimaDb(namePengirim)
                .validationBankDb(vp.getIDLogin())
                .scrollText("Tanggal Transaksi")
                .validationRekPenerimaDb(rekPengirim)
                .validationDateDb(vp.getIDLogin())
                .validationTimeDb(vp.getIDLogin())
                .validationNamePengirimDb(vp.getIDLogin())
                .validationRekPengirimDb(vp.getIDLogin())
                .scrollText("Lihat Bukti Transfer")
                .lihatBuktiTf();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"namePengirim", "rekPengirim"})
    public void transferDetailOut(String namePengirim, String rekPengirim) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationAmount(vp.getIDLogin())
                .validationNamePenerimaDb(namePengirim)
                .validationBankDb(rekPengirim)
                .validationRekPenerimaDb(vp.getIDLogin())
                .validationDateDb(vp.getIDLogin())
                .validationTimeDb(vp.getIDLogin())
                .validationNamePengirimDb(vp.getIDLogin())
                .validationRekPengirimDb(vp.getIDLogin())
                .scrollText("Simpan")
                .saveBuktiTransfer();
    }
}
