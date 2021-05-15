package Intermedio.Clase9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class windowHandler {
    public WebDriver driver;
    public static String URL = "http://automationpractice.com/index.php";


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
    /** IMPORTANTE
     * isEmpty == false si el String no esta vacio, es decir si tiene texto
     * isEmpty == true si un String no tiene texto, es decir, esta vacio
     *
     */
    @Test
    public void testGeneric(){
        //List<WebElement> elementosConId = getElementsWithIds("h1");
        //getElementText(elementosConId);

        /***
         * si no hago try/catch me tira el error:
         * java.lang.NullPointerException: Cannot invoke "String.isEmpty()"
         * because the return value of "org.openqa.selenium.WebElement.getAttribute(String)" is null
         * esto se debe a que no hay H1 con name como elemento
         *
         */
        List<WebElement> elementosConName = getElementsWithNames("h1");
        getElementText(elementosConName);

        List<WebElement> elementosConLinksValidos = getValidLinks();
        getNumberOfElements(elementosConLinksValidos);
        getElementText(elementosConLinksValidos);

        List<WebElement> elementosConLinksRotos = getBrokenLinks();
        getNumberOfElements(elementosConLinksRotos);
        getElementText(elementosConLinksRotos);

        List<WebElement> elementosBotonConTexto = getButtonsWithText();
        getNumberOfElements(elementosBotonConTexto);
        getElementText(elementosBotonConTexto);

        List<WebElement> elementosBotonDesplegados = getDisplayedBtn();
        getNumberOfElements(elementosBotonDesplegados);
        getElementText(elementosBotonDesplegados);
    }
    public void getElementText(List<WebElement> unaListaDeElementos){
            for(WebElement elId : unaListaDeElementos){
                String elIdText = elId.getText();
                System.out.println(">>> " + elIdText);

            }
    }
    public void getNumberOfElements(List<WebElement> unaListaDeElementos){
        System.out.println("Cantidad de elementos: " + unaListaDeElementos.size());

    }
    public List<WebElement> getElementsWithIds(String unTagName){
        List<WebElement> elements = driver.findElements(By.tagName(unTagName));
        List<WebElement> elementsWithIds = new ArrayList<WebElement>();

        for(WebElement el : elements){
            if(el.getAttribute("id").isEmpty()){
                elementsWithIds.add(el);

            }
        }

        return elementsWithIds;
    }
    public List<WebElement> getElementsWithNames(String unTagName){
        List<WebElement> elements = driver.findElements(By.tagName(unTagName));
        List<WebElement> elementsWithName = new ArrayList<WebElement>();

        try {
            for(WebElement el : elements){
                if(el.getAttribute("name").isEmpty() == false){
                    elementsWithName.add(el);

                }
            }

        }catch (Exception e){
            System.out.println("No existen elementos con el atributo name");
        }

        return elementsWithName;
    }
    public List<WebElement> getValidLinks(){
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        List<WebElement> elementsWithValidLinks = new ArrayList<WebElement>();
        try {
            for(WebElement el : elements){
                if(el.getAttribute("href").isEmpty() == false){
                    elementsWithValidLinks.add(el);

                }
            }

        }catch (Exception e){
            System.out.println("No existen elementos con el atributo name para el tagname especificado");
        }

        return elementsWithValidLinks;
    }
    public List<WebElement> getBrokenLinks(){
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        List<WebElement> elementsWithBrokenLinks = new ArrayList<WebElement>();
        try {
            for(WebElement el : elements){
                if(el.getAttribute("href").isEmpty() == true){
                    elementsWithBrokenLinks.add(el);

                }
            }

        }catch (Exception e){
            System.out.println("No existen elementos con el atributo name para el tagname especificado");
        }

        return elementsWithBrokenLinks;

    }
    public List<WebElement> getButtonsWithText(){
        List<WebElement> allButtons = driver.findElements(By.tagName("button"));
        List<WebElement> buttonsWithText = new ArrayList<WebElement>();
        for (WebElement btnEl : allButtons){
            String btnElText = btnEl.getText();
            if(btnElText.isEmpty() == false){
                buttonsWithText.add(btnEl);

            }

        }
        return buttonsWithText;

    }
    public List<WebElement> getDisplayedBtn(){
        List<WebElement> allButtons = driver.findElements(By.tagName("button"));
        List<WebElement> buttonsWithText = new ArrayList<WebElement>();
        for (WebElement btnEl : allButtons){
            if(btnEl.isDisplayed() == false){
                buttonsWithText.add(btnEl);

            }

        }
        return buttonsWithText;

    }
    public WebElement getElementByText(String unTexto){
        WebElement unWebElement = driver.findElement(By.xpath("//*[contains(text(),'" + unTexto + "'])"));
        return unWebElement;

    }
    public WebElement getElementByName(String unName){
        WebElement unWebElement = driver.findElement(By.name(unName));
        return unWebElement;

    }
    public WebElement getElementById(String unId){
        WebElement unWebElement = driver.findElement(By.id(unId));
        return unWebElement;

    }
    public List<WebElement> getElementByTagName(String unTagname){
        List<WebElement> unaListaDeWebElements = driver.findElements(By.tagName(unTagname));
        return unaListaDeWebElements;

    }
    public WebElement getElementByXpath(String unAtr, String unValue){
        WebElement unWebElement = driver.findElement(By.xpath("//*[@" + unAtr + "='" + unValue + "']"));
        return unWebElement;

    }
    public WebElement getElementByXpath(String unTagName, String unAtr, String unValue){
        WebElement unWebElement = driver.findElement(By.xpath("//" + unTagName + "[@" + unAtr + "='" + unValue + "']"));
        return unWebElement;

    }
    /***EJERCICIOS***/
    public void validateInvalidLinks(){
        int invalidLinksCount = 0;
        List<WebElement> linksTagList = driver.findElements(By.tagName("a"));
        getNumberOfElements(linksTagList);
        for (WebElement aTagList : linksTagList){
            if(aTagList != null){
                String url = aTagList.getAttribute("href");
                if(url != null && (url.contains("javascript") == false)){
                    //verifyURLStatus(url);

                }else{
                    invalidLinksCount++;

                }

            }

        }
        System.out.println("Total de links invalidos " + invalidLinksCount);
    }
    //falta lo del httpclient


    public void mostrarEstadoBotones(){
        int invalidEmptyButton = 0;
        int emptyNameAttribute = 0;
        int emptyIdAttribute = 0;
        List<WebElement> buttonTagsList = driver.findElements(By
                .tagName("button"));
        for(WebElement element : buttonTagsList){
            if (element.getText().isEmpty() == true){
                invalidEmptyButton++;
            }
            System.out.println(element.getAttribute("id"));
            if (element.getAttribute("id").isEmpty()){
                emptyIdAttribute++;
            }
            if (element.getAttribute("name").isEmpty()){
                emptyNameAttribute++;
            }
        }
        System.out.println("Cantidad de botones vacios " + invalidEmptyButton);
        System.out.println("Cantidad de botones sin id " + emptyIdAttribute);
        System.out.println("Cantidad de botones sin attr name " + emptyNameAttribute);
    }
    public String getAttribute_ButtonName(WebElement element) {
        return element.getAttribute("name");

    }
    public String getAttribute_Id(WebElement element) {
        return element.getAttribute("id");

    }
    public String getAttribute_class(WebElement element) {
        return element.getAttribute("class");

    }
    public String getAttribute_ButtonLabel(WebElement element) {
        return element.getAttribute("aria-label");

    }

}
