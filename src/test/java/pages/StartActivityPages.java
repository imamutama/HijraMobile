package pages;

import org.openqa.selenium.By;

public class StartActivityPages {

    private By btnSalam = By.xpath("//android.widget.TextView[@text = 'Waalaikumussalam']");
    private By btnBahasa = By.xpath("//android.widget.TextView[@text = 'Indonesia']");
    private By btnLanguage = By.xpath("//android.widget.TextView[@text = 'English']");
    private By slide1 = By.xpath("//android.widget.TextView[@text = 'Selamat datang di Hijra!']");
    private By slide2 = By.xpath("//android.widget.TextView[@text = 'Cepat dan mudah dipakai']");
    private By slide3 = By.xpath("//android.widget.TextView[@text = 'Ibadah jadi lebih mudah']");

    public By getSlide1() {
        return slide1;
    }

    public By getSlide2() {
        return slide2;
    }

    public By getSlide3() {
        return slide3;
    }

    public By getBtnSalam() {
        return btnSalam;
    }

    public By getBtnBahasa() {
        return btnBahasa;
    }

    public By getBtnLanguage() {
        return btnLanguage;
    }
}
