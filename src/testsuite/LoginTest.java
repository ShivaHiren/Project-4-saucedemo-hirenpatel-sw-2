package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        //Launch website
        openBrowser(baseUrl);
    }


    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
        //click on username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //Enter password
        sendTextToElement(By.xpath("//input[@type='password']"), "secret_sauce");

        //click on login
        clickOnElement(By.xpath("//input[@value='Login']"));

        //This is requirement
        String expectedMessage = "PRODUCTS";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //click on username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //Enter password
        sendTextToElement(By.xpath("//input[@type='password']"), "secret_sauce");

        //click on login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //This is requirement
        //Verify that six products are displayed on page
        List<WebElement> actualTextMessage = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int expectedSize = 6;
        int actualSize = actualTextMessage.size();
        Assert.assertEquals(expectedSize, actualSize);

    }

    @After
    public void testDown() {
        //Closing browser
        closeBrowser();
    }
}
