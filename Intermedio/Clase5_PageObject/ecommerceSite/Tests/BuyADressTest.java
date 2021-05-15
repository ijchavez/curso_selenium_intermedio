package Intermedio.Clase5_PageObject.ecommerceSite.Tests;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import Intermedio.Clase5_PageObject.ecommerceSite.FakeDataGenerator;
import Intermedio.Clase5_PageObject.ecommerceSite.PageObject.*;
import Intermedio.Clase5_PageObject.ecommerceSite.Utilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyADressTest extends BaseTest{

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

        String precioEnDressPage = "";

        try {
            precioEnDressPage = dressesPage.getOurPriceDisplay();

        }
        catch (Exception e){
            dressesPage.clickOnPopUpCloseBtn();

            Thread.sleep(3000);
            dressesPage.clickOnQuickViewButtonPrintedSummerDress();

            Thread.sleep(3000);
            precioEnDressPage = dressesPage.getOurPriceDisplay();

        }

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

        shoppingCartPage.clickOnProceedToCheckOutOnShipping();

        Thread.sleep(3000);
        String termsAgreementText = shoppingCartPage.getTermsAgreementMsgBox();
        Assert.assertEquals(termsAgreementText,Constants.AGREEMENT_TERMS_MESSAGE);

        shoppingCartPage.clickOnTermsAgreementCloseBtn();

        boolean termsOfServiceClick = false;
        if (shoppingCartPage.termsOfServiceCheckBox.isSelected() == false){
            shoppingCartPage.setTermsOfServiceCheckBoxClick();
            termsOfServiceClick = true;

        }
        Assert.assertTrue(termsOfServiceClick);

        shoppingCartPage.clickOnProceedToCheckOutOnShipping();

        String paymentMethodTitleText = shoppingCartPage.getPaymentMethodChooseTitleText();
        Assert.assertEquals(paymentMethodTitleText,Constants.PAYMENT_METHOD_TITLE);

        Thread.sleep(3000);

        shoppingCartPage.clickOnPayByBankWire();

        String bankWirePaymentTitleText = shoppingCartPage.getbankWirePaymentTitleText();
        Assert.assertTrue(bankWirePaymentTitleText.contains(Constants.BANK_WIRE_PAYMENT));

        System.out.println("****SUMMARY ORDER*****");
        shoppingCartPage.getOrderSummaryList();

        Thread.sleep(3000);
        shoppingCartPage.clickOniConfirmMyOrderBtn();

        System.out.println("****COMPLETE SUMMARY ORDER*****");
        shoppingCartPage.getOrderCompleteSummaryList();

        OrdersPage ordersPage = shoppingCartPage.clickOnBackToOrdersBtn();

        String orderHistoryTitleText = ordersPage.getOrderHistoryTitle();
        Assert.assertEquals(orderHistoryTitleText,Constants.ORDER_HISTORY_TITLE);

        ordersPage.clickOnDetailsBtn();
        Thread.sleep(3000);

        String unitPriceInOrderText = ordersPage.getUnitPriceInOrder();
        Assert.assertEquals(unitPriceInOrderText,precioEnShoppingCartPage);

    }


}
