package Intermedio.Clase5_PageObject.ecommerceSite.Tests;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;

    public BaseTest(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public BaseTest(){

    }
    @BeforeMethod
    public void setEcommerceSiteUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Constants.ECOMMERCESITE_URL);
        driver.manage().window().maximize();
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

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
