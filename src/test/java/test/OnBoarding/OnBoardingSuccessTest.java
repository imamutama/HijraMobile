package test.OnBoarding;

import controller.BaseController;
import controller.OTPController;
import controller.OnBoarding.Register.*;
import controller.OnBoarding.StarActivityController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;
import utils.GeneratedUtils;
import utils.VariableProperties;
import utils.listeners.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Register Data, Upload Document, Selfie Ekyc, Signature, Review Data, Personal Info")
public class OnBoardingSuccessTest extends BaseTest {

    private StarActivityController starActivityController;
    private RegisterDataController registerController;
    private OTPController otpController;
    private UploadDocumentController documentController;
    private SelfieController selfieController;
    private SelfieWithKtpController selfieWithKtpController;
    private SignatureController signatureController;
    private ReviewDataController customerDataController;
    private PersonalInfoController personalInfoController;
    private EndProsesController endProsesController;
    private VariableProperties vp = new VariableProperties();

    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Start Application and choice menu bahasa")
    @Story("Start Application and choice menu bahasa")
    public void startActivityBahasa() throws InterruptedException {
        starActivityController = new StarActivityController(driver);
        starActivityController
                .click_salam()
                .click_bahasa();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("As a user, I want to skip carousel, so that I can shorten the process")
    @Story("HIJRA-531 [Android-FE] Enable Skip On Carousel - As a user, I want to skip carousel, so that I can shorten the process ")
    public void skipCarousel() throws InterruptedException {
        starActivityController = new StarActivityController(driver);
        starActivityController.skip_button();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Term and Conditon")
    @Story("HIJRA-14 [Android-FE] T&C Page - As a user, I want to know the terms & conditions so that I know the legal matters and the limitations of the product.")
    public void termCondition() throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .click_daftar()
                .click_mulai()
                .click_checkbox();

    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Enabling the users to have personified data to log in to the account.")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    public void inputFormDaftar() throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .input_HijraID(vp.getHijraID())
                .input_Email(vp.getEmail())
                .inputPassword(vp.getPassword())
                .inputKonfirmPswrd(vp.getPassword())
                .scrollNoHp()
                .inputNoHp(vp.getNoHp())
                .click_lanjut();
        GeneratedUtils.sleep(3000);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Android] OTP Authentication - As a user, I want to be able to receive OTP so that my phone number can be authenticated.")
    @Story("HIJRA-260 [Android-FE] OTP Authentication - As a user, I want to be able to receive OTP so that my phone number can be authenticated.")
    @Parameters("validationCitcall")
    public void otpDB(String validationCitcall) throws Exception {
        otpController = new OTPController(driver);
        otpController
                .validationCitcall(validationCitcall)
                .getOtp();
        GeneratedUtils.sleep(2000);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Next Step for Upload Document")
    @Story("HIJRA-236 [Android-FE] Continue Sign-up - As a user, I want to continue my sign-up process, so that I can shorten up the process, and afford if I should drop off the onboarding process")
    public void nextStepupload() {
        documentController = new UploadDocumentController(driver);
        documentController
                .nextUpload();
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("To enable the users to prepare for documents, take photographs in a proper condition, and allow the users to give the permission of accessing camera and gallery to the app\n" +
            "\n")
    @Story("HIJRA-236[Android-FE] e-KTP KYC Page - As a user, I want to be able to do an NPWP for KYC purposes, so that the registration process could be done faster.")
    public void allowPermissonCamera() throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .allow_permission()
                .click_camera();
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Upload Document Success")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void uploadDocumentSuccess() throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .input_ktp(vp.getNoKtp())
                .input_nama(vp.getNameKtp())
                .set_day(vp.getDay(), vp.getMonth(), vp.getYears())
                .click_gunakan();
        GeneratedUtils.sleep(2000);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Take selfie and Take selfie with KTP")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void takeSelfie() throws Exception {
        selfieController = new SelfieController(driver);
        selfieController
                .take_Selfie();
        GeneratedUtils.sleep(3000);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Take selfie with KTP")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void takeSelfieKtp() throws Exception {
        selfieWithKtpController = new SelfieWithKtpController(driver);
        selfieWithKtpController
                .take_SelfieKtp();
        GeneratedUtils.sleep(2000);
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Create Signature with upload, camera and touch ")
    @Story("HIJRA-488 [Android-FE] Signature Input - As a user, I want to be able to input signature as KYC process, so that I can continue my sign-up process")
    public void createSignature() throws Exception {
        signatureController = new SignatureController(driver);
        signatureController
                .signatureThread()
                .lanjut_signature();
        GeneratedUtils.sleep(2000);
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Next Step Review Data")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void validationNextReview() throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .validation_nextReview();

    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Review Data has been successfully input")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void reviewDataSuccess() throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .scrollTL()
                .input_tempatLahir(vp.getTempatLahir())
                .select_Provinsi(vp.getProvinsi())
                .select_kota(vp.getKota())
                .select_kecamatan(vp.getKecamatan())
                .select_kelurahan(vp.getKelurahan())
                .scrollEnd()
                .input_RTRW(vp.getRTRW())
                .input_Alamat(vp.getAlamat())
                .select_Perkawinan(vp.getStatus())
                .select_Jenis(vp.getJenisKelamin())
                .select_Kewarganegaraan(vp.getKewarganegaraan())
                .click_Lanjut();
        GeneratedUtils.sleep(2000);
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Personal Info")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    public void validationPersonalInfo() {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .validation_informasi();
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Personal Info has been successfully input")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    public void PersonalInfoSuccess() throws Exception {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .input_pendidikan(vp.getPendidikan())
                .input_pekerjaan(vp.getPekerjaan())
                .input_jabatan(vp.getJabatan())
                .input_kantor(vp.getKantor())
                .input_alamat(vp.getAlamatKantor())
                .input_sumberDana(vp.getDana())
                .input_penghasilan(vp.getPenghasilan())
                .input_tujuan(vp.getTujuan())
                .input_nama(vp.IbuKandung())
                .click_lanjut();
        GeneratedUtils.sleep(3000);
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Success")
    @Story("HIJRA-490 [Android-FE] Successful Sign-up - As a user, I want to know when I have finished my sign-up process, so that I can wait for the account activation")
    public void validationSuccess() {
        endProsesController = new EndProsesController(driver);
        endProsesController
                .validationSuccessRegister();
    }


}
