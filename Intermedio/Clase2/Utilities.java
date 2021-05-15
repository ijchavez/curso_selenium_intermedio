package Intermedio.Clase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Utilities {
    WebDriver driver;


    public Utilities(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    public void actionToClickAndPerform(WebElement anElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(anElement)
                .click()
                .perform();
    }

    public void actionToFillFields(WebElement anElement, String sendKeysToComplete){
        Actions actions = new Actions(driver);
        Action actionToFillAnInputField = actions.moveToElement(anElement)
                .click()
                .sendKeys(sendKeysToComplete)
                .build();

        actionToFillAnInputField.perform();

    }
}
