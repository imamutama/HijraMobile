package controller.Transaction;

import controller.BaseController;
import helper.DatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Transaction.DetailTransferPage;
import utils.ConverDateTime;
import utils.ConvertNumber;
import utils.GeneratedUtils;
import utils.VariableProperties;

import java.sql.SQLException;

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
    public DetailTransferController validationAmount(String pengirim) {
        try {
            DatabaseConnection.DBConnect();
            String getPengirim = "SELECT amount FROM transaction_history" +
                    " WHERE username = '" + pengirim + "' ORDER BY seq_id desc limit 1";
            double amount = Double.parseDouble(getPengirim);
            textValidation = readText(detailTransferPage.getAmountValidation());
            Assert.assertTrue(textValidation.contains(ConvertNumber.currencyID(amount)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Amount In Data Manual")
    public DetailTransferController validManualAmountIn(String amountData) {
        textValidation = readText(detailTransferPage.getAmountValidation());
        Assert.assertTrue(textValidation.equals(amountData));
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
            Assert.assertTrue(textValidation.equals(getPenerima));
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
            Assert.assertTrue(textValidation.equals(getPengirim));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Nama Penerima Manual Data")
    public DetailTransferController validationNamePenerimaManual(String namePenerima) {
        textValidation = readText(detailTransferPage.getNamaPenerima());
        Assert.assertTrue(textValidation.equals(namePenerima));
        return this;
    }

    @Step("Validation Nama Penerima Manual Data")
    public DetailTransferController validationNamePengirimManual(String namePengirim) {
        textValidation = readText(detailTransferPage.getNamaPengirim());
        Assert.assertTrue(textValidation.equals(namePengirim));
        return this;
    }
    @Step("Validation Rekening Penerima Database")
    public DetailTransferController validationRekPenerimaDb(String penerima) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT account_number FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + penerima + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPenerima = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(detailTransferPage.getRekeningPenerima());
            Assert.assertTrue(textValidation.equals(getPenerima));
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
            Assert.assertTrue(textValidation.equals(getPengirim));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    @Step("Validation Rekening Penerima Manual Data")
    public DetailTransferController validationRekPenerimaManual(String rekPenerima) {
        textValidation = readText(detailTransferPage.getRekeningPenerima());
        Assert.assertTrue(textValidation.equals(rekPenerima));
        return this;
    }

    @Step("Validation Rekening Penerima Manual Data")
    public DetailTransferController validationRekPengirimManual(String rekPengirim) {
        textValidation = readText(detailTransferPage.getRekPengirim());
        Assert.assertTrue(textValidation.equals(rekPengirim));
        return this;
    }


    @Step("Validation Bank Database")
    public DetailTransferController validationBankDb(String username) {
        try {
            DatabaseConnection.DBConnect();
            String sql;
            if (username.equals("Akuntransfer8")) {
                sql = "SELECT bank_name FROM transaction_history " +
                        "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            } else {
                sql = "SELECT bank_name FROM transaction_history " +
                        "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            }
            String getBank = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(detailTransferPage.getNamaBank());
            Assert.assertTrue(textValidation.equals(getBank));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Bank Manual Data")
    public DetailTransferController validationBankManual(String bank) {
        textValidation = readText(detailTransferPage.getNamaBank());
        Assert.assertTrue(textValidation.equals(bank));
        return this;
    }

    @Step("Validation Date Database")
    public DetailTransferController validationDateDb(String username) {
        try {
            DatabaseConnection.DBConnect();
            String sql;
            if (username.equalsIgnoreCase("Akuntransfer8")) {
                sql = "SELECT created_date FROM transaction_history " +
                        "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            } else {
                sql = "SELECT created_date FROM transaction_history " +
                        "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            }
            String getDate = DatabaseConnection.QuerySql(sql, 1);
            String convertDate = ConverDateTime.dateConvert(getDate);
            textValidation = readText(detailTransferPage.getTglTransaksi());
            Assert.assertTrue(textValidation.contains(convertDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Date Manual Data")
    public DetailTransferController validationDateManual(String date) {
        textValidation = readText(detailTransferPage.getTglTransaksi());
        Assert.assertTrue(textValidation.contains(date));
        return this;
    }

    @Step("Validation TimeStamp Database")
    public DetailTransferController validationTimeDb(String username) {
        try {
            DatabaseConnection.DBConnect();
            String sql;
            if (username.equalsIgnoreCase("Akuntransfer8")) {
                sql = "SELECT created_date FROM transaction_history " +
                        "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            } else {
                sql = "SELECT created_date FROM transaction_history " +
                        "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            }
            String getTime = DatabaseConnection.QuerySql(sql, 1);
            String convertDate = ConverDateTime.timeConvert(getTime);
            textValidation = readText(detailTransferPage.getTimeTransaksi());
            Assert.assertTrue(textValidation.contains(convertDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    @Step("Validation Time Manual Data")
    public DetailTransferController validationTimeManual(String time) {
        textValidation = readText(detailTransferPage.getTimeTransaksi());
        Assert.assertTrue(textValidation.contains(time));
        return this;
    }
    @Step("scrollText")
    public DetailTransferController scrollText(String text){
        scrollAndClickBytext(text);
        return this;
    }

    @Step("Lihat Bukti Transfer")
    public DetailTransferController lihatBuktiTf() throws Exception {
        click(detailTransferPage.getBuktiTransfer());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Simpan Bukti Transfer")
    public DetailTransferController saveBuktiTransfer() throws Exception {
        click(detailTransferPage.getBtnSimpanBuktiTf());
        GeneratedUtils.sleep(2000);
        click(detailTransferPage.getBtnAllowGalery());
        GeneratedUtils.sleep(2000);
        click(detailTransferPage.getSimpanSebagaiGambar());
        return this;

    }
}

