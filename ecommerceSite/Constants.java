package Intermedio.Clase5_PageObject.ecommerceSite;

import com.github.javafaker.Faker;

public class Constants {
    public static final String ECOMMERCESITE_URL = "http://www.automationpractice.com/index.php";
    public static Faker FAKER = new Faker();
    public static String ZIP_CODE_RANDOM = "12345";
    public static String PASSWORD = "pass1234";
    public static String DUPLICATE_MAIL_ERROR_TEXT = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    public static String SHOPPING_CART_TITLE = "SHOPPING-CART SUMMARY";
    public static String ADDRESS_TITLE = "Addresses";
    public static String SHIPPING_TITLE = "Shipping";
    public static String SHIPPING_RATE = "$2.00";
    public static String AGREEMENT_TERMS_MESSAGE = "You must agree to the terms of service before continuing.";
    // dice que sale de esta manera el webdriver pero esta escrito asi: Please choose your payment method
    public static String PAYMENT_METHOD_TITLE= "PLEASE CHOOSE YOUR PAYMENT METHOD";
    public static String BANK_WIRE_PAYMENT = "Bank-wire payment.";
    public static String ORDER_HISTORY_TITLE = "Order history";

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
