package Mobile.controller;

import Mobile.helper.DatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.OtpPage;
import Mobile.utils.GeneratedUtils;
import Mobile.utils.ScreenShoot;
import Mobile.utils.VariableProperties;

import java.util.List;

public class OTPController extends BaseController {
    private OtpPage otpPage = new OtpPage();
    private VariableProperties vp = new VariableProperties();

    public OTPController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Validation Citcall")
    public OTPController validationCitcall(String validationCitcall) throws Exception {
        ScreenShoot.takeScreenShot("Page Citcall",driver);
        String textValidation = readText(otpPage.getValidationCitcall());
        System.out.println(textValidation);
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationCitcall));
        click(otpPage.getBtnMissedCall());
        click(otpPage.getAllowPermission());
        GeneratedUtils.sleep(5000);
        return this;
    }

    @Step("Get OTP")
    public OTPController getOtp() throws Exception {
        List<MobileElement> list = driver.findElements(otpPage.getTextotp());
        DatabaseConnection.DBConnect();
        String sql = "SELECT generated_token FROM otp_token WHERE user_id IN(SELECT user_id FROM user_login WHERE username = '" + vp.getHijraID() + "')";
        System.out.println(DatabaseConnection.QuerySql(sql, 1));
        String testString = String.valueOf(DatabaseConnection.QuerySql(sql, 1));
        String[] as = {testString};
        for (int i = 1; i <= list.size(); i++) {
            for (String test : as) {
                if (i == 1) {
                    writeText(otpPage.getTextOtp1(), String.valueOf(test.charAt(0)));
                } else if (i == 2) {
                    writeText(otpPage.getTextOtp2(), String.valueOf(test.charAt(1)));
                } else if (i == 3) {
                    writeText(otpPage.getTextOtp3(), String.valueOf(test.charAt(2)));
                } else if (i == 4) {
                    writeText(otpPage.getTextOtp4(), String.valueOf(test.charAt(3)));
                }
            }
        }
        ScreenShoot.takeScreenShot("Page OTP", driver);
        GeneratedUtils.sleep(5000);

        return this;
    }
}
