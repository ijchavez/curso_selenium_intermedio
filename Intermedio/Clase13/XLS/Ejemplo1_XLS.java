package Intermedio.Clase13.XLS;
import Intermedio.Clase13.Persona;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo1_XLS {
    public static List<Persona> LISTA_PERSONAS = new ArrayList<>();

    public WebDriver driver;

    @BeforeTest
    public void loadData() throws IOException {
        XSSFWorkbook samplexlsx = new XSSFWorkbook("dataloader/sample.xlsx");
        XSSFSheet sheet1 = samplexlsx.getSheet("Sheet1");
        List<String> listaDatos = new ArrayList<>();
        for (int fila = 0; fila < 9; fila++){
            String dato = "";

            for (int columna = 0; columna < 8; columna++){
                try {
                    dato += sheet1.getRow(fila).getCell(columna).getNumericCellValue() + ";";
                } catch (IllegalStateException ex) {
                    dato += sheet1.getRow(fila).getCell(columna).getStringCellValue() + ";";
                }
            }

            listaDatos.add(dato);

            System.out.println();
        }

        listaDatos.remove(0);
        for (String data : listaDatos){
            //System.out.println("*****  " + data);

            String [] datosPersonales = data.split(";");
            String firstName =  datosPersonales[1];
            String lastName = datosPersonales[2];
            String country = datosPersonales[4];
            String id = datosPersonales[7];

            String fullName = firstName.concat(" ").concat(lastName);

            Persona p = new Persona(fullName, country, 1, fullName+"@gmail.com");
            System.out.println(p);

            LISTA_PERSONAS.add(p);
        }
    }

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
    }

    private int i = 0;
    @Test(invocationCount = 2)
    public void registrationTest(){

        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/uy/signup/']")).click();

        Persona p = LISTA_PERSONAS.get(i);

        driver.findElement(By.id("email")).sendKeys(p.getEmail());
        driver.findElement(By.id("confirm")).sendKeys(p.getEmail());
        driver.findElement(By.id("displayname")).sendKeys(p.getNombre());
        Assert.assertNotEquals(LISTA_PERSONAS.size(), 0, "Deberian de haber personas en la lista!!");
        i++;
    }


}