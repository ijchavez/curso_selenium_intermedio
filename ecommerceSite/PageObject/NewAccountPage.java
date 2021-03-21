package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import Intermedio.Clase5_PageObject.ecommerceSite.Utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NewAccountPage {
    WebDriver driver;

    public NewAccountPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "email")
    public WebElement emailLoginField;

    public String getRegistrationEmail(){
        String emailElementAttribute = emailLoginField.getAttribute("value");
        return emailElementAttribute;

    }
    @FindBy(id = "uniform-id_gender1")
    public WebElement elementoGenero;

    public void getElementoGeneroClick(){
        elementoGenero.click();

    }

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    public void getFirstNameToComplete(String unNombre){
        firstName.sendKeys(unNombre);

    }

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    public void getLastNameToComplete(String unApellido){
        lastName.sendKeys(unApellido);

    }


    @FindBy(name = "passwd")
    public WebElement passwdElement;

    public void getPasswordToComplete(){
        String unPassword = "pass1234";
        passwdElement.sendKeys(unPassword);

    }


    @FindBy(name = "company")
    public WebElement companyElement;

    public void getCompanyElementToComplete(String unCompany){
        companyElement.sendKeys(unCompany);

    }

    @FindBy(name = "address1")
    public WebElement addressElement;

    public void getAddressElementToComplete(String unAddress){
        addressElement.sendKeys(unAddress);
    }

    @FindBy(id = "city")
    public WebElement cityElement;

    public void getCityElementToComplete(String aCity){
        cityElement.sendKeys(aCity);
    }

    @FindBy(id = "id_state")
    public WebElement elementoState;

    public void getElementoStateToComplete(){
        Select comboState = new Select(elementoState);
        String valueForTest = "12";
        comboState.selectByValue(valueForTest);

    }

    @FindBy(id = "postcode")
    public WebElement elementoPostcode;

    public void getElementoPostCode(String unPostCode){
        elementoPostcode.sendKeys(unPostCode);
    }

    @FindBy(id = "phone_mobile")
    public WebElement elementoPhone;

    public void getElementoPhoneToComplete(String unPhone){
        elementoPhone.sendKeys(unPhone);
    }

    @FindBy(id = "alias")
    public WebElement addressAlias;

    public void getAddressAliasToComplete(String anAddress){
        addressAlias.sendKeys(anAddress);

    }

    @FindBy(id = "submitAccount")
    public WebElement registerButton;

    public void clickOnRegisterButtonBtn(){
        registerButton.click();

    }

    @FindBy(id = "newsletter")
    public WebElement newsletterCheck;

    public void clickOnNewsLetterCheck(){
        newsletterCheck.click();
    }

    @FindBy(id = "optin")
    public WebElement specialOffersCheck;

    public void clickOnSpecialOffersCheck(){
        specialOffersCheck.click();

    }

    @FindBy(id = "days")
    public WebElement elementoDias;

    @FindBy(id = "months")
    public WebElement elementoMeses;

    @FindBy(id = "years")
    public WebElement elementoYears;

    public MyAccountPage fillingPersonalInfoForm(String unNombre, String unApellido){

        getElementoGeneroClick();

        Utilities utilities = new Utilities(driver);

        getFirstNameToComplete(unNombre);
        getLastNameToComplete(unApellido);
        getPasswordToComplete();

        utilities.comboDiaMesAño(utilities.getRandomDay(), utilities.getRandomMonth(), utilities.getRandomYear());

        Constants constants = new Constants();

        String companyFaker = constants.getCompanyName();
        String addressFaker = constants.getStreetAddress();
        String cityFaker = constants.getCity();
        String zipCodeRandom = Constants.ZIP_CODE_RANDOM;
        String phoneFaker = constants.getPhoneNumber();
        String aliasFaker = constants.getAliasFaKer();

        clickOnNewsLetterCheck();
        clickOnSpecialOffersCheck();

        //***** MAS ASSERTS EN MEDIO DE LA REGISTRACION*****
        //estos me quedaron de antes para practicar y no puedo ponerlos en los tests o no veo bien en que momento en el test de registracion
        boolean newsletterClick = false;
        if (newsletterCheck.isSelected() == true){
            newsletterClick = true;

        }
        Assert.assertTrue(newsletterClick);

        boolean specialOffersClick = false;
        if (specialOffersCheck.isSelected() == true){
            specialOffersClick = true;

        }
        Assert.assertTrue(specialOffersClick);

        getCompanyElementToComplete(companyFaker);
        getAddressElementToComplete(addressFaker);
        getCityElementToComplete(cityFaker);

        getElementoStateToComplete();
        getElementoPostCode(zipCodeRandom);
        getElementoPhoneToComplete(phoneFaker);
        getAddressAliasToComplete(aliasFaker);

        //Saque el click, pero dejo el return porque este metodo lo pide
        clickOnRegisterButtonBtn();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        return myAccountPage;

    }


}
