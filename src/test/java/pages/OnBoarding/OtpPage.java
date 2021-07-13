package pages.OnBoarding;

import org.openqa.selenium.By;

public class OtpPage {
    private By btnKirimUlangOtp = By.xpath("//android.widget.TextView[@text = 'Kirim Ulang OTP']");
    private By validationBelumTerimaOTP = By.xpath("//android.widget.TextView[@text = 'Belum terima kode OTP? (3/5)']");
    private By alertKirimUlang = By.xpath("//android.widget.TextView[@text = 'Alhamdulillah, OTP berhasil dikirim ulang!']");
    private By validationGagalMissed = By.xpath("//android.widget.TextView[2");
    private By allowPermission = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By btnUlangiNanti = By.xpath("//android.widget.TextView[@text = 'Ulangi Nanti']");
    private By btnHubungiCS = By.xpath("//android.widget.TextView[@text = 'Hubungi CS']");
    private By textOtp1 = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");
    private By textOtp2 = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");
    private By textOtp3 = By.xpath("//android.view.ViewGroup[3]/android.widget.EditText");
    private By textOtp4 = By.xpath("//android.view.ViewGroup[4]/android.widget.EditText");
    private By textotp = By.className("android.widget.EditText");
    private By btnMissedCall = By.xpath("//android.widget.TextView[@text = 'Kirim Missed Call OTP']");
    private By validationCitcall = By.xpath("//android.widget.TextView[2]");

    public By getAllowPermission() {
        return allowPermission;
    }

    public By getBtnMissedCall() {
        return btnMissedCall;
    }

    public By getValidationCitcall() {
        return validationCitcall;
    }



    public By getTextotp() {
        return textotp;
    }

    public By getTextOtp4() {
        return textOtp4;
    }

    public By getTextOtp1() {
        return textOtp1;
    }

    public By getTextOtp2() {
        return textOtp2;
    }

    public By getTextOtp3() {
        return textOtp3;
    }

    public By getBtnKirimUlangOtp() {
        return btnKirimUlangOtp;
    }

    public By getValidationBelumTerimaOTP() {
        return validationBelumTerimaOTP;
    }

    public By getAlertKirimUlang() {
        return alertKirimUlang;
    }

    public By getValidationGagalMissed() {
        return validationGagalMissed;
    }

    public By getBtnUlangiNanti() {
        return btnUlangiNanti;
    }

    public By getBtnHubungiCS() {
        return btnHubungiCS;
    }
}
