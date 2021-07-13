package pages.OnBoarding.Login;

import org.openqa.selenium.By;

public class ForgotPasswordPage {

    private By inputHijraID = By.xpath("//android.widget.EditText");
    private By btnLanjut = By.xpath("//android.widget.TextView[@text = 'Lanjut']");
    private By alertNullinput = By.xpath("//android.widget.TextView[@text = 'Isi dulu ya']");
    private By alertUserNotFound = By.xpath("//android.widget.TextView[@text = 'User not found']");

    public By getInputHijraID() {
        return inputHijraID;
    }

    public By getBtnLanjut() {
        return btnLanjut;
    }

    public By getAlertNullinput() {
        return alertNullinput;
    }

    public By getAlertUserNotFound() {
        return alertUserNotFound;
    }
}
