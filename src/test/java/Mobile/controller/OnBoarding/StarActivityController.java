package Mobile.controller.OnBoarding;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import Mobile.pages.StartActivityPages;

public class StarActivityController extends BaseController {
    private StartActivityPages startActivityPages = new StartActivityPages();

    public StarActivityController(AndroidDriver<MobileElement>driver) {
        super(driver);
    }

    @Step("Klik button salam")
    public StarActivityController click_salam() {
        click(startActivityPages.getBtnSalam());
        return this;
    }

    @Step("Pilih menu bahasa")
    public StarActivityController click_bahasa() throws InterruptedException {
        click(startActivityPages.getBtnBahasa());
        return this;
    }

    @Step("Skip Corousel")
    public StarActivityController skip_button() throws InterruptedException {
        for(int i = 0; i<2; i++){
            swipeHorizontal(driver,0.9,0.3,0.1,0.3);
        }
        return this;
    }
}
