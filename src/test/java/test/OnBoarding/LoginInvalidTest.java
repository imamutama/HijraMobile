package test.OnBoarding;

import controller.OnBoarding.Login.LoginController;
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
@Feature("Login")
public class LoginInvalidTest extends BaseTest {
    private LoginController loginController;
    private StarActivityController starActivityController;
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
    @Severity(SeverityLevel.NORMAL)
    @Description("Form input login null")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    @Parameters({"validationLoginNull"})
    public void loginNull(String validationLoginNull) throws IOException {
        loginController = new LoginController(driver);
        loginController
                .startLogin()
                .click_buttonMasuk()
                .validationLoginNull(validationLoginNull);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Hijra ID is not input in the login input form")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    @Parameters({"validationHijraNull"})
    public void hijraIDNull(String validationHijraNull) throws IOException {
        loginController = new LoginController(driver);
        loginController
                .inputPassword(vp.getPassword())
                .checkbox()
                .click_buttonMasuk()
                .validation_HijraNull(validationHijraNull);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Enabling users to log in or sign-up to the account.")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    @Parameters({"validationPassNull"})
    public void passwordNull(String validationPassNull) throws IOException {
        loginController = new LoginController(driver);
        loginController
                .inputID(vp.getHijraID())
                .clear_Password()
                .checkbox()
                .click_buttonMasuk()
                .validation_PasswordNull(validationPassNull);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Invalid login")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    @Parameters({"validationInvalid", "idInvalid", "passInvalid"})
    public void invalidLogin(String validationInvalid, String inputInvalid, String passInvalid) throws Exception {
        loginController = new LoginController(driver);
        loginController
                .clear_Hijra()
                .inputID(inputInvalid)
                .clear_Password()
                .inputPassword(passInvalid)
                .checkbox()
                .validationInvalid(validationInvalid);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Account not verification")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    @Parameters({"validationNotVerfikasi", "idNotVerifikasi", "passNotVerifikasi"})
    public void accountNotVerification(String validationNotVerfikasi, String idNotVerifikasi, String passNotVerifikasi) throws Exception {
        loginController = new LoginController(driver);
        loginController
                .clear_Hijra()
                .inputID(idNotVerifikasi)
                .clear_Password()
                .inputPassword(passNotVerifikasi)
                .click_buttonMasuk()
                .akunNotVerifikasi(validationNotVerfikasi);
    }

}
