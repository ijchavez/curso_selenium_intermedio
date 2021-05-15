package Intermedio.Clase5_PageObject.ecommerceSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class FakeDataGenerator {
    WebDriver driver;

    public FakeDataGenerator(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    public String getFakerName(){
        String unfakerName = Constants.FAKER.name().firstName();
        return unfakerName;

    }
    public String getFakerLastName(){
        String unfakerlastName = Constants.FAKER.name().lastName();
        return unfakerlastName;

    }
    public String getFakerEmail(){
        String anEmail = "gerardo" + Math.random() + "test@gmail.com";
        return anEmail;
    }
    public String getRandomDay(){
        //hago que ponga un dia random entre 1 y 28, si bien puede refinarse con eso me alcanza
        int min = 1;
        int max = 28;
        int randomInt = (int)(Math.random() * (max - min + 1) + min);

        String dayRandomText = Integer.toString(randomInt);
        return dayRandomText;

    }
    public String getRandomMonth(){
        int min = 1;
        int max = 12;
        int randomInt = (int)(Math.random() * (max - min + 1) + min);

        String dayRandomText = Integer.toString(randomInt);
        return dayRandomText;

    }
    public String getRandomYear(){
        int min = 1940;
        int max = 2000;
        int randomInt = (int)(Math.random() * (max - min + 1) + min);

        String dayRandomYear = Integer.toString(randomInt);
        return dayRandomYear;

    }
    // Se que quizas deberia hacer que el array incorpore los valores que existen para el item en particular
    // y devolver un random de eso, voy pensarlo y reformularlo
    public String getRandomSize(){
        String [] arr = {"S", "M", "L"};
        Random random = new Random();

        int select = random.nextInt(arr.length);

        String sizeSelected = arr[select];
        return sizeSelected;
    }
    public String getRandomQty(){
        int min = 1;
        int max = 4;
        int randomInt = (int)(Math.random() * (max - min + 1) + min);

        String RandomQty = Integer.toString(randomInt);
        return RandomQty;

    }
}
