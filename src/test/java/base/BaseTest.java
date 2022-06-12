package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CountryPage;
import pages.HomePage;

public class BaseTest {
    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;
    private CountryPage countryPage;


    @BeforeSuite
    public void  setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @BeforeClass
    public void navigateHomePage(){
// 1. Navigate to "https://rahulshettyacademy.com/seleniumPractise/#/" page
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        countryPage = new CountryPage(driver);
        cartPage = new CartPage(driver);

    }

        @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void greenKartTest() {

// 2. Assert page is opened (url, title)

        homePage.pageIsOpened();

// 3. Add "Mango" to the cart

        homePage.clickAddToCart();

// 4. Assert Items and Price are shown as expected in the cart info (top right)

        homePage.infoCartItemsAndPrice();

// 5. Click on the cart icon

       homePage.clickCardIcon();

// 6. Assert "Mango" is shown on the opened overlay

        homePage.isShowInCart();

// 7. Click on "Proceed to checkout" button

        homePage.clickCheckoutButton();

// 8. Assert cart page is opened

        cartPage.pageCartIsOpened();

// 9. Asset only one item is shown in the cart

//        cartPage.isOneItem();


// 10. Click on "Place Order"

        cartPage.clickPlaceOrder();

// 11. Check "Terms & Conditions" checkbox

        countryPage.checkTermsAndConditions();

// 12. Click on "Proceed" button

        countryPage.clickProceedButton();

// 13. Assert Success message is shown

        countryPage.setSuccessMessageIsShow();
    }

}