package Mobile.controller.OnBoarding.Register;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.OnBoarding.Register.EndProsesPage;
import Mobile.utils.GeneratedUtils;

public class EndProsesController extends BaseController {
    private EndProsesPage endProsesPage = new EndProsesPage();
    String textValidation;
    public EndProsesController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Validation Success Register")
    public EndProsesController validationSuccessRegister() throws Exception {
        GeneratedUtils.sleep(3000);
        textValidation = readText(endProsesPage.getValidationSelesai());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Kamu berhasil menyelesaikan pendaftaran akun"));
        click(endProsesPage.getBtnKeluar());
        return this;
    }
}
