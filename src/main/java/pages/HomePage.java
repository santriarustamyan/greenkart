package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private final  String firstTitleExpected = "GreenKart - veg and fruits kart";
    private final  String firstUrlExpected = "https://rahulshettyacademy.com/seleniumPractise/#/";
    private final String expectedItems = "1";
    private final String expectedPrice = "75";
    private final By mangoAddButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[18]/div[3]/button[1]");
    private final By iconCart = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[3]/a[4]/img[1]");
    private final By itemsInCart = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/strong[1]");
    private final By priceInCart = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/strong[1]");

    private final String expectedProductInCart = "Mango - 1 Kg";
    private final String productExpectedPriceInCart = "75";
    private final By actualProductInCart = By.xpath(".//div[1]/ul[1]/li[1]/div[1]/p[1]");
    private final By productActualPriceInCart = By.xpath(".//div[1]/ul[1]/li[1]/div[2]/p[2]");
    private final By clickOnProceedToCheckout = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[2]/div[2]/button[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void pageIsOpened() {
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualTitle, firstTitleExpected);
        Assert.assertEquals(actualUrl, firstUrlExpected);
    }
    public void clickAddToCart()  {
        driver.findElement(mangoAddButton).click();
    }

    public void infoCartItemsAndPrice(){
        String actualItems = driver.findElement( itemsInCart).getText();
        String actualPrice = driver.findElement(priceInCart).getText();

        Assert.assertEquals( actualItems, expectedItems);
        Assert.assertEquals( actualPrice, expectedPrice);
    }

    public void clickCardIcon(){
        driver.findElement(iconCart).click();
    }
    public void isShowInCart(){
        String actualProduct = driver.findElement( actualProductInCart).getText();
        String actualPrice = driver.findElement( productActualPriceInCart).getText();

        Assert.assertEquals( actualProduct, expectedProductInCart);
        Assert.assertEquals( actualPrice, productExpectedPriceInCart);
    }

    public void clickCheckoutButton(){
        driver.findElement(clickOnProceedToCheckout).click();
    }


}
