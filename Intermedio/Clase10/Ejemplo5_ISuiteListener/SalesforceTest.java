package Intermedio.Clase10.Ejemplo5_ISuiteListener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SalesforceTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">>> Before Suite <<< ");

    }
    @Test
    public void sucessTest(){
        System.out.println(">>> Esto es un test de SalesForce exitoso <<< ");

    }

    @Test
    public void failTest(){
        Assert.assertTrue(false);
        System.out.println(">>> Esto es un test de SalesForce que falla <<< ");

    }
    @Test
    public void skippedTest(){
        throw new SkipException("test skipped");

    }
    @AfterSuite
    public void afterSuite() {
        System.out.println(">>> After Suite <<< ");

    }
}
