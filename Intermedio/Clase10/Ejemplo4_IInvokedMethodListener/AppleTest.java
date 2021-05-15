package Intermedio.Clase10.Ejemplo4_IInvokedMethodListener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = InvokedMethodListeners.class)
public class AppleTest {
    @BeforeMethod
    public void setUp(){
        System.out.println("@BeforeMethod");

    }
    @Test
    public void test1(){
        System.out.println("@Test test1");

    }
    @Test
    public void test2(){
        System.out.println("@Test test2");

    }
    @AfterMethod
    public void closeMethod(){
        System.out.println("@AfterMethod closeMethod");

    }
}
