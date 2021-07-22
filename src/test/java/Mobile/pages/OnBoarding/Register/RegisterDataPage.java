package Mobile.pages.OnBoarding.Register;

import org.openqa.selenium.By;

public class RegisterDataPage {
    private By btnDaftar = By.xpath("//android.widget.TextView[@text = 'Daftar']");
    private By btnMulai = By.xpath("//android.widget.TextView[@text = 'Daftar']");
    private By checkBox1 = By.xpath("//android.view.ViewGroup[1]/android.widget.CheckBox");
    private By checkBox2 = By.xpath("//android.view.ViewGroup[2]/android.widget.CheckBox");
    private By checkBox3 = By.xpath("//android.view.ViewGroup[3]/android.widget.CheckBox");
    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");
    private By inputHijraID = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By inputEmail = By.xpath("//android.view.ViewGroup[3]/android.widget.EditText");
    private By inputPassword = By.xpath("//android.view.ViewGroup[4]/android.widget.EditText");
    private By inputKonfirm = By.xpath("//android.view.ViewGroup[6]/android.widget.EditText");
    private By inputNoHp = By.xpath("//android.view.ViewGroup[10]/android.widget.EditText");
    private By privacyPolicce = By.xpath("//android.widget.TextView[@text = 'Privacy Policy']");
    private By alertFormNull = By.xpath("//android.widget.TextView[@text = 'Form Isi dulu ya']");
    private By alertHijraIDnotValid = By.xpath("//android.widget.TextView[@text = 'Maaf, belum memenuhi kriteria Hijra ID.']");
    private By alertEmailNull = By.xpath("//android.widget.TextView[@text = 'Email Isi dulu ya']");
    private By alertPassswordNull = By.xpath("//android.widget.TextView[@text = 'Password Isi dulu ya']");
    private By alertPasswordNotvalid = By.xpath("//android.widget.TextView[@text = 'Maaf, belum memenuhi kriteria password.']");
    private By alertPasswordNotSame = By.xpath("//android.widget.TextView[@text = 'Password tidak sama']");
    private By alertKonfirmNull = By.xpath("//android.widget.TextView[@text = 'Konfirmasi Password Isi dulu ya']");
    private By alertHpNull = By.xpath("//android.widget.TextView[@text = 'Nomor Handphone Isi dulu ya']");
    private By alertHijraIDNull = By.xpath("//android.widget.TextView[@text = 'Hijra ID Isi dulu ya']");
    private By alertHijraIDterpakai = By.xpath("//android.widget.TextView[@text = 'Maaf, Hijra ID sudah terpakai. Coba yang lain ya']");
    private By tentangHijra =  By.xpath("//android.widget.TextView[@text = 'Tentang Bank Hijra']");
    private By lihatSelengkapnya = By.xpath("//android.widget.TextView[@text = 'Lihat selengkapnya']");
    private By noHpEnabled = By.xpath("//android.widget.TextView[@text = 'Maaf, nomor handphone sudah terpakai.']");
    private By warningHijraInvalid = By.xpath("//android.widget.TextView[@text = 'Hijra ID harus terdiri dari angka']");
    private By warningHijraValid = By.xpath("//android.widget.TextView[@text = 'Hijra ID minimal 6 karakter dengan huruf dan angka.']");
    private By warningPassInvalid = By.xpath("//android.widget.TextView[@text = 'Password harus terdiri dari angka']");
    private By warningPassValid = By.xpath("//android.widget.TextView[@text = 'Password minimal 8 karakter dengan huruf dan angka.']");

    public By getWarningHijraInvalid() {
        return warningHijraInvalid;
    }

    public By getWarningHijraValid() {
        return warningHijraValid;
    }

    public By getWarningPassInvalid() {
        return warningPassInvalid;
    }

    public By getWarningPassValid() {
        return warningPassValid;
    }

    public By getNoHpEnabled() {
        return noHpEnabled;
    }

    public By getTentangHijra() {
        return tentangHijra;
    }

    public By getLihatSelengkapnya() {
        return lihatSelengkapnya;
    }

    public By getAlertHijraIDNull() {
        return alertHijraIDNull;
    }

    public By getAlertHijraIDterpakai() {
        return alertHijraIDterpakai;
    }

    public By getInputEmail() {
        return inputEmail;
    }

    public By getInputPassword() {
        return inputPassword;
    }

    public By getInputKonfirm() {
        return inputKonfirm;
    }

    public By getInputNoHp() {
        return inputNoHp;
    }

    public By getPrivacyPolicce() {
        return privacyPolicce;
    }

    public By getAlertFormNull() {
        return alertFormNull;
    }

    public By getAlertHijraIDnotValid() {
        return alertHijraIDnotValid;
    }

    public By getAlertEmailNull() {
        return alertEmailNull;
    }

    public By getAlertPassswordNull() {
        return alertPassswordNull;
    }

    public By getAlertPasswordNotvalid() {
        return alertPasswordNotvalid;
    }

    public By getAlertPasswordNotSame() {
        return alertPasswordNotSame;
    }

    public By getAlertKonfirmNull() {
        return alertKonfirmNull;
    }

    public By getAlertHpNull() {
        return alertHpNull;
    }

    public By getBtnLanjut() {
        return btnLanjut;
    }

    public By getBtnDaftar() {
        return btnDaftar;
    }

    public By getBtnMulai() {
        return btnMulai;
    }

    public By getCheckBox1() {
        return checkBox1;
    }

    public By getCheckBox2() {
        return checkBox2;
    }

    public By getCheckBox3() {
        return checkBox3;
    }

    public By getInputHijraID() {
        return inputHijraID;
    }
}
