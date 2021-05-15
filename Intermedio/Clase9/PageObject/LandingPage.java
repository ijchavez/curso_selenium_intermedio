package Intermedio.Clase9.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement clickOnCookieAccept;

    public void clickOnCookieAcceptBtn(){
        clickOnCookieAccept.click();

    }


    @FindBy(xpath = "//*[@href='/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP']")
    public WebElement signUpFreeBtn;

    public RegistrationPage clickOnFreeTrialBtn(){
        signUpFreeBtn.click();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage;

    }


}
