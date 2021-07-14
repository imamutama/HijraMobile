package pages.Transaction;

import org.openqa.selenium.By;
import utils.VariableProperties;

import java.io.IOException;

public class TransferHijraPage {
    VariableProperties vp = new VariableProperties();

    private By btnHijraTransfer = By.xpath("//android.widget.TextView[@text = 'BPRS Hijra']");
    private By inputHijraIDRek = By.xpath("//android.widget.EditText");
    private By addFavorite = By.xpath("//android.widget.CheckBox");
    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");
    private By alertHijraNull = By.xpath("//android.widget.TextView[@text = 'Hijra ID / Nomor Rekening Isi dulu ya']");
    private By inputNominal = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By inputCatatan = By.xpath("//android.view.ViewGroup[3]/android.widget.EditText");
    private By alertNominalNull = By.xpath("//android.widget.TextView[@text = 'Nominal Isi dulu ya']");
    private By validationDetail = By.xpath("//android.widget.TextView[@text = '']");
    private By btnLanjutaKirim = By.xpath("//android.widget.TextView[@text = 'Lanjut Kirim']");
    private By btnUsePassword = By.xpath("//android.widget.TextView[@text = 'Gunakan password']");
    private By inputPass = By.xpath("//android.widget.EditText");
    private By kirimSekarang = By.xpath("//android.widget.TextView[@text = 'Kirim Sekarang']");
    private By alertPassNull = By.xpath("//android.widget.TextView[@text = 'Isi dulu ya']");
    private By validationRekPenerima = By.xpath("//android.view.ViewGroup[2]/android.widget.TextView[2]");
    private By validaitonNRekPengirim = By.xpath("//android.view.ViewGroup[5]/android.widget.TextView[2]");
    private By btnKembaliHome = By.xpath("//android.widget.TextView[@text = 'Kembali ke Homepage']");
    private By lihatReceipt = By.xpath("//android.widget.TextView[@text = 'Lihat Receipt']");
    private By statusTransfer = By.xpath("//android.widget.TextView[@text = 'Transaksi Berhasil']");
    private By listRiwayatTf = By.xpath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup");
    private By validationInvalidrekID = By.xpath("//android.widget.TextView[@text = 'Nomor rekening tidak ditemukan']");
    private By validaitonPassinvalid = By.xpath("/android.widget.TextView[@text = 'Password salah']");

    public By getValidaitonPassinvalid() {
        return validaitonPassinvalid;
    }

    public By getValidationInvalidrekID() {
        return validationInvalidrekID;
    }

    public By getListRiwayatTf() {
        return listRiwayatTf;
    }

    public By getStatusTransfer() {
        return statusTransfer;
    }

    public By getLihatReceipt() {
        return lihatReceipt;
    }

    public By getBtnKembaliHome() {
        return btnKembaliHome;
    }

    public By getValidationRekPenerima() {
        return validationRekPenerima;
    }

    public By getValidaitonNRekPengirim() {
        return validaitonNRekPengirim;
    }

    public VariableProperties getVp() {
        return vp;
    }

    public By getBtnHijraTransfer() {
        return btnHijraTransfer;
    }

    public By getInputHijraIDRek() {
        return inputHijraIDRek;
    }

    public By getAddFavorite() {
        return addFavorite;
    }

    public By getBtnLanjut() {
        return btnLanjut;
    }

    public By getAlertHijraNull() {
        return alertHijraNull;
    }

    public By getInputNominal() {
        return inputNominal;
    }

    public By getInputCatatan() {
        return inputCatatan;
    }

    public By getAlertNominalNull() {
        return alertNominalNull;
    }

    public By getValidationDetail() {
        return validationDetail;
    }

    public By getBtnLanjutaKirim() {
        return btnLanjutaKirim;
    }

    public By getBtnUsePassword() {
        return btnUsePassword;
    }

    public By getInputPass() {
        return inputPass;
    }

    public By getKirimSekarang() {
        return kirimSekarang;
    }

    public By getAlertPassNull() {
        return alertPassNull;
    }

}
