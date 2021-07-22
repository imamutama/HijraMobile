package Mobile.pages.OnBoarding.Login;

import org.openqa.selenium.By;

public class ForgotPasswordPage {

    private By lupaPassword = By.xpath("//android.widget.TextView[@text = 'Lupa password?']");
    private By inputHijraID = By.xpath("//android.widget.EditText");
    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");
    private By btnKirim = By.xpath("//android.widget.TextView[@text = 'Kirim']");
    private By alertNullinput = By.xpath("//android.widget.TextView[@text = 'Isi dulu ya']");
    private By alertUserNotFound = By.xpath("//android.widget.TextView[@text = 'Username tidak terdaftar']");
    private By alertFormatIDInvalid = By.xpath("//android.widget.TextView[@text = 'Maaf, username tidak sesuai syarat.']");
    private By inputIDKtp = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By inputIbuKandung = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By validationIDIbuNotValid = By.xpath("//android.widget.TextView[@text = 'NIK dan Nama ibu kandung tidak sesuai!']");
    private By validationIbuNotValid = By.xpath("//android.widget.TextView[@text = 'Nama ibu kandung tidak sesuai!']");
    private By validationKtpNotValid = By.xpath("//android.widget.TextView[@text = 'NIK tidak sesuai!']");
    private By inputPassword = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By inputKonfirm = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By validationPassNotSame = By.xpath("//android.widget.TextView[@text = 'Password tidak sama']");
    private By validationPassAngka = By.xpath("//android.widget.TextView[@text = 'Password harus terdiri dari angka']");
    private By validation8char = By.xpath("//android.widget.TextView[@text = 'Minimal password 8 karakter']");
    private By passwordEnabled = By.xpath("//android.widget.TextView[@text = 'Password baru tidak boleh sama dengan password lama']");
    private By btnSimpan = By.xpath("//android.widget.TextView[@text = 'Simpan']");
    private By validationSuccess = By.xpath("//android.widget.TextView[@text = 'Alhamdulillah, password disimpan!']");
    private By btnAllowGalery = By.id("com.android.packageinstaller:id/permission_allow_button");

    public By getAlertUserNotFound() {
        return alertUserNotFound;
    }

    public By getValidationIbuNotValid() {
        return validationIbuNotValid;
    }

    public By getBtnAllowGalery() {
        return btnAllowGalery;
    }

    public By getBtnKirim() {
        return btnKirim;
    }

    public By getLupaPassword() {
        return lupaPassword;
    }

    public By getPasswordEnabled() {
        return passwordEnabled;
    }

    public By getBtnSimpan() {
        return btnSimpan;
    }

    public By getValidationSuccess() {
        return validationSuccess;
    }

    public By getValidationPassNotSame() {
        return validationPassNotSame;
    }

    public By getValidationPassAngka() {
        return validationPassAngka;
    }

    public By getValidation8char() {
        return validation8char;
    }

    public By getInputPassword() {
        return inputPassword;
    }

    public By getInputKonfirm() {
        return inputKonfirm;
    }

    public By getAlertFormatIDInvalid() {
        return alertFormatIDInvalid;
    }

    public By getInputIDKtp() {
        return inputIDKtp;
    }

    public By getInputIbuKandung() {
        return inputIbuKandung;
    }

    public By getValidationIDIbuNotValid() {
        return validationIDIbuNotValid;
    }

    public By getValidationIDnotvalid() {
        return validationIbuNotValid;
    }

    public By getValidationKtpNotValid() {
        return validationKtpNotValid;
    }

    public By getInputHijraID() {
        return inputHijraID;
    }

    public By getBtnLanjut() {
        return btnLanjut;
    }

    public By getAlertNullinput() {
        return alertNullinput;
    }
}
