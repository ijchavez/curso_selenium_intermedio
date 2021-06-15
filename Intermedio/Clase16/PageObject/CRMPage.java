package Intermedio.Clase16.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMPage extends BasePage{

    public CRMPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String getTextById(String anId){
        return driver.findElement(By.id(anId)).getText();
    }

}
