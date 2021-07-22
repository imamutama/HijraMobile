package Mobile.pages.OnBoarding.Register;

import org.openqa.selenium.By;

public class SelfiePage {

    private By continueTakeSelfieKTP = By.xpath("//android.widget.TextView[@text = 'Lanjut Foto Selfie dengan KTP']");
    private By continueTakeSelfie = By.xpath("//android.widget.TextView[@text = 'Lanjut Foto selfie']");
    private By textSelfieKTP = By.xpath("//android.widget.TextView[@text = 'Foto Selfie dengan KTP']");
    private By btnAllowGalery = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By btnAllowRecord = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By btnSelfieCamera = By.xpath("//android.view.ViewGroup[3]");
    private By btnUpload = By.xpath("//android.widget.TextView[@text = 'Upload']");

    public By getContinueTakeSelfieKTP() {
        return continueTakeSelfieKTP;
    }

    public By getContinueTakeSelfie() {
        return continueTakeSelfie;
    }

    public By getTextSelfieKTP() {
        return textSelfieKTP;
    }

    public By getBtnAllowGalery() {
        return btnAllowGalery;
    }

    public By getBtnAllowRecord() {
        return btnAllowRecord;
    }

    public By getBtnSelfieCamera() {
        return btnSelfieCamera;
    }

    public By getBtnUpload() {
        return btnUpload;
    }
}
