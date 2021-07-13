package test.OnBoarding;

import controller.OnBoarding.Login.LoginController;
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
@Feature("Login Success")
public class LoginSucces extends BaseTest {

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
    @Description("Enabling users to log in or sign-up to the account.")
    @Story("HIJRA-45 [Android-FE] Sign-up and Login Page - As a user, I want to be presented with a login and sign-up page when I open the app so that I can start using my account.")
    public void loginValid() throws IOException {
        loginController = new LoginController(driver);
        loginController
                .startLogin()
                .inputID(vp.getHijraID())
                .inputPassword(vp.getPassword())
                .checkbox()
                .click_buttonMasuk();
    }

}
