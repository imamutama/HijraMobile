package Mobile.controller.Transaction;

import Mobile.controller.BaseController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import Mobile.pages.Transaction.FavoriteTransferPage;
import Mobile.utils.GeneratedUtils;

public class FavoriteTransferController extends BaseController {
    FavoriteTransferPage favoriteTransferPage = new FavoriteTransferPage();
    public FavoriteTransferController(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Choose List Lihat Semua")
    public FavoriteTransferController listSemua() throws Exception {
        click(favoriteTransferPage.getListAll());
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Searching Account Number")
    public FavoriteTransferController searchAccount(String account) throws Exception {
        writeText(favoriteTransferPage.getSearchList(),account);
        GeneratedUtils.sleep(2000);
        return this;
    }

    @Step("Choose Account Number List")
    public FavoriteTransferController chooseAccount() throws Exception {
        click(favoriteTransferPage.getChooseList());
        GeneratedUtils.sleep(2000);
        return this;
    }
}
