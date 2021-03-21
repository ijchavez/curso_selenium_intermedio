package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPersonalInformationPage {
    WebDriver driver;

    public MyPersonalInformationPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "firstname")
    public WebElement firstNameInput;

    public String getFirstNameAttribute(){
        String firstNameInputAttributeText = firstNameInput.getAttribute("value");
        return  firstNameInputAttributeText;
    }

    @FindBy(id = "lastname")
    public WebElement lastNameInput;

    public String getLastNameAttribute(){
        String firstLastInputAttributeText = lastNameInput.getAttribute("value");
        return  firstLastInputAttributeText;
    }

    @FindBy(id = "email")
    public WebElement emailLoginField;

    public String getEmailLoginFieldAttribute(){
        String emailLoginFieldAttributeText = emailLoginField.getAttribute("value");
        return  emailLoginFieldAttributeText;
    }


}
