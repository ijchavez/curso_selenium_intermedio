package Intermedio.ExamenIntermedio.Steps;
import Intermedio.ExamenIntermedio.PageObject.LandingPage;
import Intermedio.ExamenIntermedio.PageObject.UserAgreementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyEjercicioTresSteps extends BaseSteps{
    @Given("cuando entro a la pagina de spotify")
    public void cuando_entro_a_la_pagina_de_spotify() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("abro una nueva pestaña para entrar a {string}")
    public void abro_una_nueva_pestaña_para_entrar_a(String string) {
        driver.navigate().to(string);

    }

    @Then("valido que se encuentren los siguientes {string}")
    public void valido_que_se_encuentren_los_siguientes(String string) {
        userAgreementPage = new UserAgreementPage(driver);
        WebElement getTermsAndConditionstext = userAgreementPage.getTermsAndConditions();
        List<WebElement> elementosP = userAgreementPage.getElementosP(getTermsAndConditionstext);
        List<String> elementosPText = userAgreementPage.listaLinkText(elementosP);

        String textoParaAnalizar = elementosPText.get(1);
        Assert.assertTrue(textoParaAnalizar.contains(string));
        /**
        int i = 0;
        for (String parrafo : elementosPText){
            System.out.println(i + " >>> " + parrafo);
            i++;
        }
         */
        userAgreementPage.closeDriver();

    }

}
