package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static pages.Constants.*;

public class ForAsserts {
    private WebDriver driver;
    private final By priceInCart = By.cssSelector(".cart-info tr:nth-child(2) td strong ");
    private  String expectedProductInCart = product + " - 1 Kg";
    private final By actualProductInCart = By.cssSelector(".cart-preview p.product-name");
    private final By productActualPriceInCart = By.cssSelector(".cart-preview p.product-price");
    private final  String homeTitleExpected = "GreenKart - veg and fruits kart";
    private final By itemsInCart = By.cssSelector(".cart-info tr:nth-child(1) td strong ");
    public final String cartUrlExpected = "https://rahulshettyacademy.com/seleniumPractise/#/cart";
    private final By countNoOfItems = By.xpath("//*[@class='cartTable']/following-sibling::div");
    private final By successMessageIsShow = By.xpath(
            "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private final String expectedSuccessMessage = "Thank you, your order has been placed successfully\n" +
            "You'll be redirected to Home page shortly!!";
    public ForAsserts(WebDriver driver) {
        this.driver = driver;
    }
    public void assertPageIsOpened() {
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualTitle, homeTitleExpected);
        Assert.assertEquals(actualUrl, firstUrlExpected);
    }
    public void assertInfoCartItemsAndPrice(){
        String actualItems = driver.findElement( itemsInCart).getText();
        String actualPrice = driver.findElement(priceInCart).getText();

        Assert.assertEquals( actualItems, expectedItems);
        Assert.assertEquals( actualPrice, expectedPrice);
    }
    public void assertIsShowInCart(){
        String actualProduct = driver.findElement( actualProductInCart).getText();
        String actualPrice = driver.findElement( productActualPriceInCart).getText();

        Assert.assertEquals( actualProduct, expectedProductInCart);
        Assert.assertEquals( actualPrice, expectedPrice);
    }


    public void assertPageCartIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains("cart"));

        String actualCartUrl = driver.getCurrentUrl();
        Assert.assertEquals( actualCartUrl, cartUrlExpected);
    }

    public void assertIsOneItem(){
        String actualIsOneItem = driver.findElement(countNoOfItems).getText();
        System.out.println(actualIsOneItem);
        String isOneItemExpected = "1";
        Assert.assertEquals( actualIsOneItem, isOneItemExpected);
    }


    public void assertSuccessMessageIsShow(){
        String actualSuccessMessage = driver.findElement( successMessageIsShow).getText();
        Assert.assertEquals( actualSuccessMessage, expectedSuccessMessage);
    }
}
