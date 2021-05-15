package Intermedio.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MundoMac {
    public static final String MUNDOMAC_URL = "https://www.mundomac.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setMundoMacUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(MUNDOMAC_URL);
        driver.manage().window().maximize();
    }
    @Test
    public void getAtribute(){
        String titulo = driver.getTitle();
        System.out.println("Titulo: " + titulo);
        
        List<WebElement> listaImagenes = driver.findElements(By.tagName("img"));
        Assert.assertNotEquals(listaImagenes.size(), 0);
        System.out.println("XXX " + listaImagenes.size());
        int contador = 0;

        for(WebElement img : listaImagenes){
            String altAttr = img.getAttribute("alt");
            //System.out.println("*** " + altAttr); //>>> quita esto al usar el srcAttr

            if (altAttr.isEmpty() || altAttr.equals("") ){
                contador = contador++;
                String imgSrc = img.getAttribute("src");
                System.out.println(">>> " + imgSrc);

            }

        }
        System.out.println("Se encontraron " + contador + " imagenes sin alt");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        //driver.close();

    }
    
}
