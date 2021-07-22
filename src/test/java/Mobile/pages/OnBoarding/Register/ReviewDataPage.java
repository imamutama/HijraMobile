package Mobile.pages.OnBoarding.Register;

import org.openqa.selenium.By;

public class ReviewDataPage {

    private By inputTempatLahir1 = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By inputTempatLahir2 = By.xpath("//android.view.ViewGroup[3]/android.widget.EditText");
    private By inputTempatLahir3 = By.xpath("//android.view.ViewGroup[4]/android.widget.EditText");
    private By inputTempatLahir4 = By.xpath("//android.view.ViewGroup[5]/android.widget.EditText");;
    private By validationTTL = By.xpath("//android.widget.TextView[@text = 'Tempat Lahir']");
    private By selectProvinci = By.xpath("//android.widget.TextView[@text = 'Provinsi']");
    private By selectKota = By.xpath("//android.widget.TextView[@text = 'Kota / Kabupaten']");
    private By selectKecamatan = By.xpath("//android.widget.TextView[@text = 'Kecamatan']");
    private By selectKelurahan = By.xpath("//android.widget.TextView[@text = 'Kelurahan / Desa']");
    private By inputRTRW = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By inputAlamat = By.xpath("//android.view.ViewGroup[3]/android.widget.EditText");
    private By selectPerkawinan = By.xpath("//android.widget.TextView[@text = 'Status Perkawinan']");
    private By selectJenisKelamin = By.xpath("//android.widget.TextView[@text = 'Jenis Kelamin']");
    private By selectKewarganegara = By.xpath("//android.widget.TextView[@text = 'Kewarganegaraan']");
    private By Inputsearch = By.xpath("//android.widget.EditText");
    private By btnLanjutReview = By.xpath("//android.widget.TextView[@text = 'Lanjut Review Data']");
    private By selectMenikah = By.xpath("//android.widget.TextView[@text = 'Menikah']");
    private By selectLajang = By.xpath("//android.widget.TextView[@text = 'Lajang']");
    private By selectLaki = By.xpath("//android.widget.TextView[@text = 'Laki-Laki']");
    private By selectPerempuan = By.xpath("//android.widget.TextView[@text = 'Perempuan']");
    private By selectIndonesia = By.xpath("//android.widget.TextView[@text = 'Indonesia']");
    private By selectNonIndo = By.xpath("//android.widget.TextView[@text = 'Non Indonesia']");
    private By validationEmailNull = By.xpath("//android.widget.TextView[@text = 'Email Isi dulu ya']");
    private By validationTempatNull = By.xpath("//android.widget.TextView[@text = 'Tempat Lahir Isi dulu ya']");
    private By validationProvinsiNull = By.xpath("//android.widget.TextView[@text = 'Provinsi Isi dulu ya']");
    private By validationKotaNull = By.xpath("//android.widget.TextView[@text = 'Kota / Kabupaten Isi dulu ya']");
    private By validationKecamatanNull = By.xpath("//android.widget.TextView[@text = 'Kecamatan Isi dulu ya']");
    private By validationKelurahanNull = By.xpath("//android.widget.TextView[@text = 'Kelurahan / Desa Isi dulu ya']");
    private By validationRTNull = By.xpath("//android.widget.TextView[@text = 'RT / RW Isi dulu ya']");
    private By validationAlamatNull = By.xpath("//android.widget.TextView[@text = 'Alamat Isi dulu ya']");
    private By validationStatusNull = By.xpath("//android.widget.TextView[@text = 'Status Perkawinan Isi dulu ya']");
    private By validationRTInvalid = By.xpath("//android.widget.TextView[@text = 'Format RT/RW tidak sesuai']");
    private By validationJenisNull = By.xpath("//android.widget.TextView[@text = 'Jenis Kelamin Isi dulu ya']");
    private By validationKewarganegaraNull = By.xpath("//android.widget.TextView[@text = 'Kewarganegaraan Isi dulu ya']");
    private By getSelect = By.xpath("//android.widget.TextView");
    private By validationKodePos = By.xpath("//android.view.ViewGroup[7]/android.widget.EditText");
    private By continuteReviewData = By.xpath("//android.widget.TextView[@text = 'Lanjut Review Data']");
    private By validationnNextReviewData = By.xpath("//android.widget.TextView[@text = 'Alhamdulillah!']");


    public By getInputTempatLahir2() {
        return inputTempatLahir2;
    }

    public By getInputTempatLahir1() {
        return inputTempatLahir1;
    }

    public By getInputTempatLahir3() {
        return inputTempatLahir3;
    }

    public By getInputTempatLahir4() {
        return inputTempatLahir4;
    }

    public By getValidationTTL() {
        return validationTTL;
    }

    public By getValidationnNextReviewData() {
        return validationnNextReviewData;
    }

    public By getContinuteReviewData() {
        return continuteReviewData;
    }

    public By getBtnLanjut() {
        return btnLanjut;
    }

    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");


    public By getGetSelect() {
        return getSelect;
    }

    public By getValidationKodePos() {
        return validationKodePos;
    }

    public By getGetSelectList() {
        return getSelect;
    }

    public By getValidationEmailNull() {
        return validationEmailNull;
    }

    public By getValidationTempatNull() {
        return validationTempatNull;
    }

    public By getValidationProvinsiNull() {
        return validationProvinsiNull;
    }

    public By getValidationKotaNull() {
        return validationKotaNull;
    }

    public By getValidationKecamatanNull() {
        return validationKecamatanNull;
    }

    public By getValidationKelurahanNull() {
        return validationKelurahanNull;
    }

    public By getValidationRTNull() {
        return validationRTNull;
    }

    public By getValidationAlamatNull() {
        return validationAlamatNull;
    }

    public By getValidationStatusNull() {
        return validationStatusNull;
    }

    public By getValidationRTInvalid() {
        return validationRTInvalid;
    }

    public By getValidationJenisNull() {
        return validationJenisNull;
    }

    public By getValidationKewarganegaraNull() {
        return validationKewarganegaraNull;
    }

    public By getSelectMenikah() {
        return selectMenikah;
    }

    public By getSelectLajang() {
        return selectLajang;
    }

    public By getSelectLaki() {
        return selectLaki;
    }

    public By getSelectPerempuan() {
        return selectPerempuan;
    }

    public By getSelectIndonesia() {
        return selectIndonesia;
    }

    public By getSelectNonIndo() {
        return selectNonIndo;
    }

    public By getBtnLanjutReview() {
        return btnLanjutReview;
    }

    public By getInputTempatLahit() {
        return inputTempatLahir1;
    }

    public By getSelectProvinci() {
        return selectProvinci;
    }

    public By getSelectKota() {
        return selectKota;
    }

    public By getSelectKecamatan() {
        return selectKecamatan;
    }

    public By getSelectKelurahan() {
        return selectKelurahan;
    }

    public By getInputRTRW() {
        return inputRTRW;
    }

    public By getInputAlamat() {
        return inputAlamat;
    }

    public By getSelectPerkawinan() {
        return selectPerkawinan;
    }

    public By getSelectJenisKelamin() {
        return selectJenisKelamin;
    }

    public By getSelectKewarganegara() {
        return selectKewarganegara;
    }

    public By getInputsearch() {
        return Inputsearch;
    }
}
