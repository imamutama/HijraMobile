package controller.OnBoarding.Register;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.OnBoarding.Register.UploadDocumentPage;
import utils.GeneratedUtils;

import javax.xml.xpath.XPath;
import java.util.List;

public class UploadDocumentController extends BaseController {
    private UploadDocumentPage documentPage = new UploadDocumentPage();

    String textValidation;

    public UploadDocumentController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Continue Register")
    public UploadDocumentController continueRegist() {

        textValidation = readText(documentPage.getContinueRegister());

        if (textValidation.equalsIgnoreCase("Yuk, lanjut Upload Dokumen untuk selesaikan pendaftaran. ")) {
            click(documentPage.getBtnLanjutUpload());
        }
        return this;
    }

    @Step("Validation Next Upload Document Bookmark")
    public UploadDocumentController nextUpload() {
        textValidation = readText(documentPage.getValidationNextUploadDoc());
        if (textValidation.equalsIgnoreCase("Upload Dokumen")) {
            click(documentPage.getBtnLanjut());
        }
        return this;
    }


    @Step("Click button lanjut")
    public UploadDocumentController click_lanjut() {
        click(documentPage.getBtnLanjut());
        return this;
    }

    @Step("allow permission Camera")
    public UploadDocumentController allow_permission() {
        click(documentPage.getBtnAllowGalery());
        click(documentPage.getBtnAllowRecord());
        return this;
    }

    @Step("Ambil gambar dengan kamera")
    public UploadDocumentController click_camera() throws Exception {
        GeneratedUtils.sleep(5000);
        click(documentPage.getBtnCamera());
        return this;
    }

    @Step("Input Nomor KTP")
    public UploadDocumentController input_ktp(String noKtp) {
        writeText(documentPage.getInputKTP(), noKtp);
        return this;
    }

    @Step("Input Nama")
    public UploadDocumentController input_nama(String name) {
        writeText(documentPage.getInputName(), name);
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
    public UploadDocumentController click_gunakan() {
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
        Assert.assertTrue(validationText.equalsIgnoreCase(ktpNull));
        return this;
    }

    @Step("Name null atau tidak di input")
    public UploadDocumentController validation_nameNull(String nameNull) {
        String validationText = readText(documentPage.getAlertErorrname());
        Assert.assertTrue(validationText.equalsIgnoreCase(nameNull));
        return this;
    }

    @Step("Tanggal lahir null atau tidak di input")
    public UploadDocumentController validaiton_dateNull(String dateNull) {
        String validaitonText = readText(documentPage.getAlertTglLahirError());
        Assert.assertTrue(validaitonText.equalsIgnoreCase(dateNull));
        return this;
    }

    @Step("ID KTP Digit kurang dari 16")
    public UploadDocumentController validation_IDinvalid(String idInvalid) {
        String validationText = readText(documentPage.getAlertKtp16Digit());
        Assert.assertTrue(validationText.equalsIgnoreCase(idInvalid));
        return this;
    }

    @Step("ID KTP sudah terdaftar")
    public UploadDocumentController validation_ktpEnabled(String KtpEnabled) {
        String validationText = readText(documentPage.getAlertKtpEnabled());
        Assert.assertTrue(validationText.equalsIgnoreCase(KtpEnabled));
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


}

