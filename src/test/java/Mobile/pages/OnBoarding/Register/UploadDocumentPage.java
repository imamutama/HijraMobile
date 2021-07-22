package Mobile.pages.OnBoarding.Register;

import org.openqa.selenium.By;

public class UploadDocumentPage {
    private By btnLanjutUpload = By.xpath("//android.widget.TextView[@text = 'Lanjut Upload Dokumen']");
    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");
    private By btnAllowRecord = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By btnAllowGalery = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By btnCamera = By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup");
    private By inputKTP = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By inputName = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By inputTglLahir = By.xpath("//android.widget.TextView[@text = 'Tanggal Lahir']");
    private By getDay = By.xpath("//android.widget.NumberPicker[1]/android.widget.EditText");
    private By getMonth = By.xpath("//android.widget.NumberPicker[2]/android.widget.EditText");
    private By getYears = By.xpath("//android.widget.NumberPicker[3]/android.widget.EditText");
    private By btnOkCalendar = By.xpath("//android.widget.Button[@text = 'OK']");
    private By alertErrorKtp = By.xpath("//android.widget.TextView[@text = 'Nomor eKTP Isi dulu ya']");
    private By alertKtp16Digit = By.xpath("//android.widget.TextView[@text = 'Pastikan Nomor KTP 16 digit']");
    private By alertErorrname = By.xpath("//android.widget.TextView[@text = 'Nama Isi dulu ya']");
    private By alertTglLahirError = By.xpath("//android.widget.TextView[@text = 'Tanggal Lahir Isi dulu ya']");
    private By alertKtpEnabled = By.xpath("//android.widget.TextView[@text = 'KTP sudah terdaftar']");
    private By btnAmbilUlang = By.xpath("//android.widget.TextView[@text = 'Ambil Ulang']");
    private By btnGunakan = By.xpath("//android.widget.TextView[@text = 'Gunakan']");
    private By btnCancel = By.xpath("//android.widget.Button[@text = 'CANCEL']");
    private By btnHapus = By.xpath("//android.widget.TextView[@text = 'Hapus']");
    private By btnAmbilFotoBaru = By.xpath("//android.widget.TextView[@text = 'Ambil foto baru']");
    private By btnBuatUlang = By.xpath("//android.widget.TextView[@text = 'Buat Ulang']");
    private By continueRegister = By.xpath("//android.widget.TextView[@text = 'Yuk, lanjut Upload Dokumen untuk selesaikan pendaftaran. ']");
    private By validationNextUploadDoc = By.xpath("//android.widget.TextView[3][@text = 'Upload Dokumen']");


    public By getAlertKtpEnabled() {
        return alertKtpEnabled;
    }

    public By getContinueRegister() {
        return continueRegister;
    }

    public By getValidationNextUploadDoc() {
        return validationNextUploadDoc;
    }

    public By getBtnHapus() {
        return btnHapus;
    }

    public By getBtnAmbilFotoBaru() {
        return btnAmbilFotoBaru;
    }

    public By getBtnBuatUlang() {
        return btnBuatUlang;
    }

    public By getBtnCancel() {
        return btnCancel;
    }

    public By getBtnLanjutUpload() {
        return btnLanjutUpload;
    }

    public By getBtnLanjut() {
        return btnLanjut;
    }

    public By getBtnAllowGalery() {
        return btnAllowGalery;
    }

    public By getBtnAllowRecord() {
        return btnAllowRecord;
    }

    public By getBtnCamera() {
        return btnCamera;
    }

    public By getInputKTP() {
        return inputKTP;
    }

    public By getInputName() {
        return inputName;
    }

    public By getInputTglLahir() {
        return inputTglLahir;
    }

    public By getGetDay() {
        return getDay;
    }

    public By getGetMonth() {
        return getMonth;
    }

    public By getGetYears() {
        return getYears;
    }

    public By getBtnOkCalendar() {
        return btnOkCalendar;
    }

    public By getAlertErrorKtp() {
        return alertErrorKtp;
    }

    public By getAlertKtp16Digit() {
        return alertKtp16Digit;
    }

    public By getAlertErorrname() {
        return alertErorrname;
    }

    public By getAlertTglLahirError() {
        return alertTglLahirError;
    }

    public By getBtnAmbilUlang() {
        return btnAmbilUlang;
    }

    public By getBtnGunakan() {
        return btnGunakan;
    }
}
