package Intermedio.Clase10.Ejemplo5_ISuiteListener;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NetflixTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">>> Before Suite <<< ");

    }
    @Test
    public void test1(){
        System.out.println(">>> Esto es un test de Netflix <<< ");

    }
    @AfterSuite
    public void afterSuite() {
        System.out.println(">>> After Suite <<< ");

    }
}
