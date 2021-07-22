package Mobile.controller.OnBoarding.Register;

import Mobile.controller.BaseController;
import Mobile.helper.ReadToastMessage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.OnBoarding.Register.RegisterDataPage;
import Mobile.utils.GeneratedUtils;
import Mobile.utils.ScreenShoot;
import Mobile.utils.VariableProperties;

import java.time.Duration;

public class RegisterDataController extends BaseController {
    private RegisterDataPage registerDataPage = new RegisterDataPage();
    private VariableProperties vp = new VariableProperties();
    private ReadToastMessage readToastMessage = new ReadToastMessage(driver);

    public RegisterDataController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Klik Daftar untuk menu Bahasa ")
    public RegisterDataController click_daftar() throws InterruptedException {
        click(registerDataPage.getBtnDaftar());
        return this;
    }

    @Step("Klik Mulai untuk menu Bahasa")
    public RegisterDataController click_mulai() {
        click(registerDataPage.getBtnMulai());
        return this;
    }

    @Step("Pilih checkbox dan klik button lanjut")
    public RegisterDataController click_checkbox() throws Exception {
        click(registerDataPage.getCheckBox1());
        click(registerDataPage.getCheckBox2());
        click(registerDataPage.getCheckBox3());
        GeneratedUtils.sleep(2000);
        click(registerDataPage.getBtnLanjut());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Hijra ID pada form inputan")
    public RegisterDataController input_HijraID(String id) throws Exception {
        writeText(registerDataPage.getInputHijraID(), id);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Email pada form inputan")
    public RegisterDataController input_Email(String email) throws Exception {
        writeText(registerDataPage.getInputEmail(), email);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Password pada form inputan")
    public RegisterDataController inputPassword(String password) throws Exception {
        writeText(registerDataPage.getInputPassword(), password);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Konfirm password pada form inputan")
    public RegisterDataController inputKonfirmPswrd(String confirm) throws Exception {
        writeText(registerDataPage.getInputKonfirm(), confirm);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input No HP pada form inputan")
    public RegisterDataController inputNoHp(String noHp) throws Exception {
        writeText(registerDataPage.getInputNoHp(), noHp);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Scroll NO Handphone")
    public RegisterDataController scrollNoHp() {
        try {
            scrollAndClickBytext("keamanan");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Scroll Hijra ID")
    public RegisterDataController scrollHijraID() {
        scrollAndClickBytext("Hijra ID");
        return this;
    }

    @Step("Scrooll Tempat Lahir")
    public RegisterDataController scrollTL() throws Exception {
        GeneratedUtils.sleep(500);
        try {
            (new TouchAction<>(driver)).press(PointOption.point(466, 1450))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(474, 1111)).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }


    @Step("Klik button lanjut")
    public RegisterDataController click_lanjut() throws Exception {
        click(registerDataPage.getBtnLanjut());
        return this;
    }

    @Step("Klik button lanjut")
    public RegisterDataController click_lanjut_regis() throws Exception {
        click(registerDataPage.getBtnLanjut());
        GeneratedUtils.sleep(5000);
        return this;
    }

    @Step("Validasi Form null")
    public RegisterDataController validation_FormNull(String formNull) throws Exception {
        String validationText = readText(registerDataPage.getAlertFormNull());
        Assert.assertTrue(validationText.equalsIgnoreCase(formNull));
        ScreenShoot.takeScreenShot("Form Null", driver);
        return this;
    }

    @Step("Validasi HijraID Null")
    public RegisterDataController validation_HijraIDNull(String HijraIDNull) throws Exception {
        String validationText = readText(registerDataPage.getAlertHijraIDNull());
        Assert.assertTrue(validationText.equalsIgnoreCase(HijraIDNull));
        ScreenShoot.takeScreenShot("HijraID Null", driver);
        return this;
    }

    @Step("Validasi Hijra ID sudah terpakai")
    public RegisterDataController validation_HijraIDterpakai(String HijraEnabled) throws Exception {
        GeneratedUtils.sleep(3000);
        String validationText = readText(registerDataPage.getAlertHijraIDterpakai());
        Assert.assertTrue(validationText.equalsIgnoreCase(HijraEnabled));
        ScreenShoot.takeScreenShot("Hijra ID Terpakai", driver);
        return this;
    }

    @Step("Validasi Hijra Not Valid")
    public RegisterDataController validation_HijraInvalid(String hijraInvalid) throws Exception {
        String validationText = readText(registerDataPage.getAlertHijraIDnotValid());
        Assert.assertTrue(validationText.equalsIgnoreCase(hijraInvalid));
        ScreenShoot.takeScreenShot("HijraID Invalid", driver);
        return this;
    }

    @Step("Validasi Email Null")
    public RegisterDataController validation_EmailNull(String emailNull) throws Exception {
        String validationText = readText(registerDataPage.getAlertEmailNull());
        Assert.assertTrue(validationText.equalsIgnoreCase(emailNull));
        ScreenShoot.takeScreenShot("Email Null", driver);
        return this;
    }

    @Step("Validasi Password Null")
    public RegisterDataController validation_passwordNull(String passwordNull) throws Exception {
        String validationText = readText(registerDataPage.getAlertPassswordNull());
        Assert.assertTrue(validationText.equalsIgnoreCase(passwordNull));
        ScreenShoot.takeScreenShot("Password Null", driver);
        return this;
    }

    @Step("Validasi Konfirmasi Password Null")
    public RegisterDataController validation_KonfirmNull(String konfirmNull) throws Exception {
        String validationText = readText(registerDataPage.getAlertKonfirmNull());
        Assert.assertTrue(validationText.equalsIgnoreCase(konfirmNull));
        ScreenShoot.takeScreenShot("Confirm Password Null", driver);
        return this;
    }

    @Step("Validasi Password Not Valid")
    public RegisterDataController validation_passwordInvalid(String passInvalid) throws Exception {
        String validationText = readText(registerDataPage.getAlertPasswordNotvalid());
        Assert.assertTrue(validationText.equalsIgnoreCase(passInvalid));
        ScreenShoot.takeScreenShot("Password Invalid", driver);
        return this;
    }

    @Step("Validasi Password and Konfirmasi not same")
    public RegisterDataController validation_PassKonfirmNotSame(String passNotSame) throws Exception {
        String validationText = readText(registerDataPage.getAlertPasswordNotSame());
        Assert.assertTrue(validationText.equalsIgnoreCase(passNotSame));
        ScreenShoot.takeScreenShot("Password Not Match", driver);
        return this;
    }

    @Step("Validasi No Hp Null")
    public RegisterDataController validation_NoHPNull(String NoHpNull) throws Exception {
        String validationText = readText(registerDataPage.getAlertHpNull());
        Assert.assertTrue(validationText.equalsIgnoreCase(NoHpNull));
        ScreenShoot.takeScreenShot("No Hp Null", driver);
        return this;
    }

    @Step("Validasi No Hp Enabled")
    public RegisterDataController validation_NoHPEnabled(String noHpEnabled) throws Exception {
        GeneratedUtils.sleep(3000);
        String validationText = readText(registerDataPage.getNoHpEnabled());
        Assert.assertTrue(validationText.equalsIgnoreCase(noHpEnabled));
        ScreenShoot.takeScreenShot("No Hp Enabled", driver);
        return this;
    }

    @Step("Clear HijraID")
    public RegisterDataController clearHijra() {
        clearText(registerDataPage.getInputHijraID());
        return this;
    }

    @Step("Clear Email")
    public RegisterDataController clear_Email() {
        clearText(registerDataPage.getInputEmail());
        return this;
    }

    @Step("Clear Password")
    public RegisterDataController clear_Password() throws Exception {
        clearText(registerDataPage.getInputPassword());
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Clear Confirm")
    public RegisterDataController clear_Confirm() {
        clearText(registerDataPage.getInputKonfirm());
        return this;
    }

    @Step("Clear No HP")
    public RegisterDataController clear_NoHp() throws Exception {
        clearText(registerDataPage.getInputNoHp());
        GeneratedUtils.sleep(2000);
        return this;
    }

}
