package Mobile.pages.Hompage;

import org.openqa.selenium.By;

public class DetailTransferPage {

    private By btnDetailTransaction = By.xpath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup//android.widget.Te");
    private By validationSuccesTf = By.xpath("//android.widget.TextView[@text = 'Transaksi Berhasil']");
    private By noTransaksi = By.xpath("//android.widget.TextView[3]");
    private By namaPenerima = By.xpath("//android.widget.TextView[5]");
    private By namaBank = By.xpath("//android.widget.TextView[7]");
    private By rekPenerimaDetail = By.xpath("//android.widget.TextView[7]");
    private By rekeningPenerima = By.xpath("//android.widget.TextView[9]");
    private By dateDetail = By.xpath("//android.widget.TextView[9]");
    private By timeDetail = By.xpath("//android.widget.TextView[10]");
    private By bankDetail = By.xpath("//android.widget.TextView[12]");
    private By tglTransaksi = By.xpath("//android.widget.TextView[11]");
    private By timeTransaksi = By.xpath("//android.widget.TextView[12]");
    private By namaPengirim = By.xpath("//android.widget.TextView[14]");
    private By rekPengirim = By.xpath("//android.widget.TextView[16]");
    private By catatan = By.xpath("//android.widget.TextView[18]");
    private By buktiTransfer = By.xpath("//android.widget.TextView[@text = 'Lihat Bukti Transfer']");
    private By btnShare = By.xpath("//android.widget.TextView[@text = 'Share']");
    private By btnAllowGalery = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By simpanSebagaiGambar = By.xpath("//android.view.ViewGroup[2]/android.widget.TextView");
    private By simpanSebagaiPdf = By.xpath("//android.view.ViewGroup[3]/android.widget.TextView");
    private By validationSimpanDetail = By.xpath("//android.widget.TextView[@text = 'Bukti transaksi berhasil disimpan']");
    private By btnKembaliHome = By.xpath("//android.view.ViewGroup[3]//android.widget.TextView");
    private By amountValidation = By.xpath("//android.widget.TextView[1]");
    private By btnSimpanBuktiTf = By.xpath("//android.widget.TextView[@text = 'Simpan']");

    public By getRekPenerimaDetail() {
        return rekPenerimaDetail;
    }

    public By getDateDetail() {
        return dateDetail;
    }

    public By getTimeDetail() {
        return timeDetail;
    }

    public By getBankDetail() {
        return bankDetail;
    }

    public By getCatatan() {
        return catatan;
    }

    public By getBtnSimpanBuktiTf() {
        return btnSimpanBuktiTf;
    }

    public By getAmountValidation() {
        return amountValidation;
    }

    public By getValidationSuccesTf() {
        return validationSuccesTf;
    }

    public By getBtnDetailTransaction() {
        return btnDetailTransaction;
    }

    public By getNoTransaksi() {
        return noTransaksi;
    }

    public By getNamaPenerima() {
        return namaPenerima;
    }

    public By getNamaBank() {
        return namaBank;
    }

    public By getRekeningPenerima() {
        return rekeningPenerima;
    }

    public By getTglTransaksi() {
        return tglTransaksi;
    }

    public By getTimeTransaksi() {
        return timeTransaksi;
    }

    public By getNamaPengirim() {
        return namaPengirim;
    }

    public By getRekPengirim() {
        return rekPengirim;
    }

    public By getBuktiTransfer() {
        return buktiTransfer;
    }

    public By getBtnShare() {
        return btnShare;
    }

    public By getBtnAllowGalery() {
        return btnAllowGalery;
    }

    public By getSimpanSebagaiGambar() {
        return simpanSebagaiGambar;
    }

    public By getSimpanSebagaiPdf() {
        return simpanSebagaiPdf;
    }

    public By getValidationSimpanDetail() {
        return validationSimpanDetail;
    }

    public By getBtnKembaliHome() {
        return btnKembaliHome;
    }
}
