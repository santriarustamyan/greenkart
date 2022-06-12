package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CountryPage {

    private WebDriver driver;
    private final By clickTermsAndConditionCheckbox = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private final By clickProceedButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]");
    private final By successMessageIsShow = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private final String expectedSuccessMessage = "Thank you, your order has been placed successfully\n" +
            "You'll be redirected to Home page shortly!!";
    public CountryPage(WebDriver driver) {
        this.driver = driver;
    }
    public void checkTermsAndConditions(){
        driver.findElement(clickTermsAndConditionCheckbox).click();
    }

    public void clickProceedButton(){
        driver.findElement(clickProceedButton).click();
    }

    public void setSuccessMessageIsShow(){
        String actualSuccessMessage = driver.findElement( successMessageIsShow).getText();
        Assert.assertEquals( actualSuccessMessage, expectedSuccessMessage);
    }
}
