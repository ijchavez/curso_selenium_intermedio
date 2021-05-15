package Intermedio.Clase9.EjercicioSalesForce;

import Intermedio.Clase9.PageObject.LandingPage;
import Intermedio.Clase9.PageObject.RegistrationPage;
import org.testng.annotations.Test;
import java.util.HashMap;


public class SalesforceTest extends BaseTest{

    @Test
    public void salesforceTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        Utilities utilities = new Utilities(driver);

        Thread.sleep(1000);
        landingPage.clickOnCookieAcceptBtn();

        HashMap<String, String> mapaDeTabs = new HashMap<>();
        String mainWindow = utilities.getWindowHandle();
        mapaDeTabs.put(Constants.MAIN_TAB,mainWindow);

        Thread.sleep(1000);
        RegistrationPage registrationPage = landingPage.clickOnFreeTrialBtn();
        mapaDeTabs = utilities.cargaValoresEnMapa(mapaDeTabs, mainWindow);

        System.out.println("hola soy un mapa de tabs " + mapaDeTabs);
        utilities.changesTabs(mapaDeTabs,Constants.REGISTRO_TAB);

        utilities.changesTabs(mapaDeTabs,Constants.MAIN_TAB);
        utilities.changesTabs(mapaDeTabs,Constants.REGISTRO_TAB);


    }


}
