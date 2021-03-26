package Intermedio.Clase5_PageObject.ecommerceSite.Tests;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import Intermedio.Clase5_PageObject.ecommerceSite.FakeDataGenerator;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.*;
import Intermedio.Clase5_PageObject.ecommerceSite.Utilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceSite extends BaseTest{

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

        Assert.assertEquals(duplicateMailErrText,Constants.DUPLICATE_MAIL_ERROR_TEXT);

    }

    @Test
    public void buyADress() throws InterruptedException {
        Utilities utilities = new Utilities(driver);
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator(driver);

        String fakerName = fakeDataGenerator.getFakerName();
        String fakerLastName = fakeDataGenerator.getFakerLastName();
        String myEmail = fakeDataGenerator.getFakerEmail();

        MyAccountPage myAccountPage = utilities.registrationToSite(myEmail,fakerName,fakerLastName);

        DressesPage dressesPage = myAccountPage.clickOnDressesBtn();
        dressesPage.clickOnQuickViewButtonPrintedSummerDress();

        String precioEnDressPage = dressesPage.getOurPriceDisplay();

        ShoppingCartPage shoppingCartPage = dressesPage.setArticleInformationForBuying();

        String precioEnShoppingCartPage = shoppingCartPage.getUnitPriceDisplay();

        System.out.println("DressPage: " + precioEnDressPage);
        System.out.println("ShoppingCartPage: " + precioEnShoppingCartPage);


        Assert.assertEquals(precioEnDressPage,precioEnShoppingCartPage);

        String shoppingCartSummaryText = shoppingCartPage.getShoppingCartSummaryText();
        Assert.assertTrue(shoppingCartSummaryText.contains(Constants.SHOPPING_CART_TITLE));

        shoppingCartPage.proceedToCheckOutInSummaryBtnClick();

        Assert.assertEquals(shoppingCartPage.getAdressesText(),Constants.ADDRESS_TITLE);

        shoppingCartPage.clickOnProceedToCheckOutInAddressBtn();

        Thread.sleep(4000);

        Assert.assertEquals(shoppingCartPage.getShippingText(),Constants.SHIPPING_TITLE);
        Assert.assertEquals(shoppingCartPage.getDeliveryOptionPrice(),Constants.SHIPPING_RATE);


        boolean termsOfServiceClick = false;

        shoppingCartPage.setTermsOfServiceCheckBoxClick();

        if (shoppingCartPage.termsOfServiceCheckBox.isSelected() == true){
            termsOfServiceClick = true;

        }
        Assert.assertTrue(termsOfServiceClick);




    }


}
