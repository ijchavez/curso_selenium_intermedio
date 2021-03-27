package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(className = "fancybox-inner")
    public WebElement termsAgreementMsgBox;

    public String getTermsAgreementMsgBox(){
        String termsAgreementMsgBoxText = termsAgreementMsgBox.getText();
        return termsAgreementMsgBoxText;

    }

    @FindBy(xpath ="//*[@title='Close']")
    public WebElement termsAgreementClose;

    public void clickOnTermsAgreementCloseBtn(){
        termsAgreementClose.click();

    }

    @FindBy(name="processCarrier")
    public WebElement proceedToCheckOutOnShipping;

    public void clickOnProceedToCheckOutOnShipping(){
        proceedToCheckOutOnShipping.click();

    }
    //Step 5 Payment

    @FindBy(className="page-heading")
    public WebElement paymentMethodChooseTitle;

    public String getPaymentMethodChooseTitleText(){
        String paymentMethodChoosetitleText = paymentMethodChooseTitle.getText();
        return  paymentMethodChoosetitleText;

    }
    @FindBy(className = "bankwire")
    public WebElement payByBankWire;

    public void clickOnPayByBankWire(){
        payByBankWire.click();

    }

    @FindBy(className = "navigation_page")
    public WebElement bankWirePaymentTitle;

    public String getbankWirePaymentTitleText(){
        String bankWirePaymentTitleText = bankWirePaymentTitle.getText();
        return bankWirePaymentTitleText;

    }

    @FindBy(xpath = "//*[@id='center_column']/form/div")
    List<WebElement> orderSummaryList;

    public void getOrderSummaryList(){
        for (WebElement summaryList: orderSummaryList){
            String orderSummarylinkstText = summaryList.getText();

            if (orderSummarylinkstText.isEmpty() == false){
                System.out.println(orderSummarylinkstText);

            }

        }
    }

    @FindBy(xpath = "//*[contains(text(),'I confirm my order')]")
    public WebElement iConfirmMyOrderBtn;

    public void clickOniConfirmMyOrderBtn(){
        iConfirmMyOrderBtn.click();

    }
    @FindBy(xpath = "//*[@id='center_column']/div")
    List<WebElement> orderCompleteSummary;

    public void getOrderCompleteSummaryList(){
        for (WebElement completeSummaryList: orderCompleteSummary){
            String CompleteOrderSummarylistText = completeSummaryList.getText();

            if (CompleteOrderSummarylistText.isEmpty() == false){
                System.out.println(CompleteOrderSummarylistText);

            }

        }
    }

    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?controller=history'][@title='Back to orders']")
    public WebElement backToOrdersBtn;

    public OrdersPage clickOnBackToOrdersBtn(){
        backToOrdersBtn.click();

        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }


}
