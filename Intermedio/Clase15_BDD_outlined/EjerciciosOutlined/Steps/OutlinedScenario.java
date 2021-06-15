package practico15_bdd_outlined.EjercicioOutlined;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OutlinedScenario {

    Integer monto = 0;

    @Given("tengo {int} dolares")
    public void tengo_dolares(Integer cantidadInicial) {
        monto = cantidadInicial;
    }

    @When("gasto {int} dolares")
    public void gasto_dolares(Integer gasto) {
        monto = monto - gasto;
    }

    @Then("me sobran {int} dolares")
    public void me_sobran_dolares(Integer resto) {
        Assert.assertEquals(monto, resto, "Se esperaba tener un saldo de "  + resto);
    }
}
