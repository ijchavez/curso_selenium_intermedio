package Intermedio.Clase1.Ejercicios;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookinTest {
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
    public void validateTextTest(){
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        boolean h2TextFound = false;

        for(WebElement h2s : h2List){
            String h2sText = h2s.getText();
            if(h2sText.equals("Conecta con Gente Viajera")){
                h2TextFound = true; // --> El programa ya me dice que no esta usada y que la tengo que usar, ahi es el indicador de usar assertTrue
            }
        }
        Assert.assertTrue(h2TextFound);

    }
    public WebElement getBtnByText(String btnText){
        List<WebElement> listaDeBotones = driver.findElements(By.className("bui-button__text"));
        Assert.assertNotEquals(listaDeBotones.size(),0);

        for (WebElement btn : listaDeBotones){
            String inBtnText = btn.getText();
            if (inBtnText.equals(btnText)){
                return btn;

            }

        }
        Assert.assertFalse("No se encontro el elemento",true);
        return null;

    }
    @Test
    public void clickOrFailText(){
        WebElement loginBtn = getBtnByText("Iniciar sesión");
        try{
            loginBtn.click();
        }catch (Exception  e){
            Assert.assertFalse("El botón no se ha encontrado en el sitio", true);

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
