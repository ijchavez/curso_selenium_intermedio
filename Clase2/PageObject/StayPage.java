package Intermedio.Clase2.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StayPage {
    WebDriver driver;

    public StayPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath="//*[contains(text(),'3 huéspedes')]")
    List<WebElement> tresHuespedesList;

    public List<WebElement> getTresHuespedesList(){
        return tresHuespedesList;

    }

}
