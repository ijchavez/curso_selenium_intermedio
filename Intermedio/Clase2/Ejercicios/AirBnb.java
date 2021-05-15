package Intermedio.Clase2.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AirBnb {
    public static final String AIRBNB_URL = "https://www.airbnb.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setAirbnbUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(AIRBNB_URL);
        driver.manage().window().maximize();

    }
    @Test
    public void airBnbTest(){
        driver.findElement(By.xpath("//*[@placeholder='¿A dónde vas?']")).sendKeys("Budapest");
        // con el /div/div[2] entro a los subdivs dentro del div @data-testid
        WebElement calendarioElement = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']/div/div[2]"));
        calendarioElement.click();

        WebElement fechaInicioElement = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-02-23']"));
        fechaInicioElement.click();

        WebElement fechaFinElement = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-03-16']"));
        fechaFinElement.click();

        WebElement huespedesElement = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']/div/div[2]"));
        huespedesElement.click();

        WebElement adultosElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[1]"));
        adultosElement.click();
        adultosElement.click();

        WebElement niniosElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[2]"));
        niniosElement.click();

        WebElement bebesElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[3]"));
        bebesElement.click();

        WebElement btnBuscar = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']"));
        btnBuscar.click();
        //explicit wait..
        WebDriverWait wait = new WebDriverWait(driver, 4);

        List<WebElement> tresHuespedesList = driver.findElements(By.xpath("//*[contains(text(),'3 huéspedes')]"));

        Assert.assertNotEquals(0,tresHuespedesList.size());
        Assert.assertNotNull(tresHuespedesList);

        boolean tresHuespedes = false;

        for (WebElement unaListaTresHuespedes : tresHuespedesList){
            String tresHuespedesListText = unaListaTresHuespedes.getText();
            if(unaListaTresHuespedes.getText().contains("Más de 300 alojamientos")){
                tresHuespedes = true;
                System.out.println(">>> " + tresHuespedesListText);
            }
        }
        Assert.assertTrue(tresHuespedes);

        String url = driver.getCurrentUrl();
        System.out.println(">>> url: " + url);
        Assert.assertTrue(url.contains("Budapest"));

        System.out.println("**********");

        String titulo = driver.getTitle();
        System.out.println(">>> Titulo: " + titulo);
        Assert.assertTrue(titulo.contains("Budapest"));


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("--------------------");
        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        //driver.close();

    }
}
