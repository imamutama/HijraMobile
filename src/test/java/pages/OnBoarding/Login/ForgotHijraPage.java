package pages.OnBoarding.Login;

import org.openqa.selenium.By;

public class ForgotHijraPage {

    private By inputHp = By.xpath("//android.widget.EditText");
    private By inputIbuKandung = By.xpath("");
    private By kirimVerifikasi = By.xpath("//android.widget.TextView[@text = 'Kirim Verifikasi']");
    private By alertNullinput = By.xpath("//android.widget.TextView[@text = 'Isi dulu ya']");
    private By alertUserNotFound = By.xpath("//android.widget.TextView[@text = 'User not found']");

    public By getInputHp() {
        return inputHp;
    }

    public By getInputIbuKandung() {
        return inputIbuKandung;
    }

    public By getKirimVerifikasi() {
        return kirimVerifikasi;
    }

    public By getAlertNullinput() {
        return alertNullinput;
    }

    public By getAlertUserNotFound() {
        return alertUserNotFound;
    }
}
