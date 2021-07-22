package Mobile.controller.OnBoarding.Register;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.OnBoarding.Register.SelfiePage;
import Mobile.pages.OnBoarding.Register.UploadDocumentPage;
import Mobile.utils.GeneratedUtils;

public class UploadDocumentController extends BaseController {
    private UploadDocumentPage documentPage = new UploadDocumentPage();
    private SelfiePage selfiePage = new SelfiePage();

    String textValidation;

    public UploadDocumentController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Continue Register")
    public UploadDocumentController continueRegist() throws Exception {

        textValidation = readText(documentPage.getContinueRegister());

        if (textValidation.equalsIgnoreCase("Yuk, lanjut Upload Dokumen untuk selesaikan pendaftaran. ")) {
            click(documentPage.getBtnLanjutUpload());
            GeneratedUtils.sleep(2000);
        }
        return this;
    }

    @Step("Validation Next Upload Document Bookmark")
    public UploadDocumentController nextUpload() throws Exception {
        textValidation = readText(documentPage.getValidationNextUploadDoc());
        if (textValidation.equalsIgnoreCase("Upload Dokumen")) {
            click(documentPage.getBtnLanjut());
            GeneratedUtils.sleep(2000);
        }
        return this;
    }


    @Step("Click button lanjut")
    public UploadDocumentController click_lanjut() throws Exception {
        click(documentPage.getBtnLanjut());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("allow permission Camera")
    public UploadDocumentController allow_permission() throws Exception {
        click(documentPage.getBtnAllowGalery());
        GeneratedUtils.sleep(2000);
        click(documentPage.getBtnAllowRecord());
        GeneratedUtils.sleep(5000);
        return this;
    }

    @Step("Ambil gambar dengan kamera")
    public UploadDocumentController click_camera() throws Exception {
        click(documentPage.getBtnCamera());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Nomor KTP")
    public UploadDocumentController input_ktp(String noKtp) throws Exception {
        writeText(documentPage.getInputKTP(), noKtp);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Nama")
    public UploadDocumentController input_nama(String name) throws Exception {
        writeText(documentPage.getInputName(), name);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Set calendar day")
    public UploadDocumentController set_day(String day, String month, String years) {
        click(documentPage.getInputTglLahir());
        clearText(documentPage.getGetDay());
        click(documentPage.getGetDay());
        writeText(documentPage.getGetDay(), day);
        click(documentPage.getGetMonth());
        clearText(documentPage.getGetMonth());
        writeText(documentPage.getGetMonth(), month);
        click(documentPage.getGetYears());
        clearText(documentPage.getGetYears());
        writeText(documentPage.getGetYears(), years);
        click(documentPage.getBtnOkCalendar());
        return this;
    }

    @Step("Click Gunakan")
    public UploadDocumentController click_gunakan() throws Exception {
        click(documentPage.getBtnGunakan());
        return this;
    }

    @Step("Retake Image with selfie eKYC")
    public UploadDocumentController retake_Image() throws Exception {
        click(documentPage.getBtnAmbilUlang());
        GeneratedUtils.sleep(5000);
        click(documentPage.getBtnCamera());
        return this;
    }

    @Step("Nomor ktp null atau tidak diinput")
    public UploadDocumentController validation_ktpNull(String ktpNull) {
        String validationText = readText(documentPage.getAlertErrorKtp());
        Assert.assertEquals(validationText, ktpNull);
        return this;
    }

    @Step("Name null atau tidak di input")
    public UploadDocumentController validation_nameNull(String nameNull) {
        String validationText = readText(documentPage.getAlertErorrname());
        Assert.assertEquals(validationText, nameNull);
        return this;
    }

    @Step("Tanggal lahir null atau tidak di input")
    public UploadDocumentController validaiton_dateNull(String dateNull) {
        String validationText = readText(documentPage.getAlertTglLahirError());
        Assert.assertEquals(validationText, dateNull);
        return this;
    }

    @Step("ID KTP Digit kurang dari 16")
    public UploadDocumentController validation_IDinvalid(String idInvalid) {
        String validationText = readText(documentPage.getAlertKtp16Digit());
        Assert.assertEquals(validationText, idInvalid);
        return this;
    }

    @Step("ID KTP sudah terdaftar")
    public UploadDocumentController validation_ktpEnabled(String KtpEnabled) {
        String validationText = readText(documentPage.getAlertKtpEnabled());
        Assert.assertEquals(validationText, KtpEnabled);
        return this;
    }

    @Step("Clear Name")
    public UploadDocumentController clear_name() throws Exception {
        clearText(documentPage.getInputName());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Clear ID Card")
    public UploadDocumentController clear_ktp() throws Exception {
        clearText(documentPage.getInputKTP());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Take selfie")
    public UploadDocumentController take_Selfie() throws Exception {
        GeneratedUtils.sleep(10000);
        click(selfiePage.getBtnSelfieCamera());
        return this;
    }
    @Step("Upload Selfie Photo")
    public UploadDocumentController uploadSelfie() throws Exception {
        GeneratedUtils.sleep(2000);
        click(selfiePage.getBtnUpload());
        return this;
    }

}

