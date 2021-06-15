package Intermedio.Clase16.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Intermedio.Clase16.PageObject.LandingPage;

import java.util.concurrent.TimeUnit;

public class LandingSteps extends BaseSteps{
    @Given("estoy en la pagina de Salesforce para ver h1")
    public void estoy_en_la_pagina_de_salesforce_para_ver_h1() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://salesforce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("encuentro un solo h1")
    public void encuentro_un_solo_h1() {
        //List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        landingPage = new LandingPage(driver);
        landingPage.clickOnAceptarTodasLasCookiesBtn();
        Assert.assertEquals(landingPage.getAmountOfH1(), 1, "Se esperaba un unico h1");
        landingPage.closeDriver();
    }

}
