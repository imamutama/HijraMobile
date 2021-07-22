package Mobile.pages.OnBoarding.Login;

import org.openqa.selenium.By;

public class ForgotHijraPage {

    private By inputHp = By.xpath("//android.widget.EditText");
    private By lupaHijra = By.xpath("//android.widget.TextView[@text = 'Lupa Hijra ID']");
    private By kirimVerifikasi = By.xpath("//android.widget.TextView[@text = 'Kirim Verifikasi']");
    private By alertNullinput = By.xpath("//android.widget.TextView[@text = 'Isi dulu ya']");
    private By alertUserNotFound = By.xpath("//android.widget.TextView[@text = 'Nomor handphone tidak terdaftar']");
    private By inputFormatNotValid = By.xpath("//android.widget.TextView[@text = 'Format nomor handphone salah']");
    private By inputIDKtp = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By inputIbuKandung = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By validationIDIbuNotValid = By.xpath("//android.widget.TextView[@text = 'NIK dan Nama ibu kandung tidak sesuai!']");
    private By validationIbuNotValid = By.xpath("//android.widget.TextView[@text = 'Nama ibu kandung tidak sesuai!']");
    private By validationKtpNotValid = By.xpath("//android.widget.TextView[@text = 'NIK tidak sesuai!']");
    private By validationHijraIDDisplay = By.xpath("//android.widget.EditText");
    private By kembaliLogin = By.xpath("//android.widget.TextView[@text = 'Kembali ke Log In']");
    private By btnAllowGalery = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By btnKirim = By.xpath("//android.widget.TextView[@text = 'Kirim']");

    public By getBtnKirim() {
        return btnKirim;
    }

    public By getBtnAllowGalery() {
        return btnAllowGalery;
    }

    public By getValidationIbuNotValid() {
        return validationIbuNotValid;
    }

    public By getLupaHijra() {
        return lupaHijra;
    }

    public By getKembaliLogin() {
        return kembaliLogin;
    }

    public By getValidationHijraIDDisplay() {
        return validationHijraIDDisplay;
    }

    public By getValidationIDIbuNotValid() {
        return validationIDIbuNotValid;
    }

    public By getValidationKtpNotValid() {
        return validationKtpNotValid;
    }

    public By getInputIDKtp() {
        return inputIDKtp;
    }

    public By getInputFormatNotValid() {
        return inputFormatNotValid;
    }

    public By getInputHp() {
        return inputHp;
    }

    public By getInputIbuKandung() {
        return inputIbuKandung;
    }

    public By getKirimVerifikasi() {
        return kirimVerifikasi;
    }

    public By getAlertNullinput() {
        return alertNullinput;
    }

    public By getAlertUserNotFound() {
        return alertUserNotFound;
    }
}
