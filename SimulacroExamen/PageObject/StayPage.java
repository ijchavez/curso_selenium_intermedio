package Intermedio.SimulacroExamen.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StayPage extends BasePage {

    public StayPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);


    }
    @FindBy(xpath="//*[contains(text(),'2 huéspedes')]")
    List<WebElement> dosHuespedesList;
    public List<WebElement> getDosHuespedesList(){
        return dosHuespedesList;

    }
    @FindBy(xpath = "//*[contains(text(),'Más de 300')]")
    WebElement cantidadDeHuespedes;
    public String getCantidadDeHuespedesText(){
        String cantidadDeHuespedesText = cantidadDeHuespedes.getText();
        return cantidadDeHuespedesText;

    }
    @FindBy(xpath = "//*[contains(text(),'Estadías en ')]")
    WebElement estadiaEnLugar;
    public String getEstadiaEnLugarText(){
        String estadiaEnLugarText = estadiaEnLugar.getText();
        return estadiaEnLugarText;
    }

}
