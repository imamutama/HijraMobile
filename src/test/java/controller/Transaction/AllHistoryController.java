package controller.Transaction;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.Transaction.AllHistoryPage;
import utils.GeneratedUtils;

public class AllHistoryController extends BaseController {

    AllHistoryPage allHistoryPage = new AllHistoryPage();

    public AllHistoryController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Scroll Text")
    public AllHistoryController scroolText() {
        scrollAndClickBytext("Riwayat Transfer");
        return this;
    }

    @Step("All Transaksi")
    public AllHistoryController allTransaksi() throws Exception {
        click(allHistoryPage.getAllHistory());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("List transaksi")
    public AllHistoryController listTransaksi(String listInOut) throws Exception {
        click(allHistoryPage.getBtnListTransaksi());
        GeneratedUtils.sleep(2000);
        if (listInOut.equals("Transaksi Masuk")) {
            click(allHistoryPage.getTransaksiMasuk());
            GeneratedUtils.sleep(2000);
        } else if (listInOut.equals("Transaksi Keluar")) {
            click(allHistoryPage.getTransaksiKeluar());
            GeneratedUtils.sleep(2000);
        }
        return this;
    }

    @Step("Choose List Transaksi")
    public AllHistoryController chooseList() throws Exception {
        click(allHistoryPage.getDaftarTransaksi());
        GeneratedUtils.sleep(2000);
        return this;
    }

}
