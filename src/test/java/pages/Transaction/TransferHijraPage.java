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
    private By btnUsePassword = By.xpath("//android.widget.TextView[@text = 'use password']");
    private By inputPass = By.xpath("//android.widget.EditText");
    private By kirimSekarang = By.xpath("//android.widget.TextView[@text = 'Kirim Sekarang']");
    private By alertPassNull = By.xpath("//android.widget.TextView[@text = 'Isi dulu ya']");
    private By alertPassInvalid = By.xpath("//android.widget.TextView[@text = 'Terjadi kesalahan']");
    private By validationRekPenerima = By.xpath("//android.view.ViewGroup[2]/android.widget.TextView[2]");
    private By validaitonNRekPengirim = By.xpath("//android.view.ViewGroup[5]/android.widget.TextView[2]");

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

    public By getAlertPassInvalid() {
        return alertPassInvalid;
    }
}
