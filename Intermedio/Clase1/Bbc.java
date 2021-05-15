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

public class Bbc {
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
    public void bbc(){
        //WebElement divElement = driver.findElement(By.tagName("div"));

        List<WebElement> divElements = driver.findElements(By.tagName("div"));

        for (WebElement div : divElements){

            List<WebElement> parrafos = div.findElements(By.tagName("p"));
            List<WebElement> imgs = div.findElements(By.tagName("img"));

            System.out.println("Imgs >>> " + imgs.size());

            if (parrafos.size() > 0){
                System.out.println("se encontraron " + parrafos + " parrafos");
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
