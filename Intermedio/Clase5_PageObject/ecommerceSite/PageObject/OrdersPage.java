package Intermedio.Clase5_PageObject.ecommerceSite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    WebDriver driver;

    public OrdersPage(WebDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "navigation_page")
    public WebElement orderHistoryTitle;

    public String getOrderHistoryTitle(){
        String orderHistoryTitleText = orderHistoryTitle.getText();
        return orderHistoryTitleText;

    }

    @FindBy(xpath = "//*[contains(text(),'Details')]")
    public WebElement detailsBtn;

    public void clickOnDetailsBtn(){
        detailsBtn.click();

    }
    //por la clase price hay otros 5 por eso no puedo usarla, se que esto es la ultima opcion
    @FindBy(xpath = "//*[@id='order-detail-content']/table/tbody/tr/td[4]")
    public WebElement unitPriceInOrder;

    public String getUnitPriceInOrder(){
        String unitPriceInOrderText = unitPriceInOrder.getText();
        return unitPriceInOrderText;

    }

}
