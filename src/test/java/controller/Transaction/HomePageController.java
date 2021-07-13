package controller.Transaction;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.Transaction.HomePageTransaction;
import test.BaseTest;
import utils.ReadWriteText;

public class HomePageController extends BaseController {
    HomePageTransaction homePageTransaction = new HomePageTransaction();
    String textGetBalanced;
    public HomePageController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    @Step("Pilih transfer hijra")
    public HomePageController transfetToHijra(){
        click(homePageTransaction.getBtnTransfer());
        return this;
    }

    @Step("Saldo Balanced")
    public HomePageController balancedSaldo(){
        click(homePageTransaction.getBtnViewBalance());
        textGetBalanced = readText(homePageTransaction.getSaldoBalanced());
        ReadWriteText.writeFileText(textGetBalanced,"GetBalanced.txt");
        return this;
    }

    @Step("Validation Balanced Saldo")
    public HomePageController validationBalanced(){
        textGetBalanced = readText(homePageTransaction.getSaldoBalanced());
        if(!(textGetBalanced.equalsIgnoreCase(ReadWriteText.readFileText("GetBalanced.txt")))){
            System.out.println("Saldo Telah Berkurang PASSED");
        }else {
            System.out.println("FAILED");
        }
        return this;
    }

    @Step("Scroll Riwayat Transfer")
    public HomePageController scrollText(String textScrool){
        scrollAndClickBytext(textScrool);
        return this;
    }
}
