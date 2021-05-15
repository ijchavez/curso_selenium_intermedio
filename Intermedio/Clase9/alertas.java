package Intermedio.Clase9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class alertas {

    public WebDriver driver;
    public static String URL = "http://www.seleniumacademy.net/alertas";

    @BeforeMethod
    public void setChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @Test
    public void simpleAlertTest(){
        driver.findElement(By.id("alert1")).click();
        // para salir de la alerta hago lo siguiente
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        // acepto la alerta
        alert.accept();
    }
    @Test
    public void confirmationAlertTest(){
        driver.findElement(By.id("alert2")).click();
        // para salir de la alerta hago lo siguiente
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        // acepto la alerta
        alert.accept();
        // candelo la alerta
        // alert.dismiss();
        WebElement msgElement = driver.findElement(By.id("demo"));
        String msgElementText = msgElement.getText();
        System.out.println(msgElementText);

        Assert.assertEquals(msgElementText,"Alert accepted!");
    }
}
