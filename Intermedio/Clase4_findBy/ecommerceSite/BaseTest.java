package Intermedio.Clase4_findBy.ecommerceSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String ECOMMERCESITE_URL = "http://www.automationpractice.com/index.php";

    public WebDriver driver;

    public BaseTest(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public BaseTest(){

    }
    @BeforeMethod
    public void setEcommerceSiteUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ECOMMERCESITE_URL);
        driver.manage().window().maximize();
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "firstname")
    public WebElement firstNameInput;

    @FindBy(id = "lastname")
    public WebElement lastNameInput;

    @FindBy(id = "email_create")
    public WebElement emailInput;

    @FindBy(id = "email")
    public WebElement emailLoginField;

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=identity']")
    public WebElement myPersonalInformationBtn;

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?mylogout=']")
    public WebElement logOutBtn;

    @FindBy(id = "SubmitLogin")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement nameBtn;

    @FindBy(xpath = "//*[@id='create_account_error']/ol/li")
    public WebElement duplicateMailErr;

    @FindBy(tagName = "h1")
    public WebElement authenticationSection;

    @FindBy(id = "uniform-id_gender1")
    public WebElement elementoGenero;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(name = "passwd")
    public WebElement passwdElement;

    @FindBy(tagName = "h1")
    public WebElement myAccountH1;

    @FindBy(id = "SubmitCreate")
    public WebElement createBtn;

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement signInBtn;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheck;

    @FindBy(id = "optin")
    public WebElement specialOffersCheck;

    @FindBy(name = "company")
    public WebElement companyElement;

    @FindBy(name = "address1")
    public WebElement addressElement;

    @FindBy(id = "city")
    public WebElement cityElement;

    @FindBy(id = "id_state")
    public WebElement elementoState;

    @FindBy(id = "postcode")
    public WebElement elementoPostcode;

    @FindBy(id = "phone_mobile")
    public WebElement elementoPhone;

    @FindBy(id = "alias")
    public WebElement addressAlias;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;

    @FindBy(id = "days")
    public WebElement elementoDias;

    @FindBy(id = "months")
    public WebElement elementoMeses;

    @FindBy(id = "years")
    public WebElement elementoYears;

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("--------------------");
        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        //driver.close();

    }

}
