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
    //
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

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

 public void verifyLoginPage(){
        //Getting the current url with the help of getCurrentUrl method
      String curUrl= driver.getCurrentUrl();
     //System.out.println(curUrl);
     //Verifying that the navigated page is a login page
     Assert.assertTrue(curUrl.contains("login"));
 }
 public void enterCredentials(String email, String password){
     driver.switchTo().frame(iframe);
     pmSendTextToElement(usernameTab,email);
     pmSendTextToElement(passwordTab,password);

 }
 public void clickOnLoginButton(){
     loginTab.click();
 }
 public void verifyErrorMessage(String expectedMessage){
     String actualMessage = pmGetTextFromElement(errorMessage);
     Assert.assertEquals(actualMessage,expectedMessage);
     driver.switchTo().defaultContent();
 }

}
