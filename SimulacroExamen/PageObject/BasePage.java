package Intermedio.SimulacroExamen.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    public void closeDriver(){
        driver.close();
    }

}
