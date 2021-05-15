package Intermedio.Clase10.Ejemplo6_ITestListener;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

import static java.lang.System.*;

public class TestListeners implements ITestListener {
    public void onTestStart(ITestResult result) {
        out.println("New Test Started " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        out.println("Test succesfully finished " + "---" + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        out.println("Test Failed " +  " ---" + result.getName());
        ITestContext context = result.getTestContext();
        //hay que indicarle que este atributo que esta obteniendo es de tipo webdriver "Cast to..."
        WebDriver driver = (WebDriver) context.getAttribute("Webdriver");

        //donde estamos ubicados en el proyecto y la ruta
        String projectPath = getProperty("user.dir");
        out.println("Ruta >>>" + projectPath);

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String nameTest= result.getName();
        //almacenaje de la imagen

        try {
            FileUtils.copyFile(srcFile,
                    new File(projectPath +
                            "/screeshots/" +
                            nameTest + "-" +
                            System.currentTimeMillis() +
                            ".png"));
            }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {
        out.println("Test Skipped " + " ---" + result.getName());
    }

    public void onStart(ITestContext context) {
        out.println("Test Started " + context.getOutputDirectory() + "---" + context.getName());
    }

    public void onFinish(ITestContext context) {
        out.println("Test succesfully finished " + context.getOutputDirectory() + "---" + context.getName());
    }
}
/****** IListener.class
 *     default void onTestStart(ITestResult result) {
 *     }
 *
 *     default void onTestSuccess(ITestResult result) {
 *     }
 *
 *     default void onTestFailure(ITestResult result) {
 *     }
 *
 *     default void onTestSkipped(ITestResult result) {
 *     }
 *
 *     default void onTestFailedButWithinSuccessPercentage(ITestResult result) {
 *     }
 *
 *     default void onTestFailedWithTimeout(ITestResult result) {
 *         this.onTestFailure(result);
 *     }
 *
 *     default void onStart(ITestContext context) {
 *     }
 *
 *     default void onFinish(ITestContext context) {
 *     }
 */
