package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }

    //Step 1 Summary
    @FindBy(className = "special-price")
    WebElement unitPrice;

    public String getUnitPriceDisplay(){
        String unitPriceDisplayText = unitPrice.getText();
        return unitPriceDisplayText;

    }

    @FindBy(xpath="//*[contains(text(),'Shopping-cart summary')]")
    public WebElement shoppingCartSummary;

    public String getShoppingCartSummaryText(){
        String ShoppingCartSummaryText = shoppingCartSummary.getText();
        return ShoppingCartSummaryText;

    }

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=order&step=1']")
    public WebElement proceedToCheckOutStep1;

    public void proceedToCheckOutInSummaryBtnClick(){
        proceedToCheckOutStep1.click();

    }
    // Step 3 Address
    @FindBy(xpath="//*[contains(text(),'Addresses')]")
    public WebElement adresses;

    public String getAdressesText(){
        String adressesText = adresses.getText();
        return adressesText;

    }

    @FindBy(name="processAddress")
    public WebElement proceedToCheckOutInAddress;

    public void clickOnProceedToCheckOutInAddressBtn(){
        proceedToCheckOutInAddress.click();

    }
    //Step 4 Shipping

    @FindBy(className="navigation_page")
    public WebElement shipping;

    public String getShippingText(){
        String shippingText = shipping.getText();
        return shippingText;

    }

    @FindBy(xpath="//*[@class='delivery_option_price'][contains(text(),'2.00')]")
    public WebElement deliveryOptionPrice;

    public String getDeliveryOptionPrice(){
        String deliveryOptionPriceText = deliveryOptionPrice.getText();
        return deliveryOptionPriceText;

    }

    @FindBy(name="cgv")
    public WebElement termsOfServiceCheckBox;

    public void setTermsOfServiceCheckBoxClick(){
        termsOfServiceCheckBox.click();

    }
    // boton para proceed to checkout a payment

    //name="processCarrier"
    //Step 5 Payment
}
