package Mobile.pages.OnBoarding.Register;

import org.openqa.selenium.By;

public class PersonalInfoPage {

    String text = "S1";

    private By validationLanjutInformasi = By.xpath("//android.widget.TextView[@text = 'Yuk, lanjut Upload Dokumen untuk selesaikan pendaftaran. ']");
    private By btnLanjutInformasi = By.xpath("//android.widget.TextView[@text = 'Lanjut Informasi Tambahan']");
    private By validationInfomasiTambahan = By.xpath("//android.widget.TextView[@text = 'Info keuangan']");
    private By btnListPendidikan = By.xpath("//android.widget.TextView[@text = 'Pendidikan Terakhir']");
    private By btnPekerjaan = By.xpath("//android.widget.TextView[@text = 'Pekerjaan']");
    private By btnJabatan = By.xpath("//android.widget.TextView[@text = 'Jabatan']");
    private By inputNamaKantor = By.xpath("//android.view.ViewGroup[4]/android.widget.EditText");
    private By inputAlamatKantor = By.xpath("//android.view.ViewGroup[5]/android.widget.EditText");
    private By btnSumberDana = By.xpath("//android.widget.TextView[@text = 'Sumber Dana']");
    private By btnTotalPenghasilan = By.xpath("//android.widget.TextView[@text = 'Total Penghasilan']");
    private By btnMaksudTujuan = By.xpath("//android.widget.TextView[@text = 'Maksud dan Tujuan']");
    private By inputIbuKandung = By.xpath("//android.view.ViewGroup[8]/android.widget.EditText");
    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");
    private By validationPekerjaanNull = By.xpath("//android.widget.TextView[@text = 'Pekerjaan Isi dulu ya']");
    private By validationPendidikanNull = By.xpath("//android.widget.TextView[@text = 'Pendidikan Terakhir Isi dulu ya']");
    private By validationJabatanNull = By.xpath("//android.widget.TextView[@text = 'Jabatan Isi dulu ya']");
    private By validationKantorNull = By.xpath("//android.widget.TextView[@text = 'Nama Kantor / Bisnis Isi dulu ya']");
    private By validationAlamatNull = By.xpath("//android.widget.TextView[@text = 'Alamat Kantor / Bisnis Isi dulu ya']");
    private By validationDanaNull = By.xpath("//android.widget.TextView[@text = 'Sumber Dana Isi dulu ya']");
    private By validationPenghasilanNull = By.xpath("//android.widget.TextView[@text = 'Total Penghasilan Isi dulu ya']");
    private By validationMaksudNull = By.xpath("//android.widget.TextView[@text = 'Maksud dan Tujuan Isi dulu ya']");
    private By validationNamaNull = By.xpath("//android.widget.TextView[@text = 'Nama Ibu Kandung Isi dulu ya']");
    private By continueInformasiTambahan = By.xpath("//android.widget.TextView[@text = 'Lanjut Informasi Tambahan']");

    public String getText() {
        return text;
    }

    public By getContinueInformasiTambahan() {
        return continueInformasiTambahan;
    }

    public By getBtnPekerjaan() {
        return btnPekerjaan;
    }

    public By getBtnJabatan() {
        return btnJabatan;
    }

    public By getInputNamaKantor() {
        return inputNamaKantor;
    }

    public By getInputAlamatKantor() {
        return inputAlamatKantor;
    }

    public By getBtnSumberDana() {
        return btnSumberDana;
    }

    public By getBtnTotalPenghasilan() {
        return btnTotalPenghasilan;
    }

    public By getBtnMaksudTujuan() {
        return btnMaksudTujuan;
    }

    public By getInputIbuKandung() {
        return inputIbuKandung;
    }

    public By getBtnLanjut() {
        return btnLanjut;
    }

    public By getValidationPekerjaanNull() {
        return validationPekerjaanNull;
    }

    public By getValidationPendidikanNull() {
        return validationPendidikanNull;
    }

    public By getValidationJabatanNull() {
        return validationJabatanNull;
    }

    public By getValidationKantorNull() {
        return validationKantorNull;
    }

    public By getValidationAlamatNull() {
        return validationAlamatNull;
    }

    public By getValidationDanaNull() {
        return validationDanaNull;
    }

    public By getValidationPenghasilanNull() {
        return validationPenghasilanNull;
    }

    public By getValidationMaksudNull() {
        return validationMaksudNull;
    }

    public By getValidationNamaNull() {
        return validationNamaNull;
    }

    public By getValidationLanjutInformasi() {
        return validationLanjutInformasi;
    }

    public By getBtnLanjutInformasi() {
        return btnLanjutInformasi;
    }

    public By getValidationInfomasiTambahan() {
        return validationInfomasiTambahan;
    }

    public By getBtnListPendidikan() {
        return btnListPendidikan;
    }

}
