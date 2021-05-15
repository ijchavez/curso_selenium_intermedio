package Intermedio.Clase4_findBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindBysEjemplos {
    public static final String NETFLIX_URL = "https://www.netflix.com/";
    public WebDriver driver;

    @FindBy (tagName = "p")
    public List<WebElement> listaParrafos;

    @FindBy (tagName = "a")
    public List<WebElement> listaLinks;

    @FindBy (tagName = "button")
    public List<WebElement> listaBtn;

    @BeforeMethod
    public void setNetflixUrl() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(NETFLIX_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);

    }
    @Test
    public void ejercicio1(){
        //List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        System.out.println("la cantidad de parrafos es: " + listaParrafos.size());

        //List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("la cantidad de links es: " + listaLinks.size());
        for (WebElement links: listaLinks){
            String linkstText = links.getText();

            if (linkstText.isEmpty() == false){
                System.out.println(">>>" + linkstText);

            }

        }

        //List<WebElement> listaBtn = driver.findElements(By.tagName("button"));
        System.out.println("la cantidad de links es: " + listaBtn.size());
        for (WebElement btn: listaBtn){
            String btnText = btn.getText();

            if (btnText.isEmpty() == false){
                System.out.println(">>>" + btnText);

            }

        }

    }


}
