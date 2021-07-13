package test.OnBoarding;

import controller.OnBoarding.Login.LoginController;
import controller.OnBoarding.Register.SignatureController;
import controller.OnBoarding.Register.UploadDocumentController;
import controller.OnBoarding.StarActivityController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test.BaseTest;
import utils.VariableProperties;
import utils.listeners.TestListener;

import java.io.IOException;


@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Signature Document")
public class SignatureTest extends BaseTest {
    private VariableProperties variableProperties = new VariableProperties();
    private StarActivityController starActivityController;
    private LoginController loginController;
    private SignatureController signatureController;


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
                .inputID(variableProperties.getHijraID())
                .inputPassword(variableProperties.getPassword())
                .checkbox()
                .click_buttonMasuk();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Continue Signature Bookmark for Upload Document")
    @Story("HIJRA-233 [Android-FE] Auto-bookmark Sign-up Process - As a user, I want to be able to auto-bookmark my existing sign-up process, so that I don’t have to start from scratch if I didn’t manage to finish the sign-up process.")
    public void continueSignature() {
        signatureController = new SignatureController(driver);
        signatureController
                .continue_Signature();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Create Signature with upload, camera and touch ")
    @Story("HIJRA-488 [Android-FE] Signature Input - As a user, I want to be able to input signature as KYC process, so that I can continue my sign-up process")
    public void createSignature() throws Exception {
        signatureController = new SignatureController(driver);
        signatureController
                .signature_Image()
                .lanjut_signature();
    }
}
