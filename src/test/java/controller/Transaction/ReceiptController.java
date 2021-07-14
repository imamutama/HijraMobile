package controller.Transaction;

import controller.BaseController;
import helper.DatabaseConnection;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.Transaction.ReceiptPage;
import utils.ConverDateTime;
import utils.ConvertNumber;

import java.sql.SQLException;

public class ReceiptController extends BaseController {
    ReceiptPage receiptPage = new ReceiptPage();
    String textValidation;

    public ReceiptController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Validation Amount OUT Database")
    public ReceiptController validationAmountOUT(String pengirim) {
        try {
            DatabaseConnection.DBConnect();
            String getPengirim = "SELECT amount FROM transaction_history" +
                    " WHERE username = '" + pengirim + "' ORDER BY seq_id desc limit 1";
            double amount = Double.parseDouble(getPengirim);
            textValidation = readText(receiptPage.getAmount());
            Assert.assertTrue(textValidation.contains(ConvertNumber.currencyID(amount)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Amount Out Data Manual")
    public ReceiptController validManualAmountOut(String amountData) {
        textValidation = readText(receiptPage.getAmount());
        Assert.assertTrue(textValidation.equals(amountData));
        return this;
    }

    @Step("Validation Nama Penerima Database")
    public ReceiptController validationNamePenerimaDb(String penerima) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT customer_name FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + penerima + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPenerima = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(receiptPage.getNamaPenerima());
            Assert.assertTrue(textValidation.equals(getPenerima));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Nama Pengirim OUT Database")
    public ReceiptController validationNamePengirimDb(String pengirim) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT customer_name FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + pengirim + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPengirim = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(receiptPage.getNamaPengirim());
            Assert.assertTrue(textValidation.equals(getPengirim));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Nama Penerima Manual Data")
    public ReceiptController validationNamePenerimaManual(String namePenerima) {
        textValidation = readText(receiptPage.getNamaPenerima());
        Assert.assertTrue(textValidation.equals(namePenerima));
        return this;
    }

    @Step("Validation Nama Pengirim Manual Data")
    public ReceiptController validationNamePengirimOanual(String namePengirim) {
        textValidation = readText(receiptPage.getNamaPengirim());
        Assert.assertTrue(textValidation.equals(namePengirim));
        return this;
    }

    @Step("Validation Rekening Penerima Database")
    public ReceiptController validationRekPenerimaInDb(String penerima) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT account_number FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + penerima + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPenerima = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(receiptPage.getRekeningPenerima());
            Assert.assertTrue(textValidation.equals(getPenerima));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Rekening Pengirim Database")
    public ReceiptController validationRekPengirimDb(String pengirim) throws SQLException {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT account_number FROM customer_data WHERE username IN " +
                    "(SELECT username FROM transaction_history" +
                    " WHERE username = '" + pengirim + "' " +
                    "ORDER BY seq_id desc limit 1)";
            String getPengirim = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(receiptPage.getRekPengirim());
            Assert.assertTrue(textValidation.equals(getPengirim));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Rekening Penerima Manual Data")
    public ReceiptController validationRekPenerimaManual(String rekPenerima) {
        textValidation = readText(receiptPage.getRekeningPenerima());
        Assert.assertTrue(textValidation.equals(rekPenerima));
        return this;
    }

    @Step("Validation Rekening Penerima Manual Data")
    public ReceiptController validationRekPengirimManual(String rekPengirim) {
        textValidation = readText(receiptPage.getRekPengirim());
        Assert.assertTrue(textValidation.equals(rekPengirim));
        return this;
    }


    @Step("Validation Bank Database")
    public ReceiptController validationBankDb(String username) {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT bank_name FROM transaction_history " +
                    "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            String getBank = DatabaseConnection.QuerySql(sql, 1);
            textValidation = readText(receiptPage.getNamaBank());
            Assert.assertTrue(textValidation.equals(getBank));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Bank Manual Data")
    public ReceiptController validationBankManual(String bank) {
        textValidation = readText(receiptPage.getNamaBank());
        Assert.assertTrue(textValidation.equals(bank));
        return this;
    }

    @Step("Validation DateTime Database")
    public ReceiptController validationDateTimeDb(String username) {
        try {
            DatabaseConnection.DBConnect();
            String sql = "SELECT created_date FROM transaction_history " +
                    "WHERE username = '" + username + "' ORDER BY seq_id desc limit 1";
            String getDate = DatabaseConnection.QuerySql(sql, 1);
            String convertDate = ConverDateTime.dateTime(getDate);
            textValidation = readText(receiptPage.getTglTransaksi());
            Assert.assertTrue(textValidation.contains(convertDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Validation Date Manual Data")
    public ReceiptController validationDateManual(String date) {
        textValidation = readText(receiptPage.getTglTransaksi());
        Assert.assertTrue(textValidation.contains(date));
        return this;
    }

    @Step("Back to Transfer Status")
    public ReceiptController backNavigate() {
        driver.navigate().back();
        return this;
    }
}
