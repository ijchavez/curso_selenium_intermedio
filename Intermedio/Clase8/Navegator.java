package Intermedio.Clase8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Navegator {
    public WebDriver driver;
    public static String URL = "https://www.netflix.com/ar/";
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
    public void navigateToElementTest(){
        WebElement ayudaLink = driver.findElement(By.xpath("//*[@href='https://help.netflix.com']"));
        navigateToAnAlement(ayudaLink);
    }
    public void navigateToAnAlement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);

    }
}
