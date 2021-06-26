package Intermedio.ExamenIntermedio.Steps;

import Intermedio.ExamenIntermedio.PageObject.LandingPage;
import Intermedio.ExamenIntermedio.PageObject.PremiumPage;
import Intermedio.ExamenIntermedio.PageObject.RegistrationPage;
import Intermedio.ExamenIntermedio.PageObject.UserAgreementPage;
import Intermedio.SimulacroExamen.PageObject.BasePage;
import org.openqa.selenium.WebDriver;

public class BaseSteps extends BasePage {
    /** Aca van las pages decladadras:
     * public XxxPage xxxPage;
     * **/
    public WebDriver driver;
    public LandingPage landingPage;
    public PremiumPage premiumPage;
    public RegistrationPage registrationPage;
    public UserAgreementPage userAgreementPage;
}
