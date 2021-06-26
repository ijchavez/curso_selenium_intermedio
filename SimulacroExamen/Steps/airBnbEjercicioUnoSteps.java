package Intermedio.SimulacroExamen.Steps;

import Intermedio.SimulacroExamen.PageObject.LandingPage;
import Intermedio.SimulacroExamen.PageObject.StayPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class airBnbEjercicioUnoSteps extends BaseSteps {

    @Given("estoy en la pagina de airbnb")
    public void estoy_en_la_pagina_de_airbnb() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com.ar/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("busco alojamiento para {int} personas para {string}")
    public void busco_alojamiento_para_personas_para(Integer int1, String string) throws InterruptedException {
        lp = new LandingPage(driver);
        Thread.sleep(3000);
        lp.completeWhereToGoInputField(string);
        lp.clickOnCalendarioElement();
        lp.clickOnFechaInicioelement();
        lp.clickOnFechaFinElement();
        lp.clickOnHuespedesElement();

        lp.clickOnAdultosElement();
        lp.clickOnAdultosElement();

        sp = lp.clickOnBtnBuscar();

    }
    @Then("valido que {string} sea el lugar elegido y sea para {int} personas")
    public void valido_que_sea_el_lugar_elegido_y_sea_para_personas(String string, Integer int1) {
        sp = new StayPage(driver);
        List<WebElement> dosHuespedesList = sp.getDosHuespedesList();
        Assert.assertNotEquals(0, dosHuespedesList.size());

        String estadiaEnParis = sp.getEstadiaEnLugarText();
        Assert.assertTrue(estadiaEnParis.contains(string));
        String cantHues = sp.getCantidadDeHuespedesText();
        String numCadena = String.valueOf(int1);
        Assert.assertTrue(cantHues.contains(numCadena));

        sp.closeDriver();

    }

}
