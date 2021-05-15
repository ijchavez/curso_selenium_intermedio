package Intermedio.Clase4_findBy;

import org.apache.tools.ant.taskdefs.optional.extension.LibFileSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NetflixTest {
    public static final String NETFLIX_URL = "https://www.netflix.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setNetflixUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(NETFLIX_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this); //@FindBy: Sin esto no ando

    }

    @FindBy(tagName = "p")
    public List<WebElement> listaParrafos;
    @FindBy(tagName = "a")
    public List<WebElement> listaLinks;
    @FindBy(tagName = "button")
    public List<WebElement> listaButton;

    /****** FindBy para Hs quedan obsoletos con el @FindAll******/
    @FindBy(tagName = "h1")
    public List<WebElement> listaDeH1;
    @FindBy(tagName = "h2")
    public List<WebElement> listaDeH2;
    @FindBy(tagName = "h3")
    public List<WebElement> listaDeH3;

    /******@FindAll******/
    @FindAll({
            @FindBy(tagName = "h1"),
            @FindBy(tagName = "h2"),
            @FindBy(tagName = "h3")
    })
    public List<WebElement> allHs;

    @Test
    public void findElementsNetflixTest(){
        //List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        System.out.println("Cantidad de parrafors: " + listaParrafos.size());

        //List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("Cantidad de parrafors: " + listaLinks.size());

        for (WebElement unaListaDeLinks : listaLinks){
            String unaListaDeLinksText = unaListaDeLinks.getText();
            if (unaListaDeLinksText.isEmpty() == false){
                System.out.println(">>> " + unaListaDeLinksText);

            }

        }
        //List<WebElement> listaButton = driver.findElements(By.tagName("button"));

        for (WebElement unaListaDeButton : listaButton){
            String unaListaDeButtonText = unaListaDeButton.getText();
            if (unaListaDeButtonText.isEmpty() == false){
                System.out.println(">>> " + unaListaDeButtonText);

            }

        }
        /*Saque el ejercicio sin el @FindAll asi comento el metodo solamente */
        //findHs();
        for (WebElement todosLosH : allHs){
            String todosLosHText = todosLosH.getText();
            System.out.println("-->" + todosLosHText);

        }

    }
    public void findHs(){
        //List<WebElement> listaDeH1 = driver.findElements(By.tagName("h1"));
        //List<WebElement> listaDeH2 = driver.findElements(By.tagName("h2"));
        //List<WebElement> listaDeH3 = driver.findElements(By.tagName("h3"));
        List<String> unaListaDeH1H2H3 = new ArrayList<>();

        for(WebElement h1s : listaDeH1){
            String h1sText = h1s.getText();
            unaListaDeH1H2H3.add(h1sText);

        }
        for(WebElement h2s : listaDeH2){
            String h2sText = h2s.getText();
            unaListaDeH1H2H3.add(h2sText);

        }
        for(WebElement h3s : listaDeH3){
            String h3sText = h3s.getText();
            unaListaDeH1H2H3.add(h3sText);

        }
        for (String lista : unaListaDeH1H2H3){
            System.out.println("--> " + lista);
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
