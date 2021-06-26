package Intermedio.SimulacroExamen.PageObject;

import Intermedio.Clase2.Constants;
import Intermedio.Clase2.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="//*[@id='bigsearch-query-detached-query']")
    public WebElement whereToGoInputField;
    public void completeWhereToGoInputField(String aPlace){
        Utilities utilities = new Utilities(driver);
        utilities.actionToFillFields(whereToGoInputField, aPlace);

    }
    @FindBy(xpath="//*[@data-testid='structured-search-input-field-split-dates-0']/div/div[2]")
    public WebElement calendarioElement;
    public void clickOnCalendarioElement(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(calendarioElement);

    }

    @FindBy(xpath="//*[@data-testid='datepicker-day-2021-07-03']")
    public WebElement fechaInicioElement;
    public void clickOnFechaInicioelement() {
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(fechaInicioElement);

    }
    @FindBy(xpath="//*[@data-testid='datepicker-day-2021-07-10']")
    WebElement fechaFinElement;
    public void clickOnFechaFinElement(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(fechaFinElement);

    }
    @FindBy(xpath="//*[@data-testid='structured-search-input-field-guests-button']/div/div[2]")
    public WebElement huespedesElement;
    public void clickOnHuespedesElement(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(huespedesElement);

    }
    @FindBy(xpath = "(//*[@aria-label='aumentar valor'])[1]")
    WebElement adultosElement;
    public void clickOnAdultosElement(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(adultosElement);

    }
    @FindBy(xpath = "//*[@data-testid='structured-search-input-search-button']")
    public WebElement btnBuscar;
    public StayPage clickOnBtnBuscar(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(btnBuscar);
        StayPage stayPage = new StayPage(driver);
        return stayPage;

    }
    //@FindBy(xpath = "//span[@data-text='true'][contains(text(),'Experiencias')]")
    //@FindBy(xpath = "//*[@id='search-block-tab-false-EXPERIENCES']")
    @FindBy(xpath = "//header/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/label[2]/span[1]")
    WebElement experienciasBtn;
    public void clickOnExperienciasBtn(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(experienciasBtn);
        experienciasBtn.click();

    }
    @FindBy(xpath = "//*[@data-index=0]")
    WebElement paisButton;
    public String getPaisButtonText(){
        String paisText = paisButton.getText();
        return paisText;

    }
    @FindBy(xpath = "//*[@data-index=1]")
    WebElement fechaButton;
    public String getFechaButtonText(){
        String fechaText = fechaButton.getText();
        return fechaText;

    }
    @FindBy(xpath = "//*[@data-testid='structured-search-input-field-dates-button']")
    WebElement calendarioExperiencias;
    public void clickOnCalendarioExperienciasBtn(){
        calendarioExperiencias.click();

    }
    @FindBy(xpath = "//*[contains(text(),'Mostrando')]")
    WebElement mostrandoResultados;
    public String getMostrandoResultadosText(){
        String mostrandoResultadosText = mostrandoResultados.getText();
        return mostrandoResultadosText;

    }
    @FindBy(xpath = "//*[@style='--column-count:4;']")
    WebElement lugaresCercanos;
    public WebElement getLugaresCercanos(){
        return lugaresCercanos;

    }
    public List<WebElement> getElementosDiv(WebElement unWebElement){
        List<WebElement> elementosDentroDeListaWebElement = unWebElement.findElements(By.tagName("div"));
        return elementosDentroDeListaWebElement;

    }
    public List<String> listaDeLugaresCercanosText(List<WebElement> aListOfWebElement){
        List<String> unaListaDeStrings = new ArrayList<>();
        for(WebElement aWebElement: aListOfWebElement){
            String elementText = aWebElement.getText();
            unaListaDeStrings.add(elementText);
        }
        return unaListaDeStrings;
    }

}
