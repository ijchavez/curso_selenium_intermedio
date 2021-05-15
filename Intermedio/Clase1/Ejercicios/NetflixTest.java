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

public class NetflixTest {
    public static final String NETFLIX_URL = "https://www.netflix.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setNetflixUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(NETFLIX_URL);
        driver.manage().window().maximize();

    }
    @Test
    public void findH3InFormTest(){
        List<WebElement> listaForm = driver.findElements(By.tagName("form"));
        System.out.println("Cantidad de Form: " + listaForm.size());

        for (WebElement unaListaDeForm : listaForm){
            List<WebElement> listaDeH3 = unaListaDeForm.findElements(By.tagName("h3"));
            System.out.println("Cantidad de H3 dentro de un form: " + listaDeH3.size());
            //Hago otro for para ver la lista de H3 que existen, este es el que tengo que hacer como siempre, lo que cambia
            //Es que tengo que hacer un for antes para acotar los h3 al form creando una lista de webelement igualandola a la
            //lista que cree antes de forms y haciendo el findelements del elemento deseado, en este caso un h3
            for (WebElement unaListaDeH3 : listaDeH3){
                String listaDeH3Text = unaListaDeH3.getText();
                System.out.println("H3: " + listaDeH3Text);

            }
        }

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        driver.close();

    }

}
