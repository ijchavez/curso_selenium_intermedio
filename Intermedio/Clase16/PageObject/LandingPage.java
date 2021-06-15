package Intermedio.Clase16.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public CRMPage goToCrmPage(){
        driver.findElement(By.xpath("//a[@href='/mx/crm/']")).click();
        CRMPage nextPage = new CRMPage(driver);
        return nextPage;
    }
    public void clickOnAceptarTodasLasCookiesBtn(){
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public RegistrationPage goToRegistrationPage(){
        driver.navigate().to("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");
        RegistrationPage nextPage = new RegistrationPage(driver);
        return nextPage;
    }





}
