package test.OnBoarding;

import controller.OnBoarding.Login.LoginController;
import controller.OnBoarding.Register.UploadDocumentController;
import controller.OnBoarding.StarActivityController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;
import utils.VariableProperties;
import utils.listeners.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Upload Document")
public class UploadDocumentTest extends BaseTest {

    private UploadDocumentController documentController;
    private StarActivityController starActivityController;
    private LoginController loginController;
    private VariableProperties variableProperties = new VariableProperties();

    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Start Application and choice menu bahasa")
    @Story("HIJRA-10 Assalamualaikum and Carousel - As a user, I want to know a short introduction to the Hijra Bank product so that I can choose what value that I get from using the product.")
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
                .inputID(variableProperties.getHijraID())
                .inputPassword(variableProperties.getPassword())
                .checkbox()
                .click_buttonMasuk();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Continue Register Bookmark for Upload Document")
    @Story("HIJRA-233 [Android-FE] Auto-bookmark Sign-up Process - As a user, I want to be able to auto-bookmark my existing sign-up process, so that I don’t have to start from scratch if I didn’t manage to finish the sign-up process.")
    public void continueUpload() {
        documentController = new UploadDocumentController(driver);
        documentController
                .continueRegist();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Next Step for Upload Document")
    @Story("HIJRA-236 [Android-FE] Continue Sign-up - As a user, I want to continue my sign-up process, so that I can shorten up the process, and afford if I should drop off the onboarding process")
    public void nextStepupload() {
        documentController = new UploadDocumentController(driver);
        documentController
                .nextUpload();
    }


    @Test(priority = 5)
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

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Enabling the users to have a fully online KYC process." +
            "\n")
    @Story("HIJRA-236 [Android-FE] e-KTP KYC Page - As a user, I want to be able to do an NPWP for KYC purposes, so that the registration process could be done faster.")
    public void retakeSelfie() throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .retake_Image();
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("ID card is null, ID card is not entered on the input form ")
    @Story("HIJRA-236 [Android-FE] e-KTP KYC Page - As a user, I want to be able to do an NPWP for KYC purposes, so that the registration process could be done faster.")
    @Parameters("validationKtpNull")
    public void noKtpNull(String validationKtpNull) throws IOException {
        documentController = new UploadDocumentController(driver);
        documentController
                .input_nama(variableProperties.getNameKtp())
                .click_gunakan()
                .validation_ktpNull(validationKtpNull);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Name is null, name is not entered on the input form ")
    @Story("HIJRA-236 [Android-FE] e-KTP KYC Page - As a user, I want to be able to do an NPWP for KYC purposes, so that the registration process could be done faster.")
    @Parameters({"validationNameNull"})
    public void nameNull(String validationNameNull) throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .input_ktp(variableProperties.getNoKtp())
                .clear_name()
                .click_gunakan()
                .validation_nameNull(validationNameNull);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Date is null, Date is not entered on the input form ")
    @Story("HIJRA-236 [Android-FE] e-KTP KYC Page - As a user, I want to be able to do an NPWP for KYC purposes, so that the registration process could be done faster.")
    @Parameters("validationDateNull")
    public void DateNull(String validationDateNull) throws IOException {
        documentController = new UploadDocumentController(driver);
        documentController
                .input_nama(variableProperties.getNameKtp())
                .click_gunakan()
                .validaiton_dateNull(validationDateNull);
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("ID Card invalid input")
    @Story("HIJRA-236 [Android-FE] e-KTP KYC Page - As a user, I want to be able to do an NPWP for KYC purposes, so that the registration process could be done faster.")
    @Parameters({"validationIdInvalid"})
    public void idCardinvalid(String validationIdInvalid) throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .clear_ktp()
                .input_ktp("123456")
                .set_day(variableProperties.getDay(), variableProperties.getMonth(), variableProperties.getYears())
                .click_gunakan()
                .validation_IDinvalid(validationIdInvalid);
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("ID Card is Enabled ")
    @Story("HIJRA-236 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    @Parameters({"validationIdEnabled", "idEnabled"})
    public void validationKtpEnabled(String validationIdEnabled, String idEnabled) throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .clear_ktp()
                .input_ktp(idEnabled)
                .click_gunakan()
                .validation_ktpEnabled(validationIdEnabled);
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Upload Document Success")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void uploadDocumentSuccess() throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .clear_ktp()
                .input_ktp(variableProperties.getNoKtp())
                .click_gunakan();
    }


}