package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CountryPage {

    private WebDriver driver;
    private final By clickTermsAndConditionCheckbox = By.cssSelector("input.chkAgree");
    private final By clickProceedButton = By.cssSelector(".wrapperTwo button");

    public CountryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTermsAndConditions(){
        driver.findElement(clickTermsAndConditionCheckbox).click();
    }

    public void clickProceedButton(){
        driver.findElement(clickProceedButton).click();
    }


}
