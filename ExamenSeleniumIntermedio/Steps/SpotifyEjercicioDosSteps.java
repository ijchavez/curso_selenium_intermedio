package Intermedio.ExamenIntermedio.Steps;
import Intermedio.ExamenIntermedio.PageObject.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyEjercicioDosSteps extends BaseSteps{
    @Given("Dentro de la pagina de spotify")
    public void dentro_de_la_pagina_de_spotify() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("Me registro con un {string}")
    public void me_registro_con_un(String string) {
        landingPage = new LandingPage(driver);
        registrationPage = landingPage.clickOnRegistrateBtn();

        registrationPage.fillRegistrationEmail(string);

    }
    @Then("valido los mensajes de {string}")
    public void valido_los_mensajes_de(String string) {
        //hago esto para que los mensajes de error aparezcan
        registrationPage.fillConfirmRegistrationEmail("");
        String err = registrationPage.getValidMailErrMsgText();
        Assert.assertEquals(string, err);

        registrationPage.closeDriver();
    }

}
