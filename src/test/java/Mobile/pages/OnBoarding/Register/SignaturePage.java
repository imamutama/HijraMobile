package Mobile.pages.OnBoarding.Register;

import org.openqa.selenium.By;

public class SignaturePage {

    private By btnUploadSignature = By.xpath("//android.widget.TextView[@text = 'Upload']");
    private By continueSignature = By.xpath("//android.widget.TextView[@text = 'Lanjut Tanda Tangan']");
    private By btnPilihGalery = By.xpath("//android.widget.TextView[@text = 'Pilih foto dari galeri']");
    private By btnAllowGalery = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By chooseImage = By.xpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.view.View");
    private By btnLanjutSignature = By.xpath("//android.widget.TextView[@text = 'Lanjut']");


    public By getBtnUploadSignature() {
        return btnUploadSignature;
    }

    public By getContinueSignature() {
        return continueSignature;
    }

    public By getBtnPilihGalery() {
        return btnPilihGalery;
    }

    public By getBtnAllowGalery() {
        return btnAllowGalery;
    }

    public By getChooseImage() {
        return chooseImage;
    }

    public By getBtnLanjutSignature() {
        return btnLanjutSignature;
    }
}
