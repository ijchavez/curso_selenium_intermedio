package Intermedio.Clase7;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAsserts {

    @Test
    public void testAsserts(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(1<5, "Error: 1 es menor q 5");
        softAssert.assertTrue(10>12, "10 no es mayor a 12");
        softAssert.assertEquals("hola","mundo", "Se esperaba encontrar a Mundo pero no fue asi");
        softAssert.assertNotEquals("hola","hola", "no se esperaba hola, pero se obtuvo hola");
        softAssert.assertTrue("hola".contains("x"), "no se encontro X");



        System.out.println("Fin del metodo de test");
        softAssert.assertAll();
    }



}
