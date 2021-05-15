package Intermedio.Clase4_findBy.ecommerceSite;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceSite extends BaseTest {

    //WebDriver driver;

    @Test
    public void registrationTest(){
        Faker faker = new Faker();

        String fakerName = faker.name().firstName();
        String fakerlastName = faker.name().lastName();
        String myEmail = "gerardo" + Math.random() + "test@gmail.com";

        Utilities util = new Utilities(driver);
        util.registrationToSite(myEmail,fakerName,fakerlastName);

        //Hacer click en el boton de registro y...
        myPersonalInformationBtn.click();

        //para obtener el valor ya cargado en los campos que figuran en gris
        String obtainName = firstNameInput.getAttribute("value");
        String obtainLastName = lastNameInput.getAttribute("value");
        String obtainEmail = emailLoginField.getAttribute("value");

        Assert.assertEquals(fakerName,obtainName);
        Assert.assertEquals(fakerlastName,obtainLastName);
        Assert.assertEquals(myEmail,obtainEmail);

    }

    @Test
    public void loginTest(){

        Faker faker = new Faker();

        String fakerName = faker.name().firstName();
        String fakerlastName = faker.name().lastName();
        String myEmail = "gerardo" + Math.random() + "test@gmail.com";

        Utilities util = new Utilities(driver);
        util.registrationToSite(myEmail,fakerName,fakerlastName);

        logOutBtn.click();

        String urlNotSignedAccount = util.getCurrentUrl();
        System.out.println("Previo al login --> " + urlNotSignedAccount);

        emailLoginField.sendKeys(myEmail);

        passwdElement.sendKeys("pass1234");

        loginBtn.click();

        String urlAccount = util.getCurrentUrl();
        System.out.println("Luego del login >>> " + urlAccount);
        Assert.assertTrue(urlAccount.contains("my-account"));

        String nameBtnText = nameBtn.getText();
        System.out.println(nameBtnText);

        String myAccountH1Text = myAccountH1.getText();

        Assert.assertEquals("MY ACCOUNT",myAccountH1Text);
        Assert.assertTrue(nameBtnText.contains(fakerName));
        Assert.assertTrue(nameBtnText.contains(fakerlastName));
    }

    @Test
    public void checkUserNameIsUnique(){
        Faker faker = new Faker();

        signInBtn.click();

        String myEmail = "gerardo" + Math.random() + "test@gmail.com";
        String fakerName = faker.name().firstName();
        String fakerlastName = faker.name().lastName();

        Utilities util = new Utilities(driver);
        util.registrationToSite(myEmail,fakerName,fakerlastName);

        logOutBtn.click();

        emailInput.sendKeys(myEmail);

        createBtn.click();

        String duplicateMailErrText = duplicateMailErr.getText();

        Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",
                duplicateMailErrText);
    }



}
/**************** asi esta la clase con los driver.findelements comentados, quedan excluidos de la version nueva ************************
 @Test
 public void registrationTest(){
 Faker faker = new Faker();

 String fakerName = faker.name().firstName();
 String fakerlastName = faker.name().lastName();
 String myEmail = "gerardo" + Math.random() + "test@gmail.com";

 Utilities util = new Utilities(driver);
 util.registrationToSite(myEmail,fakerName,fakerlastName);

 //Hacer click en el boton de registro y...

 //WebElement myPersonalInformationBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=identity']"));
 myPersonalInformationBtn.click();

 //WebElement firstNameInput = driver.findElement(By.id("firstname"));
 //WebElement lastNameInput = driver.findElement(By.id("lastname"));
 //WebElement emailInput = driver.findElement(By.id("email"));

 //para obtener el valor ya cargado en los campos que figuran en gris
 String obtainName = firstNameInput.getAttribute("value");
 String obtainLastName = lastNameInput.getAttribute("value");
 String obtainEmail = emailLoginField.getAttribute("value");

 Assert.assertEquals(fakerName,obtainName);
 Assert.assertEquals(fakerlastName,obtainLastName);
 Assert.assertEquals(myEmail,obtainEmail);

 }

 @Test
 public void loginTest(){

 Faker faker = new Faker();

 String fakerName = faker.name().firstName();
 String fakerlastName = faker.name().lastName();
 String myEmail = "gerardo" + Math.random() + "test@gmail.com";

 Utilities util = new Utilities(driver);
 util.registrationToSite(myEmail,fakerName,fakerlastName);


 //WebElement logOutBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?mylogout=']"));
 logOutBtn.click();

 String urlNotSignedAccount = util.getCurrentUrl();
 System.out.println("Previo al login --> " + urlNotSignedAccount);

 //WebElement emailLoginField = driver.findElement(By.id("email"));
 emailLoginField.sendKeys(myEmail);

 //WebElement passwdElement = driver.findElement(By.name("passwd"));
 passwdElement.sendKeys("pass1234");

 //WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
 loginBtn.click();

 String urlAccount = util.getCurrentUrl();
 System.out.println("Luego del login >>> " + urlAccount);
 Assert.assertTrue(urlAccount.contains("my-account"));

 //WebElement nameBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=my-account']"));
 String nameBtnText = nameBtn.getText();
 System.out.println(nameBtnText);

 //WebElement myAccountH1 = driver.findElement(By.tagName("h1"));
 String myAccountH1Text = myAccountH1.getText();

 Assert.assertEquals("MY ACCOUNT",myAccountH1Text);
 Assert.assertTrue(nameBtnText.contains(fakerName));
 Assert.assertTrue(nameBtnText.contains(fakerlastName));
 }

 @Test
 public void checkUserNameIsUnique(){
 Faker faker = new Faker();
 //driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?controller=my-account']")).click();
 signInBtn.click();

 String myEmail = "gerardo" + Math.random() + "test@gmail.com";
 String fakerName = faker.name().firstName();
 String fakerlastName = faker.name().lastName();

 Utilities util = new Utilities(driver);
 util.registrationToSite(myEmail,fakerName,fakerlastName);

 //WebElement logOutBtn = driver.findElement(By.xpath("//*[@href='http://automationpractice.com/index.php?mylogout=']"));
 logOutBtn.click();

 //WebElement email = driver.findElement(By.id("email_create"));
 emailInput.sendKeys(myEmail);

 //WebElement createBtn = driver.findElement(By.id("SubmitCreate"));
 createBtn.click();


 //WebElement duplicateMailErr = driver.findElement(By.xpath("//*[@id='create_account_error']/ol/li"));
 String duplicateMailErrText = duplicateMailErr.getText();

 Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",
 duplicateMailErrText);
 }



************************************************************/