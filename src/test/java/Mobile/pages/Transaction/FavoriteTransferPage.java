package Mobile.pages.Transaction;

import org.openqa.selenium.By;

public class FavoriteTransferPage {
    private By listAll = By.xpath("//android.widget.TextView[@text = 'Lihat Semua']");
    private By searchList = By.xpath("//android.widget.EditText");
    private By chooseList = By.xpath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
    private By deleteList = By.xpath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup");

    public By getListAll() {
        return listAll;
    }

    public By getSearchList() {
        return searchList;
    }

    public By getChooseList() {
        return chooseList;
    }

    public By getDeleteList() {
        return deleteList;
    }
}
