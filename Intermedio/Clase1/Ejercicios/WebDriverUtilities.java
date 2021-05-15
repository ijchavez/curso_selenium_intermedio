package Intermedio.Clase1.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebDriverUtilities {
    public static List<WebElement> getElementsByClassName(WebDriver driver, String unaClase){
        List<WebElement> listaDeElementos = driver.findElements(By.className(unaClase));
        if (listaDeElementos.size() == 0){
            return null;

        }else{
            return listaDeElementos;

        }
    }
}
