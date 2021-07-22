package Mobile.pages.Transaction;

import org.openqa.selenium.By;

public class ReceiptPage {
    private By validationSuccesTf = By.xpath("//android.widget.TextView[@text = 'Transaksi Berhasil']");
    private By amount = By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]");
    private By biayaAdmin = By.xpath("//android.widget.TextView[2]");
    private By namaPenerima = By.xpath("//android.widget.TextView[6]");
    private By rekeningPenerima = By.xpath("//android.widget.TextView[8]");
    private By tglTransaksi = By.xpath("//android.widget.TextView[10]");
    private By timeTransaksi = By.xpath("//android.widget.TextView[11]");
    private By namaBank = By.xpath("//android.widget.TextView[12]");
    private By namaPengirim = By.xpath("//android.widget.TextView[14]");
    private By rekPengirim = By.xpath("//android.widget.TextView[16]");
    private By btnKembaliHome = By.xpath("//android.widget.TextView[@text = 'Kembali ke Homepage']");

    public By getBtnKembaliHome() {
        return btnKembaliHome;
    }

    public By getTimeTransaksi() {
        return timeTransaksi;
    }

    public By getValidationSuccesTf() {
        return validationSuccesTf;
    }

    public By getAmount() {
        return amount;
    }

    public By getBiayaAdmin() {
        return biayaAdmin;
    }

    public By getNamaPenerima() {
        return namaPenerima;
    }

    public By getRekeningPenerima() {
        return rekeningPenerima;
    }

    public By getTglTransaksi() {
        return tglTransaksi;
    }

    public By getNamaBank() {
        return namaBank;
    }

    public By getNamaPengirim() {
        return namaPengirim;
    }

    public By getRekPengirim() {
        return rekPengirim;
    }
}
