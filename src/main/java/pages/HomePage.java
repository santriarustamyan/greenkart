package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private final By iconCart = By.className("cart-icon");
    private final By clickOnProceedToCheckout = By.cssSelector(".cart-preview button");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart( String productName)  {

        new WebDriverWait(driver, Duration.ofMillis(200)).until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//h4[@class='product-name' and starts-with(., '" +
                        productName + "')]//following::div[2]/button[text()='ADD TO CART']"))).click();
    }

    public void clickCardIcon(){
        driver.findElement(iconCart).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(clickOnProceedToCheckout).click();
    }


}
