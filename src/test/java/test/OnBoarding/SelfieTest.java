package test.OnBoarding;

import controller.OnBoarding.Login.LoginController;
import controller.OnBoarding.Register.SelfieController;
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
@Feature("Selfie Ekyc")
public class SelfieTest extends BaseTest {
    private VariableProperties variableProperties = new VariableProperties();
    private StarActivityController starActivityController;
    private LoginController loginController;
    private SelfieController selfieController;


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
    @Description("Continue Selfie Bookmark for Upload Document")
    @Story("HIJRA-233 [Android-FE] Auto-bookmark Sign-up Process - As a user, I want to be able to auto-bookmark my existing sign-up process, so that I don’t have to start from scratch if I didn’t manage to finish the sign-up process.")
    public void continueSelfie() {
        selfieController = new SelfieController(driver);
        selfieController
                .continue_Selfie();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Take selfie and Take selfie with KTP")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void takeSelfie() throws Exception {
        selfieController = new SelfieController(driver);
        selfieController
                .take_SelfieContinue();
    }
}
