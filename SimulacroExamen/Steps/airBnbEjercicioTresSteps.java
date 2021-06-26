package Intermedio.SimulacroExamen.Steps;
import Intermedio.SimulacroExamen.PageObject.LandingPage;
import Intermedio.SimulacroExamen.PageObject.StayPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class airBnbEjercicioTresSteps extends BaseSteps{
    List<String> lugaresCercanosText = new ArrayList<>();
    @Given("voy al sitio de AirBnb")
    public void voy_al_sitio_de_air_bnb() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com.ar/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @When("me fijo que lugares cercanos muestra la pagina")
    public void me_fijo_que_lugares_cercanos_muestra_la_pagina() {
        lp = new LandingPage(driver);
        WebElement listaLugaresCercanos = lp.getLugaresCercanos();
        List<WebElement> lugaresCercanos = lp.getElementosDiv(listaLugaresCercanos);
        lugaresCercanosText = lp.listaDeLugaresCercanosText(lugaresCercanos);

    }
    @Then("muestro la ubicacion y las horas en auto a ese lugar")
    public void muestro_la_ubicacion_y_las_horas_en_auto_a_ese_lugar() {
        for(String lugaresCercanos : lugaresCercanosText){
            if(lugaresCercanos != ""){
                System.out.println(lugaresCercanos);

            }

        }
        lp.closeDriver();
    }

}
