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

public class airBnbEjercicioDosSteps extends BaseSteps {

    @Given("me encuentro en el sitio de AirBnb")
    public void me_encuentro_en_el_sitio_de_air_bnb() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com.ar/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("realizo una busqueda de experiencias para el cinco de julio en Budapest y valido los valores previo a buscar")
    public void realizo_una_busqueda_de_experiencias_para_el_cinco_de_julio_en_budapest_y_valido_los_valores_previo_a_buscar() throws InterruptedException {
        lp = new LandingPage(driver);
        lp.clickOnExperienciasBtn();

        lp.completeWhereToGoInputField("París");
        lp.clickOnCalendarioExperienciasBtn();
        lp.clickOnFechaInicioelement();

        lp.clickOnBtnBuscar();

    }

    @Then("valido que lo buscado concuerde con lo indicado en la busqueda")
    public void valido_que_lo_buscado_concuerde_con_lo_indicado_en_la_busqueda() {
        lp = new LandingPage(driver);

        String paisText = lp.getPaisButtonText();
        String mostrandoResultados = lp.getMostrandoResultadosText();
        String fechaText = lp.getFechaButtonText();

        Assert.assertTrue(paisText.contains("Paris"));
        Assert.assertTrue(mostrandoResultados.contains("Paris"));
        Assert.assertTrue(fechaText.contains("3 jul"));
        lp.closeDriver();
    }

}
