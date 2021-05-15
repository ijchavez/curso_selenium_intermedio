package Intermedio.Clase1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Clase1 {

    public static final String BOOKING_URL = "https://www.booking.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setBoopkingUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(BOOKING_URL);
        driver.manage().window().maximize();
    }
    @Test
    public void primerTest() {

        String estilo = driver.findElement(By.id("revc_write_a_review_login_intro")).getAttribute("style");

        String titulo = driver.getTitle();
        System.out.println(">>>" + titulo);

        WebElement elementHx = driver.findElement(By.tagName("PX")); //>>> No lo encuentra
        List<WebElement> listaHxs = driver.findElements(By.tagName("PX")); //>> no falla porque crea una lista vacia

        Assert.assertNotEquals(listaHxs.size(), 0);
        Assert.assertFalse(listaHxs.isEmpty()); //>> Es falso que la lista es vacia el isEmpty dice que si la lista es vacia devuelve true

        for(WebElement element: listaHxs){
            String listaHxsText = element.getText();
            System.out.println(">>>" + listaHxsText);
        }
        /*Validar el estado de las listas a través de Asserts */


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        driver.close();

    }

}
