package Intermedio.Clase12;

import Intermedio.Clase9.EjercicioSalesForce.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestsConStrings {
    public static String DATA = "112111,Emiliano,Montevideo,Uruguay,testing@test.com;12341234,Ana,Buenos Aires,Argentina,ana@ana.com";
    public static List<Persona> LISTA_PERSONAS = new ArrayList<>();

    @BeforeTest
    public void loadData(){
        String [] arregloPersona = DATA.split(";");
        System.out.println(arregloPersona[0]);
        System.out.println(arregloPersona[1]);

        for (int i = 0; i < arregloPersona.length; i++){
            String [] datosPersonales = arregloPersona[i].split(",");

            String dni = datosPersonales[0];
            String nombre = datosPersonales[1];
            String pais = datosPersonales[3];
            String email = datosPersonales[4];

            Persona pers = new Persona(pais, nombre,Integer.parseInt(dni), email);
            LISTA_PERSONAS.add(pers);

        }

    }
    public WebDriver driver;
    public static String URL = "https://www.spotify.com";
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
    //varias personas al mismo test
    private int i = 0;

    @Test(invocationCount = 2)
    public void registrationTest(){
        System.out.println("****PERSONAS****");
        System.out.println(LISTA_PERSONAS.get(0));
        System.out.println(LISTA_PERSONAS.get(1));

        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        Persona p = LISTA_PERSONAS.get(i);


        driver.findElement(By.id("email")).sendKeys(p.getEmail());
        driver.findElement(By.id("confirm")).sendKeys(p.getEmail());
        driver.findElement(By.id("displayname")).sendKeys(p.getNombre());

        Assert.assertNotEquals(LISTA_PERSONAS.size(), 0,"Deberian existir personas en la lista");
        i++;

    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();

    }

}
