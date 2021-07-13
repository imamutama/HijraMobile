package controller;

import controller.OnBoarding.Register.RegisterDataController;
import helper.DatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.OnBoarding.OtpPage;
import utils.GeneratedUtils;
import utils.VariableProperties;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OTPController extends BaseController {
    private OtpPage otpPage = new OtpPage();
    private VariableProperties vp = new VariableProperties();
    public OTPController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Validation Citcall")
    public OTPController validationCitcall(String validationCitcall) throws Exception {
        String textValidation = readText(otpPage.getValidationCitcall());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationCitcall));
        click(otpPage.getBtnMissedCall());
        click(otpPage.getAllowPermission());
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Get OTP")
    public OTPController getOtp() throws SQLException, IOException {
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

        return this;
    }
}
