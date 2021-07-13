package test.OnBoarding;

import controller.OnBoarding.StarActivityController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import test.BaseTest;

public class StartActivityTest extends BaseTest {

    private StarActivityController starActivityController;

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
}
