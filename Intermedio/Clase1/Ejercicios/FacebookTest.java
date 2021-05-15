package Intermedio.Clase1.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacebookTest {
    public static final String FACEBOOK_URL = "https://www.facebook.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setFacebookUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(FACEBOOK_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void findH112Test(){
        List<WebElement> listaH112 = driver.findElements(By.id("H112"));

        Assert.assertEquals(listaH112.size(), 0);
        Assert.assertTrue(listaH112.isEmpty());
        Assert.assertFalse(listaH112.isEmpty() == false);

    }
    @Test
    public void findH1NonExistent(){
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        Assert.assertNotEquals(h1List.size(),0); //--> pide que valide que la lista no sea vacia la lista no tiene q ser igual a 0
        Assert.assertFalse(h1List.isEmpty());
        Assert.assertTrue(h1List.isEmpty());

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        driver.close();

    }
}
