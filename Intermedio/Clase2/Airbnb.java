package Intermedio.Clase2;

import Intermedio.Clase2.PageObject.LandingPage;
import Intermedio.Clase2.PageObject.StayPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Airbnb extends BaseTest{

    @Test
    public void airBnbTest() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        Thread.sleep(3000);

        landingPage.completeWhereToGoInputField();

        landingPage.clickOnCalendarioElement();
        landingPage.clickOnFechaInicioelement();
        landingPage.clickOnFechaFinElement();
        landingPage.clickOnHuespedesElement();

        landingPage.clickOnAdultosElement();
        landingPage.clickOnAdultosElement();

        landingPage.clickOnNinioselement();
        landingPage.clickOnBebesElement();

        StayPage stayPage = landingPage.clickOnBtnBuscar();

        List<WebElement> tresHuespedesList = stayPage.getTresHuespedesList();

        Assert.assertNotEquals(0,tresHuespedesList.size());

        boolean tresHuespedes = false;

        for (WebElement unaListaTresHuespedes : tresHuespedesList){
            String tresHuespedesListText = unaListaTresHuespedes.getText();
            if(unaListaTresHuespedes.getText().contains(Constants.THREE_HUNDRED_LODGINGS)){
                tresHuespedes = true;
                System.out.println(">>> " + tresHuespedesListText);
            }
        }
        Assert.assertTrue(tresHuespedes);
    }

}

