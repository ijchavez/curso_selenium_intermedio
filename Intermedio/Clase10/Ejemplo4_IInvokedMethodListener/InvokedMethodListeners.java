package Intermedio.Clase10.Ejemplo4_IInvokedMethodListener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListeners implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Antes de invocar al metodo " + method.getTestMethod().getMethodName());

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("despues de invocar al metodo "  + method.getTestMethod().getMethodName());
    }


}
