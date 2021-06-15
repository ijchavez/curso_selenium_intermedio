package Intermedio.Clase16.PageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void fillRegistrationFields(){
        Faker faker = new Faker();
        driver.findElement(By.name("UserFirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("UserLastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("UserTitle")).sendKeys(faker.job().title());
        driver.findElement(By.name("UserEmail")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("UserPhone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.name("CompanyName")).sendKeys("Salesforce");

        WebElement industryElement = driver.findElement(By.name("Lead.Industry"));
        Select industrySelect = new Select(industryElement);
        industrySelect.selectByVisibleText("Otro");
    }

}
