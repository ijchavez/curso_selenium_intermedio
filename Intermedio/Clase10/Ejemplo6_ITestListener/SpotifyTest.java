package Intermedio.Clase10.Ejemplo6_ITestListener;

import Intermedio.Clase9.EjercicioSalesForce.Constants;
import junit.framework.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
//con esta linea apuntando al listener si tiene un error te saca una foto
@Listeners(Intermedio.Clase10.Ejemplo6_ITestListener.TestListeners.class)
public class SpotifyTest {
    WebDriver driver;
    String url = "https://www.spotify.com";
    @BeforeMethod
    public void setChromeDriver(ITestContext context){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);
        context.setAttribute("Webdriver", driver);
    }

    @Test//implicito: (successPercentage = 100, invocationCount = 1)
    public void getTitleTest() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Escuchar es todo - Spotify");

        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        List<WebElement> errorList = driver.findElements(By.tagName("span"));
        Assert.assertNotEquals(errorList.size(), 0);
        for(WebElement el : errorList){
            String errorListText = el.getText();
            //System.out.println(">>> " + errorListText);
            if(errorListText.equals("Es necesario que introduzcas tu correo electrónico.")){
                Assert.assertTrue(false);

            }
            Assert.assertNotEquals(errorListText, "Es necesario que introduzcas tu correo electrónico.");

        }
        //para que falle descomentar
        //Assert.assertTrue(false);

    }
    private int i = 0;
    /***********
     *     sucessPercentaje = 0 >> fallan todos el resultado es exitoso
     *     sucessPercentaje = 20 >> 20%, deben pasar 1 de las 5 ejecuciones
     *     sucessPercentaje = 40 >> 40%, deben pasar  2 de las 5 ejecuciones
     *     sucessPercentaje = 60 >> 60%, deben pasar  3 de las 5 ejecuciones
     *     sucessPercentaje = 80 >> 80%, deben pasar  4 de las 5 ejecuciones
     *     sucessPercentaje = 100 >> no se toleran fallas, deben pasar los 5 test
     ***********/
    @Test(successPercentage = 40, invocationCount = 5)
    public void percentageTestSuccessRate(){
        i++;
        System.out.println("i vale: " + i);
        if(i == 1 || i == 2){
            Assert.assertTrue(false);

        }

    }

}
