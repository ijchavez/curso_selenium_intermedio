package Intermedio.Clase16.Steps;

import Intermedio.Clase16.PageObject.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationSteps extends BaseSteps{
    @Given("estoy en la pagina de Salesforce para reg")
    public void estoy_en_la_pagina_de_salesforce_para_reg() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://salesforce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("ingreso a la seccion de registrarse")
    public void ingreso_a_la_seccion_de_registrarse() {
        //driver.navigate().to("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");
        landingPage = new LandingPage(driver);
        landingPage.clickOnAceptarTodasLasCookiesBtn();
        registrationPage = landingPage.goToRegistrationPage();
    }

    @Then("puedo completar todos los campos del registro")
    public void puedo_completar_todos_los_campos_del_registro() {
        registrationPage.fillRegistrationFields();
        registrationPage.closeDriver();
    }
}
