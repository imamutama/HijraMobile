package Mobile.controller.OnBoarding.Register;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import Mobile.pages.OnBoarding.Register.PersonalInfoPage;
import Mobile.utils.GeneratedUtils;

public class PersonalInfoController extends BaseController {
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    String textValidation;

    public PersonalInfoController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Validation Bookmark Continue Registration")
    public PersonalInfoController continueRegister() {
        String textValidation = readText(personalInfoPage.getValidationLanjutInformasi());
        System.out.println(textValidation);
        if (textValidation.contains("Yuk, lanjut Upload Dokumen untuk selesaikan pendaftaran.")) {
            click(personalInfoPage.getBtnLanjutInformasi());
        } else {
            System.out.println("GAGAL");
        }

        return this;
    }

    @Step("Validation Next Step Informasi pekerjaan & keuangan")
    public PersonalInfoController validation_informasi() throws Exception {
        GeneratedUtils.sleep(2000);
        String textValidation = readText(personalInfoPage.getValidationInfomasiTambahan());
        System.out.println(textValidation);
        Assert.assertTrue(textValidation.equalsIgnoreCase("Info keuangan"));
        return this;
    }

    @Step("Input Pendidikan Terakhir")
    public PersonalInfoController input_pendidikan(String pendidikan) {
        click(personalInfoPage.getBtnListPendidikan());
        By select = By.xpath("//android.widget.TextView[@text = '" + pendidikan + "']");
        click(select);
        return this;
    }

    @Step("Input Pekerjaan")
    public PersonalInfoController input_pekerjaan(String pekerjaan) {
        click(personalInfoPage.getBtnPekerjaan());
        By select = By.xpath("//android.widget.TextView[@text = '" + pekerjaan + "']");
        click(select);
        return this;
    }

    @Step("Input Jabatan")
    public PersonalInfoController input_jabatan(String jabatan) {
        click(personalInfoPage.getBtnJabatan());
        By select = By.xpath("//android.widget.TextView[@text = '" + jabatan + "']");
        click(select);
        return this;
    }

    @Step("Input Kantor atau Bisnis")
    public PersonalInfoController input_kantor(String kantor) {
        writeText(personalInfoPage.getInputNamaKantor(), kantor);
        return this;
    }

    @Step("Input Alamat Kantor")
    public PersonalInfoController input_alamat(String alamat) {
        writeText(personalInfoPage.getInputAlamatKantor(), alamat);
        scrollAndClickBytext("Keamanan");
        return this;
    }

    @Step("Input Sumber Dana")
    public PersonalInfoController input_sumberDana(String sumberDana) {
        click(personalInfoPage.getBtnSumberDana());
        By select = By.xpath("//android.widget.TextView[@text = '" + sumberDana + "']");
        click(select);
        return this;
    }

    @Step("Input Total Penghasilan")
    public PersonalInfoController input_penghasilan(String penghasilan) {
        click(personalInfoPage.getBtnTotalPenghasilan());
        By select = By.xpath("//android.widget.TextView[@text = '" + penghasilan + "']");
        click(select);
        return this;
    }

    @Step("Input Maksud dan Tujuan")
    public PersonalInfoController input_tujuan(String tujuan) {
        click(personalInfoPage.getBtnMaksudTujuan());
        By select = By.xpath("//android.widget.TextView[@text = '" + tujuan + "']");
        click(select);
        return this;
    }

    @Step("Input Nama Ibu Kandung")
    public PersonalInfoController input_nama(String nama) {
        writeText(personalInfoPage.getInputIbuKandung(), nama);
        return this;
    }

    @Step("Validation Pendidikan Null")
    public PersonalInfoController validation_pendidikan(String validationPendidikan) {
        textValidation = readText(personalInfoPage.getValidationPendidikanNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationPendidikan));
        return this;
    }

    @Step("Continue Lanjut Informasi Tambahan")
    public PersonalInfoController continue_Informasi() {
        textValidation = readText(personalInfoPage.getContinueInformasiTambahan());
        Assert.assertEquals(textValidation, "Lanjut Informasi Tambahan");
        if (textValidation.equalsIgnoreCase("Lanjut Informasi Tambahan")) {
            click(personalInfoPage.getContinueInformasiTambahan());
        }
        return this;
    }

    @Step("Validation Pekerjaan Null")
    public PersonalInfoController validation_pekerjaan(String validationPekerjaan) {
        textValidation = readText(personalInfoPage.getValidationPekerjaanNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationPekerjaan));
        return this;
    }

    @Step("Validation Jabatan Null")
    public PersonalInfoController validation_jabatan(String validationJabatan) {
        textValidation = readText(personalInfoPage.getValidationJabatanNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationJabatan));
        return this;
    }

    @Step("Validation Kantor / Bisnis Null")
    public PersonalInfoController validation_kantor(String validationKantor) {
        textValidation = readText(personalInfoPage.getValidationKantorNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationKantor));
        return this;
    }

    @Step("Validation Alamat Null")
    public PersonalInfoController validation_alamat(String validationAlamat) {
        textValidation = readText(personalInfoPage.getValidationAlamatNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationAlamat));
        return this;
    }

    @Step("Validation Sumber Dana Null")
    public PersonalInfoController validation_sumberDana(String validationDana) {
        textValidation = readText(personalInfoPage.getValidationDanaNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationDana));
        return this;
    }

    @Step("Validation Total Penghasilan Null")
    public PersonalInfoController validation_penghasilan(String validationPenghasilan) {
        textValidation = readText(personalInfoPage.getValidationPenghasilanNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationPenghasilan));
        return this;
    }

    @Step("Validation Maksud dan Tujuan Null")
    public PersonalInfoController validation_tujuan(String validationTujuan) {
        textValidation = readText(personalInfoPage.getValidationMaksudNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationTujuan));
        return this;
    }

    @Step("Validation Nama Ibu Kandung Null")
    public PersonalInfoController validation_nama(String validationNama) {
        textValidation = readText(personalInfoPage.getValidationNamaNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationNama));
        return this;
    }

    @Step("Click Button Lanjut")
    public PersonalInfoController click_lanjut() {
        click(personalInfoPage.getBtnLanjut());
        return this;
    }


}
