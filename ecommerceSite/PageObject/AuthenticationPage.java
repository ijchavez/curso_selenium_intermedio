package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AuthenticationPage {
    WebDriver driver;

    public AuthenticationPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @FindBy(tagName = "h1")
    public WebElement authenticationSection;

    public void validateAuthPage(){
        String autenticathionSectionGetText = authenticationSection.getText();

        String authenticationSectiontext = autenticathionSectionGetText;
        Assert.assertEquals(authenticationSectiontext,"AUTHENTICATION");

    }
    @FindBy(id = "SubmitCreate")
    public WebElement createBtn;

    public NewAccountPage createEmailOfTheAccount(String unEmail){
        emailInput.sendKeys(unEmail);
        createBtn.click();

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        return newAccountPage;
    }
    @FindBy(id = "email")
    public WebElement emailLoginField;

    public void emailLoginFieldInput(String anEmail){
        emailLoginField.sendKeys(anEmail);

    }
    @FindBy(name = "passwd")
    public WebElement passwdElement;

    public void passwordLoginField(String aPassword){
        passwdElement.sendKeys(aPassword);

    }
    @FindBy(id = "SubmitLogin")
    public WebElement loginBtn;

    public MyAccountPage clickOnLogInBtn(){
        loginBtn.click();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        return myAccountPage;
    }

    @FindBy(id = "email_create")
    public WebElement emailInput;

    public void emailInputField(String anEmail){
        emailInput.sendKeys(anEmail);

    }
    @FindBy(xpath = "//*[@id='create_account_error']/ol/li")
    public WebElement duplicateMailErr;

    public String getDuplicateMailErr(){
        String duplicateMailErrText =  duplicateMailErr.getText();
        return duplicateMailErrText;

    }

    public void clickOnCreateBtn(){
        //si bien esto es un click, la funcion registrationToSite devuelve
        //el return que necesita la funcion return newAccountPage.fillingPersonalInfoForm(fakerFirstName,fakerlastName);
        //en la clase utilities
        createBtn.click();
    }

}
