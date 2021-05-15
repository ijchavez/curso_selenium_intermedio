package Intermedio.Clase1.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BbcTest {
    public static final String BBC_URL = "https://www.bbc.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setBbcUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(BBC_URL);
        driver.manage().window().maximize();
    }
    @Test
    public void findPIndivTest(){
        WebElement elementoDiv = driver.findElement(By.tagName("div"));

        List<WebElement> listaDeP = elementoDiv.findElements(By.tagName("p"));
        System.out.println("Cantidad de P dentro de un div " + listaDeP.size());
        for (WebElement unaListaP : listaDeP) {
            String listaDePText = unaListaP.getText();
            System.out.println("P: " + listaDePText);

        }

    }
    @Test
    public void getAttributeIdOnDiv(){
        int cont = 0;
        List<WebElement> elementosDiv = driver.findElements(By.tagName("div"));
        System.out.println("la cantidad de elementos Div es: " + elementosDiv.size());

        for (WebElement eleDiv : elementosDiv){
            if(eleDiv.getAttribute("id").isEmpty() == false){
                //Estas preguntando si el atributo id tiene valor..
                //isEmpty == false si el String no esta vacio, es decir si tiene texto
                //isEmpty == true si un String no tiene texto, es decir, esta vacio
                cont++;

            }
        }
        System.out.println("La cantidad de Divs con el atributo id es de " + cont);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("--------------------");
        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        driver.close();

    }
}
