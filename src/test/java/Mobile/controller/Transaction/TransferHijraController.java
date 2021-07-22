package Mobile.controller.Transaction;

import Mobile.controller.BaseController;
import Mobile.controller.OnBoarding.Register.ReviewDataController;
import Mobile.controller.PinController;
import Mobile.helper.DatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import Mobile.pages.Hompage.HomePageTransaction;
import Mobile.pages.Transaction.TransferHijraPage;
import Mobile.utils.GeneratedUtils;

import java.sql.SQLException;
import java.time.Duration;

public class TransferHijraController extends BaseController {
    private TransferHijraPage transferHijraPage = new TransferHijraPage();
    private HomePageTransaction homePageTransaction = new HomePageTransaction();
    private PinController pinController = new PinController(driver);
    String textValidation;

    public TransferHijraController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Pilih menu transfer pada homepage")
    public TransferHijraController transferToHijra() throws Exception {
        GeneratedUtils.sleep(2000);
        click(homePageTransaction.getBtnTransfer());
        click(transferHijraPage.getBtnHijraTransfer());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Masukan Rekening atau ID Hijra")
    public TransferHijraController inputRekHijraID(String rekHijraID) throws Exception {
        writeText(transferHijraPage.getInputHijraIDRek(), rekHijraID);
        GeneratedUtils.sleep(2000);
        click(transferHijraPage.getAddFavorite());
        GeneratedUtils.sleep(2000);

        return this;
    }

    @Step("Klik button lanjut")
    public TransferHijraController clickbtnLanjut() throws Exception {
        click(transferHijraPage.getBtnLanjut());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Nominal")
    public TransferHijraController inputNominal(String nominal) throws Exception {
        writeText(transferHijraPage.getInputNominal(), nominal);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Input Catatan")
    public TransferHijraController inputCatatan(String catatan) {
        writeText(transferHijraPage.getInputCatatan(), catatan);
        return this;
    }

    @Step("Validation Nama Penerima")
    public TransferHijraController validationDtlNamePenerima(String penerima, String pengirim) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String namePenerima = "SELECT customer_name FROM customer_data WHERE username = '" + penerima + "'";
            String namePengirim = "SELECT customer_name FROM customer_data WHERE username = '" + pengirim + "'";
            String textNamePenerima = String.valueOf(DatabaseConnection.QuerySql(namePenerima, 1));
            String texNametPengirim = String.valueOf(DatabaseConnection.QuerySql(namePengirim, 1));
            System.out.println(DatabaseConnection.QuerySql(namePenerima, 1) + " & " + DatabaseConnection.QuerySql(namePengirim, 1));
            MobileElement vaildationPenerima = driver.findElement(By.xpath("//android.widget.TextView[@text = '" + textNamePenerima + "']"));
            MobileElement vaildationPengirim = driver.findElement(By.xpath("//android.widget.TextView[@text = '" + texNametPengirim + "']"));
            Assert.assertTrue(vaildationPenerima.isDisplayed());
            Assert.assertTrue(vaildationPengirim.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Nomor Rekening Number")
    public TransferHijraController validationDetailRekPenerima(String penerima, String pengirim) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String getPenerima = "SELECT account_number FROM customer_data WHERE username = '" + penerima + "'";
            String getPengirim = "SELECT account_number FROM customer_data WHERE username = '" + pengirim + "'";
            String textPenerima = String.valueOf(DatabaseConnection.QuerySql(getPenerima, 1));
            String textPengirim = String.valueOf(DatabaseConnection.QuerySql(getPengirim, 1));
            System.out.println(DatabaseConnection.QuerySql(getPengirim, 1) + " && " + DatabaseConnection.QuerySql(getPenerima, 1));
            String ValidationRekPenerima = readText(transferHijraPage.getValidationRekPenerima());
            String ValidationRekPengirim = readText(transferHijraPage.getValidaitonNRekPengirim());
            Assert.assertEquals(ValidationRekPenerima, textPenerima);
            Assert.assertEquals(ValidationRekPengirim, textPengirim);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Lanjutkan Transfer")
    public TransferHijraController btnLanjutKirim() {
        click(transferHijraPage.getBtnLanjutaKirim());
        return this;
    }

    @Step("Transfer Option Authentication")
    public TransferHijraController transferAuthentication(String auth, String Password) throws Exception {
        if (auth.equals("Password")) {
            click(transferHijraPage.getBtnUsePassword());
            writeText(transferHijraPage.getInputPass(), Password);
            click(transferHijraPage.getKirimSekarang());
        } else if (auth.equals("PIN")) {
            pinController.inputPin();
        }
        return this;
    }

    @Step("Transfer Status")
    public TransferHijraController statusTransfer(String validationStatus) {
        textValidation = readText(transferHijraPage.getStatusTransfer());
        Assert.assertEquals(textValidation, validationStatus);
        return this;
    }

    @Step("Kembali Homepage")
    public TransferHijraController backHome() throws Exception {
        click(transferHijraPage.getBtnKembaliHome());
        GeneratedUtils.sleep(3000);
        return this;
    }

    @Step("Lihat Receipt")
    public TransferHijraController viewReceipt() {
        click(transferHijraPage.getLihatReceipt());
        return this;
    }

    @Step("scrollText")
    public TransferHijraController scrollText(String text) {
        scrollAndClickBytext(text);
        return this;
    }

    @Step("Transfer via riwayat transfer")
    public TransferHijraController riwayatTransfer() {
        click(transferHijraPage.getListRiwayatTf());
        return this;
    }

    @Step("Validation Hijra ID / Rekening Null")
    public TransferHijraController validationRekIdNull(String hijraNull) {
        textValidation = readText(transferHijraPage.getAlertHijraNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(hijraNull));
        return this;
    }

    @Step("Validation Hijra ID / Rekening Invalid")
    public TransferHijraController validationRekIdInvalid(String hijraInvalid) {
        textValidation = readText(transferHijraPage.getValidationInvalidrekID());
        Assert.assertTrue(textValidation.equalsIgnoreCase(hijraInvalid));
        return this;
    }

    @Step("Validation Nominal Null")
    public TransferHijraController validationNominalNull(String nominalNull) {
        textValidation = readText(transferHijraPage.getAlertNominalNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(nominalNull));
        return this;
    }

    @Step("Validation Nominal limit")
    public TransferHijraController validationNominalLimit(String nominalLimitMin, String nominalLimitMax, String nominal) {
        if (nominal == "5000") {
            textValidation = readText(transferHijraPage.getValidationMinimalLimitMin());
            Assert.assertTrue(textValidation.equalsIgnoreCase(nominalLimitMin));
        } else if (nominal == "26000000") {
            textValidation = readText(transferHijraPage.getValidationMinimalLimitMax());
            Assert.assertTrue(textValidation.equalsIgnoreCase(nominalLimitMax));
        }
        return this;
    }

    @Step("Transfer Option Authentication Negative")
    public TransferHijraController transferAuthenticationNegative(String authOptions, String validationParam, String validationParam1, String validationParam2, String passNull, String formatInvalid, String validationFormatInvalid, String passLock, String validationParam3) throws Exception {
        if (authOptions.equals("Password")) {
            click(transferHijraPage.getBtnUsePassword());
            validationPassNull(passNull);
            validationFormatinvalid(formatInvalid, validationFormatInvalid);
            validationPassinvalid3x(passLock, validationParam3);
        } else if (authOptions.equals("PIN")) {
            pinController.invalidPin(validationParam);
            pinController.invalidPin3x(validationParam1, validationParam2);
        }
        return this;
    }

    @Step("Validation Password Null")
    public TransferHijraController validationPassNull(String passNull) {
        click(transferHijraPage.getKirimSekarang());
        textValidation = readText(transferHijraPage.getAlertPassNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passNull));
        return this;
    }

    @Step("Validation Password Format Invalid")
    public TransferHijraController validationFormatinvalid(String formatInvalid, String validationFormatInvalid) throws Exception {
        writeText(transferHijraPage.getInputPass(), formatInvalid);
        GeneratedUtils.sleep(2000);
        click(transferHijraPage.getKirimSekarang());
        textValidation = readText(transferHijraPage.getValidaitonPassinvalid());
        Assert.assertEquals(textValidation, validationFormatInvalid);
        return this;
    }

    @Step("Validation Password Invalid")
    public TransferHijraController validationPassinvalid3x(String passLock, String validationParam3) throws Exception {
        clearText(transferHijraPage.getInputPass());
        writeText(transferHijraPage.getInputPass(), "Password1234");
        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                clearText(transferHijraPage.getInputPass());
                writeText(transferHijraPage.getInputPass(), "Password1234");
                GeneratedUtils.sleep(3000);
                click(transferHijraPage.getKirimSekarang());
            }
            if (i == 2) {
                clearText(transferHijraPage.getInputPass());
                writeText(transferHijraPage.getInputPass(), "Password12345");
                GeneratedUtils.sleep(3000);
                click(transferHijraPage.getKirimSekarang());
            }
            if (i == 3) {
                clearText(transferHijraPage.getInputPass());
                writeText(transferHijraPage.getInputPass(), "Password12346");
                GeneratedUtils.sleep(3000);
                click(transferHijraPage.getKirimSekarang());
            }

        }
        textValidation = readText(transferHijraPage.getAkunTerkunci());
        System.out.println(textValidation);
        if (textValidation.equals(passLock)) {
            textValidation = readText(transferHijraPage.getPassInvalid3x());
            Assert.assertEquals(textValidation, validationParam3);
            click(transferHijraPage.getKeluarApp());
            GeneratedUtils.sleep(3000);
        }

        return this;
    }

    @Step("Clear Rekening")
    public TransferHijraController clearRek() {
        clearText(transferHijraPage.getInputHijraIDRek());
        return this;
    }

    @Step("Clear Nominal")
    public TransferHijraController clearNominal() {
        clearText(transferHijraPage.getInputNominal());
        return this;
    }

    @Step("Update failed login count")
    public TransferHijraController updateCountLogin(String account) throws SQLException {
        DatabaseConnection.DBConnect();
        DatabaseConnection.updateDB("UPDATE user_login SET failed_login_count = 0 WHERE username = '" + account + "'");
        return this;
    }

    @Step("Scrooll Tempat Lahir")
    public TransferHijraController scrollTL() throws Exception {
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

    @Step("Scroll End")
    public TransferHijraController scrollEnd() throws Exception {
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

}


