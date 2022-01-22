package com.heartbingo.pages;

import com.heartbingo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    // For logging, we're declaring variable of Logger class from Log4J2
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    // with this constructor, we initialize all the page object with initElement method of PageFactory class
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log In']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//a[@class='site-main-nav__item--link bvs-link'][normalize-space()='Bingo']")
    WebElement bingoButton;

    public void clickOnLogin() {

        pmWaitWithThreadSleep(20);
        pmClickOnElement(loginButton);
        log.info("Click on Login on Home Page :" + loginButton);
    }

}
