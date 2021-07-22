package Mobile.controller.Hompage;

import Mobile.controller.BaseController;
import Mobile.utils.ConvertNumber;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import Mobile.pages.Hompage.HomePageTransaction;
import Mobile.utils.ReadWriteText;
import org.testng.Assert;

import java.text.ParseException;

public class HomePageController extends BaseController {
    HomePageTransaction homePageTransaction = new HomePageTransaction();
    String textGetBalanced;

    public HomePageController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    @Step("Pilih transfer hijra")
    public HomePageController transfetToHijra() {
        click(homePageTransaction.getBtnTransfer());
        return this;
    }

    @Step("Saldo Balanced")
    public HomePageController balancedSaldo() {
        click(homePageTransaction.getBtnViewBalance());
        textGetBalanced = readText(homePageTransaction.getSaldoBalanced());
        ReadWriteText.writeFileText(textGetBalanced, "GetBalanced.txt");
        return this;
    }

    @Step("Validation Balanced Saldo")
    public HomePageController validationBalanced(int amount) throws ParseException {
        try {
            String splitAmount = ReadWriteText.readFileText("GetBalanced.txt").split("Rp ")[1];
            int parseAmount = ConvertNumber.parseCurrency(splitAmount);
            int totalAmount = parseAmount - amount;
            System.out.println("Expected : "+totalAmount);
            String textAmount = String.valueOf(totalAmount);
            click(homePageTransaction.getBtnViewBalance());
            textGetBalanced = readText(homePageTransaction.getSaldoBalanced());
            String splitAmount2 = textGetBalanced.split("Rp ")[1];
            System.out.println("Actual : "+splitAmount2);
            int parseAmountTotal = ConvertNumber.parseCurrency(splitAmount2);
            String textAmountTotal = String.valueOf(parseAmountTotal);
            Assert.assertEquals(textAmount, textAmountTotal);
            ReadWriteText.deleteFile("GetBalanced.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    @Step("Scroll Riwayat Transfer")
    public HomePageController scrollText(String textScrool) {
        scrollAndClickBytext(textScrool);
        return this;
    }
}
