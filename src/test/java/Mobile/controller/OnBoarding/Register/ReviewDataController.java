package Mobile.controller.OnBoarding.Register;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.OnBoarding.Register.ReviewDataPage;
import Mobile.utils.GeneratedUtils;
import Mobile.utils.VariableProperties;

import java.time.Duration;

public class ReviewDataController extends BaseController {
    private ReviewDataPage customerDataPage = new ReviewDataPage();
    private VariableProperties vp = new VariableProperties();

    public ReviewDataController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Continue Review Data")
    public ReviewDataController continue_review() {
        String textValidation = readText(customerDataPage.getContinuteReviewData());
        Assert.assertEquals(textValidation, "Lanjut Review Data");
        if (textValidation.equalsIgnoreCase("Lanjut Review Data")) {
            click(customerDataPage.getBtnLanjutReview());
        }
        return this;
    }

    @Step("Scrooll Tempat Lahir")
    public ReviewDataController scrollTL() throws Exception {
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

    @Step("Scrooll Tempat Lahir")
    public ReviewDataController scrollKC() throws Exception {
        GeneratedUtils.sleep(500);
        try {
            (new TouchAction<>(driver)).press(PointOption.point(500, 1452))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(492, 1059)).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Scroll End")
    public ReviewDataController scrollEnd() throws Exception {
        GeneratedUtils.sleep(500);
        try {
            (new TouchAction<>(driver)).press(PointOption.point(430, 1438))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(426, 394)).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    @Step("Input Tempat Lahir")
    public ReviewDataController input_tempatLahir(String tempat) throws Exception {
        try {
            MobileElement element = driver.findElement(customerDataPage.getValidationTTL());
            if (element.isEnabled()) {
                click(customerDataPage.getValidationTTL());
                writeText(customerDataPage.getInputTempatLahir1(), tempat);
                driver.navigate().back();
            } else {
                System.out.println("FAILED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Select Provinsi")
    public ReviewDataController select_Provinsi(String provinsi) throws Exception {
        for (int i = 1; i <= 2; i++) {
            click(customerDataPage.getSelectProvinci());
        }
        GeneratedUtils.sleep(2000);
        writeText(customerDataPage.getInputsearch(), provinsi);
        GeneratedUtils.sleep(2000);
        click(customerDataPage.getGetSelectList());

        return this;
    }

    @Step("Select Kota")
    public ReviewDataController select_kota(String kota) throws Exception {
        click(customerDataPage.getSelectKota());
        GeneratedUtils.sleep(2000);
        writeText(customerDataPage.getInputsearch(), kota);
        GeneratedUtils.sleep(2000);
        click(customerDataPage.getGetSelectList());
        return this;
    }

    @Step("Select Kecamatan")
    public ReviewDataController select_kecamatan(String kecamatan) throws Exception {
        click(customerDataPage.getSelectKecamatan());
        GeneratedUtils.sleep(2000);
        writeText(customerDataPage.getInputsearch(), kecamatan);
        GeneratedUtils.sleep(2000);
        click(customerDataPage.getGetSelectList());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Select Kelurahan")
    public ReviewDataController select_kelurahan(String kelurahan) throws Exception {
        click(customerDataPage.getSelectKelurahan());
        GeneratedUtils.sleep(2000);
        writeText(customerDataPage.getInputsearch(), kelurahan);
        GeneratedUtils.sleep(2000);
        click(customerDataPage.getGetSelectList());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input RT/RW")
    public ReviewDataController input_RTRW(String rtrw) {
        writeText(customerDataPage.getInputRTRW(), rtrw);
        return this;
    }

    @Step("Input Alamat")
    public ReviewDataController input_Alamat(String Alamat) {
        writeText(customerDataPage.getInputAlamat(), Alamat);
        return this;
    }

    @Step("Select Perkawinan")
    public ReviewDataController select_Perkawinan(String status) {
        click(customerDataPage.getSelectPerkawinan());
        if (status.equalsIgnoreCase("Lajang")) {
            click(customerDataPage.getSelectLajang());
        } else {
            click(customerDataPage.getSelectMenikah());
        }

        return this;
    }

    @Step("Select Jenis Kelamin")
    public ReviewDataController select_Jenis(String jenis) {
        click(customerDataPage.getSelectJenisKelamin());
        if (jenis.equalsIgnoreCase("Laki-laki")) {
            click(customerDataPage.getSelectLaki());
        } else {
            click(customerDataPage.getSelectPerempuan());
        }
        return this;
    }

    @Step("Select Kewarganegaraan")
    public ReviewDataController select_Kewarganegaraan(String kewarganegaraan) {
        click(customerDataPage.getSelectKewarganegara());
        if (kewarganegaraan.equalsIgnoreCase("Indonesia")) {
            click(customerDataPage.getSelectIndonesia());
        } else {
            click(customerDataPage.getSelectNonIndo());
        }
        return this;
    }

    @Step("Validation Tempat Lahir Null")
    public ReviewDataController validation_Tempat(String assertTempat) throws Exception {
        String textValidation = readText(customerDataPage.getValidationTempatNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertTempat));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Provinsi Null")
    public ReviewDataController validation_Provinsi(String assertProvinsi) throws Exception {
        String textValidation = readText(customerDataPage.getValidationProvinsiNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertProvinsi));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Kota / Kabupaten Null")
    public ReviewDataController validation_Kota(String assertKota) throws Exception {
        String textValidaiton = readText(customerDataPage.getValidationKotaNull());
        Assert.assertTrue(textValidaiton.equalsIgnoreCase(assertKota));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Kecamatan Null")
    public ReviewDataController validation_Kecamatan(String assertKecamatan) throws Exception {
        String textValidation = readText(customerDataPage.getValidationKecamatanNull());
        System.out.println("Text :" + textValidation);
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertKecamatan));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Kelurhan Null")
    public ReviewDataController validaiton_Kelurahan(String assertKelurahan) throws Exception {
        String textValidation = readText(customerDataPage.getValidationKelurahanNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertKelurahan));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Kode Pos Automation Default")
    public ReviewDataController validation_KodePos() {
        String textValidation = readText(customerDataPage.getValidationKodePos());
        if (textValidation != null) {
            System.out.println("KODE POS PASSED DEFAULT");
        } else {
            System.out.println("FAILED");
        }
        return this;
    }

    @Step("Validation RTRW Null")
    public ReviewDataController validation_RT(String assertRTRW) throws Exception {
        String textValidation = readText(customerDataPage.getValidationRTNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertRTRW));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation RTRW Null")
    public ReviewDataController validation_RTInvalid(String assertRTRWInvalid) throws Exception {
        String textValidation = readText(customerDataPage.getValidationRTInvalid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertRTRWInvalid));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Alamat")
    public ReviewDataController validation_Alamat(String assertAlamat) throws Exception {
        String textValidation = readText(customerDataPage.getValidationAlamatNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertAlamat));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Status Perkawinan")
    public ReviewDataController validation_Status(String asserStatus) throws Exception {
        String textValidation = readText(customerDataPage.getValidationStatusNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(asserStatus));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validation Jenis Kelamin")
    public ReviewDataController validation_Jenis(String assertJenis) throws Exception {
        String textValidation = readText(customerDataPage.getValidationJenisNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertJenis));
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Validaiton Kewarganegaraan")
    public ReviewDataController validation_Kewarganegaraan(String assertKewarganegaraan) throws Exception {
        String textValidation = readText(customerDataPage.getValidationKewarganegaraNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(assertKewarganegaraan));
        GeneratedUtils.sleep(3000);
        return this;
    }


    @Step("Validation Next Review Data")
    public ReviewDataController validation_nextReview() throws Exception {
        GeneratedUtils.sleep(2000);
        String textValidation = readText(customerDataPage.getValidationnNextReviewData());
        Assert.assertTrue(textValidation.equalsIgnoreCase("Alhamdulillah!"));
        return this;
    }

    @Step("Click button lanjut")
    public ReviewDataController click_Lanjut() {
        click(customerDataPage.getBtnLanjut());
        return this;
    }

    @Step("Clear RT RW")
    public ReviewDataController clear_RT() {
        clearText(customerDataPage.getInputRTRW());
        return this;
    }
}
