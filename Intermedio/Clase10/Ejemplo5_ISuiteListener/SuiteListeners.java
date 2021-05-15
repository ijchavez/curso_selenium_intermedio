package Intermedio.Clase10.Ejemplo5_ISuiteListener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListeners implements ISuiteListener {
    public void onStart(ISuite suite) {
        System.out.println("Se va a ejecutar la suite " + suite.getName());

    }

    public void onFinish(ISuite suite) {
        System.out.println("Se va a terminar la suite " + suite.getName());

    }
}
