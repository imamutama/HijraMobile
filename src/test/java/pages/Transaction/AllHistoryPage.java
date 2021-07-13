package pages.Transaction;

import org.openqa.selenium.By;

public class AllHistoryPage {

    private By daftarTransaksi = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    private By btnListTransaksi = By.xpath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup");
    private By btnDate = By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private By validationListTransaction = By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[3]");
    private By transaksiMasuk = By.xpath("//android.widget.TextView[@text = 'Transaksi Masuk']");
    private By transaksiKeluar = By.xpath("//android.widget.TextView[@text = 'Transaksi Keluar']");

    public By getDaftarTransaksi() {
        return daftarTransaksi;
    }

    public By getBtnListTransaksi() {
        return btnListTransaksi;
    }

    public By getBtnDate() {
        return btnDate;
    }

    public By getValidationListTransaction() {
        return validationListTransaction;
    }

    public By getTransaksiMasuk() {
        return transaksiMasuk;
    }

    public By getTransaksiKeluar() {
        return transaksiKeluar;
    }
}
