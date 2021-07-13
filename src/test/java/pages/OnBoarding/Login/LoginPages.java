package pages.OnBoarding.Login;

import org.openqa.selenium.By;

public class LoginPages {

    private By btnMasuk = By.xpath("//android.widget.TextView[@text = 'Masuk']");
    private By inputHijraID = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By inputPassword = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By chekboxSimpan = By.xpath("//android.widget.CheckBox");
    private By linkTentangHijra = By.xpath("//android.widget.TextView[@text = 'Tentang Hijra Bank']");
    private By btnMasukForm = By.xpath("//android.widget.TextView[@text = 'Masuk']");
    private By btnLupaID = By.xpath("//android.widget.TextView[@text = 'Lupa Hijra ID']");
    private By btnAllowPermisson = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By alertFormNull = By.xpath("//android.widget.TextView[@text = 'Form Isi dulu ya']");
    private By alertHijraIDNull = By.xpath("//android.widget.TextView[@text = 'Hijra ID Isi dulu ya']");
    private By alertPasswordNull = By.xpath("//android.widget.TextView[@text = 'Password Isi dulu ya']");
    private By alertInvalid3x= By.xpath("//android.widget.TextView[@text = 'Password salah sebanyak 3x. Silakan reset password saat log in']");
    private By alertInvalidLogin = By.xpath("//android.widget.TextView[@text = 'Hijra ID atau Password salah (1/3)']");
    private By btnLupasPass = By.xpath("//android.widget.TextView[@text = 'Lupa password']");
    private By alertPassNull = By.xpath("//android.widget.TextView[@text = 'Password Isi dulu ya']");
    private By alertIDNull = By.xpath("//android.widget.TextView[@text = 'Hijra ID Isi dulu ya']");
    private By alertloginInvalid = By.xpath("//android.widget.TextView[@text = 'Hijra ID atau Password salah (1/3)']");
    private By alertAkunNotVerifikasi = By.xpath("//android.widget.TextView[@text = 'Akun anda belum terverifikasi']");
    private By btnOkeAlertNotVerifikasi = By.xpath("//android.widget.TextView[@text = 'OK']");

    public By getAlertAkunNotVerifikasi() {
        return alertAkunNotVerifikasi;
    }

    public By getBtnOkeAlertNotVerifikasi() {
        return btnOkeAlertNotVerifikasi;
    }

    public By getAlertHijraIDNull() {
        return alertHijraIDNull;
    }

    public By getAlertPasswordNull() {
        return alertPasswordNull;
    }

    public By getAlertInvalid3x() {
        return alertInvalid3x;
    }

    public By getAlertInvalidLogin() {
        return alertInvalidLogin;
    }

    public By getBtnAllowPermisson() {
        return btnAllowPermisson;
    }

    public By getBtnMasuk() {
        return btnMasuk;
    }

    public By getInputHijraID() {
        return inputHijraID;
    }

    public By getInputPassword() {
        return inputPassword;
    }

    public By getChekboxSimpan() {
        return chekboxSimpan;
    }

    public By getLinkTentangHijra() {
        return linkTentangHijra;
    }

    public By getBtnMasukForm() {
        return btnMasukForm;
    }

    public By getBtnLupaID() {
        return btnLupaID;
    }

    public By getBtnLupasPass() {
        return btnLupasPass;
    }

    public By getAlertFormNull() {
        return alertFormNull;
    }

    public By getAlertPassNull() {
        return alertPassNull;
    }

    public By getAlertIDNull() {
        return alertIDNull;
    }

    public By getAlertloginInvalid() {
        return alertloginInvalid;
    }


}
