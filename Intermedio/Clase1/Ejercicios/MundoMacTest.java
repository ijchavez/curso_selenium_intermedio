package Intermedio.Clase1.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MundoMacTest {
    public static final String MUNDOMAC_URL = "https://www.mundomac.com/";
    public WebDriver driver;

    @BeforeMethod
    public void setMundoMacUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(MUNDOMAC_URL);
        driver.manage().window().maximize();
    }
    @Test
    public void undefinedAltTest(){
        List<WebElement> listaDeImagenes = driver.findElements(By.tagName("img"));
        System.out.println("Cantidad de Imagenes " + listaDeImagenes.size());
        Assert.assertNotEquals(listaDeImagenes.size(), 0); // >>> Es distinto que la lista de imagenes, en su propiedad size (su cantidad) es igual a 0
        Assert.assertFalse(listaDeImagenes.isEmpty()); // >>> Es falso que la lista de imagenes esta vacia

        int cont = 0;
        for (WebElement unaListaDeImagenes : listaDeImagenes){
            if (unaListaDeImagenes.getAttribute("alt").isEmpty() == false){
                System.out.println(">>> " + unaListaDeImagenes.getAttribute("alt"));
                //.isEmpty retorna true, pero si igualo el getAtribute("id") a false lo que estoy diciendo es:
                //Estas preguntando si el atributo id tiene valor..
                //isEmpty == false si el String no esta vacio, es decir si tiene texto
                //isEmpty == true si un String esta vacio, es decir, no tiene texto
            }else {
                cont++;
            }
        }
        System.out.println("La cantidad de imagenes sin alt es: " + cont);
        // En este ejercicio tengo que mostrar las que la tienen y contar las que no y mostrar esa cantidad
    }

    @Test
    public void buttonsUseClassTest(){
        List<WebElement> listaDeBotones = driver.findElements(By.tagName("button"));
        Assert.assertFalse(listaDeBotones.isEmpty(), "La lista esta vacia");
        Assert.assertNotEquals(listaDeBotones.size(), 0);

        for (WebElement listaBotones : listaDeBotones){
            Assert.assertTrue(listaBotones.getAttribute("class").contains("btn btn-default"), "no hay elementos con la clase btn btn-default");
            //aca digo que tenga el atributo clase y que contenga la clase btn btn-default
        }
    }

    @Test
    public void elementsWithOutHrefTest(){
        List<WebElement> listaDeUl = driver.findElements(By.tagName("ul"));
        int cont = 0;

        for(WebElement unaListaDeUl : listaDeUl){
            List<WebElement> listaDeLi = unaListaDeUl.findElements(By.tagName("li"));

            for (WebElement unaListaDeLi : listaDeLi){
                try{
                    WebElement link = unaListaDeLi.findElement(By.tagName("a"));
                    System.out.println(">>> " + link.getAttribute("href"));
                }catch (Exception e){
                    System.out.println("elemento sin tagname a");
                    cont++;
                }
            }

            /*
            for (WebElement unaListaDeLi : listaDeLi){

                WebElement link = unaListaDeLi.findElement(By.tagName("a"));
                if (link.getAttribute("href") != null){
                    System.out.println(">>> " + link.getAttribute("href"));

                }else{
                    System.out.println("elemento sin href");
                    cont++;

                }

            }
            */

        }
        System.out.println("se encontraron " + cont + " elementos sin href");

    }

    @Test //comentar el windows maximize en el before method
    public void imgWithAndWithOutAltTest(){
        List<WebElement> listaDeImagenes = driver.findElements(By.tagName("img"));
        List<WebElement> listaDeImagenesConAlt = new ArrayList();
        List<WebElement> listaDeImagenesSinAlt = new ArrayList();

        List<String> listaDeImagenesConAltText = new ArrayList<>();
        List<String> listaDeImagenesSinAltText = new ArrayList<>();

        for(WebElement unaListaDeImagenes : listaDeImagenes){
            if(unaListaDeImagenes.getAttribute("alt").isEmpty() == true){
                //Estas preguntando si el atributo alt no tiene valor..
                //isEmpty == false si el String no esta vacio, es decir si tiene texto
                //isEmpty == true si un String esta vacio, es decir, no tiene texto
                System.out.println(unaListaDeImagenes.getAttribute("src"));
                listaDeImagenesSinAlt.add(unaListaDeImagenes);
                listaDeImagenesSinAltText.add(unaListaDeImagenes.getText());

            }else{
                listaDeImagenesConAlt.add(unaListaDeImagenes);
                listaDeImagenesConAltText.add(unaListaDeImagenes.getText());

            }
        }
        System.out.println("***********Lista de imagenes con Alt***********");
        System.out.println(listaDeImagenesConAltText);


        System.out.println("***********Lista de imagenes sin Alt***********");
        System.out.println(listaDeImagenesSinAltText);
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
