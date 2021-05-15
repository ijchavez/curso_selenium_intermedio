package Intermedio.Clase8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class EjemploActions {

    public WebDriver driver;
    public static String URL = "https://www.google.com";
    public static String DRAG_AND_DROP_URL = "http://crossbrowsertesting.github.io/drag-and-drop.html";
    public static String DOUBLE_CLICK_URL = "http://api.jquery.com/dblclick/";


    @BeforeMethod
    public void setChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @Test
    public void moveToElementTest(){
        driver.get(URL);
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gmailLink).
                build().
                perform();

    }
    @Test
    public void contextClickElementTest(){
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        Actions actions = new Actions(driver);
        actions.contextClick(gmailLink).
                build().
                perform();

    }
    @Test
    public void dragAndDropTest(){
        driver = new ChromeDriver();
        driver.get(DRAG_AND_DROP_URL);

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement dropAreaElement = driver.findElement(By.id("droppable"));

        Actions ddAction = new Actions(driver);
        ddAction.dragAndDrop(sourceElement,dropAreaElement).perform();

    }
    @Test
    public void doubleClickTest(){
        driver = new ChromeDriver();
        driver.get(DOUBLE_CLICK_URL);
        driver.switchTo().frame(0);

        WebElement elementoClickeable = driver.findElement(By.cssSelector("html>body>div"));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementoClickeable)
                .click()
                .perform();

    }
}
