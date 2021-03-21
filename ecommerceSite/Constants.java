package Intermedio.Clase5_PageObject.ecommerceSite;

import com.github.javafaker.Faker;

public class Constants {
    public static final String ECOMMERCESITE_URL = "http://www.automationpractice.com/index.php";
    public static Faker FAKER = new Faker();
    public static String ZIP_CODE_RANDOM = "12345";

    public String getCompanyName(){
        String companyName = FAKER.company().name();
        return companyName;

    }
    public String getStreetAddress(){
        String streetAddress = FAKER.address().streetAddress();
        return streetAddress;
    }
    public String getCity(){
        String addressCity = FAKER.address().city();
        return addressCity;

    }
    public String getPhoneNumber(){
        String phoneNumber = FAKER.phoneNumber().cellPhone();
        return phoneNumber;

    }
    public String getAliasFaKer(){
        String aliasFaker = FAKER.name().username();
        return aliasFaker;
    }

}
