package controller.Transaction;

import controller.BaseController;
import helper.DatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Transaction.HomePageTransaction;
import pages.Transaction.TransferHijraPage;
import utils.GeneratedUtils;

import java.sql.SQLException;

public class TransferHijraController extends BaseController {
    private TransferHijraPage transferHijraPage = new TransferHijraPage();
    private HomePageTransaction homePageTransaction = new HomePageTransaction();
    String textValidation;

    public TransferHijraController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Pilih menu transfer pada homepage")
    public TransferHijraController transferToHijra() throws Exception {
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
    public TransferHijraController inputNominal(String nominal) {
        writeText(transferHijraPage.getInputNominal(), nominal);
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

    @Step("Transfer Option Password")
    public TransferHijraController usePassword() {
        click(transferHijraPage.getBtnUsePassword());
        return this;
    }

    @Step("Input Password")
    public TransferHijraController inputPassowrd(String Password) {
        writeText(transferHijraPage.getInputPass(), Password);
        return this;
    }

    @Step("Transfer dilakukan")
    public TransferHijraController kirimSekarang() {
        click(transferHijraPage.getKirimSekarang());
        return this;
    }

    @Step("Transfer Status")
    public TransferHijraController statusTransfer(String validationStatus) {
        textValidation = readText(transferHijraPage.getStatusTransfer());
        Assert.assertEquals(textValidation, validationStatus);
        return this;
    }

    @Step("Kembali Homepage")
    public TransferHijraController backHome() {
        click(transferHijraPage.getBtnKembaliHome());
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
    public TransferHijraController validationNominalLimit(String nominalLimit) {
        textValidation = readText(transferHijraPage.getAlertNominalNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(nominalLimit));
        return this;
    }

//    @Step("Invalid Pin 3x")
//    public TransferHijraController validationInvalidPin3x(String validationPinReset) {
//        if (readText(transferHijraPage.getAkunTerkunci()).equalsIgnoreCase("Akun terkunci sementara")) {
//            textValidation = readText(transferHijraPage.getPinInvalid3x());
//            Assert.assertTrue(textValidation.equalsIgnoreCase(validationPinReset));
//            click(transferHijraPage.getKeluarApp());
//        }
//        return this;
//    }

    @Step("Validation Password Null")
    public TransferHijraController validationPassNull(String passNull) {
        textValidation = readText(transferHijraPage.getAlertPassNull());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passNull));
        return this;
    }
    @Step("Validation Password Invalid")
    public TransferHijraController validationPassinvalid(String passInvalid) {
        textValidation = readText(transferHijraPage.getValidaitonPassinvalid());
        Assert.assertTrue(textValidation.equalsIgnoreCase(passInvalid));
        return this;
    }

}
