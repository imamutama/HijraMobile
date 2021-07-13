package test.OnBoarding;

import controller.OnBoarding.Login.LoginController;
import controller.OnBoarding.Register.ReviewDataController;
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
@Feature("Review Data")
public class ReviewDataTest extends BaseTest {
    private ReviewDataController customerDataController;
    private LoginController loginController;
    private StarActivityController starActivityController;
    private VariableProperties variableProperties = new VariableProperties();

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
    @Severity(SeverityLevel.NORMAL)
    @Description("Enabling users to log in or sign-up to the account.")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    public void loginValid() throws IOException {
        loginController = new LoginController(driver);
        loginController
                .startLogin()
                .inputID("Test2019")
                .inputPassword("Pass1234")
                .checkbox()
                .click_buttonMasuk();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Continue Review Data Bookmark for Upload Document")
    @Story("HIJRA-233 [Android-FE] Auto-bookmark Sign-up Process - As a user, I want to be able to auto-bookmark my existing sign-up process, so that I don’t have to start from scratch if I didn’t manage to finish the sign-up process.")
    public void continueReview() {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .continue_review();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Next Step Review Data")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void validationNextReview() throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .validation_nextReview();

    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Place of birth input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters({"validationTempatNull"})
    public void validationTempatLahir(String validationTempatNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .scrollTL()
                .click_Lanjut()
                .validation_Tempat(validationTempatNull)
                .input_tempatLahir(variableProperties.getTempatLahir());
        GeneratedUtils.sleep(2000);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Province input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters({"validationProvinsiNull"})
    public void validationProvinsi(String validationProvinsiNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_Provinsi(validationProvinsiNull)
                .select_Provinsi(variableProperties.getProvinsi());
        GeneratedUtils.sleep(2000);

    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("City input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters({"validationKotaNull"})
    public void validationKota(String validationKotaNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_Kota(validationKotaNull)
                .select_kota(variableProperties.getKota());
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("District input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters({"validationKecamatanNull"})
    public void validationKecamatan(String validationKecamatanNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_Kecamatan(validationKecamatanNull)
                .select_kecamatan(variableProperties.getKecamatan());

    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Village input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters({"validationKelurahanNull"})
    public void validationKelurahan(String validationKelurahanNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validaiton_Kelurahan(validationKelurahanNull)
                .select_kelurahan(variableProperties.getKelurahan())
                .scrollEnd();

    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate postal code with default value")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void validationKodePos() {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .validation_KodePos();
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("RT / RW input form is not entered And invalid input value")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters({"validationRTNull", "invalidRT", "validationRTInvalid"})
    public void validationRTRW(String validationRTNull, String invalidRT, String validationRTInvalid) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_RT(validationRTNull)
                .input_RTRW(invalidRT)
                .click_Lanjut()
                .validation_RTInvalid(validationRTInvalid)
                .clear_RT()
                .input_RTRW(variableProperties.getRTRW());
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Address input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters("validationAlamatNull")
    public void validationAlamat(String validationAlamatNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_Alamat(validationAlamatNull)
                .input_Alamat(variableProperties.getAlamat());
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Marital status input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters("validationStatusNull")
    public void validationStatus(String validationStatusNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_Status(validationStatusNull)
                .select_Perkawinan(variableProperties.getStatus());
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Gender input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters("validationJenisNull")
    public void validationJenis(String validationJenisNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_Jenis(validationJenisNull)
                .select_Jenis(variableProperties.getJenisKelamin());
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Nationality input form is not entered")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters("validationNationalityNull")
    public void validationNegara(String validationNationalityNull) throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut()
                .validation_Kewarganegaraan(validationNationalityNull)
                .select_Kewarganegaraan(variableProperties.getKewarganegaraan());
        GeneratedUtils.sleep(2000);
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Customer Data has been successfully input")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void reviewDataSuccess() throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                .click_Lanjut();
        GeneratedUtils.sleep(5000);
    }


}
