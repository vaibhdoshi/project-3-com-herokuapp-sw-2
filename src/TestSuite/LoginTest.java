package TestSuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSucesssfullyWithValidCredentials() {
        //enter username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //click on Login but"on
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //verify the text "Secure area"
        String expectedMessage = "Secure Area";
        WebElement actualTextMessage = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage = actualTextMessage.getText();
        //validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void VerifyTheUsernameErrorMessage() {
        //enter invalid username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        //enter correct password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message "Your username is invalid!"
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualTextMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextMessage.getText();
        //validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void VerifyThePasswordErrorMessage() {
        //Enter "username"
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        //click on 'Login 'button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message “Your password is invalid!”
        String expectedMessage = "Your password is invalid!\n" + "×";
        WebElement actualTextMessage = driver.findElement(By.xpath("(//div[@id='flash'])[1]"));
        String actualMessage = actualTextMessage.getText();
        //validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);


    }


    @After
    public void tearDown() {

        closeBrowser();
    }

}
