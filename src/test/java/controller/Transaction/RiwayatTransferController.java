package controller.Transaction;

import controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.Transaction.RiwayatTransferPage;
import utils.VariableProperties;

public class RiwayatTransferController extends BaseController {
    private RiwayatTransferPage riwayatTransferPage = new RiwayatTransferPage();
    private VariableProperties vp = new VariableProperties();
    String textValidation;
    public RiwayatTransferController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Choose List Transaksi")
    public RiwayatTransferController chooseListTransfer(){
        click(riwayatTransferPage.getBtnDetailTransaction());
        return this;
    }
    @Step("Validation Amount In Database")
    public RiwayatTransferController validationAmount(){

        return this;
    }

}
