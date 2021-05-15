package Intermedio.Clase2.PageObject;

import Intermedio.Clase2.Constants;
import Intermedio.Clase2.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;


    public LandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath="//*[@id='bigsearch-query-detached-query']")
    public WebElement whereToGoInputField;

    public void completeWhereToGoInputField(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToFillFields(whereToGoInputField, Constants.WHERE_TO_GO);


    }

    @FindBy(xpath="//*[@data-testid='structured-search-input-field-split-dates-0']/div/div[2]")
    public WebElement calendarioElement;

    public void clickOnCalendarioElement(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(calendarioElement);

    }

    @FindBy(xpath="//*[@data-testid='datepicker-day-2021-04-03']")
    public WebElement fechaInicioElement;

    public void clickOnFechaInicioelement() {
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(fechaInicioElement);

    }

    @FindBy(xpath="//*[@data-testid='datepicker-day-2021-04-15']")
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

    @FindBy(xpath = "(//*[@aria-label='aumentar valor'])[2]" )
    WebElement niniosElement;

    public void clickOnNinioselement(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(niniosElement);

    }

    @FindBy(xpath = "(//*[@aria-label='aumentar valor'])[3]")
    public WebElement bebesElement;

    public void clickOnBebesElement(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(bebesElement);

    }
    @FindBy(xpath = "//*[@data-testid='structured-search-input-search-button']")
    public WebElement btnBuscar;

    public StayPage clickOnBtnBuscar(){
        Utilities utilities = new Utilities(driver);
        utilities.actionToClickAndPerform(btnBuscar);

        StayPage stayPage = new StayPage(driver);
        return stayPage;

    }



}
