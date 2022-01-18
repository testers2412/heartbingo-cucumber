package co.uk.heartbingo.pages;

import co.uk.heartbingo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log In']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//a[@class='site-main-nav__item--link bvs-link'][normalize-space()='Bingo']")
    WebElement bingoButton;
    @CacheLookup
    @FindBy(xpath = "(//iframe)[1]")
    WebElement iframe;

    public void clickOnLogin() {
       // driver.switchTo().frame(iframe);
        pmWaitWithThreadSleep(20);
       pmClickOnElement(loginButton);
       // driver.switchTo().defaultContent();
    }

}
