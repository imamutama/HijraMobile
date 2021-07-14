package pages;

import org.openqa.selenium.By;

public class PinPage {
    private By btnInputPin1 = By.xpath("//android.widget.TextView[@text = '1']");
    private By btnInputPin2 = By.xpath("//android.widget.TextView[@text = '2']");
    private By pinInvalid3x = By.xpath("//android.widget.TextView[2]");
    private By akunTerkunci = By.xpath("//android.widget.TextView[1]");
    private By keluarApp = By.xpath("//android.widget.TextView[@text = 'Keluar Aplikasi']");
    private By invalidPin = By.xpath("//android.widget.TextView[@text = 'PIN salah 1/3']");

    public By getBtnInputPin2() {
        return btnInputPin2;
    }

    public By getBtnInputPin1() {
        return btnInputPin1;
    }

    public By getPinInvalid3x() {
        return pinInvalid3x;
    }

    public By getAkunTerkunci() {
        return akunTerkunci;
    }

    public By getKeluarApp() {
        return keluarApp;
    }

    public By getInvalidPin() {
        return invalidPin;
    }
}
