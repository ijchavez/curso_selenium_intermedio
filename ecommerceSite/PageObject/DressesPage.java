package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import Intermedio.Clase5_PageObject.ecommerceSite.Constants;
import Intermedio.Clase5_PageObject.ecommerceSite.FakeDataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DressesPage {

    WebDriver driver;

    public DressesPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }


    //clase de Dresses a partir de aca
    @FindBy(xpath = "//*[@href='http://automationpractice.com/index.php?id_product=5&controller=product']")
    public WebElement quickViewButtonPrintedSummerDress;

    public void clickOnQuickViewButtonPrintedSummerDress(){
        quickViewButtonPrintedSummerDress.click();

    }

    @FindBy(id="our_price_display")
    WebElement priceDisplay;

    public String getOurPriceDisplay(){
        String priceDisplayText = priceDisplay.getText();
        return priceDisplayText;
    }

    @FindBy(id = "quantity_wanted")
    public WebElement quantityWanted;

    public void setQuantityWanted(String unaCantidad){
        quantityWanted.clear();
        quantityWanted.sendKeys(unaCantidad);

    }

    @FindBy(name="group_1")
    public WebElement sizeSelect;

    public void selectSize(String unSize){

        Select comboSelect = new Select(sizeSelect);
        comboSelect.selectByVisibleText(unSize);

    }

    @FindBy(name="Submit")
    public WebElement addToCartBtn;

    public void clickOnSetAddToCartBtn(){
        addToCartBtn.click();

    }

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckOutBtn;

    public void clickOnProceedToCheckOutBtn(){
        proceedToCheckOutBtn.click();

    }
    public ShoppingCartPage setArticleInformationForBuying(){

        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator(driver);
        setQuantityWanted(fakeDataGenerator.getRandomQty());
        selectSize(fakeDataGenerator.getRandomSize());
        clickOnSetAddToCartBtn();
        clickOnProceedToCheckOutBtn();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        return shoppingCartPage;

    }



    //Submit >> boton add to cart
    // name="qty" ingresar cantidad
    // id="color_14" color azul
    // talle M selectByValue value="2"
    // compro algo mas //*[@title='Continue shopping'] como xpath
    // proceed to checkout href="http://automationpractice.com/index.php?controller=order"
    // clase SHOPPING-CART a partir de aca
    /************
     *
     * Cosas verificables
     *  >> Vestidos comprados
     *  >> Que figuren en stock
     *  >> precios
     *  >> titulo sea Shopping-Cart Summary
     *  >> "Your shopping cart contains 2 products
     *  >> talles y colores especificados antes
     *  >> Tocar el boton en 4. shipping I agree to the terms of service and will adhere to them unconditionally.
     *      >> que aparezca el siguiente mensaje si no se acepta You must agree to the terms of service before continuing.
     *
     *  >>  BANK-WIRE PAYMENT.
     *          You have chosen to pay by bank wire. Here is a short summary of your order:
     *            - The total amount of your order comes to: $81.97 (tax incl.)
     *            - We allow the following currency to be sent via bank wire: Dollar
     *            - Bank wire account information will be displayed on the next page.
     *            - Please confirm your order by clicking "I confirm my order.".
     *
     *  >> me dara para verificar el monto de la operacion en cada paso?
     *  >> que aparezca esto
     *      Your order on My Store is complete.
     *      Please send us a bank wire with
     *      - Amount $81.97
     *      - Name of account owner Pradeep Macharla
     *      - Include these details xyz
     *      - Bank name RTP
     *      - Do not forget to insert your order reference JMNEZRVVV in the subject of your bank wire. >> Referencia de la orden ver en MIS ORDENES
     *          An email has been sent with this information.
     *          Your order will be sent as soon as we receive payment.
     *          If you have questions, comments or concerns, please contact our expert customer support team. .
     *
     *  pago con cheque aparece este cartel Your order on My Store is complete.
     *
     *  entrar a mis ordenes
     *  tocar la referencia de la orden
     *  chequear el producto comprado coincida con lo q se compro
     ***********/

}
