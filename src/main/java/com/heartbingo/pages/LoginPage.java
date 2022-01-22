package com.heartbingo.pages;

import com.heartbingo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {
    // For logging, we're declaring variable of Logger class from Log4J2
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    // with this constructor, we initialize all the page object with initElement method of PageFactory class
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//iframe[@class='oneauth-iframe']")
    WebElement iframe;
    @CacheLookup
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameTab;
    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordTab;
    @CacheLookup
    @FindBy(xpath = "//button[@name='login_submit']")
    WebElement loginTab;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'The username or password you entered is incorrect.')]")
    WebElement errorMessage;

    public void verifyLoginPage() {
        //Getting the current url with the help of getCurrentUrl method
        String curUrl = driver.getCurrentUrl();
        //System.out.println(curUrl);
        //Verifying that the navigated page is a login page
        Assert.assertTrue(curUrl.contains("login"));
        log.info("Verify Login Page Url contains Login :" + curUrl);
    }

    public void enterCredentials(String email, String password) {
        driver.switchTo().frame(iframe);
        pmSendTextToElement(usernameTab, email);
        pmSendTextToElement(passwordTab, password);
        log.info("Enter the credentials : Username - " + email + ", Password - " + password);
    }

    public void clickOnLoginButton() {
        loginTab.click();
        log.info("Click on Login button :" + loginTab);
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = pmGetTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
        driver.switchTo().defaultContent();
        log.info("Verify error message :" + actualMessage);
    }

}
