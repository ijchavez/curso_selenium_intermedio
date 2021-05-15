package Intermedio.Clase5_PageObject.ecommerceSite.Tests;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import Intermedio.Clase5_PageObject.ecommerceSite.FakeDataGenerator;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.AuthenticationPage;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.MyAccountPage;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.MyPersonalInformationPage;
import Intermedio.Clase5_PageObject.ecommerceSite.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() throws InterruptedException {

        Utilities utilities = new Utilities(driver);
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator(driver);

        String fakerName = fakeDataGenerator.getFakerName();
        String fakerlastName = fakeDataGenerator.getFakerLastName();
        String myEmail = fakeDataGenerator.getFakerEmail();

        MyAccountPage myAccountPage = utilities.registrationToSite(myEmail,fakerName,fakerlastName);
        AuthenticationPage authenticationPage = myAccountPage.clickLogOutBtn();

        String urlNotSignedAccount = utilities.getCurrentUrl();
        System.out.println("Previo al login --> " + urlNotSignedAccount);

        authenticationPage.emailLoginFieldInput(myEmail);
        authenticationPage.passwordLoginField(Constants.PASSWORD);

        authenticationPage.clickOnLogInBtn();

        String urlAccount = utilities.getCurrentUrl();
        System.out.println("Luego del login >>> " + urlAccount);
        Assert.assertTrue(urlAccount.contains("my-account"));

        String nameBtnText = myAccountPage.nameBtnGetText();
        System.out.println(nameBtnText);

        String myAccountH1Text = myAccountPage.myAccountH1GetText();
        System.out.println(myAccountH1Text);

        Assert.assertEquals(myAccountH1Text,"MY ACCOUNT");
        Assert.assertTrue(nameBtnText.contains(fakerName));
        Assert.assertTrue(nameBtnText.contains(fakerlastName));
    }


}
