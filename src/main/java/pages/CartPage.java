package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private final By clickPlaceOrder = By.cssSelector(".products-wrapper button:nth-last-child(1)");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder(){
        driver.findElement(clickPlaceOrder).click();
    }

}
