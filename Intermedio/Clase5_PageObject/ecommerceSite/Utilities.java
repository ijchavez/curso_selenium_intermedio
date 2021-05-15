package Intermedio.Clase5_PageObject.ecommerceSite;

import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.*;
import Intermedio.Clase5_PageObject.ecommerceSite.Tests.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Utilities extends BaseTest {

    WebDriver driver;

    public Utilities(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }

    public String getTitle(){
        String titulo = driver.getTitle();
        return titulo;

    }
    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        return url;

    }


    public MyAccountPage registrationToSite(String myEmail, String fakerFirstName, String fakerlastName) throws InterruptedException {


        String titulo = getTitle();
        System.out.println(">>> " + titulo);

        LandingPage landingPage = new LandingPage(driver);
        AuthenticationPage authenticationPage = landingPage.clickOnLoginBtn();

        Thread.sleep(3000);
        String nuevoTitulo = getTitle();
        System.out.println(">>> " + nuevoTitulo);

        //hay un assert aca porque estaba de antes para practicar y si lo pongo en el test me falla
        Assert.assertTrue(nuevoTitulo.contains("Login"));

        authenticationPage.validateAuthPage();
        NewAccountPage newAccountPage = authenticationPage.createEmailOfTheAccount(myEmail);

        newAccountPage.getRegistrationEmail();
        System.out.println("Mail cargado: " + myEmail);

        //este sleep es para que espere y visualice que sean iguales los mails
        Thread.sleep(10000);

        System.out.println("Mail en la pag: " + newAccountPage.getRegistrationEmail());
        Assert.assertEquals(myEmail,newAccountPage.getRegistrationEmail());

        return newAccountPage.fillingPersonalInfoForm(fakerFirstName,fakerlastName);


    }
    public void comboDiaMesAño(String unDia, String unMes, String unAño) {
        NewAccountPage newAccountPage = new NewAccountPage(driver);

        Select comboDias = new Select(newAccountPage.elementoDias);
        comboDias.selectByValue(unDia);

        Select comboMeses = new Select(newAccountPage.elementoMeses);
        comboMeses.selectByValue(unMes);

        Select comboYears = new Select(newAccountPage.elementoYears);
        comboYears.selectByValue(unAño);

    }
    public void actionToDoDoubleClick(WebElement anElement){
        Actions actionToDoubleClick = new Actions(driver);
        actionToDoubleClick.doubleClick(anElement)
                .click()
                .perform();


    }
}
/**************** asi esta la clase con los driver.findelements comentados, quedan excluidos de la version nueva ************************

 */

