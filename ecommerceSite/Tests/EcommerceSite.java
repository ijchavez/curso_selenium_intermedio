package Intermedio.Clase5_PageObject.ecommerceSite.Tests;

import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.AuthenticationPage;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.LandingPage;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.MyAccountPage;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.MyPersonalInformationPage;
import Intermedio.Clase5_PageObject.ecommerceSite.Utilities;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceSite extends BaseTest{

    @Test
    public void registrationTest() throws InterruptedException {

        Utilities utilities = new Utilities(driver);

        String fakerName = utilities.getFakerName();
        String fakerlastName = utilities.getFakerLastName();
        String myEmail = utilities.getFakerEmail();

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

    @Test
    public void loginTest() throws InterruptedException {

        Utilities utilities = new Utilities(driver);

        String fakerName = utilities.getFakerName();
        String fakerlastName = utilities.getFakerLastName();
        String myEmail = utilities.getFakerEmail();

        MyAccountPage myAccountPage = utilities.registrationToSite(myEmail,fakerName,fakerlastName);
        AuthenticationPage authenticationPage = myAccountPage.clickLogOutBtn();

        String urlNotSignedAccount = utilities.getCurrentUrl();
        System.out.println("Previo al login --> " + urlNotSignedAccount);

        authenticationPage.emailLoginFieldInput(myEmail);
        authenticationPage.passwordLoginField("pass1234");

        authenticationPage.clickOnLogInBtn();

        String urlAccount = utilities.getCurrentUrl();
        System.out.println("Luego del login >>> " + urlAccount);
        Assert.assertTrue(urlAccount.contains("my-account"));

        String nameBtnText = myAccountPage.nameBtnGetText();
        System.out.println(nameBtnText);

        String myAccountH1Text = myAccountPage.myAccountH1GetText();
        System.out.println(myAccountH1Text);

        Assert.assertEquals("MY ACCOUNT",myAccountH1Text);
        Assert.assertTrue(nameBtnText.contains(fakerName));
        Assert.assertTrue(nameBtnText.contains(fakerlastName));
    }

    @Test
    public void checkUserNameIsUnique() throws InterruptedException {
        Utilities utilities = new Utilities(driver);

        String myEmail = utilities.getFakerEmail();
        String fakerName = utilities.getFakerName();
        String fakerlastName = utilities.getFakerLastName();

        MyAccountPage myAccountPage = utilities.registrationToSite(myEmail,fakerName,fakerlastName);
        AuthenticationPage authenticationPage = myAccountPage.clickLogOutBtn();

        authenticationPage.emailInputField(myEmail);
        authenticationPage.clickOnCreateBtn();


        String duplicateMailErrText = authenticationPage.getDuplicateMailErr();

        Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",
                duplicateMailErrText);

    }

    //Hacer un test para comprar un vestido

}
