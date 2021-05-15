package Intermedio.Clase2.Ejercicios;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EcommerceSite {
    public static final String ECOMMERCESITE_URL = "http://www.automationpractice.com/index.php";
    public WebDriver driver;

    @BeforeMethod
    public void setEcommerceSiteUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ECOMMERCESITE_URL);
        driver.manage().window().maximize();

    }
    @Test
    public void registrationTest(){
        String titulo = driver.getTitle();
        System.out.println(">>> " + titulo);
        driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=my-account']")).click();

        WebElement authenticationSection = driver.findElement(By.tagName("h1"));
        String authenticationSectiontext = authenticationSection.getText();
        Assert.assertEquals(authenticationSectiontext,"AUTHENTICATION");

        String nuevoTitulo = driver.getTitle();
        System.out.println(">>> " + nuevoTitulo);
        Assert.assertTrue(nuevoTitulo.contains("Login"));

        String myEmail = "gerardo" + Math.random() + "test@gmail.com";
        driver.findElement(By.id("email_create")).sendKeys(myEmail);
        driver.findElement(By.name("SubmitCreate")).click();

        driver.findElement(By.id("uniform-id_gender1")).click();

        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Gerardo");

        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Chavez");

        WebElement emailElement = driver.findElement(By.id("email"));
        String emailElementAttribute = emailElement.getAttribute("value");

        System.out.println("Mail cargado: " + myEmail);
        System.out.println("Mail en la pag: " + emailElementAttribute);

        Assert.assertEquals(myEmail,emailElementAttribute);

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
