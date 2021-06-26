package Intermedio.ExamenIntermedio.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserAgreementPage extends BasePage{
    public UserAgreementPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//*[@class='container legal-body']")
    WebElement termsAndConditions;
    public WebElement getTermsAndConditions(){
        return termsAndConditions;

    }
    public List<WebElement> getElementosP(WebElement unWebElement){
        List<WebElement> elementosDentroDeListaWebElement = unWebElement.findElements(By.tagName("p"));
        return elementosDentroDeListaWebElement;

    }
    public List<String> listaLinkText(List<WebElement> aListOfWebElement){
        List<String> unaListaDeStrings = new ArrayList<>();
        for(WebElement aWebElement: aListOfWebElement){
            String elementText = aWebElement.getText();
            unaListaDeStrings.add(elementText);
        }
        return unaListaDeStrings;
    }

}
