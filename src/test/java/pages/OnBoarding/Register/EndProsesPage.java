package pages.OnBoarding.Register;

import org.openqa.selenium.By;

public class EndProsesPage {
    private By validationSelesai = By.xpath("//android.widget.TextView[@text = 'Kamu berhasil menyelesaikan proses.']");
    private By btnKeluar = By.xpath("//android.widget.TextView[@text = 'Keluar']");

    public By getValidationSelesai() {
        return validationSelesai;
    }

    public By getBtnKeluar() {
        return btnKeluar;
    }
}
