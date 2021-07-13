package controller.OnBoarding.Register;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.OnBoarding.Register.EndProsesPage;

public class EndProsesController extends BaseController {
    private EndProsesPage endProsesPage = new EndProsesPage();
    String textValidation;
    public EndProsesController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Validation Success Register")
    public EndProsesController validationSuccessRegister(){
        textValidation = readText(endProsesPage.getValidationSelesai());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Kamu berhasil menyelesaikan proses."));
        click(endProsesPage.getBtnKeluar());
        return this;
    }
}
