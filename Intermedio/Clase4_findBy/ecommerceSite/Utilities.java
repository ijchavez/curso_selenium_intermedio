package Intermedio.Clase4_findBy.ecommerceSite;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Utilities extends BaseTest {

    WebDriver driver;

    public Utilities(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        String titulo = driver.getTitle();
        return titulo;

    }
    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        return url;

    }
    public void registrationToSite(String myEmail, String fakerFirstName, String fakerlastName){
        Faker faker = new Faker();

        String titulo = getTitle();
        System.out.println(">>> " + titulo);

        signInBtn.click();

        String nuevoTitulo = getTitle();
        System.out.println(">>> " + nuevoTitulo);
        Assert.assertTrue(nuevoTitulo.contains("Login"));

        String authenticationSectiontext = authenticationSection.getText();
        Assert.assertEquals(authenticationSectiontext,"AUTHENTICATION");

        emailInput.sendKeys(myEmail);
        createBtn.click();

        elementoGenero.click();

        firstName.sendKeys(fakerFirstName);

        lastName.sendKeys(fakerlastName);

        String emailElementAttribute = emailLoginField.getAttribute("value");

        System.out.println("Mail cargado: " + myEmail);
        System.out.println("Mail en la pag: " + emailElementAttribute);

        Assert.assertEquals(myEmail,emailElementAttribute);

        passwdElement.sendKeys("pass1234");

        comboDiaMesAño("29","6","1986");

        newsletterCheck.click();

        specialOffersCheck.click();

        /***** MAS ASSERTS EN MEDIO DE LA REGISTRACION*****/

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
        /*************************************************/


        String companyFaker = faker.company().name();
        String addressFaker = faker.address().streetAddress();
        String cityFaker = faker.address().city();
        String zipCodeRandom = "12345";
        String phoneFaker = faker.phoneNumber().cellPhone();
        String aliasFaker = faker.name().username();

        companyElement.sendKeys(companyFaker);
        addressElement.sendKeys(addressFaker);
        cityElement.sendKeys(cityFaker);

        comboState("12");

        elementoPostcode.sendKeys(zipCodeRandom);
        elementoPhone.sendKeys(phoneFaker);
        addressAlias.sendKeys(aliasFaker);
        registerButton.click();

    }
    public void comboDiaMesAño(String unDia, String unMes, String unAño){
        Select comboDias = new Select(elementoDias);
        comboDias.selectByValue(unDia);

        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByValue(unMes);

        Select comboYears = new Select(elementoYears);
        comboYears.selectByValue(unAño);


    }
    public void comboState(String unCodigoState){
        Select comboState = new Select(elementoState);
        comboState.selectByValue(unCodigoState);
    }


}
/**************** asi esta la clase con los driver.findelements comentados, quedan excluidos de la version nueva ************************
 public void registrationToSite(String myEmail, String fakerFirstName, String fakerlastName){
 Faker faker = new Faker();

 String titulo = getTitle();
 System.out.println(">>> " + titulo);
 //driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=my-account']")).click();

 signInBtn.click();

 String nuevoTitulo = getTitle();
 System.out.println(">>> " + nuevoTitulo);
 Assert.assertTrue(nuevoTitulo.contains("Login"));

 //WebElement authenticationSection = driver.findElement(By.tagName("h1"));
 String authenticationSectiontext = authenticationSection.getText();
 Assert.assertEquals(authenticationSectiontext,"AUTHENTICATION");

 emailInput.sendKeys(myEmail);
 //driver.findElement(By.name("SubmitCreate")).click();
 createBtn.click();

 elementoGenero.click();

 //WebElement firstName = driver.findElement(By.id("customer_firstname"));
 firstName.sendKeys(fakerFirstName);

 //WebElement lastName = driver.findElement(By.id("customer_lastname"));
 lastName.sendKeys(fakerlastName);

 //estaba entre medio de la registracion este assert
 //WebElement emailElement = driver.findElement(By.id("email"));
 String emailElementAttribute = emailLoginField.getAttribute("value");

 System.out.println("Mail cargado: " + myEmail);
 System.out.println("Mail en la pag: " + emailElementAttribute);

 Assert.assertEquals(myEmail,emailElementAttribute);

 //WebElement passwdElement = driver.findElement(By.name("passwd"));
 passwdElement.sendKeys("pass1234");

 comboDiaMesAño("29","6","1986");

 //WebElement newsletterCheck = driver.findElement(By.id("newsletter"));
 newsletterCheck.click();

 //WebElement specialOffersCheck = driver.findElement(By.id("optin"));
 specialOffersCheck.click();

 //***** MAS ASSERTS EN MEDIO DE LA REGISTRACION*****

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
 //*************************************************


 String companyFaker = faker.company().name();
 String addressFaker = faker.address().streetAddress();
 String cityFaker = faker.address().city();
 String zipCodeRandom = "12345";
 String phoneFaker = faker.phoneNumber().cellPhone();
 String aliasFaker = faker.name().username();

 //WebElement companyElement = driver.findElement(By.name("company"));
 companyElement.sendKeys(companyFaker);

 //WebElement addressElement = driver.findElement(By.name("address1"));
 addressElement.sendKeys(addressFaker);

 //WebElement cityElement = driver.findElement(By.id("city"));
 cityElement.sendKeys(cityFaker);

 //WebElement elementoState = driver.findElement(By.id("id_state"));
 Select comboState = new Select(elementoState);
 comboState.selectByValue("12");

 //WebElement elementoPostcode = driver.findElement(By.id("postcode"));
 elementoPostcode.sendKeys(zipCodeRandom);

 //WebElement elementoPhone = driver.findElement(By.name("phone_mobile"));
 elementoPhone.sendKeys(phoneFaker);

 //WebElement addressAlias = driver.findElement(By.id("alias"));
 addressAlias.sendKeys(aliasFaker);


 //WebElement registerButton = driver.findElement(By.id("submitAccount"));
 registerButton.click();

 }
 public void comboDiaMesAño(String unDia, String unMes, String unAño){
 //WebElement elementoDias = driver.findElement(By.id("days"));
 Select comboDias = new Select(elementoDias);
 comboDias.selectByValue(unDia);

 //WebElement elementoMeses = driver.findElement(By.id("months"));
 Select comboMeses = new Select(elementoMeses);
 comboMeses.selectByValue(unMes);

 //WebElement elementoYears = driver.findElement(By.id("years"));
 Select comboYears = new Select(elementoYears);
 comboYears.selectByValue(unAño);


 }
 */

