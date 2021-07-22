package Mobile.test.OnBoarding;

import Mobile.controller.OnBoarding.Login.LoginController;
import Mobile.controller.OnBoarding.Register.EndProsesController;
import Mobile.controller.OnBoarding.Register.PersonalInfoController;
import Mobile.controller.OnBoarding.StarActivityController;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Mobile.test.BaseTest;
import Mobile.utils.VariableProperties;
import Mobile.utils.listeners.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Personal Info")
public class PersonalInfoTest extends BaseTest {
    private LoginController loginController;
    private StarActivityController starActivityController;
    private PersonalInfoController personalInfoController;
    private EndProsesController endProsesController;
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
    public void loginValid() throws Exception {
        loginController = new LoginController(driver);
        loginController
                .startLogin()
                .inputID(vp.getHijraID())
                .inputPassword(vp.getPassword())
                .checkbox()
                .click_buttonMasuk();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Continue Signature Bookmark for Personal Info")
    @Story("HIJRA-233 [Android-FE] Auto-bookmark Sign-up Process - As a user, I want to be able to auto-bookmark my existing sign-up process, so that I don’t have to start from scratch if I didn’t manage to finish the sign-up process.")
    public void continueRegister() {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .continueRegister();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Education input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationPendidikan"})
    public void validationPendidikanNull(String validationPendidikan) throws Exception {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .validation_informasi()
                .click_lanjut()
                .validation_pendidikan(validationPendidikan)
                .input_pendidikan(vp.getPendidikan());

    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Profession input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationPekerjaan"})
    public void validationPekerjaanNull(String validationPekerjaan) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_pekerjaan(validationPekerjaan)
                .input_pekerjaan(vp.getPekerjaan());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Position input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationJabatan"})
    public void validationJabatanNull(String validationJabatan) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_jabatan(validationJabatan)
                .input_jabatan(vp.getJabatan());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Office input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationKantor"})
    public void validationKantorNull(String validationKantor) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_kantor(validationKantor)
                .input_kantor(vp.getKantor());
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Address Office input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationAlamat"})
    public void validationAlamatNull(String validationAlamat) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_alamat(validationAlamat)
                .input_alamat(vp.getAlamatKantor());
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Income Fund input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationDana"})
    public void validationDanaNull(String validationDana) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_sumberDana(validationDana)
                .input_sumberDana(vp.getDana());
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Income input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationPenghasilan"})
    public void validationPenghasilanNull(String validationPenghasilan) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_penghasilan(validationPenghasilan)
                .input_penghasilan(vp.getPenghasilan());
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Destination input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationTujuan"})
    public void validationTujuanNull(String validationTujuan) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_tujuan(validationTujuan)
                .input_tujuan(vp.getTujuan());
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Biological mother input form is not entered")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    @Parameters({"validationIbuKandung"})
    public void validationIbuKandungNull(String validationIbuKandung) throws IOException {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .click_lanjut()
                .validation_nama(validationIbuKandung)
                .input_nama(vp.IbuKandung())
                .click_lanjut();
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Success")
    @Story("HIJRA-490 [Android-FE] Successful Sign-up - As a user, I want to know when I have finished my sign-up process, so that I can wait for the account activation")
    public void validationSuccess() throws Exception {
        endProsesController = new EndProsesController(driver);
        endProsesController
                .validationSuccessRegister();
    }


}
