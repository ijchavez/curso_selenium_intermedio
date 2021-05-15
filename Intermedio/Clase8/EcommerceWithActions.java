package Intermedio.Clase8;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EcommerceWithActions {

    public WebDriver driver;
    public static final String ECOMMERCESITE_URL = "http://www.automationpractice.com/index.php";

    @BeforeMethod
    public void setEcommerceSiteUrl() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ECOMMERCESITE_URL);
        driver.manage().window().maximize();
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);
    }
    @Test
    public void registrationTest(){
       WebElement loginBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=my-account']"));

       Actions actions = new Actions(driver);

       actions.moveToElement(loginBtn).click().perform();

       String email = "gerardo" + Math.random() + "@gmail.com";
       WebElement emailInputField = driver.findElement(By.id("email_create"));

       Action fillEmailInputField = actions.moveToElement(emailInputField)
               .click()
               .sendKeys(email)
               .build();

        fillEmailInputField.perform();
        /***
         * Es un boton no creo un elemento Action
         ***/
        WebElement submitBtn = driver.findElement(By.id("SubmitCreate"));
        actions.moveToElement(submitBtn).click().build().perform();

        WebElement firstNameElement = driver.findElement(By.id("customer_firstname"));
        WebElement lastNameElement = driver.findElement(By.id("customer_lastname"));
        WebElement passElement = driver.findElement(By.id("passwd"));
        /***
         * Es un campo, tengo que crear la clase Actions y un elemento Action = a actions.XXXXX
         ***/
        Action firstNameAction = actions.moveToElement(firstNameElement)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("Juan")
                .keyUp(Keys.SHIFT)
                .build();

        Action lastNameAction = actions.moveToElement(lastNameElement)
                .click()
                .sendKeys("Perez")
                .build();

        Action passwordAction = actions.moveToElement(passElement)
                .click()
                .sendKeys("pass1234")
                .build();

        firstNameAction.perform();
        lastNameAction.perform();
        passwordAction.perform();
    }

}
