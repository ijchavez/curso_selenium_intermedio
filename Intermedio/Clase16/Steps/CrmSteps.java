package Intermedio.Clase16.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Intermedio.Clase16.PageObject.LandingPage;

import java.util.concurrent.TimeUnit;

public class CrmSteps extends BaseSteps {
    @Given("estoy en la pagina de Salesforce")
    public void estoy_en_la_pagina_de_salesforce() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://salesforce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("hago click en CRM")
    public void hago_click_en_crm() {
        landingPage = new LandingPage(driver);
        landingPage.clickOnAceptarTodasLasCookiesBtn();
        crmPage = landingPage.goToCrmPage();
    }

    @Then("ingreso a la pagina de CRM")
    public void ingreso_a_la_pagina_de_crm() {
        Assert.assertEquals(crmPage.getPageUrl(), "https://www.salesforce.com/mx/crm/", "Se esperaba otra URL");
        Assert.assertTrue(crmPage.getPageUrl().contains("crm"));
    }

    @Then("encuentro informacion sobre los CRM")
    public void encuentro_informacion_sobre_los_crm() {
        Assert.assertEquals(crmPage.getTextById("que-es-crm"), "¿Qué es CRM?", "Se esperaba otro elemento");
        crmPage.closeDriver();
    }

}
