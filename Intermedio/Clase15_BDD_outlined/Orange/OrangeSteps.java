package Intermedio.Clase15_BDD_outlined.Orange;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangeSteps {

    public WebDriver driver;
    String cantidadElementos = "";

    @Given("estoy en Orange")
    public void estoy_en_orange() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("me logeo")
    public void me_logeo() {
        driver.findElement(By.id("btnLogin")).click();

    }

    @When("estoy en la landing page")
    public void estoy_en_la_landing_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        WebElement dashboardTitleElement = driver.findElement(By.className("page-title"));
        Assert.assertEquals(dashboardTitleElement.getText(), "Dashboard", "Se esperaba encontrar al elemento Dashboard");
    }

    @Then("veo la Assign leave en quick actions")
    public void veo_la_assign_leave_en_quick_actions() {
        StepsHelper.validateQuickActions(Constants.ASSIGN_LEAVE_QUICK_ACTION, driver);

    }

    @Then("veo la Leave List en quick actions")
    public void veo_la_leave_list_en_quick_actions() {
        StepsHelper.validateQuickActions(Constants.LEAVE_LIST_QUICK_ACTION, driver);
    }

    @Then("veo la Leave Calendar en quick actions")
    public void veo_la_leave_calendar_en_quick_actions() {
        StepsHelper.validateQuickActions(Constants.LEAVE_CALENDAR_QUICK_ACTION, driver);
    }

    @When("obtengo la cantidad de leave request to approve")
    public void obtengo_la_cantidad_de_leave_request_to_approve() {
        WebElement cantidadLeaveRequestElement = driver.findElement(By.className("record-count"));
        System.out.println(cantidadLeaveRequestElement.getText());

        cantidadElementos = cantidadLeaveRequestElement.getText().replace("(", "");
        cantidadElementos = cantidadElementos.replace(")", "");

    }

    @When("ingreso a la seccion de leave requests")
    public void ingreso_a_la_seccion_de_leave_requests() {
        driver.findElement(By.className("link-title")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("view_leave_list"));
    }

    @Then("la cantidad de elementos a desplegarse debe coincidir")
    public void la_cantidad_de_elementos_a_desplegarse_debe_coincidir() {

        WebElement cantidadElementosTotal = driver.findElement(By.className("summary"));
        System.out.println("===> " + cantidadElementosTotal.getText());

        Assert.assertTrue(cantidadElementosTotal.getText().endsWith("of " + cantidadElementos));

    }

}
