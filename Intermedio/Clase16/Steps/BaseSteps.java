package Intermedio.Clase16.Steps;

import Intermedio.Clase16.PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import Intermedio.Clase16.PageObject.CRMPage;
import Intermedio.Clase16.PageObject.LandingPage;
import Intermedio.Clase16.PageObject.RegistrationPage;

public class BaseSteps extends BasePage {
    public WebDriver driver;
    public LandingPage landingPage;
    public CRMPage crmPage;
    public RegistrationPage registrationPage;

}
