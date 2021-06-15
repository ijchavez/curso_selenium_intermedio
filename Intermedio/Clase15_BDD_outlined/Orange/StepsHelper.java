package Intermedio.Clase15_BDD_outlined.Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class StepsHelper {

    public static void validateQuickActions(String quickActionText, WebDriver driver){
        List<WebElement> quickActionsList = driver.findElements(By.className("quick-access-heading"));
        Assert.assertNotEquals(quickActionsList.size(), 0, "La lista deberia contenter las quick actions");

        boolean quickActionFound = false;
        for (WebElement quickAction: quickActionsList) {
            System.out.println(quickAction.getText());

            if (quickAction.getText().equals(quickActionText)){
                quickActionFound = true;
            }
        }

        Assert.assertTrue(quickActionFound);
        driver.close();
    }



}
