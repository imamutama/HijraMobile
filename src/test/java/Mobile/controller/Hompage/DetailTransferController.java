package Mobile.controller.Hompage;

import Mobile.controller.BaseController;
import Mobile.controller.OnBoarding.Register.ReviewDataController;
import Mobile.helper.DatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.testng.Assert;
import Mobile.pages.Hompage.DetailTransferPage;
import Mobile.utils.ConverDateTime;
import Mobile.utils.ConvertNumber;
import Mobile.utils.GeneratedUtils;

import java.sql.SQLException;
import java.time.Duration;

public class DetailTransferController extends BaseController {
    private DetailTransferPage detailTransferPage = new DetailTransferPage();
    String textValidation;

    public DetailTransferController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Choose List Transaksi")
    public DetailTransferController chooseListTransfer() {
        click(detailTransferPage.getBtnDetailTransaction());
        return this;
    }

    @Step("Validation Status Berhasil")
    public DetailTransferController statusTransfer() {
        textValidation = readText(detailTransferPage.getValidationSuccesTf());
        Assert.assertEquals(textValidation, "Transaksi Berhasil");
        return this;
    }

    @Step("Validation Amount Database")
    public DetailTransferController validationAmount(String username, String transactionType) {
        try {
            DatabaseConnection.DBConnect();
            String getPengirim = "SELECT amount FROM transaction_history WHERE username = '" + username + "' AND transaction_type = '" + transactionType + "' " +
                    "ORDER BY seq_id desc limit 1";
            double amount = Double.parseDouble(DatabaseConnection.QuerySql(getPengirim, 1));
            textValidation = readText(detailTransferPage.getAmountValidation());
            System.out.println(textValidation);
            String splitText = textValidation.split("Rp ")[1];
            Assert.assertEquals(splitText, ConvertNumber.currencyID(amount));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


    @Step("Validation Nama Penerima Database")
    public DetailTransferController validationNamePenerimaDb(String penerima) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT customer_name FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + penerima + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPenerima = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(detailTransferPage.getNamaPenerima());
            Assert.assertEquals(textValidation, getPenerima);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Nama Penerima Database")
    public DetailTransferController validationNamePengirimDb(String pengirim) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT customer_name FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + pengirim + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPengirim = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(detailTransferPage.getNamaPengirim());
            Assert.assertEquals(textValidation, getPengirim);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Nama Penerima Manual Data")
    public DetailTransferController validationNamePenerimaManual(String namePenerima) {
        textValidation = readText(detailTransferPage.getNamaPenerima());
        Assert.assertEquals(textValidation, namePenerima);
        return this;
    }

    @Step("Validation Nama Penerima Manual Data")
    public DetailTransferController validationNamePengirimManual(String namePengirim) {
        textValidation = readText(detailTransferPage.getNamaPengirim());
        Assert.assertEquals(textValidation, namePengirim);
        return this;
    }

    @Step("Validation Rekening Penerima Database")
    public DetailTransferController validationRekPenerimaDb(String penerima, String historyType) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT account_number FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + penerima + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPenerima = DatabaseConnection.QuerySql(sql, 1);
            if (historyType.equals("Detail")) {
                textValidation = readText(detailTransferPage.getRekPenerimaDetail());
            } else if (historyType.equals("Status")) {
                textValidation = readText(detailTransferPage.getRekeningPenerima());
            }
            Assert.assertEquals(textValidation, getPenerima);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Rekening Pengirim Database")
    public DetailTransferController validationRekPengirimDb(String pengirim) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT account_number FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + pengirim + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPengirim = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(detailTransferPage.getRekPengirim());
            Assert.assertEquals(textValidation, getPengirim);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Rekening Penerima Manual Data")
    public DetailTransferController validationRekPenerimaManual(String rekPenerima) {
        textValidation = readText(detailTransferPage.getRekeningPenerima());
        Assert.assertEquals(textValidation, rekPenerima);
        return this;
    }

    @Step("Validation Rekening Penerima Manual Data")
    public DetailTransferController validationRekPengirimManual(String rekPengirim) {
        textValidation = readText(detailTransferPage.getRekPengirim());
        Assert.assertEquals(textValidation, rekPengirim);
        return this;
    }


    @Step("Validation Bank Database")
    public DetailTransferController validationBankDb(String username, String historyType) {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT bank_name FROM transaction_history " +
                    "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            String getBank = DatabaseConnection.QuerySql(sql, 1);
            if (historyType.equals("Detail")) {
                textValidation = readText(detailTransferPage.getBankDetail());
            } else if (historyType.equals("Status")) {
                textValidation = readText(detailTransferPage.getNamaBank());
            }
            Assert.assertEquals(textValidation, getBank);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Bank Manual Data")
    public DetailTransferController validationBankManual(String bank) {
        textValidation = readText(detailTransferPage.getNamaBank());
        Assert.assertEquals(textValidation, bank);
        return this;
    }

    @Step("Validation Date Database")
    public DetailTransferController validationDateDb(String username, String transaction_type, String historyType) {
        try {
            DatabaseConnection.DBConnect();

            String sql = "SELECT created_date FROM transaction_history " +
                    "WHERE username ='" + username + "' AND transaction_type = '" + transaction_type + "' " +
                    "ORDER BY seq_id desc limit 1";

            String getDate = DatabaseConnection.QuerySql(sql, 1);
            String convertDate = ConverDateTime.dateConvert(getDate);
            if (historyType.equals("Detail")) {
                textValidation = readText(detailTransferPage.getDateDetail());
            } else if (historyType.equals("Status")) {
                textValidation = readText(detailTransferPage.getTglTransaksi());
            }
            Assert.assertEquals(textValidation, convertDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Date Manual Data")
    public DetailTransferController validationDateManual(String date, String historyType) {
        if (historyType.equals("Detail")) {
            textValidation = readText(detailTransferPage.getDateDetail());
        } else if (historyType.equals("Status")) {
            textValidation = readText(detailTransferPage.getTglTransaksi());
        }
        Assert.assertEquals(textValidation, date);
        return this;
    }

    @Step("Validation TimeStamp Database")
    public DetailTransferController validationTimeDb(String username, String transaction_type, String historyType) {
        try {
            DatabaseConnection.DBConnect();

            String sql = "SELECT created_date FROM transaction_history " +
                    "WHERE username ='" + username + "' AND transaction_type = '" + transaction_type + "' " +
                    "ORDER BY seq_id desc limit 1";

            String getTime = DatabaseConnection.QuerySql(sql, 1);
            String convertDate = ConverDateTime.timeConvert(getTime);
            if (historyType.equals("Detail")) {
                textValidation = readText(detailTransferPage.getTimeDetail());
            } else if (historyType.equals("Status")) {
                textValidation = readText(detailTransferPage.getTimeTransaksi());
            }
            String splitText = textValidation.split(" WIB")[0];
            Assert.assertEquals(splitText, convertDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Scroll End")
    public DetailTransferController scrollEnd() throws Exception {
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

    @Step("scrollText")
    public DetailTransferController scrollText(String text) {
        scrollAndClickBytext(text);
        return this;
    }

    @Step("Lihat Bukti Transfer")
    public DetailTransferController lihatBuktiTf() throws Exception {
        click(detailTransferPage.getBuktiTransfer());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Simpan Bukti Transfer Gambar")
    public DetailTransferController saveBuktiTransfer() throws Exception {
        click(detailTransferPage.getBtnSimpanBuktiTf());
        GeneratedUtils.sleep(2000);
        click(detailTransferPage.getBtnAllowGalery());
        GeneratedUtils.sleep(2000);
        click(detailTransferPage.getSimpanSebagaiGambar());
        return this;
    }

    @Step("Simpan Bukti Transfer PDF")
    public DetailTransferController saveBuktiPDF() throws Exception {
        click(detailTransferPage.getBtnSimpanBuktiTf());
        GeneratedUtils.sleep(2000);
        click(detailTransferPage.getSimpanSebagaiPdf());
        return this;
    }

    @Step("Validation Simpan Bukti Transfer")
    public DetailTransferController validationSaveBukti(String validationSave) {
        textValidation = readText(detailTransferPage.getValidationSimpanDetail());
        Assert.assertTrue(textValidation.equalsIgnoreCase(validationSave));
        driver.navigate().back();
        return this;
    }


    @Step("Simpan Bukti Transfer PDF")
    public DetailTransferController backHomePage() throws Exception {
        click(detailTransferPage.getBtnKembaliHome());
        GeneratedUtils.sleep(3000);
        return this;
    }
}

