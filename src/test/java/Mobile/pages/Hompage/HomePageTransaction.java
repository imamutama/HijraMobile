package Mobile.pages.Hompage;

import org.openqa.selenium.By;

public class HomePageTransaction {

    private By btnTransfer = By.xpath("//android.widget.TextView[@text = 'Transfer']");
    private By btnDeposit = By.xpath("//android.widget.TextView[@text = 'Deposit']");
    private By btnWithDraw = By.xpath("//android.widget.TextView[@text = 'Withdraw']");
    private By saldoBalanced = By.xpath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]");
    private By btnViewBalance = By.xpath("//android.view.ViewGroup[3]/android.widget.ImageView");
    private By nomorRekening = By.xpath("//android.widget.TextView[4]");


    public By getSaldoBalanced() {
        return saldoBalanced;
    }

    public By getBtnViewBalance() {
        return btnViewBalance;
    }

    public By getNomorRekening() {
        return nomorRekening;
    }

    public By getBtnTransfer() {
        return btnTransfer;
    }

    public By getBtnDeposit() {
        return btnDeposit;
    }

    public By getBtnWithDraw() {
        return btnWithDraw;
    }
}
