package pages.OnBoarding.Login;

import org.openqa.selenium.By;

public class ForgotHijraPage {

    private By inputHp = By.xpath("//android.widget.EditText");
    private By lupaHijra = By.xpath("//android.widget.TextView[@text = 'Lupa Hijra ID']");
    private By kirimVerifikasi = By.xpath("//android.widget.TextView[@text = 'Kirim Verifikasi']");
    private By alertNullinput = By.xpath("//android.widget.TextView[@text = 'Isi dulu ya']");
    private By alertUserNotFound = By.xpath("//android.widget.TextView[@text = 'User not found']");
    private By inputFormatNotValid = By.xpath("//android.widget.TextView[@text = 'Format nomor handphone salah']");
    private By inputIDKtp = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By inputIbuKandung = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By validationIDIbuNotValid = By.xpath("//android.widget.TextView[@text = '']");
    private By validationIDnotvalid = By.xpath("//android.widget.TextView[@text = '']");
    private By validationKtpNotValid = By.xpath("//android.widget.TextView[@text = '']");
    private By validationHijraIDDisplay = By.xpath("//android.widget.EditText");
    private By kembaliLogin = By.xpath("//android.widget.TextView[@text = 'Kembali ke Log In']");


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

    public By getValidationIDnotvalid() {
        return validationIDnotvalid;
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
