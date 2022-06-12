package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    public final String cartUrlExpected = "https://rahulshettyacademy.com/seleniumPractise/#/cart";
    private final By countNoOfItems = By.xpath("//*[@class='cartTable']/following-sibling::div");
    private final By clickPlaceOrder = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void pageCartIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains("cart"));

        String actualCartUrl = driver.getCurrentUrl();
        Assert.assertEquals( actualCartUrl, cartUrlExpected);
    }

    public void isOneItem(){
        String actualIsOneItem = driver.findElement(countNoOfItems).getText();
        System.out.println(actualIsOneItem);
        String isOneItemExpected = "1";
        Assert.assertEquals( actualIsOneItem, isOneItemExpected);
    }

    public void clickPlaceOrder(){
        driver.findElement(clickPlaceOrder).click();
    }

}
