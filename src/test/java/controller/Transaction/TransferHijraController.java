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
            String ValidationRekPengirim = readText(transferHijraPage.getValidationRekPenerima());
            Assert.assertEquals(ValidationRekPenerima,textPenerima);
            Assert.assertEquals(ValidationRekPengirim,textPengirim);
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

}
