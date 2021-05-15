package Intermedio.Clase5_PageObject.ecommerceSite.Tests;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import Intermedio.Clase5_PageObject.ecommerceSite.FakeDataGenerator;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.AuthenticationPage;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.MyAccountPage;
import Intermedio.Clase5_PageObject.ecommerceSite.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckUsernameIsUniqueTest extends BaseTest {
    @Test
    public void checkUserNameIsUnique() throws InterruptedException {
        Utilities utilities = new Utilities(driver);
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator(driver);

        String fakerName = fakeDataGenerator.getFakerName();
        String fakerlastName = fakeDataGenerator.getFakerLastName();
        String myEmail = fakeDataGenerator.getFakerEmail();

        MyAccountPage myAccountPage = utilities.registrationToSite(myEmail,fakerName,fakerlastName);
        AuthenticationPage authenticationPage = myAccountPage.clickLogOutBtn();

        authenticationPage.emailInputField(myEmail);
        authenticationPage.clickOnCreateBtn();


        String duplicateMailErrText = authenticationPage.getDuplicateMailErr();

        Assert.assertEquals(duplicateMailErrText, Constants.DUPLICATE_MAIL_ERROR_TEXT);

    }
}
