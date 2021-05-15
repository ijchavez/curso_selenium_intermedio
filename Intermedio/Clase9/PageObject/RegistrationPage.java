package Intermedio.Clase9.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    public RegistrationPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
}
