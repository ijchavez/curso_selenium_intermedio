package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?mylogout=']")
    public WebElement logOutBtn;

    public AuthenticationPage clickLogOutBtn(){
        logOutBtn.click();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        return authenticationPage;

    }
    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=identity']")
    public WebElement myPersonalInformationBtn;

    public MyPersonalInformationPage clickOnMyPersonalInformationBtn(){
        myPersonalInformationBtn.click();
        MyPersonalInformationPage myPersonalInformationPage = new MyPersonalInformationPage(driver);
        return myPersonalInformationPage;

    }

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement nameBtn;

    public String nameBtnGetText(){
        String nameBtnText = nameBtn.getText();
        return nameBtnText;

    }


    @FindBy(tagName = "h1")
    public WebElement myAccountH1;

    public String myAccountH1GetText(){
        String myAccountH1Text = myAccountH1.getText();
        return myAccountH1Text;
    }

}
