package controller.OnBoarding.Login;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.OnBoarding.Login.LoginPages;
import utils.GeneratedUtils;

public class LoginController extends BaseController {

    private LoginPages loginPages = new LoginPages();
    String textValidation;

    public LoginController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("choice button masuk")
    public LoginController startLogin() {
        click(loginPages.getBtnMasuk());
        return this;
    }

    @Step("Input Hijra ID")
    public LoginController inputID(String hijraID) {
        writeText(loginPages.getInputHijraID(), hijraID);
        return this;
    }

    @Step("Input Password")
    public LoginController inputPassword(String password) {
        writeText(loginPages.getInputPassword(), password);
        return this;
    }

    @Step("Input Checkbox")
    public LoginController checkbox() {
        click(loginPages.getChekboxSimpan());
        return this;
    }

    @Step("Click button masuk dengan inputan HijraID dan Password")
    public LoginController click_buttonMasuk() {
        click(loginPages.getBtnMasukForm());
        //   click(loginPages.getBtnAllowPermisson());
        return this;
    }

    @Step("Validation Form Input Login Null")
    public LoginController validationLoginNull(String loginNull) {
        textValidation = readText(loginPages.getAlertFormNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Form Isi dulu ya"));
        return this;
    }

    @Step("Validation HijraID Null")
    public LoginController validation_HijraNull(String HijraNull) {
        textValidation = readText(loginPages.getAlertHijraIDNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Hijra ID Isi dulu ya"));
        return this;
    }

    @Step("Validation Password Null")
    public LoginController validation_PasswordNull(String passNull) {
        textValidation = readText(loginPages.getAlertPasswordNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Password Isi dulu ya"));
        return this;
    }

    @Step("Validation Input Login Invalid")
    public LoginController validationInvalid(String loginInvalid) throws Exception {
        click(loginPages.getBtnMasuk());
        textValidation = readText(loginPages.getAlertloginInvalid());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Hijra ID atau Password salah (1/3)"));

        return this;
    }

    @Step("Invalid login 3x")
    public LoginController invalid3x() throws Exception {
        for (int i = 0; i <= 3; i++) {
            click(loginPages.getBtnMasuk());
        }
        textValidation = readText(loginPages.getAlertInvalid3x());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Password salah sebanyak 3x. Silakan reset password saat log in"));
        driver.navigate().back();
        return this;

    }

    @Step("Step Akun belum terverifikasi")
    public LoginController akunNotVerifikasi(String akunNotVerifikasi){
        textValidation = readText(loginPages.getAlertAkunNotVerifikasi());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Akun anda belum terverifikasi"));
        click(loginPages.getBtnOkeAlertNotVerifikasi());
        return this;
    }


    @Step("Clear Passowrd")
    public LoginController clear_Password() {
        clearText(loginPages.getInputPassword());
        return this;
    }

    @Step("Clear HijraID")
    public LoginController clear_Hijra() {
        clearText(loginPages.getInputHijraID());
        return this;
    }


}
