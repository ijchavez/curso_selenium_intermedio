package Intermedio.Clase5_PageObject.ecommerceSite.Tests;

import Intermedio.Clase5_PageObject.ecommerceSite.FakeDataGenerator;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.MyAccountPage;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.MyPersonalInformationPage;
import Intermedio.Clase5_PageObject.ecommerceSite.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @Test
    public void registrationTest() throws InterruptedException {

        Utilities utilities = new Utilities(driver);
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator(driver);

        String fakerName = fakeDataGenerator.getFakerName();
        String fakerlastName = fakeDataGenerator.getFakerLastName();
        String myEmail = fakeDataGenerator.getFakerEmail();

        MyAccountPage myAccountPage = utilities.registrationToSite(myEmail,fakerName,fakerlastName);
        MyPersonalInformationPage myPersonalInformationPage = myAccountPage.clickOnMyPersonalInformationBtn();
        //Hacer click en el boton de registro y...

        /*****************
         * puse un Thread.sleep en la funcion y tarda en cargar los valores porque a veces tarda en ver los attributes
         * para obtener el valor ya cargado en los campos que figuran en gris
         * deberia poner driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         * en cada constructor para que haga las esperas implicitas?
         *
         ******************/

        String obtainName = myPersonalInformationPage.getFirstNameAttribute();
        String obtainLastName = myPersonalInformationPage.getLastNameAttribute();
        String obtainEmail = myPersonalInformationPage.getEmailLoginFieldAttribute();

        Assert.assertEquals(fakerName,obtainName);
        Assert.assertEquals(fakerlastName,obtainLastName);
        Assert.assertEquals(myEmail,obtainEmail);

    }
}
