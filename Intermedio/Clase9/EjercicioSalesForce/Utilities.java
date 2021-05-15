package Intermedio.Clase9.EjercicioSalesForce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Set;

public class Utilities {
    WebDriver driver;

    public Utilities(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    public String getWindowHandle(){
        String mainWindow = driver.getWindowHandle();
        return mainWindow;

    }
    public Set<String> getWindowHandles(){
        Set<String> allWindows = driver.getWindowHandles();
        return allWindows;

    }
    public HashMap<String, String> cargaValoresEnMapa(HashMap<String, String> aHashMap, String unaMainWindow){

        System.out.println(">>>" + unaMainWindow);

        //es como una lista el Set pero no acepta duplicados o numero repetidos
        Set<String> allWindows = getWindowHandles();
        System.out.println("***** Set de ventanas **********");
        for (String aWindow : allWindows){
            System.out.println(">>> " + aWindow);
            // como dejar solamente la ventana principal
            //si la ventana principal no es igual a la que estoy recorriendo entonces me muevo hacia esa ventana
            if(!unaMainWindow.equals(aWindow)){
                aHashMap.put(Constants.REGISTRO_TAB, aWindow);

            }

        }
        return aHashMap;

    }
    public void changesTabs (HashMap<String, String> aHashMap, String unaMainWindow) throws InterruptedException {
        driver.switchTo().window(aHashMap.get(unaMainWindow));
        Thread.sleep(3000);

    }

}
