package Mobile.pages.Transaction;

import org.openqa.selenium.By;
import Mobile.utils.VariableProperties;

public class TransferHijraPage {

    private By btnHijraTransfer = By.xpath("//android.widget.TextView[@text = 'BPRS Hijra']");
    private By inputHijraIDRek = By.xpath("//android.widget.EditText");
    private By addFavorite = By.xpath("//android.widget.CheckBox");
    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");
    private By alertHijraNull = By.xpath("//android.widget.TextView[@text = 'Hijra ID / Nomor Rekening Isi dulu ya']");
    private By inputNominal = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By inputCatatan = By.xpath("//android.view.ViewGroup[3]/android.widget.EditText");
    private By alertNominalNull = By.xpath("//android.widget.TextView[@text = 'Nominal Isi dulu ya']");
    private By validationMinimalLimitMin = By.xpath("//android.widget.TextView[@text = 'minimal transaksi Rp 10.000']");
    private By validationMinimalLimitMax = By.xpath("//android.widget.TextView[@text = 'maksimal transaksi Rp. 25.000.000']");
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
    private By validationFormatInvalid = By.xpath("//android.widget.TextView[@text = 'Password Salah']");
    private By passInvalid3x = By.xpath("//android.widget.TextView[2]");
    private By akunTerkunci = By.xpath("//android.widget.TextView[1]");
    private By keluarApp = By.xpath("//android.widget.TextView[@text = 'Keluar Aplikasi']");

    public By getPassInvalid3x() {
        return passInvalid3x;
    }

    public By getAkunTerkunci() {
        return akunTerkunci;
    }

    public By getKeluarApp() {
        return keluarApp;
    }

    public By getValidaitonPassinvalid() {
        return validationFormatInvalid;
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

    public By getValidationMinimalLimitMin() {
        return validationMinimalLimitMin;
    }

    public By getValidationMinimalLimitMax() {
        return validationMinimalLimitMax;
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
